package com.ekezet.example

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ekezet.example.data.*
import com.ekezet.example.views.AsyncAlbumWithChevronItemView
import com.ekezet.example.views.AsyncArtistWithChevronItemView
import com.ekezet.example.views.ProgressIndicatorItemView
import com.ekezet.example.views.TrackItemView
import com.ekezet.treeview.AnyTreeItem
import com.ekezet.treeview.AnyTreeItemView
import com.ekezet.treeview.TreeItem
import com.ekezet.treeview.TreeViewAdapter
import com.ekezet.treeview.TreeViewAdapter.ViewHolder
import com.ekezet.treeview.TreeViewAdapter.ViewHolderFactory
import kotlinx.android.synthetic.main.activity_example.*

/**
 * @author kiri
 */
class CustomClickEventActivity : AppCompatActivity() {

    private val items = mutableListOf<AnyTreeItem>(
        TreeItem from Repo.getArtist(1),
        TreeItem from Repo.getArtist(2),
        TreeItem from Repo.getArtist(3)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        recyclerView.adapter = CustomTreeViewAdapter(items)
    }

    private class Factory : ViewHolderFactory {
        override fun createViewHolder(context: Context, viewType: Int): ViewHolder<AnyTreeItemView> {
            val itemView: View = when (viewType) {
                Artist::class.hashCode() -> AsyncArtistWithChevronItemView(context)
                Album::class.hashCode() -> AsyncAlbumWithChevronItemView(context)
                Track::class.hashCode() -> TrackItemView(context)
                ProgressIndicator::class.hashCode() -> ProgressIndicatorItemView(context)
                else -> throw IllegalArgumentException("Illegal viewType: $viewType")
            }
            return ViewHolder(itemView)
        }
    }

    private inner class CustomTreeViewAdapter(items: MutableList<AnyTreeItem>) : TreeViewAdapter(Factory(), items) {
        override fun onBindViewHolder(holder: ViewHolder<AnyTreeItemView>, position: Int) {
            val listItem = get(position)
            holder.treeItemView.bind(listItem, position)
            holder.itemView.setOnClickListener {
                onItemClicked(holder.treeItemView, holder.adapterPosition)
                Toast.makeText(
                    this@CustomClickEventActivity,
                    "Item ${listItem.data.toString()} depth: ${listItem.depth}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
