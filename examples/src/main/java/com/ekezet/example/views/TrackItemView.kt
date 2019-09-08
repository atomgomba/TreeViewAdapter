package com.ekezet.example.views

import android.content.Context
import android.widget.FrameLayout
import com.ekezet.example.R
import com.ekezet.example.data.Track
import com.ekezet.treeview.ITreeViewAdapter
import com.ekezet.treeview.TreeItem
import com.ekezet.treeview.TreeViewAdapter.TreeItemView
import kotlinx.android.synthetic.main.item_view_track.view.*

/**
 * @author kiri
 */
class TrackItemView(context: Context) : FrameLayout(context), TreeItemView<Track> {
    init {
        inflate(context, R.layout.item_view_track, this)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    override fun bind(item: TreeItem<Track>, position: Int) {
        val data = item.data
        titleText.text = data.title
        lengthText.text = data.length
    }

    override fun onExpandChildren(item: TreeItem<Track>, position: Int, adapter: ITreeViewAdapter) {
        // Track has no children
    }
}
