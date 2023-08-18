package nl.mranderson.flutterplugindemo.testcases.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import nl.mranderson.flutterplugindemo.R
import nl.mranderson.flutterplugindemo.ui.theme.FlutterPluginDemoTheme

class DemoNativeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                FlutterPluginDemoTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Column {
                            Text(text = "Header - StatusBar Check")
                            Text(text = "Header - Below StatusBar Check")
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                launchFlutterButton("Go to Flutter Demo Fragment") {
                                    findNavController().navigate(R.id.demo)
                                }
                            }
                        }
                    }
                }
            }
        }

    @Composable
    fun launchFlutterButton(text: String, onClick: () -> Unit) {
        Button(onClick = onClick) {
            Text(text = text)
        }
    }

}
