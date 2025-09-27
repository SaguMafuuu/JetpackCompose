package com.example.jetpackcompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SecondScreen(navController: NavController) {
    Scaffold {
        SecondBodyContent(navController)
    }
}

@Composable
fun SecondBodyContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar
        Image(
            painter = painterResource(id = R.drawable.andres),
            contentDescription = "Foto de perfil de Andrés",
            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre
        Text(text = "Andres Ortega Marinez")

        Spacer(modifier = Modifier.height(8.dp))

        // Perfil (menos de 100 palabras)
        Text(
            text = "Futuro ingeniero apasionado por las luchas, el rock y la ciberseguridad. " +
                    "Trabaja en PwC, donde fortalece su experiencia en análisis y seguridad. " +
                    "Le motiva aprender, compartir conocimiento y construir proyectos que combinen tecnología y creatividad.",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón de regreso
        Button(onClick = { navController.navigate(AppScreens.FirstScreen.route) }) {
            Text(text = "Regresar")
        }
    }
}
