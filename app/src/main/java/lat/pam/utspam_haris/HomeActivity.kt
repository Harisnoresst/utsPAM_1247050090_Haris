package lat.pam.utspam_haris

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged

class HomeActivity : AppCompatActivity() {
    private lateinit var menuContainer: LinearLayout
    private lateinit var orderButton: Button

    private val menuItems = listOf(
        MenuItemData("Cappucino", "Espresso dengan foam susu lembut", "Rp22.000", "Kopi", R.drawable.menu_cappucino, "Best seller"),
        MenuItemData("Donat Coklat", "Donat lembut dengan glaze coklat", "Rp12.000", "Cemilan", R.drawable.menu_donut),
        MenuItemData("Ice Choco", "Coklat premium, susu, dan es", "Rp18.000", "Non-kopi", R.drawable.menu_choco),
        MenuItemData("Croissant Almond", "Pastry renyah dengan topping almond", "Rp20.000", "Cemilan", R.drawable.menu_croissant),
        MenuItemData("Coffe V60", "Biji kopi arabica dengan teknik v60", "Rp25.000", "Kopi", R.drawable.menu_v60),
        MenuItemData("Matcha Latte", "Matcha Jepang dan susu segar", "Rp23.000", "Non-kopi", R.drawable.menu_matcha)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        menuContainer = findViewById(R.id.menuContainer)
        orderButton = findViewById(R.id.btnOrder)
        setupNavigation()
        updateOrderButton()
        renderMenu("Semua")
    }

    private fun setupNavigation() {
        findViewById<TextView>(R.id.btnProfileTop).setOnClickListener { openProfile() }
        findViewById<TextView>(R.id.btnProfileBottom).setOnClickListener { openProfile() }
        findViewById<TextView>(R.id.btnOrderBottom).setOnClickListener { openAddress() }
        findViewById<TextView>(R.id.btnCoffeeCategory).setOnClickListener { selectCategory("Kopi") }
        findViewById<TextView>(R.id.filterAll).setOnClickListener { selectCategory("Semua") }
        findViewById<TextView>(R.id.filterCoffee).setOnClickListener { selectCategory("Kopi") }
        findViewById<TextView>(R.id.filterNonCoffee).setOnClickListener { selectCategory("Non-kopi") }
        findViewById<TextView>(R.id.filterSnack).setOnClickListener { selectCategory("Cemilan") }
        findViewById<EditText>(R.id.inputSearch).doAfterTextChanged { text ->
            highlightChip("Semua")
            renderMenu(category = "Semua", query = text?.toString().orEmpty())
        }
        orderButton.setOnClickListener { openAddress() }
    }

    // Pilih kategori: tampilkan menu sesuai kategori dan tandai chip yang aktif
    private fun selectCategory(category: String) {
        highlightChip(category)
        renderMenu(category)
    }

    private fun highlightChip(category: String) {
        val activeId = when (category) {
            "Kopi" -> R.id.filterCoffee
            "Non-kopi" -> R.id.filterNonCoffee
            "Cemilan" -> R.id.filterSnack
            else -> R.id.filterAll
        }
        listOf(R.id.filterAll, R.id.filterCoffee, R.id.filterNonCoffee, R.id.filterSnack).forEach { id ->
            val chip = findViewById<TextView>(id)
            val isActive = id == activeId
            chip.setBackgroundResource(if (isActive) R.drawable.bg_chip_active else R.drawable.bg_chip)
            chip.setTextColor(
                ContextCompat.getColor(this, if (isActive) android.R.color.white else R.color.charcoal)
            )
        }
    }

    private fun renderMenu(category: String, query: String = "") {
        menuContainer.removeAllViews()
        menuItems
            .filter { item ->
                val matchesCategory = category == "Semua" || item.category == category
                val matchesQuery = item.name.contains(query, ignoreCase = true)
                matchesCategory && matchesQuery
            }
            .forEach { item -> addMenuItem(item) }
    }

    private fun addMenuItem(item: MenuItemData) {
        val itemView = LayoutInflater.from(this)
            .inflate(R.layout.item_menu, menuContainer, false)

        itemView.findViewById<ImageView>(R.id.menuImage).setImageResource(item.imageRes)
        itemView.findViewById<TextView>(R.id.menuTag).apply {
            text = item.tag
            visibility = if (item.tag.isEmpty()) View.GONE else View.VISIBLE
        }
        itemView.findViewById<TextView>(R.id.menuName).text = item.name
        itemView.findViewById<TextView>(R.id.menuDescription).text = item.description
        itemView.findViewById<TextView>(R.id.menuPrice).text = item.price
        itemView.findViewById<TextView>(R.id.btnAddMenu).setOnClickListener { addToCart() }
        menuContainer.addView(itemView)
    }

    private fun addToCart() {
        AppStorage.setCartCount(this, AppStorage.getCartCount(this) + 1)
        updateOrderButton()
    }

    private fun updateOrderButton() {
        val cartCount = AppStorage.getCartCount(this)
        orderButton.visibility = if (cartCount > 0) View.VISIBLE else View.GONE
        orderButton.text = "Pesan sekarang ($cartCount)"
    }

    private fun openProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
    }

    private fun openAddress() {
        startActivity(Intent(this, AddressActivity::class.java).putExtra(AddressActivity.FROM_ORDER, true))
    }
}

