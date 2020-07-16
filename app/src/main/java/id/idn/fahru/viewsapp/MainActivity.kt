package id.idn.fahru.viewsapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import id.idn.fahru.viewsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.homeToolbar) // kode digunakan untuk memberitahu MainActivity mengenai actionbar yang akan digunakan


        supportActionBar?.setDisplayShowTitleEnabled(false) // Set false untuk menonaktifkan title

        Glide.with(this).load(R.drawable.logodetik).into(binding.imgToolbar)

        binding.btnSend.setOnClickListener {
            val data = binding.editText.text
            saveData(data.toString())
        }
    }

    private fun saveData(data: String) {
        binding.textView.text = data
    }

    // kode untuk menampilkan menu pada Activity
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // onOptionsItemSelected digunakan untuk memberi fungsi ketika menu diklik
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_refresh) {
            Toast.makeText(this, "Menu Refresh ditekan", Toast.LENGTH_SHORT).show()
            binding.textView.text = "Masukkan Text"
            binding.editText.text.clear()   // Clear() untuk menghapus teks di dalam EditText
        }
        return super.onOptionsItemSelected(item)
    }
}
