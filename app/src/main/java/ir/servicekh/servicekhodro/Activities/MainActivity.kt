package ir.servicekh.servicekhodro.Activities

import android.net.Uri
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import ir.servicekh.servicekhodro.R
import ir.servicekh.servicekhodro.Fragments.HomeFragment
import androidx.fragment.app.Fragment
import ir.servicekh.servicekhodro.Fragments.CustomersFragment
import ir.servicekh.servicekhodro.Fragments.OnFragmentInteractionListener


class MainActivity : AppCompatActivity() , OnFragmentInteractionListener {
       private lateinit var textMessage: TextView
    val fragment1: Fragment = HomeFragment()
    val fragment2: Fragment = CustomersFragment()
    val fm = supportFragmentManager
    var active = fragment1

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                fm.beginTransaction().hide(active).show(fragment1).commit()
                active = fragment1
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_customers -> {
                fm.beginTransaction().hide(active).show(fragment2).commit()
                active = fragment2
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_add -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_reports -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_help -> {
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        fm.beginTransaction().show(fragment1).commit()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
