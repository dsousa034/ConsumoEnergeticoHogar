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

class Electrodomésticos {
    @Composable
    fun ElectrodomesticosScreen(navController: NavController, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Consumo energético electrodomésticos\n" +
                            "Seleccione un electrodoméstico",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Button(onClick = { navController.navigate("Lavadora") }) {
                    Text(text = "Lavadora")
                }
                Button(onClick = { navController.navigate("AireAcondicionado") }) {
                    Text(text = "Aire Acondicionado")
                }
                Button(onClick = { navController.navigate("Nevera") }) {
                    Text(text = "Nevera")
                }
                Button(onClick = { navController.navigate("Lavavajillas") }) {
                    Text(text = "Lavavajillas")
                }
                Button(onClick = { navController.navigate("Television") }) {
                    Text(text = "Television")
                }
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

    @Preview(showBackground = true)
    @Composable
    fun ElectrodomesticosScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            ElectrodomesticosScreen(navController)
        }
    }
}