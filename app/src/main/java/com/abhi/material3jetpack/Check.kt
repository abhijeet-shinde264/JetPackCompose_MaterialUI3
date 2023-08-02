package com.abhi.material3jetpack

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Check(modifier : Modifier = Modifier){
    val checkitems = listOf("First Option","Second Option","Third Option")
    val checkedState = remember{ mutableStateMapOf<String,Boolean>().withDefault { false }}
    Column(
        modifier = modifier
            .fillMaxSize(),
    ) {
        Text(
            text = "Checkbox Examples",
            modifier = modifier.padding(start = 32.dp,top = 20.dp),
            textAlign = TextAlign.Start
        )
        checkitems.forEach{item ->
            Row(
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp)
                .toggleable(
                    value = checkedState.getValue(item),
                    onValueChange = { checkedState[item] = it }
                )
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item,
                style = MaterialTheme.typography.bodyLarge,
                modifier = modifier.padding(start = 16.dp)
            )
            Checkbox(
                checked = checkedState.getValue(item),
                onCheckedChange = null,
            )
        }
            Divider()
        }
    }
}