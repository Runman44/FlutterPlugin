package nl.mranderson.flutterplugindemo.testcases.singlefragment

import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import io.flutter.embedding.android.FlutterFragment
import nl.mranderson.flutterplugindemo.R

class FlutterSingleFragmentActivity : FragmentActivity() {

    private var flutterFragment: FlutterFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager
        val newFlutterFragment = FlutterFragment.withCachedEngine("flutter_engine_id").build<FlutterFragment>()
        flutterFragment = newFlutterFragment
        fragmentManager
            .beginTransaction()
            .add(
                R.id.fragment_container,
                newFlutterFragment,
                "TAG_FLUTTER_FRAGMENT"
            )
            .commit()
    }

    override fun onPostResume() {
        super.onPostResume()
        flutterFragment?.onPostResume()
    }

    override fun onNewIntent(@NonNull intent: Intent) {
        super.onNewIntent(intent)
        flutterFragment?.onNewIntent(intent)
    }

    override fun onBackPressed() {
        flutterFragment?.onBackPressed()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        flutterFragment?.onRequestPermissionsResult(
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
        flutterFragment?.onActivityResult(
            requestCode,
            resultCode,
            data
        )
    }

    override fun onUserLeaveHint() {
        flutterFragment?.onUserLeaveHint()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        flutterFragment?.onTrimMemory(level)
    }
}
