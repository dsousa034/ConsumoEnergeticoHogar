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

class Nevera {
    var consumoNevera = Random.nextDouble(10.0, 25.0)
    @Composable
    fun NeveraScreen(navController: NavController, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Consumo energético\n" +
                        "Nevera",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Box(modifier = Modifier.fillMaxSize()) {
                if (consumoNevera > 20.0) {
                    Text(
                        text = "La nevera este mes ha tenido un consumo de $consumoNevera kW/h \n" +
                                "Estás consumiendo más de lo recomendado\n" +
                                "¡¡DEBERÍAS REDUCIR EL CONSUMO!!",
                        fontSize = 18.sp,
                        modifier = modifier.padding(16.dp)
                    )
                } else if (consumoNevera < 15.0) {
                    Text(
                        text = "La nevera este mes ha tenido un consumo de $consumoNevera kW/h \n" +
                                "Estás consumiendo menos de lo recomendado\n" +
                                "¡¡DEBERÍAS AUMENTAR EL CONSUMO!!",
                        fontSize = 18.sp,
                        modifier = modifier.padding(16.dp)
                    )
                } else {
                    Text(
                        text = "La nevera este mes ha tenido un consumo de $consumoNevera kW/h \n" +
                                "Estás en el rango de valores óptimos\n" +
                                "¡¡SIGUE ASÍ!!",
                        fontSize = 18.sp,
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
    fun NeveraScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            this.NeveraScreen(navController)
        }
    }
}