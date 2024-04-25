package com.example.practicodos.ui.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicodos.R
import com.example.practicodos.databinding.ActivityMainBinding
import com.example.practicodos.models.Ingredient
import com.example.practicodos.ui.adapters.IngredientAdapter

class MainActivity : AppCompatActivity() {
    // ,OnIngredientClickListener -> este click listener va al lado del appcompact
    private lateinit var binding: ActivityMainBinding
    private val model: MainViewModel by viewModels()

    /*
val updateResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val ingredient = result.data?.getSerializableExtra("ingredient") as Ingredient
            val adapter = binding.lstIngredients.adapter as IngredientAdapter
            adapter.updateIngredient(ingredient)
        }
    }
    val insertResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val ingredient  = result.data?.getSerializableExtra("ingredient") as Ingredient 
                val adapter = binding.lstIngredients.adapter as GeneroIngredient
                adapter.addIngredient(ingredient)
            }
        }
    */
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

        setupRecyclerView()
        //setupEventListeners()
    }

    /*
    private fun setupEventListeners() {
            binding.fabAddIngredient.setOnClickListener {
                insertResultLauncher.launch(
                    Intent(this, DetailActivity::class.java)
                )
            }
        }
    */
    private fun setupRecyclerView() {
        binding.lstIngredients.apply {
            adapter = IngredientAdapter(arrayListOf(
                Ingredient(1, "Tomate", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzBA7C4TFqEM3egsWV8ZoZm1VaJ5BM7SMXE9EIywbGQA&s"),
                Ingredient(2, "Cebolla", "https://www.fructusterrum.com/wp-content/uploads/2020/07/cebolla-roja-1.jpg"),
                Ingredient(3, "Huevo", "https://i.blogs.es/09c069/huevo/1366_2000.jpg"),
                Ingredient(4, "Arroz","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT85iUp9z5wQJEaj2xOCwedc_GxO0l_I26_0E6UYVyQIw&s"),
                Ingredient(5, "Carne de res","https://weriselatam.com/wp-content/uploads/2020/10/En-defensa-de-la-carne-de-res.jpg"),
                Ingredient(6, "Fideo","https://www.fidalga.com/cdn/shop/products/127.png?v=1653343987"),
                Ingredient(7, "Carne de pollo","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT97RCPvDZYBA4RW1hQJPfYOWj3ln5WLi19YlRJv9GgCg&s"),
                Ingredient(8, "Champiñones","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrD7r96GiiVrx_8tqii2Z-7YjZP_NSpaEcNwo8SyY0dg&s"),
                Ingredient(9, "Zanahoria","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1hdgU7QxT0OLycpfSoRRqn8AiLk6aIhsRS0-YLYynRQ&s"),
                Ingredient(10, "Pepino","https://agrosemval.com/wp-content/uploads/2020/05/pepino-poinsett-ipc-01.jpg"),
// this@MainActivity
            ))
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    /*
    override fun onIngredientClick(ingredient: Ingredient) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("ingredient", ingredient)
        updateResultLauncher.launch(intent)
    }

    override fun onIngredientClick(ingredient: Ingredient) {
        val adapter = binding.lstIngredient.adapter as IngredientAdapter
        adapter.removeIngredient(ingredient)
    }
    */
}
