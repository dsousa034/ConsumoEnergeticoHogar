package com.example.consumoenergticohogar

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
import androidx.navigation.compose.rememberNavController
import com.example.consumoenergticohogar.ui.theme.ConsumoEnergéticoHogarTheme
import androidx.compose.ui.tooling.preview.Preview

class PantallaPrincipal {
    @Composable
    fun MainScreen(navController: NavController, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Bienvenido al gestor de consumo energético de su hogar\n" +
                        "¿Qué desea hacer?",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Button(
                onClick = { navController.navigate("gestorConsumo") },
                modifier = modifier
            ) {
                Text(text = "Ver consumo energético de mi hogar por categorías")
            }
            Button(
                onClick = { navController.navigate("") },
                modifier = modifier
            ) {
                Text(text = "¿Qué debería hacer para ahorrar más?")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            MainScreen(navController)
        }
    }
}