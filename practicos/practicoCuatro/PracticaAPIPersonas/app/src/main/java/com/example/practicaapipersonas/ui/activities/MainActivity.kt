package com.example.practicaapipersonas.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practiacapipersonas.repositories.GenderRepository
import com.example.practicaapipersonas.R
import com.example.practicaapipersonas.databinding.ActivityMainBinding
import com.example.practicaapipersonas.models.Categoria
import com.example.practicaapipersonas.models.Categorias
import com.example.practicaapipersonas.ui.adapters.CategoriaAdapter
import com.example.practicaapipersonas.ui.viewmodels.MainViewModel

class MainActivity : AppCompatActivity(), CategoriaAdapter.OnCategoriaClickListener {
    lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupEventListeners()
        setupRecyclerView()
        setupViewModelListeners()
    }

    override fun onResume() {
        super.onResume()
        model.fetchListaPersonas()
    }
    private fun setupEventListeners() {
        binding.fabAddCategoria.setOnClickListener {
            val intent = Intent(this, CategoryDetailActivity::class.java)
            startActivity(intent)
        }
        binding.btnGoToProducts.setOnClickListener {
            val intent = Intent(this, ProductoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupViewModelListeners() {
        model.categoryList.observe(this) {
            val adapter = (binding.lstPersonas.adapter as CategoriaAdapter)
            adapter.updateData(it)
        }
    }


    private fun setupRecyclerView() {
        binding.lstPersonas.apply {
            this.adapter = CategoriaAdapter(Categorias(), this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun onCategoriaClick(categoria: Categoria) {
        val intent = Intent(this, CategoryDetailActivity::class.java)
        intent.putExtra("categoriaId", categoria.id)
        startActivity(intent)
    }

    override fun onCategoriaDelete(categoria: Categoria) {
        GenderRepository.deleteCategory(categoria.id!!,
            success = {
                model.fetchListaPersonas()
            },
            failure = {
                it.printStackTrace()
            })
    }
}