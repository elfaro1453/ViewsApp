package id.idn.fahru.viewsapp.rv

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.idn.fahru.viewsapp.DetailNewsActivity
import id.idn.fahru.viewsapp.DetailNewsActivity.Companion.DATA_INTENT_NEWS
import id.idn.fahru.viewsapp.R
import id.idn.fahru.viewsapp.data.News

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
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_list_news, parent, false)
        return ItemListNewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listNews.size
    }

    override fun onBindViewHolder(holder: ItemListNewsViewHolder, position: Int) {
        val data = listNews[position]
        holder.bind(data)
        holder.itemView.setOnClickListener { view ->
            val context = view.context
            val intent = Intent(context, DetailNewsActivity::class.java)
            intent.putExtra(DATA_INTENT_NEWS, data)
            context.startActivity(intent)
        }
    }
}