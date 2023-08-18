package nl.mranderson.flutterplugindemo.testcases.bottomnav

import android.content.Context
import android.os.Bundle
import androidx.core.view.WindowCompat
import io.flutter.embedding.android.FlutterFragment
import io.flutter.embedding.android.FlutterView

class DemoFlutterFragment : FlutterFragment() {
    override fun onAttach(context: Context) {
        (arguments ?: Bundle()).apply {
            /**
             * It is important to do this to instruct the base FlutterFragment to automatically
             * propagate the back press to the engine. It also has to be done before the base's `onAttach`
             */
            putBoolean(ARG_SHOULD_AUTOMATICALLY_HANDLE_ON_BACK_PRESSED, true)
            arguments = this
        }
        super.onAttach(context)
    }

    override fun onStart() {
        super.onStart()
        /**
         * onPostResume() will basically set deprecated system UI flags to do the same. Here we don't call onPostResume but call this new API for ourselves.
         *
         * But now because we use the Flutter Fragment inside bottomNav - this height will be added to the keyboard. what to do?
         */
        onPostResume()
        WindowCompat.setDecorFitsSystemWindows(requireActivity().window, false)
        flutterEngine?.also {
            (view as? FlutterView)?.attachToFlutterEngine(it)
        }
    }

    override fun onStop() {
        (view as? FlutterView)?.detachFromFlutterEngine()
        /**
         * Here we disable the fullscreen system UI - otherwise the status bar will be ignored on native pages
         */
        WindowCompat.setDecorFitsSystemWindows(requireActivity().window, true)
        super.onStop()
    }

    override fun getCachedEngineId(): String = "flutter_engine_id"
}
