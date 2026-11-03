package lat.pam.utspam_haris

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setupNavigation()
        setupSettings()
    }

    private fun setupNavigation() {
        findViewById<TextView>(R.id.btnHomeTop).setOnClickListener { openHome() }
        findViewById<TextView>(R.id.btnHomeBottom).setOnClickListener { openHome() }
        findViewById<Button>(R.id.btnHome).setOnClickListener { openHome() }
    }

    private fun setupSettings() {
        val addressSetting = findViewById<View>(R.id.settingAddress)
        addressSetting.findViewById<TextView>(R.id.settingTitle).text =
            getString(R.string.shipping_address)
        addressSetting.findViewById<TextView>(R.id.settingSubtitle).text =
            "Rumah · ${AppStorage.getSavedAddress(this)}"
        addressSetting.setOnClickListener { openAddressSettings() }

        val dataSetting = findViewById<View>(R.id.settingData)
        dataSetting.findViewById<TextView>(R.id.settingTitle).text =
            getString(R.string.personal_data)
        dataSetting.findViewById<TextView>(R.id.settingSubtitle).text =
            getString(R.string.personal_data_value)

        val securitySetting = findViewById<View>(R.id.settingSecurity)
        securitySetting.findViewById<TextView>(R.id.settingTitle).text =
            getString(R.string.security)
        securitySetting.findViewById<TextView>(R.id.settingSubtitle).text =
            getString(R.string.security_value)
    }

    private fun openHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun openAddressSettings() {
        startActivity(Intent(this, AddressActivity::class.java).putExtra(AddressActivity.FROM_ORDER, false))
    }
}
