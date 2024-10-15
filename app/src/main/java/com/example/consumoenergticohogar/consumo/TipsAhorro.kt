package com.example.consumoenergticohogar.consumo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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

class TipsAhorro {
    private val tips = listOf(
        "Apaga los electrodomésticos cuando no los uses.",
        "Utiliza programas de bajo consumo en tu lavavajillas y lavadora.",
        "Mantén el aire acondicionado a una temperatura moderada.",
        "Desconecta los cargadores cuando no los estés usando.",
        "Aprovecha la luz natural siempre que sea posible."
    )

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TipsAhorroScreen(navController: NavController, modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF45308F))
                .border(width = 5.dp, color = Color(0xFF45308F))
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                "Tips ahorro",
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
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Consejos para ahorrar energía",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        tips.forEachIndexed { index, tip ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 8.dp),
                                shape = RoundedCornerShape(8.dp),
                                elevation = CardDefaults.cardElevation(4.dp)
                            ) {
                                Text(
                                    text = "${index + 1}. $tip",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .background(MaterialTheme.colorScheme.surface)
                                )
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
            ) {
                Text(text = "Volver a la pantalla principal")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun TipsAhorroScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            TipsAhorroScreen(navController)
        }
    }
}