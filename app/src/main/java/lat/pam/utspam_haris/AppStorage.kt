package lat.pam.utspam_haris

import android.content.Context

object AppStorage {
    private const val PREFERENCES = "kopi_dan_nyemil"
    private const val CART_COUNT = "cart_count"
    private const val SAVED_ADDRESS = "saved_address"
    private const val DEFAULT_ADDRESS = "Jl. Melati No. 12, Sukajadi"

    fun getCartCount(context: Context): Int =
        preferences(context).getInt(CART_COUNT, 0)

    fun setCartCount(context: Context, count: Int) {
        preferences(context).edit().putInt(CART_COUNT, count).apply()
    }

    fun getSavedAddress(context: Context): String =
        preferences(context).getString(SAVED_ADDRESS, DEFAULT_ADDRESS).orEmpty()

    fun setSavedAddress(context: Context, address: String) {
        preferences(context).edit().putString(SAVED_ADDRESS, address).apply()
    }

    private fun preferences(context: Context) =
        context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)
}
