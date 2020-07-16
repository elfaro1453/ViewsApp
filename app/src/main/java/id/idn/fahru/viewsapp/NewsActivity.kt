package id.idn.fahru.viewsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import id.idn.fahru.viewsapp.data.News
import id.idn.fahru.viewsapp.data.NewsModel
import id.idn.fahru.viewsapp.databinding.ActivityNewsBinding
import id.idn.fahru.viewsapp.rv.ItemListNewsAdapter

class NewsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsBinding
    private lateinit var adapter: ItemListNewsAdapter
    private lateinit var data: List<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = layoutInflater
        binding = ActivityNewsBinding.inflate(inflater)
        setContentView(binding.root)

        setSupportActionBar(binding.homeToolbar) // kode digunakan untuk memberitahu MainActivity mengenai actionbar yang akan digunakan
        // supportActionBar?.title = "Berita App" // setelah set support action bar, ubah title
        // supportActionBar?.setIcon(R.drawable.ic_baseline_policy_24) // cara menambahkan logo drawable
        supportActionBar?.setDisplayShowTitleEnabled(false) // Set false untuk menonaktifkan title
        Glide.with(this).load(R.drawable.logodetik).into(binding.imgToolbar)

        adapter = ItemListNewsAdapter()
        binding.rvNews.setHasFixedSize(true)
        binding.rvNews.layoutManager = LinearLayoutManager(this)
        binding.rvNews.adapter = adapter

        data = NewsModel.newslist
        adapter.addData(data)
    }
}