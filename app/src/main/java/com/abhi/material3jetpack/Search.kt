package com.abhi.material3jetpack

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true , showSystemUi = true)
@Composable
fun Search(modifier: Modifier = Modifier){
    var search by remember { mutableStateOf("")}
    var active by remember { mutableStateOf(false)}

    var list = listOf("Goal","Android","JetPack Compose","Marshmello","100","Bareeeee")

    Box(modifier = modifier.fillMaxSize()) {
        SearchBar(
            query = search,
            onQueryChange = { search = it },
            onSearch = { newQuery -> print("performing search on: $newQuery") },
            active = active,
            onActiveChange = { active = it },
            placeholder = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },
            trailingIcon = {
                Row() {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_mic_24),
                            contentDescription = "mic"
                        )
                    }
                    if (active) {
                        IconButton(onClick = {
                            if (search.isNotEmpty()) search = "" else active = false
                        }) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
                        }
                    }
                }
            }
        )
        {
            list.takeLast(3).forEach { item ->
                ListItem(
                    modifier = modifier.clickable { search = item }
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp),
                    headlineContent = { Text(text = item) },
                    leadingContent = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_history_24),
                            contentDescription = null
                        )
                    }
                )
            }
        }
    }
}
