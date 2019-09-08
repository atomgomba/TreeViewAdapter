package com.ekezet.example

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ekezet.example.data.Album
import com.ekezet.example.data.Artist
import com.ekezet.example.data.Repo
import com.ekezet.example.data.Track
import com.ekezet.example.views.AlbumWithChevronItemView
import com.ekezet.example.views.ArtistWithChevronItemView
import com.ekezet.example.views.TrackItemView
import com.ekezet.treeview.AnyTreeItem
import com.ekezet.treeview.AnyTreeItemView
import com.ekezet.treeview.TreeItem
import com.ekezet.treeview.TreeViewAdapter
import com.ekezet.treeview.TreeViewAdapter.ViewHolder
import com.ekezet.treeview.TreeViewAdapter.ViewHolderFactory
import kotlinx.android.synthetic.main.activity_example.*

class AnimatedActivity : AppCompatActivity() {

    private val items = mutableListOf<AnyTreeItem>(
        TreeItem from Repo.getArtist(1),
        TreeItem from Repo.getArtist(2),
        TreeItem from Repo.getArtist(3)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example)
        recyclerView.adapter = TreeViewAdapter(Factory(), items)
    }

    private class Factory : ViewHolderFactory {
        override fun createViewHolder(context: Context, viewType: Int): ViewHolder<AnyTreeItemView> {
            val itemView: View = when (viewType) {
                Artist::class.hashCode() -> ArtistWithChevronItemView(context)
                Album::class.hashCode() -> AlbumWithChevronItemView(context)
                Track::class.hashCode() -> TrackItemView(context)
                else -> throw IllegalArgumentException("Illegal viewType: $viewType")
            }
            return ViewHolder(itemView)
        }
    }
}
