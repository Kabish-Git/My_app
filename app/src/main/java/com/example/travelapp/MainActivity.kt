package com.example.travelapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelApp(this)
        }
    }

    @Composable
    fun TravelApp(context: Context) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                fontSize = 40.sp,
                color = Color(android.graphics.Color.rgb(120, 40, 251)),
                fontFamily = FontFamily.Cursive,
                text = "Wanderlust Travel"
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Destinations
            DestinationCard(
                context = context,
                imageResId = R.drawable.bali,
                placeResId = R.string.place_1,
                descriptionResId = R.string.description_bali,
                planResId = R.string.plan_bali,
                activityClass = BaliActivity::class.java
            )

            Spacer(modifier = Modifier.height(20.dp))

            DestinationCard(
                context = context,
                imageResId = R.drawable.paris,
                placeResId = R.string.place_2,
                descriptionResId = R.string.description_paris,
                planResId = R.string.plan_paris,
                activityClass = ParisActivity::class.java
            )

            Spacer(modifier = Modifier.height(20.dp))

            DestinationCard(
                context = context,
                imageResId = R.drawable.singapore,
                placeResId = R.string.place_3,
                descriptionResId = R.string.description_singapore,
                planResId = R.string.plan_singapore,
                activityClass = SingaporeActivity::class.java
            )

            Spacer(modifier = Modifier.height(20.dp))

            DestinationCard(
                context = context,
                imageResId = R.drawable.newyork,
                placeResId = R.string.place_4,
                descriptionResId = R.string.description_new_york,
                planResId = R.string.plan_new_york,
                activityClass = NewYorkActivity::class.java
            )

            Spacer(modifier = Modifier.height(20.dp))

            DestinationCard(
                context = context,
                imageResId = R.drawable.mysore,
                placeResId = R.string.place_5,
                descriptionResId = R.string.description_mysore,
                planResId = R.string.plan_mysore,
                activityClass = MysoreActivity::class.java
            )

            Spacer(modifier = Modifier.height(20.dp))

            DestinationCard(
                context = context,
                imageResId = R.drawable.ooty,
                placeResId = R.string.place_6,
                descriptionResId = R.string.description_ooty,
                planResId = R.string.plan_ooty,
                activityClass = OotyActivity::class.java
            )

            Spacer(modifier = Modifier.height(20.dp))

            DestinationCard(
                context = context,
                imageResId = R.drawable.switzerland,
                placeResId = R.string.place_7,
                descriptionResId = R.string.description_switzerland,
                planResId = R.string.plan_switzerland,
                activityClass = SwitzerlandActivity::class.java
            )
        }
    }

    @Composable
    fun DestinationCard(
        context: Context,
        imageResId: Int,
        placeResId: Int,
        descriptionResId: Int,
        planResId: Int,
        activityClass: Class<*>
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .clickable {
                    context.startActivity(Intent(context, activityClass))
                },
            elevation = 8.dp
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = null,
                    modifier = Modifier
                        .height(150.dp)
                        .scale(scaleX = 1.2F, scaleY = 1F)
                )
                Text(text = stringResource(id = placeResId), fontSize = 18.sp)
                Text(
                    text = stringResource(id = descriptionResId),
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(id = planResId),
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            }
        }
    }
}
