package com.example.emulador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.emulador.ui.theme.EmuladorTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmuladorTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black // Fondo negro para una apariencia de Android TV
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun MainScreen() {
    Row(
        modifier = Modifier.fillMaxSize()
    ) {
        // Menú lateral
        SideMenu(categories = listOf("Category Zero", "Category One", "Category Two", "Category Three", "Preferencias"))

        // Área principal de contenido
        ContentArea()
    }
}


@Composable
fun SideMenu(categories: List<String>) {
    LazyColumn(
        modifier = Modifier
            .width(200.dp) // Ancho del menú
            .padding(8.dp)
    ) {
        items(categories) { category ->
            Text(
                text = category,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White, // Texto blanco para contraste
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ContentArea() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Videos by Your Company",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Aquí puedes agregar carruseles de videos u otros contenidos
    }
}
