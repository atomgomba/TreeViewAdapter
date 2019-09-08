package com.ekezet.example.views

import android.content.Context
import android.widget.FrameLayout
import com.ekezet.example.R
import com.ekezet.example.data.Album
import com.ekezet.example.data.Repo
import com.ekezet.treeview.ITreeViewAdapter
import com.ekezet.treeview.TreeItem
import com.ekezet.treeview.TreeViewAdapter.TreeItemView
import kotlinx.android.synthetic.main.item_view_album.view.*

/**
 * @author kiri
 */
class AlbumItemView(context: Context) : FrameLayout(context), TreeItemView<Album> {
    init {
        inflate(context, R.layout.item_view_album, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    override fun bind(item: TreeItem<Album>, position: Int) {
        val data = item.data
        titleText.text = data.title
        yearText.text = "${data.yearOfRelease}"
    }

    override fun onExpandChildren(item: TreeItem<Album>, position: Int, adapter: ITreeViewAdapter) {
        adapter.insertChildren(position, Repo.getTracks(item.data.id).map { TreeItem from it })
    }
}
