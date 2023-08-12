package com.abhi.material3jetpack

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true , showSystemUi = true)
@Composable

fun FloatingButton(modifier: Modifier = Modifier){
    val listState = rememberLazyListState()
    val isExpanded by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 }}

    Scaffold (floatingActionButton = {
        Column {
            ExtendedFABM3(expanded = isExpanded)
            Spacer(modifier = modifier.height(20.dp))
            Floating()
            Spacer(modifier = modifier.height(20.dp))
            SmallFAB()
            Spacer(modifier = modifier.height(20.dp))
            LargeFAB()
        }

    }){padding ->
        LazyColumn(
            state = listState,
            modifier = modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp)){
            items(50){
                androidx.compose.material3.ListItem(
                    headlineContent = { Text(text = "Items $it") },
                    leadingContent = {
                        Icon(imageVector = Icons.Default.Face, contentDescription = null)
                    }
                )
            }
        }
    }
}

@Composable
fun Floating(modifier: Modifier = Modifier){
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context,"Clicked FAB.", Toast.LENGTH_LONG).show()
    }) {
        Icon(imageVector = Icons.Default.Edit, contentDescription = null)
    }
}

@Composable
fun SmallFAB(modifier: Modifier = Modifier){
    val context = LocalContext.current
    SmallFloatingActionButton(onClick = {
        Toast.makeText(context,"Clicked Small FAB.", Toast.LENGTH_LONG).show()
    }) {
        Icon(imageVector = Icons.Default.Search, contentDescription = null)
    }
}

@Composable
fun LargeFAB(modifier: Modifier = Modifier){
    val context = LocalContext.current
    LargeFloatingActionButton(onClick = {
        Toast.makeText(context,"Clicked Large FAB.", Toast.LENGTH_LONG).show()
    }) {
        Icon(
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = null,
            modifier = modifier.size(FloatingActionButtonDefaults.LargeIconSize))
    }
}

@Composable
fun ExtendedFABM3(
    expanded: Boolean
) {
    val context = LocalContext.current
    ExtendedFloatingActionButton(
        onClick = {
            Toast.makeText(context,"Clicked Extended FAB.", Toast.LENGTH_LONG).show()
        },
        icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = null) },
        text = { Text(text = "Compose")},
        expanded = expanded
    )
}