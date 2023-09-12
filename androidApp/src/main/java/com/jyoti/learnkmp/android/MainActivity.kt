package com.jyoti.learnkmp.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jyoti.learnkmp.MainView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainView()
//            MyApplicationTheme {
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    var text by remember { mutableStateOf("Loading") }
//                    LaunchedEffect(key1 = Unit, block = {
//                        text = try {
//                            Greeting().greet()
//                        } catch (e: Exception) {
//                            e.localizedMessage ?: "error"
//                        }
//                    })
//                    GreetingView(text)
//                }
//            }
        }
    }
}
//
//@Composable
//fun GreetingView(text: String) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(textAlign = TextAlign.Center, text = text)
//    }
//}
//
//@Preview
//@Composable
//fun DefaultPreview() {
//    MyApplicationTheme {
//        GreetingView("Hello, Android!")
//    }
//}
