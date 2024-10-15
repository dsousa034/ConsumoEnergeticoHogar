package com.example.consumoenergticohogar.electrodomésticos

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.consumoenergticohogar.ui.theme.ConsumoEnergéticoHogarTheme
import kotlin.random.Random

class Lavadora {
    var consumoLavadora = Random.nextDouble(10.0, 25.0)
    private val mensaje = if (consumoLavadora in 10.0..20.0) {
        "La lavadora este mes ha tenido un consumo de $consumoLavadora kW/h \n" +
                "Estás en el rango de valores óptimos\n" +
                "¡¡SIGUE ASÍ!!"
    } else {
        "La lavadora este mes ha tenido un consumo de $consumoLavadora kW/h \n" +
                "Estás fuera del rango de valores óptimos\n" +
                "¡NECESITAS MEJORAR!"
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LavadoraScreen(navController: NavController, modifier: Modifier = Modifier) {
        val backgroundColor = if (mensaje.contains("¡¡SIGUE ASÍ!!")) Color(0xFFD0F0C0) else Color(0xFFFFC0C0)

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Consumo Lavadora") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = Color.White
                    )
                )
            },
            content = { paddingValues ->
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp)
                ) {
                    Column {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(backgroundColor)
                                    .border(8.dp, Color.LightGray, RoundedCornerShape(8.dp))
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = mensaje,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                    }
                    Button(
                        onClick = { navController.navigate("mainScreen") },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(16.dp)
                            .height(70.dp)
                            .width(150.dp),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                    ) {
                        Text(text = "Inicio", color = Color.White, fontSize = 18.sp)
                    }
                }
            }
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun LavadoraScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            LavadoraScreen(navController)
        }
    }
}