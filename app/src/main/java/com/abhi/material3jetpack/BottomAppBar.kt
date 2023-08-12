@file:OptIn(ExperimentalMaterial3Api::class)

package com.abhi.material3jetpack

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true , showSystemUi = true)
@Composable
fun BottomApp(modifier: Modifier = Modifier){
    Scaffold(
        bottomBar = {BottomApp1()}
    ) {
        padding ->
        run {
            LazyColumn(
                modifier = modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp)
            ) {
                items(50) {
                    ListItem(
                        headlineContent = { Text(text = "Item $it") },
                        leadingContent = {
                            Icon(imageVector = Icons.Default.Face, contentDescription = null)
                        })
                }
            }
        }
    }
}

@Composable
fun BottomApp1(modifier: Modifier = Modifier){
    val context = LocalContext.current
    BottomAppBar(
        actions = {
            IconButton(
                onClick =
                {
                    Toast.makeText(context,"Clicked Check.",Toast.LENGTH_LONG).show()
                }
            )
            {
                Icon(Icons.Filled.Check, contentDescription = null)
            }
            IconButton(
                onClick =
                {
                    Toast.makeText(context,"Clicked Edit.",Toast.LENGTH_LONG).show()
                }
            )
            {
                Icon(Icons.Filled.Edit, contentDescription = null)
            }
            IconButton(
                onClick =
                {
                    Toast.makeText(context,"Clicked Search.",Toast.LENGTH_LONG).show()
                }
            )
            {
                Icon(Icons.Filled.Search, contentDescription = null)
            }
            IconButton(
                onClick =
                {
                    Toast.makeText(context,"Clicked Share.",Toast.LENGTH_LONG).show()
                }
            )
            {
                Icon(Icons.Filled.Share, contentDescription = null)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick =
                {
                    Toast.makeText(context,"Clicked FAB.",Toast.LENGTH_LONG).show()
                },
                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                containerColor = BottomAppBarDefaults.bottomAppBarFabColor
            ) {
                Icon(Icons.Filled.Add, contentDescription = null )
            }
        }
    )
}