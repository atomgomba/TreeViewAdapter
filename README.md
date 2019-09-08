# TreeViewAdapter

A multi-level expandable list adapter for RecyclerView.

## Features

* View-agnostic
* Data-agnostic
* Extendable, supports custom list item events eg. onClick

## Examples

Please see the [:examples](./examples/) module for sample code.

### Activity

```kotlin
class SimpleActivity : AppCompatActivity() {

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
                Artist::class.hashCode() -> ArtistItemView(context)
                Album::class.hashCode() -> AlbumItemView(context)
                Track::class.hashCode() -> TrackItemView(context)
                else -> throw IllegalArgumentException("Illegal viewType: $viewType")
            }
            return ViewHolder(itemView)
        }
    }
}
```

### Item data model

```kotlin
data class Artist(
    val id: Int,
    val name: String,
    val countryCode2: String
)
```

### Item view

```kotlin
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
```

