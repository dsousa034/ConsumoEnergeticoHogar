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

class AireAcondicionado {
    var consumoAireAcondicionado = Random.nextDouble(10.0, 25.0)
    private val mensaje = if (consumoAireAcondicionado in 10.0..20.0) {
        "El aire acondicionado este mes ha tenido un consumo de $consumoAireAcondicionado kW/h \n" +
                "Estás en el rango de valores óptimos\n" +
                "¡¡SIGUE ASÍ!!"
    } else {
        "El aire acondicionado este mes ha tenido un consumo de $consumoAireAcondicionado kW/h \n" +
                "Estás fuera del rango de valores óptimos\n" +
                "¡NECESITAS MEJORAR!"
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AireAcondicionadoScreen(navController: NavController, modifier: Modifier = Modifier) {
        val backgroundColor = if (mensaje.contains("¡¡SIGUE ASÍ!!")) Color(0xFFD0F0C0) else Color(0xFFFFC0C0)

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Consumo Aire Acondicionado") },
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
                        .background(backgroundColor)
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
                                text = mensaje,
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
    fun AireAcondicionadoScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            AireAcondicionadoScreen(navController)
        }
    }
}