package com.example.lab_04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_04.ui.theme.Lab_04Theme

// Colores constantes
private val ColorPrimary = Color(0xFF4CAF50)
private val ColorSecondary = Color(0xFFF44336)
private val TitleColor = Color.Yellow
private val SubtitleColor = Color.Green

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_04Theme {
                // Scaffold principal
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GreetingScreen(modifier: Modifier = Modifier) {
    // Columna principal con scroll
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título principal
        Text(
            text = "Bienvenido al Curso",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = TitleColor
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Subtítulo
        Text(
            text = "Hola, Android!",
            fontSize = 30.sp,
            color = SubtitleColor
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Descripción adicional
        Text(
            text = "Aprende a crear apps modernas con Jetpack Compose",
            fontSize = 18.sp,
            color = Color.LightGray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Card con botones
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF212121))
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ActionButtons()
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Imagen decorativa
        DecorativeImage()

        Spacer(modifier = Modifier.height(16.dp))

        // Botón extra
        Button(
            onClick = { /* Acción más info */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Cyan,
                contentColor = Color.Black
            )
        ) {
            Text("Más información")
        }
    }
}

@Composable
fun ActionButtons() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(
            onClick = { /* Acción aceptar */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorPrimary,
                contentColor = Color.White
            )
        ) {
            Text("Aceptar")
        }

        Button(
            onClick = { /* Acción cancelar */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = ColorSecondary,
                contentColor = Color.White
            )
        ) {
            Text("Cancelar")
        }
    }
}

@Composable
fun DecorativeImage() {
    Image(
        painter = painterResource(id = R.drawable.images__1_),
        contentDescription = "Imagen de ejemplo",
        modifier = Modifier.size(120.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab_04Theme {
        GreetingScreen()
    }
}
