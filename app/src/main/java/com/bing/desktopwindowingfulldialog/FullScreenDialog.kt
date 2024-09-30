package com.bing.desktopwindowingfulldialog

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.bing.desktopwindowingfulldialog.ui.theme.DesktopWindowingFullDialogTheme

@Composable
fun FullScreenDialog(
    onDismiss: () -> Unit = {}
) {
    val context = LocalContext.current
    Dialog(
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        ),
        onDismissRequest = onDismiss
    ) {
        Card(
            modifier = Modifier
                .width(360.dp)
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier.background(MaterialTheme.colorScheme.inversePrimary)
            ) {
                Icon(
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            Toast
                                .makeText(
                                    context,
                                    "Close button clicked!",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                            onDismiss()
                        },
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                )
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "FULL SCREEN DIALOG!"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewFullScreenDialog() {
    DesktopWindowingFullDialogTheme {
        FullScreenDialog()
    }
}
