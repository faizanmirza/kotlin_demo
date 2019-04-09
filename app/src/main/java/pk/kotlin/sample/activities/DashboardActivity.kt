package pk.kotlin.sample.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_dashboard.*
import pk.kotlin.sample.R
import pk.kotlin.sample.fragments.MapFragment
import pk.kotlin.sample.fragments.ScheduleListFragment
import pk.kotlin.sample.utils.Utils

class DashboardActivity : AppCompatActivity() {

    private var currentFragment: Fragment? = null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.navSchedule -> {
                if (currentFragment is ScheduleListFragment) {
                    return@OnNavigationItemSelectedListener true
                } else {
                    setUIForFabIcon(true)
                    switchFragment(ScheduleListFragment())

                    return@OnNavigationItemSelectedListener true
                }
            }
            R.id.navMap -> {
                if (currentFragment is MapFragment) {
                    return@OnNavigationItemSelectedListener true
                } else {
                    setUIForFabIcon(false)
                    switchFragment(MapFragment())
                    return@OnNavigationItemSelectedListener true
                }
            }
        }
        false
    }

    private fun setUIForFabIcon(isScheduleScreen: Boolean) {

        if (isScheduleScreen) {
            fabRegister.icon = Utils.getDrawable(R.drawable.ic_group_work)
            fabRegister.text = Utils.getString(R.string.register)
        } else {
            fabRegister.icon = Utils.getDrawable(R.drawable.ic_my_location)
            fabRegister.text = Utils.getString(R.string.navigate)
        }

    }

    private fun switchFragment(fragment: Fragment) {

        currentFragment = fragment
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment, fragment, fragment.toString())
        fragmentTransaction.addToBackStack(fragment.toString())
        fragmentTransaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        initUI()
        switchFragment(ScheduleListFragment())
    }

    private fun initUI() {

        var fabRegister = findViewById<MaterialButton>(R.id.fabRegister)
        var navigationView = findViewById<BottomNavigationView>(R.id.navigation)
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        fabRegister.setOnClickListener {

            if (currentFragment is MapFragment) {
                openGoogleMap()
            } else {
                openRegistrationFragment()
            }
        }
    }

    private fun openRegistrationFragment() {
        intent = Intent(this, RegistrationActivity::class.java)
        startActivity(intent)
    }

    private fun openGoogleMap() {

        val gmmIntentUri = Uri.parse("geo:24.8633741, 67.0747251")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }
    }
}