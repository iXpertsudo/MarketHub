package com.victor.markethub.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.victor.markethub.R
import com.victor.markethub.navigation.ROUTE_Intent
import com.victor.markethub.ui.theme.neworange

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController){


    Column(

        modifier = Modifier.fillMaxSize()
    ){


         //TopAppBar
        TopAppBar(
            title = {Text("Home")},
            navigationIcon = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription = "menu"

                        )





                }
            },
            actions = {
                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.ShoppingCart,
                        contentDescription = ""

                    )





                }

                IconButton(
                    onClick = {}
                ) {
                    Icon(imageVector = Icons.Default.Notifications,
                        contentDescription = "menu"

                    )





                }

                IconButton(
                    onClick = {
                        navController.navigate(ROUTE_Intent)

                    }
                ) {
                    Icon(imageVector = Icons.Default.ArrowForward,
                        contentDescription = "menu"

                    )





                }



            },

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = neworange,
                navigationIconContentColor = Color.White,
                titleContentColor = Color.White,
                actionIconContentColor = Color.White
            )

        )
        //End Of TopAppBar

        Spacer(modifier = Modifier.height(20.dp))

        //Searchbar

        var search by remember { mutableStateOf("") }

        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            modifier = Modifier.padding(start = 10.dp, end = 10.dp).fillMaxWidth(),
            leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") },
            placeholder = { Text("Search products,category...") },

            )
        //End of Searchbar

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Product Categories",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(start = 20.dp),
            fontStyle = FontStyle.Italic
        )


        Spacer(modifier = Modifier.height(20.dp))

        //Row

        Row(
            modifier = Modifier.padding(start = 20.dp).horizontalScroll(rememberScrollState())

        ) {

            Spacer(modifier = Modifier.height(20.dp))



            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)

                Button(
                    {},
                    colors = ButtonDefaults.buttonColors(neworange),
                    shape = RoundedCornerShape(10.dp),

                    ) {
                    Text(text = "Shop Now")

                }




            }

            Spacer(modifier = Modifier.width(20.dp))


            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)

                Button(
                    {},
                    colors = ButtonDefaults.buttonColors(neworange),
                    shape = RoundedCornerShape(10.dp),

                    ) {
                    Text(text = "Shop Now")

                }






            }

            Spacer(modifier = Modifier.width(20.dp))

            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)

                Button(
                    {},
                    colors = ButtonDefaults.buttonColors(neworange),
                    shape = RoundedCornerShape(10.dp),

                    ) {
                    Text(text = "Shop Now")

                }




            }

            Spacer(modifier = Modifier.width(20.dp))




            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)

                Button(
                    {},
                    colors = ButtonDefaults.buttonColors(neworange),
                    shape = RoundedCornerShape(10.dp),

                    ) {
                    Text(text = "Shop Now")

                }




            }

            Spacer(modifier = Modifier.width(20.dp))





            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)

                Button(
                    {},
                    colors = ButtonDefaults.buttonColors(neworange),
                    shape = RoundedCornerShape(10.dp),

                    ) {
                    Text(text = "Shop Now")

                }




            }

            Spacer(modifier = Modifier.width(20.dp))


            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)

                Button(
                    {},
                    colors = ButtonDefaults.buttonColors(neworange),
                    shape = RoundedCornerShape(10.dp),

                    ) {
                    Text(text = "Shop Now")

                }




            }





        }


        //End of Row



        //Row

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.padding(start = 20.dp).horizontalScroll(rememberScrollState())

        ) {

            Spacer(modifier = Modifier.height(20.dp))


            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Top Selling Products 2",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)

                Button(
                    {},
                    colors = ButtonDefaults.buttonColors(neworange),
                    shape = RoundedCornerShape(10.dp),

                    ) {
                    Text(text = "Shop Now")
                }


            }

            Spacer(modifier = Modifier.width(20.dp))


            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)


            }

            Spacer(modifier = Modifier.width(20.dp))

            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)


            }

            Spacer(modifier = Modifier.width(20.dp))




            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)


            }

            Spacer(modifier = Modifier.width(20.dp))





            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)


            }

            Spacer(modifier = Modifier.width(20.dp))


            Column() {

                Image(
                    painter = painterResource(R.drawable.electronics),
                    contentDescription = "product",
                    modifier = Modifier.size(150.dp).clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Electronics",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(start = 20.dp),
                    fontStyle = FontStyle.Italic)


            }

            Button(
                {},
                colors = ButtonDefaults.buttonColors(neworange),
                shape = RoundedCornerShape(10.dp),

            ) {
                Text(text = "Shop Now")
            }





        }


        //End of Row





















    }



}


@Preview (showBackground = true)
@Composable
fun HomeScreenPreview(){

    HomeScreen(rememberNavController())

}
