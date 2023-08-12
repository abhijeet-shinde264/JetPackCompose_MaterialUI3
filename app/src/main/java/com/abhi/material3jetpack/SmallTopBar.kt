package com.abhi.material3jetpack

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SmallTop(modifier: Modifier = Modifier){
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val context = LocalContext.current
    Scaffold (
    modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Small Top App Bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis)
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                                Toast.makeText(context , "Clicked navigation Icon.", Toast.LENGTH_LONG).show()
                            }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            Toast.makeText(context , "Clicked Attaced Icon.", Toast.LENGTH_LONG).show()
                        }
                    ) 
                    {
                        Icon(painter = painterResource(id = R.drawable.baseline_attach_file_24), contentDescription = null)
                    }
                    IconButton(
                        onClick = {
                        Toast.makeText(context , "Clicked Calander Icon.", Toast.LENGTH_LONG).show()
                    }
                    ) {
                        Icon(painterResource(id = R.drawable.baseline_calendar_month_24),contentDescription = null)
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ){innerpadding ->
        LazyColumn(
            contentPadding = innerpadding,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ){
            val list = (0..85).map { it.toString() }
            items(count = list.size){
                Text(
                    text = "This is list $it",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}
