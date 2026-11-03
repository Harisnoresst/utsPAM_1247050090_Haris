package lat.pam.utspam_haris

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }
        findViewById<Button>(R.id.btnSubmitRegister).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            })
        }
        findViewById<TextView>(R.id.btnSwitchLogin).setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
