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
fun ThirdScreen(navController: NavController) {
    Scaffold {
        ThirdBodyContent(navController)
    }
}

@Composable
fun ThirdBodyContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Avatar
        Image(
            painter = painterResource(id = R.drawable.santi),
            contentDescription = "Foto de perfil de Santiago",
            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Nombre
        Text(text = "Santiago Gutiérrez Morales")

        Spacer(modifier = Modifier.height(8.dp))

        // Perfil (<100 palabras)
        Text(
            text = "Me gusta el análisis de datos y actualmente trabajo en Stellantis, " +
                    "donde desarrollo mis habilidades en procesos y tecnología. " +
                    "En mi tiempo libre disfruto jugar videojuegos y mantenerme activo haciendo ejercicio, " +
                    "lo que me ayuda a equilibrar mi vida profesional y personal.",
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Botón de regreso
        Button(onClick = { navController.navigate(AppScreens.FirstScreen.route) }) {
            Text(text = "Regresar")
        }
    }
}
