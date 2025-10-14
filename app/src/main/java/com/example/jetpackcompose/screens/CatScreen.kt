package com.example.jetpackcompose.screens

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackcompose.navigation.AppScreens
import com.example.jetpackcompose.network.getCatFact
import com.example.jetpackcompose.network.getCatImage
import kotlinx.coroutines.launch

// ====== Paleta igual que en FirstScreen (gris cálido) ======
private val SkeuoBgLight = Color(0xFFECECEC)
private val SkeuoBgDark  = Color(0xFFBDBDBD)
private val SkeuoSurface = Color(0xFFF7F7F7)
private val SkeuoEdgeHi  = Color(0xFFFFFFFF)
private val SkeuoText    = Color(0xFF3A3A3A)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatScreen(navController: NavController) {
    var catFact by remember { mutableStateOf("Cargando… ") }
    var catImage by remember { mutableStateOf<Bitmap?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()

    // Carga automática al entrar
    LaunchedEffect(Unit) {
        scope.launch {
            catFact = getCatFact() ?: "No se pudo obtener el fact "
            catImage = getCatImage()
            isLoading = false
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Demostraciòn API", color = SkeuoText) }
                // si quieres un ícono de volver aquí, lo añadimos luego
            )
        }
    ) { padding ->
        // Fondo esqueumórfico
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Tarjeta contenedora (relieve + gradiente)
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
                        .padding(20.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // Fact
                        Text(
                            text = if (isLoading) "Cargando… 🐱" else catFact,
                            color = SkeuoText
                        )

                        Spacer(Modifier.height(16.dp))

                        // Imagen (si ya cargó)
                        catImage?.let { bmp ->
                            Image(
                                bitmap = bmp.asImageBitmap(),
                                contentDescription = "Gato",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(220.dp)
                                    .shadow(12.dp, RoundedCornerShape(24.dp))
                                    .clip(RoundedCornerShape(24.dp))
                                    .background(Color.White)
                                    .border(
                                        1.dp,
                                        SkeuoEdgeHi.copy(alpha = 0.5f),
                                        RoundedCornerShape(24.dp)
                                    )
                            )
                        }
                    }
                }

                Spacer(Modifier.height(20.dp))

                // Recargar fact + gato
                SkeuoButton(
                    text = if (isLoading) "Cargando…" else "Otro",
                    onClick = {
                        if (!isLoading) {
                            isLoading = true
                            scope.launch {
                                catFact = getCatFact() ?: "No se pudo obtener el fact 😿"
                                catImage = getCatImage()
                                isLoading = false
                            }
                        }
                    }
                )

                Spacer(Modifier.height(12.dp))

                // Volver
                SkeuoButton(
                    text = "Volver",
                    onClick = { navController.navigate(AppScreens.FirstScreen.route) }
                )
            }
        }
    }
}
