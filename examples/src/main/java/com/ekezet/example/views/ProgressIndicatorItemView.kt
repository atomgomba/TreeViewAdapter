package com.ekezet.example.views

import android.content.Context
import android.widget.FrameLayout.LayoutParams
import android.widget.FrameLayout.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout.LayoutParams.WRAP_CONTENT
import android.widget.TextView
import androidx.core.view.setPadding
import com.ekezet.example.data.ProgressIndicator
import com.ekezet.treeview.ITreeViewAdapter
import com.ekezet.treeview.TreeItem
import com.ekezet.treeview.TreeViewAdapter.TreeItemView

/**
 * @author kiri
 */
class ProgressIndicatorItemView(context: Context) : TextView(context), TreeItemView<ProgressIndicator> {
    init {
        layoutParams = LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        setPadding(8)
    }

    override fun bind(item: TreeItem<ProgressIndicator>, position: Int) {
        text = item.data.text
    }

    override fun onExpandChildren(item: TreeItem<ProgressIndicator>, position: Int, adapter: ITreeViewAdapter) {
        // doesn't have children
    }
}
