package id.idn.fahru.viewsapp.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.idn.fahru.viewsapp.data.News
import id.idn.fahru.viewsapp.databinding.ItemListNewsBinding

/**
 * Created by Imam Fahrur Rofi on 16/07/2020.
 */
class ItemListNewsAdapter : RecyclerView.Adapter<ItemListNewsViewHolder>() {
    private val listNews = ArrayList<News>()

    fun addData(data: List<News>) {
        listNews.clear()
        listNews.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemListNewsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemListNewsBinding.inflate(layoutInflater, parent, false)
        return ItemListNewsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    override fun onBindViewHolder(holder: ItemListNewsViewHolder, position: Int) {
        val data = listNews[position]
        holder.bind(data)
    }
}