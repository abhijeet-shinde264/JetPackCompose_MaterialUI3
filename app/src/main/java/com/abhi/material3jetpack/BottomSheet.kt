package com.abhi.material3jetpack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true , showSystemUi = true)
@Composable
fun BottomSheet(modifier: Modifier = Modifier){

    var openSheet by remember { mutableStateOf(false)}
    val scope = rememberCoroutineScope()
    val bottomsheetstate = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = { openSheet = true }
        ) {
            Text(text = "Show Bottom Sheet")
        }
    }

    if (openSheet){
        ModalBottomSheet(
            sheetState = bottomsheetstate
            ,onDismissRequest = { openSheet = false },
            dragHandle = {
                Column(
                    modifier = modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    BottomSheetDefaults.DragHandle()
                    Text(
                        text = "Comments",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Divider()
                }
            }
        ) {
            BottomSheetContent(
                onHideButtonClick = {
                    scope.launch { bottomsheetstate.hide() }.invokeOnCompletion {
                        if (!bottomsheetstate.isVisible) openSheet = false
                    }
                }
            )
        }
    }

}

@Composable
fun BottomSheetContent(
    onHideButtonClick: () -> Unit
){
    LazyColumn(contentPadding = PaddingValues(16.dp)){
        items(5){
            androidx.compose.material3.ListItem(
                headlineContent = { Text(text = "Item $it") },
                leadingContent = {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                }
            )
        }
        item{
            Button(
                onClick = onHideButtonClick,
                modifier = Modifier.fillMaxWidth()) {
                Text(text = "Cancel")
            }
        }
    }
}