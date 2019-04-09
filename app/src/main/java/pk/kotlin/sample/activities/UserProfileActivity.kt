package pk.kotlin.sample.activities

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.Toolbar
import pk.kotlin.sample.R

class UserProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        initUI()
    }

    private fun initUI() {
        setupToolbar()
    }


    private fun setupToolbar() {
        var toolbar = findViewById<Toolbar>(R.id.layoutToolbar)
        var btnClose = toolbar.findViewById<AppCompatImageButton>(R.id.toolbarCloseButton)
        var btnSignOut = toolbar.findViewById<TextView>(R.id.btnSignOut)

        btnClose.setOnClickListener {
            finish()
        }

        btnSignOut.setOnClickListener {
            finish()
        }
    }
}
