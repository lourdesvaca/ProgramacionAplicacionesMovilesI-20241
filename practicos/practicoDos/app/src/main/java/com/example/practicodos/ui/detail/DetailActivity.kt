package com.example.practicodos.ui.detail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.practicodos.R
import com.example.practicodos.databinding.ActivityDetailBinding
import com.example.practicodos.databinding.ActivityMainBinding
import com.example.practicodos.ui.main.MainViewModel

class DetailActivity : AppCompatActivity() {
    // private var ingredientId: Int = 0
    private lateinit var binding: ActivityDetailBinding
    private val model: DetailViewModel by viewModels()

    /*
    private var tomate: String = "1"
    private var hayTomate: Boolean = false
    private var cebolla: String = "2"
    private var hayCebolla: Boolean = false
    private var huevo: String = "3"
    private var hayHuevo: Boolean = false
    private var arroz: String = "4"
    private var hayArroz: Boolean = false
    private var carne: String = "5"
    private var hayCarne: Boolean = false
    private var fideo: String = "6"
    private var hayFideo: Boolean = false
    private var pollo: String = "7"
    private var hayPollo: Boolean = false
    private var champiñones: String = "8"
    private var hayChampiñones: Boolean = false
    private var zanahoria: String = "9"
    private var hayZanahoria: Boolean = false
    private var pepino: String = "10"
    private var hayPepino: Boolean = false
    val RecipeListToLoad: MutableList<Recipe> = mutableListOf()

*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //loadIngredient()
        setupEventListeners()
    }

    private fun setupEventListeners() {
        /*
        binding.apply {
            
    
        
            btnSaveIngredient.setOnClickListener { saveIngredient() }
            btnCancelIngredient.setOnClickListener { finish() }
        }
        */

    }

     /*private fun loadIngredient() {
        val ingredient = intent.getSerializableExtra("genero") as Ingredient?
        if (ingredient != null) {
            binding.lblRecipeIngredientName.editText?.setText(ingredient.nombre)
            binding.lblRecipeIngredientUrl.editText?.setText(ingredient.imagenUrl)
            ingredientId = ingredient.id
        }
    }*/
}
