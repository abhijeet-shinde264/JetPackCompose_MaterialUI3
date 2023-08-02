package com.abhi.material3jetpack

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Done
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.SuggestionChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
/*
1. Assist Chip
2. ElevatedAssistChip
3. FilterChip
4. ElevatedFliterChip
5. SuggestionChip
6. ElevatedSuggestionChip
7. InputChip*/
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AssistChips(modifier: Modifier = Modifier){
    val context = LocalContext.current
    var selected by remember { mutableStateOf(false) }
    var selected1 by remember { mutableStateOf(false)}
    var selected2 by remember { mutableStateOf(false)}
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(top = 10.dp),
    verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally) {
        AssistChip(
            onClick =
            {
                Toast.makeText(context, "This is a Assist Chip", Toast.LENGTH_LONG).show()
            },
            label = { Text(text = "Assist Chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Check,
                    contentDescription = "Localized description",
                    modifier = modifier.size(AssistChipDefaults.IconSize)
                )
            },
            modifier = modifier.padding(bottom = 10.dp)
        )
        Divider()
        ElevatedAssistChip(
            onClick = {
                Toast.makeText(context, "This is a ElevatedAssist Chip", Toast.LENGTH_LONG).show()
            },
            label = { Text(text = "Elevated Assist Chip") },
            leadingIcon = {
                Icon(
                    Icons.Rounded.ShoppingCart,
                    contentDescription = "Localized description",
                    modifier = modifier.size(AssistChipDefaults.IconSize)
                )
            },
            modifier = modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Divider()
        FilterChip(
            selected = selected,
            onClick = { selected = !selected },
            label = { Text(text = "Filter Chip") },
            leadingIcon = if (selected) {
                {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = "Localized Description",
                        modifier = modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else null,
            modifier = modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Divider()
        ElevatedFilterChip(
            selected = selected1,
            onClick = { selected1 = !selected1 },
            label = { Text(text = "Elevated Filter Chip") },
            leadingIcon = if (selected1) {
                {
                    Icon(
                        imageVector = Icons.Rounded.Done,
                        contentDescription = "Localized Description",
                        modifier = modifier.size(FilterChipDefaults.IconSize)
                    )
                }
            } else null,
            modifier = modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Divider()
        SuggestionChip(
            onClick =
            {
                Toast.makeText(context, "This is a Suggestion Chip", Toast.LENGTH_LONG).show()
            },
            label =
            {
                Text(text = "Suggestion Chip")
            },
        icon =
        {
            Icon(
            imageVector = Icons.Rounded.Build,
            contentDescription = "Localized Description",
        modifier = modifier.size(SuggestionChipDefaults.IconSize))
        },
            modifier = modifier.padding(top = 10.dp, bottom = 10.dp))
        Divider()
        ElevatedSuggestionChip(
            onClick =
        {
            Toast.makeText(context, "This is a ElevatedSuggestion Chip", Toast.LENGTH_LONG).show()
        },
            label =
            {
                Text(text = "Elevated Suggestion Chip")
            },
            icon =
            {
                Icon(
                    imageVector = Icons.Rounded.Face,
                    contentDescription = "Localized Description",
                    modifier = modifier.size(SuggestionChipDefaults.IconSize))
            },
            modifier = modifier.padding(top = 10.dp, bottom = 10.dp)
        )
        Divider()
        InputChip(
            selected = selected2 ,
            onClick = { selected2 = !selected2 },
            label = { Text(text = "Input Chip")},
            leadingIcon = {
                if (selected2) {
                    Icon(
                        imageVector = Icons.Rounded.AccountCircle,
                        contentDescription = null,
                        modifier = modifier.size(SuggestionChipDefaults.IconSize))
                }else {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_no_accounts_24),
                        contentDescription = null,
                    modifier = modifier.size(SuggestionChipDefaults.IconSize))
                }
            },
            modifier = modifier.padding(top = 10.dp, bottom = 10.dp)
        )
    }
}