package com.example.consumoenergticohogar.electrodomésticos

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

class Lavavajillas {
    var consumoLavavajillas = Random.nextDouble(10.0, 25.0)
    @Composable
    fun LavavajillasScreen(navController: NavController, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Consumo energético\n" +
                        "Lavavajillas",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Box(modifier = Modifier.fillMaxSize()) {
                if (consumoLavavajillas > 20.0) {
                    Text(
                        text = "El lavavajillas este mes ha tenido un consumo de $consumoLavavajillas kW/h \n" +
                                "Estás consumiendo más de lo recomendado\n" +
                                "¡¡DEBERÍAS REDUCIR EL CONSUMO!!",
                        modifier = modifier.padding(16.dp)
                    )
                } else if (consumoLavavajillas < 15.0) {
                    Text(
                        text = "El lavavajillas este mes ha tenido un consumo de $consumoLavavajillas kW/h \n" +
                                "Estás consumiendo menos de lo recomendado\n" +
                                "¡¡DEBERÍAS AUMENTAR EL CONSUMO!!",
                        modifier = modifier.padding(16.dp)
                    )
                } else {
                    Text(
                        text = "El lavavajillas este mes ha tenido un consumo de $consumoLavavajillas kW/h \n" +
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
    fun LavavajillasScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            this.LavavajillasScreen(navController)
        }
    }
}