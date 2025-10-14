package com.example.jetpackcompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose.R
import com.example.jetpackcompose.navigation.AppScreens

// Paleta
private val SkeuoBgLight = Color(0xFFECECEC)
private val SkeuoBgDark  = Color(0xFFBDBDBD)
private val SkeuoSurface = Color(0xFFF7F7F7)
private val SkeuoEdgeHi  = Color(0xFFFFFFFF)
private val SkeuoText    = Color(0xFF3A3A3A)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirtScreen(navController: NavController) {
    Scaffold { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(SkeuoBgLight, SkeuoBgDark)
                    )
                ),
            contentAlignment = Alignment.Center // <- centramos el contenido
        ) {
            BodyContent(navController)
        }
    }
}

@Composable
fun BodyContent(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // --- Caja con logo y título ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(18.dp, shape = RoundedCornerShape(28.dp), clip = false)
                .clip(RoundedCornerShape(28.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(SkeuoSurface, Color(0xFFE7E7E7))
                    )
                )
                .border(1.dp, SkeuoEdgeHi.copy(alpha = 0.6f), RoundedCornerShape(28.dp))
                .padding(vertical = 24.dp, horizontal = 20.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(220.dp) // <- aquí la hacemos más grande
                        .shadow(10.dp, RoundedCornerShape(28.dp))
                        .clip(RoundedCornerShape(28.dp))
                        .background(Color.White)
                        .border(1.dp, SkeuoEdgeHi.copy(alpha = 0.5f), RoundedCornerShape(28.dp))
                        .padding(16.dp)
                )
                Spacer(Modifier.height(16.dp))
                Text("Crepa Mania", color = SkeuoText)
            }
        }

        Spacer(Modifier.height(40.dp))

        // --- Botones esqueumórficos ---
        SkeuoButton(
            text = "API",
            onClick = { navController.navigate(AppScreens.CatScreen.route) }
        )

        Spacer(Modifier.height(16.dp))

        SkeuoButton(
            text = "Andres",
            onClick = { navController.navigate(AppScreens.SecondScreen.route) }
        )

        Spacer(Modifier.height(16.dp))

        SkeuoButton(
            text = "Santiago",
            onClick = { navController.navigate(AppScreens.ThirdScreen.route) }
        )
    }
}

@Composable
fun SkeuoButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .shadow(14.dp, shape = RoundedCornerShape(22.dp), clip = false)
            .clip(RoundedCornerShape(22.dp))
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFDFDFD),
                        Color(0xFFEFEFEF),
                        Color(0xFFD8D8D8)
                    )
                )
            )
            .border(1.dp, SkeuoEdgeHi.copy(alpha = 0.7f), RoundedCornerShape(22.dp))
            .clickable(onClick = onClick)
            .padding(horizontal = 28.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = text, color = SkeuoText)
    }
}
