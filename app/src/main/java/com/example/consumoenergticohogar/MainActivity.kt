package com.example.consumoenergticohogar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.consumoenergticohogar.consumo.Agua
import com.example.consumoenergticohogar.consumo.Calefacción
import com.example.consumoenergticohogar.consumo.GestorConsumo
import com.example.consumoenergticohogar.consumo.Electrodomésticos
import com.example.consumoenergticohogar.consumo.Radiadores
import com.example.consumoenergticohogar.consumo.TipsAhorro
import com.example.consumoenergticohogar.electrodomésticos.AireAcondicionado
import com.example.consumoenergticohogar.electrodomésticos.Lavadora
import com.example.consumoenergticohogar.electrodomésticos.Lavavajillas
import com.example.consumoenergticohogar.electrodomésticos.Nevera
import com.example.consumoenergticohogar.electrodomésticos.Television
import com.example.consumoenergticohogar.ui.theme.ConsumoEnergéticoHogarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConsumoEnergéticoHogarTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController, startDestination = "mainScreen", modifier = Modifier.padding(innerPadding)) {
                        composable("mainScreen") { PantallaPrincipal().MainScreen(navController) }
                        composable("gestorConsumo") { GestorConsumo().GestorScreen(navController) }
                        composable("electrodomesticos") { Electrodomésticos().ElectrodomesticosScreen(navController)}
                        composable("Lavadora") { Lavadora().LavadoraScreen(navController) }
                        composable("Lavavajillas") { Lavavajillas().LavavajillasScreen(navController) }
                        composable("AireAcondicionado") { AireAcondicionado().AireScreen(navController) }
                        composable("Television") { Television().TelevisionScreen(navController) }
                        composable("Nevera") { Nevera().NeveraScreen(navController) }
                        composable("Agua") { Agua().AguaScreen(navController) }
                        composable("Calefaccion") { Calefacción().CalefaccionScreen(navController) }
                        composable("Radiadores") { Radiadores().RadiadoresScreen(navController) }
                        composable("TipsAhorro") { TipsAhorro().TipsAhorroScreen(navController) }
                    }
                }
            }
        }
    }
}