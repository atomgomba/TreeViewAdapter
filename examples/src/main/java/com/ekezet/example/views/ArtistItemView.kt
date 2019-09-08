package com.ekezet.example.views

import android.content.Context
import android.widget.FrameLayout
import com.ekezet.example.R
import com.ekezet.example.data.Artist
import com.ekezet.example.data.Repo
import com.ekezet.treeview.ITreeViewAdapter
import com.ekezet.treeview.TreeItem
import com.ekezet.treeview.TreeViewAdapter.TreeItemView
import kotlinx.android.synthetic.main.item_view_artist.view.*

/**
 * @author kiri
 */
class ArtistItemView(context: Context) : FrameLayout(context), TreeItemView<Artist> {
    init {
        inflate(context, R.layout.item_view_artist, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    override fun bind(item: TreeItem<Artist>, position: Int) {
        val data = item.data
        nameText.text = data.name
        countryText.text = data.countryCode2
    }

    override fun onExpandChildren(item: TreeItem<Artist>, position: Int, adapter: ITreeViewAdapter) {
        adapter.insertChildren(position, Repo.getAlbums(item.data.id).map { TreeItem from it })
    }
}
