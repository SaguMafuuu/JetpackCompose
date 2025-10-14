package com.example.jetpackcompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.navigation.AppScreens

// ====== Paleta igual que en First/Third/Cat ======
private val SkeuoBgLight = Color(0xFFECECEC)
private val SkeuoBgDark  = Color(0xFFBDBDBD)
private val SkeuoSurface = Color(0xFFF7F7F7)
private val SkeuoEdgeHi  = Color(0xFFFFFFFF)
private val SkeuoText    = Color(0xFF3A3A3A)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(navController: NavController) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(SkeuoBgLight, SkeuoBgDark)
                    )
                )
        ) {
            SecondBodyContent(navController)
        }
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
        // ===== Avatar circular con sombra y borde =====
        Box(
            modifier = Modifier
                .size(150.dp)
                .shadow(12.dp, CircleShape, clip = false)
                .clip(CircleShape)
                .background(Color.White)
                .border(2.dp, SkeuoEdgeHi.copy(alpha = 0.7f), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.andres),
                contentDescription = "Foto de perfil de Andrés",
                modifier = Modifier
                    .size(140.dp)
                    .clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ===== Nombre =====
        Text(
            text = "Andres Ortega Marinez",
            color = SkeuoText
        )

        Spacer(modifier = Modifier.height(16.dp))

        // ===== Perfil en tarjeta esqueumórfica =====
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(10.dp, RoundedCornerShape(20.dp), clip = false)
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.linearGradient(
                        listOf(SkeuoSurface, Color(0xFFE7E7E7))
                    )
                )
                .border(1.dp, SkeuoEdgeHi.copy(alpha = 0.5f), RoundedCornerShape(20.dp))
                .padding(16.dp)
        ) {
            Text(
                text = "Futuro ingeniero apasionado por las luchas, el rock y la ciberseguridad. " +
                        "Trabaja en PwC, donde fortalece su experiencia en análisis y seguridad. " +
                        "Le motiva aprender, compartir conocimiento y construir proyectos que combinen tecnología y creatividad.",
                textAlign = TextAlign.Center,
                color = SkeuoText
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        // ===== Botón de regreso con tu estilo =====
        SkeuoButton(
            text = "Regresar",
            onClick = { navController.navigate(AppScreens.FirstScreen.route) }
        )
    }
}
