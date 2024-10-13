package com.example.consumoenergticohogar.consumo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

class Calefacción {
    @Composable
    fun CalefaccionScreen(navController: NavController, modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = "Consumo energético Calefaccion\n" +
                            "Seleccione una opcion",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Column(modifier = modifier) {
                    Button(onClick = { navController.navigate("AireAcondicionado") }) {
                        Text(text = "Aire Acondicionado")
                    }
                    Button(onClick = { navController.navigate("Radiadores") }) {
                        Text(text = "Radiadores")
                    }
                }
            }
        }
    }
}
