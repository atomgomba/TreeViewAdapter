/*
 * Copyright 2019 Károly Kiripolszky
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ekezet.treeview

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ekezet.treeview.TreeViewAdapter.ViewHolder

/**
 * @author kiri
 */
open class TreeViewAdapter(
    private val viewHolderFactory: ViewHolderFactory,
    items: MutableList<AnyTreeItem> = ArrayList()
) : RecyclerView.Adapter<ViewHolder<AnyTreeItemView>>(),
    MutableList<AnyTreeItem> by items,
    ITreeViewAdapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        viewHolderFactory.createViewHolder(parent.context, viewType)

    override fun onBindViewHolder(holder: ViewHolder<AnyTreeItemView>, position: Int) =
        with(get(position)) {
            holder.view.bind(this@with, position)
            (holder.view as View).setOnClickListener {
                onItemClicked(holder.view, holder.adapterPosition)
            }
        }

    /**
     * Method that handles expansion/collapse. Call this manually if you want to override the onClickListener on the list items.
     */
    @Suppress("MemberVisibilityCanBePrivate")
    protected fun onItemClicked(view: AnyTreeItemView, position: Int) = with(get(position)) {
        isExpanded = !isExpanded
        if (isExpanded) {
            view.onExpandChildren(get(position), position, this@TreeViewAdapter)
        } else {
            view.onCollapseChildren(get(position), position, this@TreeViewAdapter)
            removeChildren(position)
        }
    }

    override fun getItemCount(): Int = size

    override fun getItemViewType(position: Int): Int = get(position).viewType

    override fun insertChildren(position: Int, children: List<AnyTreeItem>) {
        val elem = get(position)
        elem.isExpanded = true
        val newList: MutableList<AnyTreeItem> = ArrayList<AnyTreeItem>().apply {
            addAll(this@TreeViewAdapter)
            addAll(position + 1, children.map { it.depth = elem.depth + 1; it })
        }
        val result = DiffUtil.calculateDiff(ListDiffCallback(this, newList))
        clear()
        addAll(newList)
        result.dispatchUpdatesTo(this)
        notifyItemChanged(position)
    }

    override fun replaceChildren(position: Int, children: List<AnyTreeItem>) {
        removeChildren(position)
        insertChildren(position, children)
    }

    private fun removeChildren(position: Int) {
        val elem = get(position)
        elem.isExpanded = false
        val fromIndex = position + 1
        val toIndex = findLastChildPosition(fromIndex, elem.depth)
        if (toIndex == -1) {
            // no children
            return
        }
        val newList: MutableList<AnyTreeItem> = ArrayList<AnyTreeItem>().apply {
            addAll(this@TreeViewAdapter)
            subList(fromIndex, toIndex + 1).clear()
        }
        val result = DiffUtil.calculateDiff(ListDiffCallback(this, newList))
        clear()
        addAll(newList)
        result.dispatchUpdatesTo(this)
        notifyItemChanged(position)
    }

    /**
     * @return the position of the last child or -1 if there are no children
     */
    private fun findLastChildPosition(fromIndex: Int, depth: Int): Int {
        var lastItemPosition = -1
        for (index in fromIndex until size) {
            val item = get(index)
            if (depth < item.depth) {
                lastItemPosition = index
            } else {
                break
            }
        }
        return lastItemPosition
    }

    interface ViewHolderFactory {
        fun createViewHolder(context: Context, viewType: Int): ViewHolder<AnyTreeItemView>
    }

    interface TreeItemView<in T> {
        fun bind(item: TreeItem<T>, position: Int)

        /**
         * Callback method invoked when the item has to load/display it's children (if any).
         * The item must manually call the appropriate adapter method to add its children.
         */
        fun onExpandChildren(item: TreeItem<T>, position: Int, adapter: ITreeViewAdapter)

        /**
         * Callback method invoked when the item has to collapse it's children (if any).
         * Child elements are removed automatically by the adapter.
         */
        fun onCollapseChildren(item: TreeItem<T>, position: Int, adapter: ITreeViewAdapter) {}
    }

    @Suppress("UNCHECKED_CAST")
    open class ViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val view: T get() = itemView as T
    }

    private class ListDiffCallback(
        private val oldList: List<AnyTreeItem>,
        private val newList: List<AnyTreeItem>
    ) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList.getOrNull(oldItemPosition)?.data == newList.getOrNull(newItemPosition)?.data

        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList.getOrNull(oldItemPosition)?.data == newList.getOrNull(newItemPosition)?.data
    }
}
