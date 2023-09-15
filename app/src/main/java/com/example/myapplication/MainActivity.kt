package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Yingying BABA")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.tails
        2 -> R.drawable.bruno
        else -> {
            R.drawable.tabby
        }
    }
    val catName = when (result) {
        1 -> "Tails"
        2 -> "Bruno"
        else -> {
            "Tabby"
        }
    }
    var isCatHappy by remember {
        mutableStateOf(false)
    }

    val actionText =
        if (isCatHappy) "$catName is happier after your petting!"
        else "$catName seems to want pet..."

    Box(modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center
        )
        {
            Box(
                modifier = Modifier
                    .background(color = Color.hsl(202f, 0.65f, 0.85f))
                    .size(400.dp, 55.dp)
            ) {
                Row(
                    modifier = Modifier
                        .size(400.dp, 55.dp)
                        .align(Alignment.Center),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier
                            .size(200.dp, 55.dp),
                        text = "Los Gatos",
                        fontSize = 40.sp,
                        lineHeight = 0.sp,
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Image(
                        painter = painterResource(id = R.drawable.black_cat),
                        contentDescription = "cat_logo"
                    )

                }

            }
            Text(
                text = "Hello $catName !",
                fontSize = 35.sp,
                fontWeight = FontWeight(350),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.hsl(202f, 0.65f, 0.85f))
                    .padding(20.dp)
            )

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.background),
                    contentDescription = "Background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(800.dp, 900.dp)

                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier.clickable { isCatHappy = !isCatHappy }) {
                        Image(
                            modifier = Modifier
                                .size(300.dp, 300.dp)
                                .clip(RoundedCornerShape(24.dp)),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(imageResource),
                            contentDescription = "Funny_cat_1"
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Button(
                            onClick = {
                                result = result - 1
                                isCatHappy = false
                            },
                            enabled = result > 1,
                        ) {

                            Text(
                                stringResource(R.string.last_button),
                                fontSize = 20.sp
                            )
                        }
                        Button(onClick = {
                            result = result + 1
                            isCatHappy = false
                        }, enabled = result < 3) {
                            Text(
                                stringResource(R.string.next_button),
                                fontSize = 20.sp
                            )
                        }
                    }
                    Text(
                        text = actionText,
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color.hsl(200f, 0.70f, 0.25f),
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 20.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Yingying and Alejandro went to Santana Row to buy Ice cream and some cookies for Tails. It's sooo delicious")
    }
}