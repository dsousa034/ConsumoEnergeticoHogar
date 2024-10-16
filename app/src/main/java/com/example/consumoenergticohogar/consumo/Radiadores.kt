package com.example.consumoenergticohogar.consumo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

class Radiadores {
    var consumoRadiadores = 1500.0

    @Composable
    fun RadiadoresScreen(navController: NavController, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Consumo energético\n" +
                        "Radiadores",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(16.dp)
            )
            Box(modifier = Modifier.fillMaxSize()) {
                if (consumoRadiadores > 2160.0) {
                    Text(
                        text = "Los radiadores este mes han tenido un consumo de $consumoRadiadores kW/h \n" +
                                "Estás consumiendo más de lo recomendado\n" +
                                "¡¡DEBERÍAS REDUCIR EL CONSUMO!!",
                        fontSize = 18.sp,
                        modifier = modifier.padding(16.dp)
                    )
                } else {
                    Text(
                        text = "Los radiadores este mes han tenido un consumo de $consumoRadiadores kW/h \n" +
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
                        .height(70.dp)
                        .width(150.dp),
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                ) {
                    Text(text = "Inicio", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun RadiadoresScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            this.RadiadoresScreen(navController)
        }
    }
}