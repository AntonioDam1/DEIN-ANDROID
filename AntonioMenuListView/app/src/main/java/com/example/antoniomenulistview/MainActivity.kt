package com.example.antoniomenulistview

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import com.example.antoniomenulistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var adapter: ArrayAdapter<String>
    val coloresConMarca = arrayOf(
        "Azul_Mitsubishi", "Blanco_Mitsubishi", "Negro_Mitsubishi", "Oro_Mitsubishi",
        "Metal_Ford", "Blanco_Ford", "Negro_Ford", "Oro_Ford","Azul_Mitsubishi", "Blanco_Mitsubishi", "Negro_Mitsubishi", "Oro_Mitsubishi",
        "Metal_Ford", "Blanco_Ford", "Negro_Ford", "Oro_Ford"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listView = findViewById(R.id. listview)
        adapter = ArrayAdapter( this, android.R.layout. simple_list_item_1,
            coloresConMarca)
        listView.adapter = adapter


        val toolbar: Toolbar = findViewById(R.id. toolbar)
        setSupportActionBar(toolbar)




    }
    override fun onCreateOptionsMenu (menu: Menu?): Boolean {
        menuInflater.inflate(R.menu. menuelistview, menu)
        return true
        val searchItem = menu?.findItem(R.id. app_bar_search)
        val searchView = searchItem?.actionView as SearchView
        searchView. queryHint = "Nombre..."
        searchView.setOnQueryTextListener( object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit (query: String?): Boolean {
                Toast.makeText( this@MainActivity , "Búsqueda enviada: $query", Toast.LENGTH_SHORT).show()
                return false
            }
            override fun onQueryTextChange (newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })
    }

    override fun onOptionsItemSelected (item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.app_bar_search, R.id.add_category, R.id.add_label, R.id.settings -> {
                Toast.makeText( this, item.title, Toast.LENGTH_SHORT).show()
                true
            }
            R.id. settings -> {
                goToSettings()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun goToSettings() {
        val intent = Intent( this, SettingsActivity::class.java)
        startActivity(intent)

    }

}