package com.victor.markethub.ui.screens.OnBoarding

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.victor.markethub.R
import com.victor.markethub.ui.theme.neworange

@Composable
fun OnBoardingScreen(){


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    )  {

        // Image
        Image(
            painter = painterResource(R.drawable.products),
            contentDescription = "product",
            modifier = Modifier.size(300.dp)
            )




        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "WELCOME TO MARKETHUB",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = neworange,
            fontFamily = FontFamily.SansSerif
        )


        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Shop Smarter,",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )



        Text(
            text = "everywhere you go",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )



        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Effective ecommerce mobile app design focuses on user-friendly interfaces, seamless navigation, and features that enhance engagement and conversion.",
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
        )



        Spacer(modifier = Modifier.height(20.dp))

        Button(
            {},
            colors = ButtonDefaults.buttonColors(neworange),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.width(350.dp)
        ) {
            Text(text = "Get Started")
        }
















    }



}


@Preview (showBackground = true)
@Composable
fun OnBoardingScreenPreview(){

    OnBoardingScreen()

}