import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.navigation.compose.*

@Composable
fun AppLayout() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        HeaderSection()
        BodySection()
        FooterSection()
    }
}

@Composable
fun HeaderSection() {
    Text(text = "Header", style = MaterialTheme.typography.h4)
}

@Composable
fun BodySection() {
    var inputText by remember { mutableStateOf("") }

    TextField(
        value = inputText,
        onValueChange = { inputText = it },
        label = { Text("Enter Text") },
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    )

    Button(onClick = { }) {
        Text("Submit")
    }

    if (inputText.isNotEmpty()) {
        Text("You entered: $inputText", modifier = Modifier.padding(top = 16.dp))
    }
}

@Composable
fun FooterSection() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        IconButton(onClick = { }) {
            Icon(painter = painterResource(id = android.R.drawable.ic_menu_info_details), contentDescription = "Info")
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { AppLayout() }
    }
}

@Composable
fun Animations() {
    var expanded by remember { mutableStateOf(false) }

    AnimatedVisibility(visible = expanded) {
        Text("Animation Triggered", modifier = Modifier.padding(top = 16.dp))
    }

    Button(onClick = { expanded = !expanded }) {
        Text("Toggle Animation")
    }
}

@Composable
fun AccessibleUI() {
    Button(onClick = { }, modifier = Modifier.semantics { contentDescription = "Accessible Button" }) {
        Text("Click Me")
    }
}

@Preview
@Composable
fun PreviewApp() {
    AppLayout()
}
