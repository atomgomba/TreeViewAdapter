package com.ekezet.example.views

import android.animation.ValueAnimator
import android.content.Context
import android.widget.FrameLayout
import com.ekezet.example.R
import com.ekezet.example.data.Album
import com.ekezet.example.data.Repo
import com.ekezet.treeview.ITreeViewAdapter
import com.ekezet.treeview.TreeItem
import com.ekezet.treeview.TreeViewAdapter.TreeItemView
import kotlinx.android.synthetic.main.item_view_album_with_chevron.view.*

/**
 * @author kiri
 */
class AlbumWithChevronItemView(context: Context) : FrameLayout(context), TreeItemView<Album> {
    private val animator = ValueAnimator().apply {
        duration = 666L
        addUpdateListener {
            chevronImage.rotation = animatedValue as Float
        }
    }

    init {
        inflate(context, R.layout.item_view_album_with_chevron, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    override fun bind(item: TreeItem<Album>, position: Int) {
        val data = item.data
        titleText.text = data.title
        yearText.text = "${data.yearOfRelease}"
        chevronImage.rotation = if (item.isExpanded)
            90F
        else
            0F
    }

    override fun onExpandChildren(item: TreeItem<Album>, position: Int, adapter: ITreeViewAdapter) {
        adapter.insertChildren(position, Repo.getTracks(item.data.id).map { TreeItem from it })
        animator.setFloatValues(0F, 90F)
        animator.start()
    }

    override fun onCollapseChildren(item: TreeItem<Album>, position: Int, adapter: ITreeViewAdapter) {
        super.onCollapseChildren(item, position, adapter)
        animator.setFloatValues(90F, 00F)
        animator.start()
    }
}
