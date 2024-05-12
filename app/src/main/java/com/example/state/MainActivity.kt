package com.example.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.state.ui.theme.StateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ImageApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun ImageApp(modifier: Modifier){
    var current by remember{ mutableStateOf(1)}

    when(current){
        1->{
            ImageAndDescription(image = R.drawable.vangogh, description = stringResource(id = R.string.first),author = stringResource(
                id = R.string.author),modifier = Modifier.fillMaxSize())
            ButtonPreviuous(onClick = {current = 4}, modifier = Modifier.fillMaxSize())
            ButtonNext(onClick = {current = 2}, modifier = Modifier.fillMaxSize())
        }

        2->{
            ImageAndDescription(image = R.drawable.flowers, description = stringResource(id = R.string.second),author = stringResource(
                id = R.string.author),modifier = Modifier.fillMaxSize())
            ButtonPreviuous(onClick = {current = 1}, modifier = Modifier.fillMaxSize())
            ButtonNext(onClick = {current = 3}, modifier = Modifier.fillMaxSize())
        }

        3->{
            ImageAndDescription(image = R.drawable.white, description = stringResource(id = R.string.third),author = stringResource(
                id = R.string.author),modifier = Modifier.fillMaxSize())
            ButtonPreviuous(onClick = {current = 2}, modifier = Modifier.fillMaxSize())
            ButtonNext(onClick = {current = 4}, modifier = Modifier.fillMaxSize())
        }

        4->{
            ImageAndDescription(image = R.drawable.bedroom, description = stringResource(id = R.string.fourth),author = stringResource(
                id = R.string.author) ,modifier = Modifier.fillMaxSize())
            ButtonPreviuous(onClick = {current = 3}, modifier = Modifier.fillMaxSize())
            ButtonNext(onClick = {current = 1}, modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun ImageAndDescription(image:Int,description:String,author:String,modifier: Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(image),
            contentDescription = "Current showing image"
        )

        Text(
            text = description,
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Normal,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
        
        Text(
            text = author,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier.padding(top = 80.dp)
        )
    }
}

@Composable
fun ButtonNext(onClick:()->Unit,modifier: Modifier){
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End,
    ){
        Button(onClick=onClick,modifier = Modifier.padding(end = 30.dp)){
            Text(text = "Next")
        }
    }
}

@Composable
fun ButtonPreviuous(onClick: () -> Unit,modifier: Modifier){
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Start,
    ){
        Button(onClick = onClick,modifier = Modifier.padding(start = 30.dp)){
            Text(text = "Previous")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    StateTheme {
        ImageAndDescription(image = R.drawable.vangogh, description = stringResource(id = R.string.first), author = stringResource(
            id = R.string.author
        ),modifier = Modifier.fillMaxSize())
    }
}