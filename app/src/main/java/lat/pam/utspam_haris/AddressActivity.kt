package lat.pam.utspam_haris

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AddressActivity : AppCompatActivity() {
    companion object {
        const val FROM_ORDER = "from_order"
    }

    private var fromOrder = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        fromOrder = intent.getBooleanExtra(FROM_ORDER, false)
        findViewById<EditText>(R.id.inputAddress).setText(AppStorage.getSavedAddress(this))
        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }

        val actionButton = findViewById<Button>(R.id.btnOrderSend)
        actionButton.setText(if (fromOrder) R.string.order_send else R.string.save_address)
        actionButton.setOnClickListener {
            saveAddress()
            if (fromOrder) {
                AppStorage.setCartCount(this, 0)
                startActivity(Intent(this, ConfirmationActivity::class.java))
            } else {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
            finish()
        }
    }

    private fun saveAddress() {
        val address = findViewById<EditText>(R.id.inputAddress).text.toString()
        if (address.isNotBlank()) {
            AppStorage.setSavedAddress(this, address)
        }
    }
}
