package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScopeInstance.matchParentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
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
    Box(modifier = Modifier) {
        Column(
            verticalArrangement = Arrangement.Center
        )
        {
            Box(
                modifier = Modifier
                    .background(color = Color.hsl(199f, 0.70f, 0.87f))
                    .size(400.dp, 55.dp)
            ) {
                Row(
                    modifier = Modifier
                        .size(200.dp, 55.dp)
                        .align(Alignment.Center),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier
                            .size(150.dp, 55.dp),
                        text = "CuteCat",
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
            Box(
                modifier = Modifier.align(Alignment.End)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.funny_cat_blog_15_desktop_background),
                    contentDescription = "Welcome_Photo"
                )
                Row(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                ) {
                    Text(
                        text = "TODAY CAT:",
                        fontSize = 35.sp,
                        fontWeight = FontWeight(1000),
                        fontStyle = FontStyle.Normal,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .size(210.dp, 50.dp)
                    )
                    Text(
                        text = "Butters",
                        fontSize = 35.sp,
                        fontWeight = FontWeight(250),
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .size(150.dp, 50.dp)
                    )
                }


            }
            Box(
                modifier = Modifier.fillMaxHeight()
            ) {
//                Column() {
//                    Image(
//                        painter = painterResource(id = R.drawable.background_paws),
//                        contentDescription = "Background",
//                        modifier = Modifier
//                            .size(800.dp,400.dp)
//                    )
//                    Image(
//                        painter = painterResource(id = R.drawable.background_paws),
//                        contentDescription = "Background",
//                        modifier = Modifier
//                            .size(800.dp,800.dp)
//                    )
//                }
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