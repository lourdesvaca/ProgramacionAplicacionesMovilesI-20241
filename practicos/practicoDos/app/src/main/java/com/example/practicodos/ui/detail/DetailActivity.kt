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
        /*
        val ordenIngredientes = intent.getStringExttra("LISTA_EXTRA")
        setupRecyclerView(ordenIngredientes)
        */
        setupEventListeners()
    }

    /*
    private fun setupRecyclerView(ordenIngredientes:String){
        if (listaRecibida != null) {
            for (id in 0 until listaRecibida.length) {
                val elemento = listaRecibida[id].toString()
                when (elemento) {
                    pollo -> hayTomate = true
                    arroz -> hayCebolla = true
                    tomate -> hayHuevo = true
                    platano -> hayArroz = true
                    carne -> hayCarne = true
                    zanahoria -> hayFideo = true
                    espinaca -> hayPollo = true
                    queso -> hayChampiñones = true
                    pasta -> hayZanahoria = true
                    harina -> hayPepino = true
                }
        }

        
        when {
        hayArroz && hayHuevo-> {
            RecipeListToLoad.add(
                Recipe(
                    1,
                    "Arroz hervido",
                    "Ingredientes:\n" +
                            "\n" +
                            "2 unidades de huevo\n" +
                            "1 taza de arroz\n" +
                            "2 tazas de agua\n" +
                            "Sal al gusto\n" +
                            "\n", 
                            "https://th.bing.com/th/id/R.03d4c9b12017c140af3bddc3607a9612?rik=vQuCsUxzmwDuBg&pid=ImgRaw&r=0", //imgReceta
                            "Descripción:\n" +
                            "\n" +
                            "1. Enjuaga el arroz para quitar el exceso de almidón.\n" +
                            "2. En una olla, hierve las 2 tazas de agua.\n" +
                            "3. Agrega el arroz y la sal al agua hirviendo.\n" +
                            "4. Deje cocinar por 15min y revuelva e intervalos de 5min" +
                            "5. Una vez cocido, apaga el fuego y dejar enfriar el arroz.\n" +
                            "7. Freír el huevo en aceite caliente\n" +
                            "6. Servir en platos."
                )
            )
        }
        
    hayArroz && hayCarne -> {
        RecipeListToLoad.add(
            Recipe(
                2,
                "Arroz con Carne",
                "Ingredientes:\n" +
                        "\n" +
                        "350 gramos de carne de res\n" +
                        "1 cubo sabor carne\n" +
                        "Sal al gusto\n" +
                        "2 tazas de arroz\n" +
                        "1 cucharadita de ajo molido\n" +
                        "1 tomate\n" +
                        "1/4 de taza de frijol verde\n" +
                        "1 cebolla roja\n" +
                        "1 zanahoria\n" +
                        "2 cucharadas de aceite vegetal\n" +
                        "1/2 taza de arverjas\n" +
                        "2 cucharadas de ají amarillo molido\n" +
                        "Descripción:\n" +
                        "\n" +
                        "1. Picamos la zanahoria, la cebolla y el tomate en cubos de tamaño reducido, siguiendo el mismo proceso con la carne, cortándola en trozos medianos.\n" +
                        "2. En una olla con aceite caliente, freímos la cebolla, el ajo y el ají amarillo, y agregamos el cubito de sabor a carne. Cocinamos a fuego medio durante 5 minutos.\n" +
                        "3. Añadimos el tomate, los trozos de carne y una taza de agua, y cocinamos durante 10 minutos adicionales.\n" +
                        "4. Incorporamos el arroz, que previamente habíamos enjuagado y 2 tazas de agua. Agregamos los frijoles, las arvejas y la zanahoria. Mezclamos todo de manera uniforme y cocinamos durante 15 minutos a fuego medio. Finalmente, completamos la cocción durante 5 minutos a fuego bajo.\n" +
                        "5. Servimos caliente en un plato nuestro rico Arroz amarillo con carne y lo acompañamos con zarza criolla y ají de rocoto.\n", 
                        "https://th.bing.com/th/id/OIP.Mm0ohH2M--jL7t5_P7PQdAHaEK?rs=1&pid=ImgDetMain"
            )
        )
    }
    hayArroz && hayPollo -> {
        RecipeListToLoad.add(
            Recipe(
                3,
                "Arroz con Pollo",
                "Ingredientes:\n" +
                        "\n" +
                        "3 presas de pollo\n" +
                        "1 atado pequeño de culantro\n" +
                        "100 gramos de espinaca\n" +
                        "2 cebollas grandes\n" +
                        "2 cdas de ajo molido\n" +
                        "1/2 taza de chicha de jora\n" +
                        "50 gr de loche rallado\n" +
                        "4 cdas de ají amarillo en pasta\n" +
                        "1 cda de pasta de ají panca\n" +
                        "1/4 de taza de cerveza negra\n" +
                        "1/3 de taza de zanahoria en brunoise\n" +
                        "1/3 de taza de alverja\n" +
                        "1 pimiento rojo en juliana\n" +
                        "1/2 taza de choclo desgranado\n" +
                        "2 tazas de arroz\n" +
                        "1/3 de taza de aceite vegetal\n" +
                        "Sal\n" +
                        "Pimienta\n" +
                        "Comino\n" +
                        "Orégano\n",
                        "Descripción:\n" +
                        "\n" +
                        "1. Condimentamos el pollo con sal, pimienta, orégano, comino y doramos en una olla con el aceite a fuego medio alto volteando el pollo y reservamos.\n" +
                        "2. En la misma olla a fuego medio sofreímos la cebolla y el ajo por 15 minutos sin dejar de mover incorporamos la pasta de ají amarillo, la pasta de ají panca, el loche rallado, la sal, la pimienta, el orégano y el comino hasta que el aceite se corte (se separe) del aderezo.\n" +
                        "3. Licuar el culantro y la espinaca con la chicha de jora y lo añadimos a la olla del aderezo anterior.\n" +
                        "4. Incorporamos la cerveza negra, las arvejas, la zanahoria y el pollo para cocinar por 30 minutos a fuego medio. Retiramos las presas.\n" +
                        "5. Verter 2 tazas de agua, rectificar la sal y subir el fuego hasta romper el hervor. Añadir el arroz y mover hasta burbujear. Tapar y cocinar durante 25 minutos.\n" 
                        "6. Granear el arroz agregando el pimiento en juliana y el choclo cocido. Tapar por 5 minutos más.\n" +
                        "7. Servir y acompañar con papa a la huancaina y sarsa criolla.\n", 
                        "https://comidasperuanas.net/wp-content/uploads/2023/02/Servir-acompanado-de-zarza-criolla-o-papa-a-la-huancaina.jpg"
            )
        )
    }

    hayArroz -> {
            RecipeListToLoad.add(
                Recipe(
                    4,
                    "Arroz hervido",
                    "Ingredientes:\n" +
                            "\n" +
                            "1 taza de arroz\n" +
                            "2 tazas de agua\n" +
                            "Sal al gusto\n" +
                            "\n", 
                            "https://th.bing.com/th/id/R.03d4c9b12017c140af3bddc3607a9612?rik=vQuCsUxzmwDuBg&pid=ImgRaw&r=0", //imgReceta
                            "Descripción:\n" +
                            "\n" +
                            "1. Enjuaga el arroz para quitar el exceso de almidón.\n" +
                            "2. En una olla, hierve las 2 tazas de agua.\n" +
                            "3. Agrega el arroz y la sal al agua hirviendo.\n" +
                            "4. Deje cocinar por 15min y revuelva e intervalos de 5min" +
                            "5. Una vez cocido, apaga el fuego y dejar enfriar el arroz.\n" +
                            "6. Servir en porciones."
                )
            )
        }

    hayTomate && hayCebolla && hayFideo && hayChampiñones -> {
            RecipeListToLoad.add(
                Recipe(
                    5,
                    "Tallarin con verduras",
                    "Ingredientes:\n" +
                            "\n" +
                            "3 tomates\n" +
                            "2 cebollas\n" +
                            "20gr de champiñones\n" +
                            "300gr de fideo\n" +
                            "Sal al gusto\n" +
                            "\n", 
                            "https://th.bing.com/th/id/R.eeb14d45b0354a1d710ee7c11c1d5318?rik=FiX%2bvnvltpbqBw&pid=ImgRaw&r=0", //imgReceta
                            "Descripción:\n" +
                            "\n" +
                            "1. Lavar todas las verduras y picarlas en cuadrados.\n" +
                            "2. En una olla, hervir 1 litro de agua.\n" +
                            "3. En una sarten antiadherente saltear las verduras con sal, pimienta.\n" +
                            "4. Cuando el agua esté hierviendo verter los fideos por 7 minutos" +
                            "5. Colar el fideo y mezclar con las verduras\n" +
                            "6. Servir en porciones."
                )
            )
        }
}

        
}
binding.lstRecipe.apply {
            adapter = RecetaAdapter(RecipeListToLoad,
                this@DetailActivity
            )
           layoutManager = LinearLayoutManager(this@DetailActivity)
        }
    }

    override fun onRecipesClick(recipe: Recipe) {
        val intent = Intent(this, RecipeActivity::class.java)
        intent.putExtra("texto", recipe.texto)
        startActivity(intent)
    }
}
    }
    */
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
