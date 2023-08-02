package com.abhi.material3jetpack

import android.graphics.ColorSpace
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun Swich(modifier : Modifier = Modifier){
    var isChecked by remember {
        mutableStateOf(false)
    }
    val icons = if (isChecked) Icons.Filled.Check else Icons.Filled.Close

    val icon:(@Composable () -> Unit)? = if (isChecked){
        {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = null,
            modifier = modifier.size(SwitchDefaults.IconSize))
        }
    }else null

    Column(modifier = modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()) {
            Text(text = "Switch1",
            textAlign = TextAlign.Center,
            modifier = modifier.padding(start = 10.dp))
            Switch(
                checked = isChecked,
                onCheckedChange = {isChecked = it},
                thumbContent = icon,
                modifier = modifier.padding(end = 10.dp),
            )
        }
    }
}