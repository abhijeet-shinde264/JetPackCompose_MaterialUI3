package com.abhi.material3jetpack


import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.platform.LocalContext

/*
1. Dropdown Menu
2. Dropdown Menu Item
3. Exposed Dropdown Menu Box
 */

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MenuExample(modifier: Modifier = Modifier)
{
    var expand by remember { mutableStateOf(false)}
    val context = LocalContext.current

    Box(
        modifier = modifier.wrapContentSize()
    ){
        IconButton(onClick = { expand = true }) {
            Icon(Icons.Default.MoreVert, contentDescription = null)
        }
        DropdownMenu(
            expanded = expand,
            onDismissRequest = { expand = false }
        ) {
            DropdownMenuItem(
                text = { Text(text = "Home") },
                onClick =
                {
                    Toast.makeText(context,"Clicked Home.",Toast.LENGTH_LONG).show()
                },
                leadingIcon = {
                    Icon(
                    Icons.Default.Home,
                    contentDescription = null
                )
                }
            )
            DropdownMenuItem(
                text = { Text(text = "Settings") },
                onClick =
                {
                    Toast.makeText(context,"Clicked Settings.",Toast.LENGTH_LONG).show()
                },
                leadingIcon = {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = null
                    )
                }
            )
            Divider()
            DropdownMenuItem(
                text = { Text(text = "Send Feedback") },
                onClick =
                {
                    Toast.makeText(context,"Clicked Feedback.",Toast.LENGTH_LONG).show()
                },
                leadingIcon =
                {
                    Icon(Icons.Default.Email, contentDescription = null)
                },
                trailingIcon = { Text(text = "F11")}
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ExposedDropDown(modifier: Modifier = Modifier)
{
    val options = listOf("Item1","Item2","Item3")
    var expand by remember { mutableStateOf(false) }
    var selectOption by remember { mutableStateOf(options[0])}
    Column(modifier = modifier.fillMaxSize()) {
        ExposedDropdownMenuBox(
            expanded = expand,
            onExpandedChange = {expand = ! expand}
        ) {
            TextField(
                value = selectOption,
                onValueChange = {},
            modifier = modifier.menuAnchor(),
            readOnly = true,
            label = { Text(text = "Lable")},
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expand) },)
        }
    }
}