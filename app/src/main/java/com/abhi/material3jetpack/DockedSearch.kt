package com.abhi.material3jetpack

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DockedSearch(modifier : Modifier = Modifier){
    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }

    Box (modifier = modifier.fillMaxSize()){
        DockedSearchBar(
            modifier = modifier
                .align(Alignment.TopCenter)
                .padding(top = 8.dp),
            query = text,
            onQueryChange = {text = it},
            onSearch = {active = false},
            active = active,
            onActiveChange ={active = it},
            placeholder = { Text(text = "Hinted Search bar")},
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            trailingIcon = {
                Icon(Icons.Default.MoreVert , contentDescription = null)
            }
        ) {
            repeat(4){
                idx ->
                val resultText = "Suggestion$idx"
                androidx.compose.material3.ListItem(
                    headlineContent = { Text(resultText) },
                    supportingContent = { Text("Adding Info")},
                    leadingContent = {
                        Icon(Icons.Default.Star, contentDescription = null)
                    },
                    modifier = modifier
                        .clickable {
                            text = resultText
                            active = false
                        }
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp))
            }
        }
        LazyColumn(contentPadding = PaddingValues(
            start = 16.dp,top = 72.dp, end = 16.dp, bottom = 16.dp
        ),
            verticalArrangement = Arrangement.spacedBy(8.dp)){
            val list = List(100){"Text $it"}
            items(count = list.size){
                Text(list[it],
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp))
            }
        }
    }
}