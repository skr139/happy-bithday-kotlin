package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(message = getString(R.string.happy_birthday_text), from = getString(
                        R.string.signature_text
                    ))
                }
            }
        }
    }
}

/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}*/
@Composable
fun GreetingText(message: String, from: String,modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier) {
        Text(
            text = message,
            fontSize = 60.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }
}
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier, contentAlignment = Alignment.Center) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(message = message, from = from, modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        //GreetingText(message = "Hola Kotlin, como te va?!", from = "Desde California")
        GreetingImage(message = "Hola Kotlin, Feliz cumpleaños", from = "From SKR")
    }
}