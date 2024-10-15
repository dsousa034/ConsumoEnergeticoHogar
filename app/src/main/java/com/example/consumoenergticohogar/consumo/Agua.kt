package com.example.consumoenergticohogar.consumo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.consumoenergticohogar.ui.theme.ConsumoEnergéticoHogarTheme
import kotlin.random.Random

class Agua {
    var consumoAgua = Random.nextDouble(70.0, 120.0)

    @Composable
    fun AguaScreen(navController: NavController, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Consumo energético\n" +
                        "Agua",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Box(modifier = Modifier.fillMaxSize()) {
                if (consumoAgua > 111.0) {
                    Text(
                        text = "Este mes ha tenido un consumo de agua de $consumoAgua litros \n" +
                                "Estás consumiendo más de lo recomendado\n" +
                                "¡¡DEBERÍAS REDUCIR EL CONSUMO!!",
                        modifier = modifier.padding(16.dp)
                    )
                } else {
                    Text(
                        text = "Este mes ha tenido un consumo de agua de $consumoAgua litros \n" +
                                "Estás en el rango de valores óptimos\n" +
                                "¡¡SIGUE ASÍ!!",
                        modifier = modifier.padding(16.dp)
                    )
                }
                Button(
                    onClick = { navController.navigate("mainScreen") },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(16.dp)
                ) {
                    Text(text = "Volver a la pantalla principal")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun AguaScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            this.AguaScreen(navController)
        }
    }
}