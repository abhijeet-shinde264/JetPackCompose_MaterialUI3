package com.abhi.material3jetpack

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ListM3(modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier.fillMaxSize()){
        items(items = tasks, key = {it.id}){task ->
            androidx.compose.material3.ListItem(
                headlineContent = { Text(text = task.name) },
                supportingContent = { Text(text = task.desc)},
                leadingContent = {
                    Icon(imageVector = task.icon, contentDescription = task.name)
                },
                trailingContent = {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = task.name)
                }
            )
        }
    }
}
data class Task(
    val id: Int,
    val name : String,
    val icon : ImageVector,
    val desc : String
)

val tasks = listOf(
    Task(1,"Face",Icons.Rounded.Face,"This is Face"),
    Task(2,"FavoriteBorder",Icons.Rounded.FavoriteBorder,"This is Favorite"),
    Task(3,"Email",Icons.Rounded.Email,"This is Email"),
    Task(4,"Home",Icons.Rounded.Home,"This is Home"),
    Task(5,"Share",Icons.Rounded.Share,"This is Share")
)