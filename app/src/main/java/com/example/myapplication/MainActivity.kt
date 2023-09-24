package com.example.myapplication

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
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
                    Greeting(shouldPlaySound = true)
                }
            }
        }
    }
}

@Composable
fun Greeting(shouldPlaySound: Boolean) {
    var result by remember { mutableStateOf(0) }
    var isCatHappy by remember {
        mutableStateOf(false)
    }

    val catTails = Cat(
        name = stringResource(id = R.string.tails_name),
        beforeActionTextResId = R.string.tails_before_action_text,
        afterActionTextResId = R.string.tails_after_action_text,
        imageResId = R.drawable.tails,
        actionSoundEffectResId = R.raw.tails_after_action_sound_effect
    )
    val catBruno = Cat(
        name = stringResource(id = R.string.bruno_name),
        beforeActionTextResId = R.string.bruno_before_action_text,
        afterActionTextResId = R.string.bruno_after_action_text,
        imageResId = R.drawable.bruno,
        actionSoundEffectResId = R.raw.bruno_after_action_sound_effect
    )
    val catTabby = Cat(
            name = stringResource(id = R.string.tabby_name),
        beforeActionTextResId = R.string.tabby_before_action_text,
        afterActionTextResId = R.string.tabby_after_action_text,
        imageResId = R.drawable.tabby,
        actionSoundEffectResId = R.raw.tabby_after_action_sound_effect
    )

    var cats by remember {
        mutableStateOf(listOf(catTails, catBruno, catTabby))
    }

    val actionText =
        if (isCatHappy) stringResource(id = cats[result].afterActionTextResId)
        else stringResource(id = cats[result].beforeActionTextResId)
    val catSound = if (shouldPlaySound) MediaPlayer.create(
        LocalContext.current,
        cats[result].actionSoundEffectResId
    ) else null

    catSound?.setOnCompletionListener {
        it.release()
    }

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
                            .size(220.dp, 55.dp),
                        text = stringResource(id = R.string.app_name),
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
                text = "Hello ${cats[result].name} !",
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
                    Box(modifier = Modifier.clickable {
                        isCatHappy = !isCatHappy
                        catSound?.start()
                    }) {
                        Image(
                            modifier = Modifier
                                .size(300.dp, 300.dp)
                                .clip(RoundedCornerShape(24.dp)),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(cats[result].imageResId),
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
                            enabled = result > 0,
                        ) {

                            Text(
                                stringResource(R.string.last_button),
                                fontSize = 20.sp
                            )
                        }
                        Button(onClick = {
                            result = result + 1
                            isCatHappy = false
                        }, enabled = result < 2) {
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
                    ChangeNameButton(
                        onTextChanged = { value -> cats[result].name = value }
                    )
                }
            }
        }
    }
}

@Composable
fun ChangeNameButton(onTextChanged: (String) -> Unit) {
    var shouldDisplayInputField by remember { mutableStateOf(false) }

    FloatingActionButton(onClick = { shouldDisplayInputField = true }) {
        Text(text = stringResource(id = R.string.change_cat_name_button))
    }

    if (shouldDisplayInputField) {
        DisplayInputField(
            onTextChanged = { value -> onTextChanged(value) },
            onInputFieldClose = { shouldDisplayInputField = false }
        )
    }
}

@Composable
fun DisplayInputField(
    onTextChanged: (String) -> Unit,
    onInputFieldClose: () -> Unit
) {
    var inputValue by remember { mutableStateOf(TextFieldValue()) }

    AlertDialog(
        onDismissRequest = { onInputFieldClose() },
        text = {
            BasicTextField(
                value = inputValue,
                onValueChange = { inputValue = it },
                modifier = Modifier
                    .padding(16.dp)
                    .size(200.dp, 30.dp)
                    .border(3.dp, Color.hsl(200f, 0.70f, 0.25f))
            )
        },
        confirmButton = {
            Button(onClick = {
                onInputFieldClose()
                onTextChanged(inputValue.text)
            }) {
                Text(text = "OK")
            }
        },
        dismissButton = {
            Button(onClick = { onInputFieldClose() }) {
                Text(text = "Cancel")
            }
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting(shouldPlaySound = false)
    }
}
