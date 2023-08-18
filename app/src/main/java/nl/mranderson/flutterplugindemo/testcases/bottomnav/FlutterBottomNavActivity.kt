package nl.mranderson.flutterplugindemo.testcases.bottomnav

import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.flutter.embedding.android.FlutterFragment
import nl.mranderson.flutterplugindemo.R

class FlutterBottomNavActivity : FragmentActivity() {

    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav_bar)
        bottomNavigationView.setupWithNavController(navController)

        bottomNavigationView.setOnItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(item, navController)
            return@setOnItemSelectedListener true
        }
    }

    override fun onNewIntent(@NonNull intent: Intent) {
        super.onNewIntent(intent)
        (navHostFragment.childFragmentManager.primaryNavigationFragment as? FlutterFragment)?.onNewIntent(intent)
    }

    override fun onBackPressed() {
        (navHostFragment.childFragmentManager.primaryNavigationFragment as? FlutterFragment)?.onBackPressed()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        (navHostFragment.childFragmentManager.primaryNavigationFragment as? FlutterFragment)?.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        (navHostFragment.childFragmentManager.primaryNavigationFragment as? FlutterFragment)?.onActivityResult(
            requestCode,
            resultCode,
            data
        )
    }

    override fun onUserLeaveHint() {
        (navHostFragment.childFragmentManager.primaryNavigationFragment as? FlutterFragment)?.onUserLeaveHint()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        (navHostFragment.childFragmentManager.primaryNavigationFragment as? FlutterFragment)?.onTrimMemory(level)
    }
}
