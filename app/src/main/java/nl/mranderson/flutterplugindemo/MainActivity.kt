package nl.mranderson.flutterplugindemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import nl.mranderson.flutterplugindemo.testcases.bottomnav.FlutterBottomNavActivity
import nl.mranderson.flutterplugindemo.testcases.singlefragment.FlutterSingleFragmentActivity
import nl.mranderson.flutterplugindemo.ui.theme.FlutterPluginDemoTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlutterPluginDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        launchFlutterButton("Go to Flutter Single Fragment") {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    FlutterSingleFragmentActivity::class.java
                                )
                            )
                        }
                        launchFlutterButton("Go to Flutter BottomNav Fragment") {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    FlutterBottomNavActivity::class.java
                                )
                            )
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
