package com.example.lab_04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_04.ui.theme.Lab_04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_04Theme {
                // Componente 1: Scaffold principal
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Componente 2: Pantalla de saludo
                    GreetingScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingScreen(modifier: Modifier = Modifier) {
    // Componente 3: Columna principal
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Bienvenido al Curso",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Yellow
        )

        Spacer(modifier = Modifier.height(30.dp))


        Text(
            text = "Hola, Android!",
            fontSize = 30.sp,
            color = Color.Green
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Componente 6: Row con dos botones
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Componente 6a: Botón Aceptar
            Button(
                onClick = { /* Acción aceptar */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF4CAF50), // Verde
                    contentColor = Color.White
                )
            ) {
                Text("Aceptar")
            }

            // Componente 6b: Botón Cancelar
            Button(
                onClick = { /* Acción cancelar */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF44336), // Rojo
                    contentColor = Color.White
                )
            ) {
                Text("Cancelar")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Componente 7: Imagen decorativa
        Image(
            painter = painterResource(id = R.drawable.images__1_),
            contentDescription = "Imagen de ejemplo",
            modifier = Modifier.size(120.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab_04Theme {
        GreetingScreen()
    }
}
