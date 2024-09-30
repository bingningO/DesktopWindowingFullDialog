package com.bing.desktopwindowingfulldialog

import android.os.Build
import android.os.Bundle
import android.view.WindowInsetsController.APPEARANCE_TRANSPARENT_CAPTION_BAR_BACKGROUND
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bing.desktopwindowingfulldialog.ui.theme.DesktopWindowingFullDialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setEdgeToEdge()
        setContent {
            MainContent()
        }
    }
}

private fun ComponentActivity.setEdgeToEdge() {
    enableEdgeToEdge()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) {
        window.insetsController?.setSystemBarsAppearance(
            APPEARANCE_TRANSPARENT_CAPTION_BAR_BACKGROUND,
            APPEARANCE_TRANSPARENT_CAPTION_BAR_BACKGROUND
        )
    }
}

@Composable
private fun MainContent() {
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    DesktopWindowingFullDialogTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            DialogButton(
                modifier = Modifier.padding(innerPadding),
                onClick = {
                    showDialog = true
                }
            )
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Button(
                    onClick = {
                        Toast
                            .makeText(
                                context,
                                "Top Button clicked!",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                ) {
                    Text(text = "Top Button")
                }
            }

            if (showDialog) {
                FullScreenDialog(onDismiss = { showDialog = false })
            }
        }
    }
}

@Composable
private fun DialogButton( modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(modifier = modifier.fillMaxSize()) {
        Button(modifier = Modifier.align(Alignment.Center), onClick = onClick) {
            Text(text = "Display Dialog")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DesktopWindowingFullDialogTheme {
        MainContent()
    }
}
