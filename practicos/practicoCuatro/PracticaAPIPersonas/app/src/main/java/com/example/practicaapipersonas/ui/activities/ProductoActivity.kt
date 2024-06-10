package com.example.practicaapipersonas.ui.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicaapipersonas.databinding.ActivityProductoBinding
import com.example.practicaapipersonas.ui.adapters.ProductAdapter
import com.example.practicaapipersonas.ui.viewmodels.ProductViewModel

class ProductoActivity : AppCompatActivity() {
    private val model: ProductViewModel by viewModels()
    private lateinit var binding: ActivityProductoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupViewModelListeners()

        model.fetchProducts()
    }

    private fun setupRecyclerView() {
        binding.lstProducts.apply {
            this.adapter = ProductAdapter()
            layoutManager = LinearLayoutManager(this@ProductoActivity)
        }
    }

    private fun setupViewModelListeners() {
        model.productList.observe(this) { products ->
            (binding.lstProducts.adapter as ProductAdapter).submitList(products)
        }
    }
}