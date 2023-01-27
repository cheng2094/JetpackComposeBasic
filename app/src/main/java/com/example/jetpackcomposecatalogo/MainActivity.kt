package com.example.jetpackcomposecatalogo

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalogo.ui.theme.JetpackComposeCatalogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCatalogoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyStateExample()
                }
            }
        }
    }
}

@Composable
fun MyStateExample(){
    var counter = rememberSaveable{ mutableStateOf(0)}
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { counter.value += 1 }) {
                Text(text = "Pulsar")
            }
        Text(text = "He sido pulsado ${counter.value} veces")
    }
}


@Composable
fun MyComplexLayout(){
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center){
                Text(text = "Cyan")
        }
        MySpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)){
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red), contentAlignment = Alignment.Center){
                Text(text = "Red")
            }
            Box(modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Green), contentAlignment = Alignment.Center){
                Text(text = "Hola soy Sheng")
            }
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter){
            Text(text = "Magenta")
        }
    }
}

@Composable
fun MySpacer(size: Int){
    Spacer(modifier = Modifier.height(size.dp))
}


@Composable
fun MyRow(){
//    Row(Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween) {
//        Text(text = "Ejemplo1")
//        Text(text = "Ejemplo2")
//        Text(text = "Ejemplo3")
//    }
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())) {
        Text(text = "Ejemplo1", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo2", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
        Text(text = "Ejemplo3", modifier = Modifier.width(100.dp))
    }
}

@Composable
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ejemplo 1",
            modifier = Modifier
                .background(Color.Red)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 2",
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Ejemplo 3",
            modifier = Modifier
                .background(Color.Cyan)
                .fillMaxWidth()
                .height(100.dp)
        )
    }
}

@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.BottomCenter
        ) {
            Text("Esto es un ejemplo")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeCatalogoTheme {
        MyStateExample()
    }
}