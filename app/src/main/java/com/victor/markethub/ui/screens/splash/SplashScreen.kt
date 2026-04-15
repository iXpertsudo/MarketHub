package com.victor.markethub.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.victor.markethub.R
import com.victor.markethub.navigation.ROUTE_OnBoarding
import com.victor.markethub.ui.theme.neworange
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    //Navigation
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(ROUTE_OnBoarding) {
            popUpTo(ROUTE_OnBoarding) { inclusive = true }
        }
    }
    //End of Navigation

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = neworange),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(R.drawable.electronics),
            contentDescription = "electronics",
            modifier = Modifier.size(300.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}
