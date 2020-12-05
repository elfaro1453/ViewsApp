package id.idn.fahru.viewsapp.rv

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.idn.fahru.viewsapp.data.News
import id.idn.fahru.viewsapp.databinding.ItemListNewsBinding

/**
 * Created by Imam Fahrur Rofi on 16/07/2020.
 */
class ItemListNewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemListNewsBinding.bind(view)

    fun bind(news: News) {
        binding.run {
            txtTitle.text = news.title
            txtDate.text = news.desc
            Glide.with(binding.root).load(news.photo).into(imageView)
        }
    }
}

