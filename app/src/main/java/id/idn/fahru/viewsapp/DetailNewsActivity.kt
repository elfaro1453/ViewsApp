package id.idn.fahru.viewsapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.idn.fahru.viewsapp.data.News
import id.idn.fahru.viewsapp.databinding.ActivityDetailNewsBinding

class DetailNewsActivity : AppCompatActivity() {

    companion object {
        const val DATA_INTENT_NEWS = "DATA_INTENT_NEWS"
    }

    // lateinit variabel yang dibutuhkan
    private lateinit var binding: ActivityDetailNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // konfigurasi binding dimulai
        val inflater = layoutInflater
        binding = ActivityDetailNewsBinding.inflate(inflater)
        setContentView(binding.root)
        // konfigurasi binding selesai

        // aktifkan back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // get data class from intent
        val dataIntent = intent.getParcelableExtra<News>(DATA_INTENT_NEWS)

        // sifat data intent adalah nullable, cek dataIntent jika tidak null maka tampilkan data
        dataIntent?.let {
            title = it.title
            binding.run {
                txtTitle.visibility = View.VISIBLE
                txtDesc.visibility = View.VISIBLE
                imgNews.visibility = View.VISIBLE
                txtTitle.text = it.title
                txtDesc.text = it.desc
                Glide.with(this@DetailNewsActivity).load(it.photo).into(imgNews)
            }
        }
    }

    // saat back button actionbar di tekan
    override fun onSupportNavigateUp(): Boolean {
        // akhiri activity dan kembali ke activity sebelumnya
        finish()
        return super.onSupportNavigateUp()
    }
}