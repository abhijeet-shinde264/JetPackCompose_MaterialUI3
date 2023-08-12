package com.abhi.material3jetpack

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true , showBackground = true)
@Composable
fun TopBar(modifier: Modifier = Modifier){
    val scrollBar = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val context = LocalContext.current
    Scaffold(
        modifier = modifier.nestedScroll(scrollBar.nestedScrollConnection),
        topBar = {
            CenterTobBar(scrollBehavior = scrollBar)
        }
    ){ innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            val list = (0..70).map {  it.toString() }
            items(count = list.size){
                Text(
                    text = list[it],
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CenterTobBar(modifier: Modifier = Modifier,scrollBehavior : TopAppBarScrollBehavior ){
    val context = LocalContext.current
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Center App Bar",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            },
            navigationIcon = {
                IconButton(onClick = { Toast.makeText(context,"Clicked Navigation Icon", Toast.LENGTH_LONG).show()}) {
                    Icon(imageVector = Icons.Filled.Menu,
                        contentDescription = "Localized description"
                    )
                }
            },
            actions = {
                IconButton(onClick = { Toast.makeText(context,"Clicked Icon Button", Toast.LENGTH_LONG).show() }) {
                    Icon(imageVector = Icons.Filled.Face,
                        contentDescription = "Localized description"
                    )
                }
            },
            scrollBehavior = scrollBehavior
        )
}