package com.abhi.material3jetpack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun DialogMaterial(modifier: Modifier = Modifier){
    var openDialog by remember { mutableStateOf(false)}
    IconButton(onClick = { openDialog = true }) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete Icon"
        )
    }
    if(openDialog){
        AlertDialog(onDismissRequest = { openDialog = false },
            icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
        title = { Text(text = "Dialog with hero icon")},
        text = {
            Text(text = "A dialog is a type of modal window that appears in front of app content to provide critical information, or ask for a decision.")
        },
        confirmButton = {
            TextButton(onClick = { openDialog = false }) {
                Text(text = "Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = { openDialog = false }) {
                Text(text = "Dismiss")
            }
        })
    }
}

@Preview(showBackground = true , showSystemUi = true)
@Composable
fun DialogM3() {
    var openDialog by remember { mutableStateOf(false) }

    IconButton(onClick = { openDialog = true }) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete Icon"
        )
    }

    if (openDialog) {
        Dialog(onDismissRequest = { openDialog = false }) {
            Surface {
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Congratulation",
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = "You have cleared all the stages",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Button(onClick = { openDialog = false }) {
                        Text(text = "Play")
                    }
                }
            }
        }
    }
}
