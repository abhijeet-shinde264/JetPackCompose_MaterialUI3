package com.abhi.material3jetpack

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Indicator(modifier: Modifier = Modifier){
    var isloading by remember { mutableStateOf(false)}

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if(isloading){
            Indicator2()
        }
        Button(onClick = { isloading = !isloading }) {
            Text(text = "Click for Indicator")
        }
    }
}

@Composable
fun Indicator2(modifier: Modifier = Modifier){
    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(progress = animatedProgress)
        Button(onClick = {
            if (progress < 1f) progress += 0.1f
        }) {
            Text(text = "Click Here")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Linier(modifier : Modifier = Modifier){
    var isLoading by remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isLoading) {
            Linier2()
        }
        Button(onClick = { isLoading = !isLoading }) {
            Text(text = "Click Here")
        }
    }
}

@Composable
fun Linier2(modifier : Modifier = Modifier){
    var progress by remember { mutableStateOf(0.1f) }
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LinearProgressIndicator(progress = animatedProgress)
        Button(onClick = {
            if (progress < 1f) progress += 0.1f
        }) {
            Text(text = "Click Here")
        }
    }
}