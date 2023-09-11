package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
    Image(painter = painterResource(id = R.drawable.androidparty), contentDescription = "Background" )
    Column (
        verticalArrangement = Arrangement.Center)
    {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Welcome",
            fontSize = 60.sp,
            lineHeight = 0.sp,
            textAlign = TextAlign.Center,
            color = Color.hsl(hue = 150f, saturation = 0.71f, lightness = 0.85f),
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold

        )
        Text(
            text = "Home",
            fontSize = 60.sp ,
            modifier = Modifier.fillMaxWidth(),
            color = Color.hsl(hue = 345f, saturation = 0.69f, lightness = 0.66f),
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold,
            letterSpacing = 20.sp
        )
        Text(
            text = "Bruno",
            fontSize = 90.sp,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
        Box(modifier = Modifier
            .size(
                500.dp, 320.dp
            )
            .border(5.dp, Color.White)
            .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.bruno),
                contentDescription = "bruno's photo",
                modifier = Modifier
                    .size(450.dp, 400.dp)
            )
        }
        Text(
            text = "From: YY and Alejandro",
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            textAlign = TextAlign.Right,
            fontStyle = FontStyle.Italic,
            fontSize = 24.sp,

            )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Yingying and Alejandro went to Santana Row to buy Ice cream and some cookies for Tails. It's sooo delicious")
    }
}