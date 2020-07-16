package id.idn.fahru.viewsapp.rv

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.idn.fahru.viewsapp.data.News
import id.idn.fahru.viewsapp.databinding.ItemListNewsBinding

/**
 * Created by Imam Fahrur Rofi on 16/07/2020.
 */
class ItemListNewsViewHolder(binding: ItemListNewsBinding) : RecyclerView.ViewHolder(binding.root) {
    private val image = binding.imageView
    private val title = binding.txtTitle
    private val date = binding.txtDate
    private val root = binding.root

    fun bind(berita: News) {
        title.text = berita.title
        date.text = berita.desc
        Glide.with(root.context).load(berita.photo).into(image)
    }
}

