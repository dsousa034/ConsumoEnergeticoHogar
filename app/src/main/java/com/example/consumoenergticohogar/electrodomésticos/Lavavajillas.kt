package com.example.consumoenergticohogar.electrodomésticos

import androidx.compose.foundation.background
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

class Lavavajillas {
    var consumoLavavajillas = Random.nextDouble(10.0, 25.0)

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun LavavajillasScreen(navController: NavController, modifier: Modifier = Modifier) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Consumo Lavavajillas") },
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
                            Text(
                                text = "El lavavajillas este mes ha tenido un consumo de $consumoLavavajillas kW/h \n" +
                                        "Estás en el rango de valores óptimos\n" +
                                        "¡¡SIGUE ASÍ!!",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Medium,
                                modifier = Modifier
                                    .padding(16.dp)
                                    .background(MaterialTheme.colorScheme.surface)
                            )
                        }
                    }
                    Button(
                        onClick = { navController.navigate("mainScreen") },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(16.dp),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                    ) {
                        Text(text = "Volver a la pantalla principal", color = Color.White)
                    }
                }
            }
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun LavavajillasScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            LavavajillasScreen(navController)
        }
    }
}