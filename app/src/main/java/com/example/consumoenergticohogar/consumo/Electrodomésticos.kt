package com.example.consumoenergticohogar.consumo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.consumoenergticohogar.ui.theme.ConsumoEnergéticoHogarTheme

class Electrodomésticos {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ElectrodomesticosScreen(navController: NavController, modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                "Consumo Electrodomésticos",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            titleContentColor = Color.White
                        )
                    )
                },
                content = { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(0x74C2E4F5))
                            .padding(paddingValues)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Electrodomésticos\n",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 0.dp)
                        )
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Seleccione un electrodoméstico",
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Button(
                                onClick = { navController.navigate("Lavadora") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(vertical = 8.dp)
                            ) {
                                Text(text = "Lavadora", fontSize = 18.sp)
                            }
                            Button(
                                onClick = { navController.navigate("AireAcondicionado") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(vertical = 8.dp)
                            ) {
                                Text(text = "Aire Acondicionado", fontSize = 18.sp)
                            }
                            Button(
                                onClick = { navController.navigate("Nevera") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(vertical = 8.dp)
                            ) {
                                Text(text = "Nevera", fontSize = 18.sp)
                            }
                            Button(
                                onClick = { navController.navigate("Lavavajillas") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(vertical = 8.dp)
                            ) {
                                Text(text = "Lavavajillas", fontSize = 18.sp)
                            }
                            Button(
                                onClick = { navController.navigate("Television") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(vertical = 8.dp)
                            ) {
                                Text(text = "Television", fontSize = 18.sp)
                            }
                        }
                    }
                }
            )
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

    @Preview(showBackground = true)
    @Composable
    fun ElectrodomesticosScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            ElectrodomesticosScreen(navController)
        }
    }
}