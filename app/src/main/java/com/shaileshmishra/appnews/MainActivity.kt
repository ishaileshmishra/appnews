package com.shaileshmishra.appnews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shaileshmishra.appnews.ui.theme.AppNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNewsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(20.dp),
                        verticalArrangement = Arrangement.Top,
                        Alignment.Start,
                    ) {
                        News(name = "Shailesh Mishra")
                    }
                }
            }
        }
    }
}


@Composable
fun News(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to App News",
        modifier = modifier
    )

    var switchOn by remember {
        mutableStateOf(false)
    }
    Switch(
        checked = switchOn,
        onCheckedChange = { switchOn_ ->
            switchOn = switchOn_
        },
        colors = SwitchDefaults.colors(
            checkedThumbColor = Color.Green,
            checkedTrackColor = Color.Magenta
        )
    )

    val messageList = listOf<Message>(
        Message("Apple", "", "", ""),
        Message("Cherry", "", "", ""),
        Message("Banana", "", "", "")
    )
    MessageList(messages = messageList)
}


@Composable
fun MessageList(messages: List<Message>) {
    Column {
        messages.forEach { message ->
            MessageTitle(message)
        }
    }
}

@Composable
fun MessageTitle(message: Message) {

    Card(modifier = Modifier
        .padding(all = 10.dp)
        .fillMaxWidth()) {
        Column(modifier = Modifier.padding(all = 10.dp)) {
            Text(message.title, fontSize = 25.sp, fontWeight = FontWeight.W700, modifier = Modifier.padding(10.dp))
            Text(message.title, color = Color.Gray, modifier = Modifier.padding(10.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppNewsTheme {
        News("Android")
    }
}