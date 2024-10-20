package com.example.consumoenergticohogar.consumo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.consumoenergticohogar.ui.theme.ConsumoEnergéticoHogarTheme
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class Calefacción {
    var consumoCalefaccion = 1500.0

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun CalefaccionScreen(navController: NavController, modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                "Consumo Calefacción",
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
                            text = "Calefacción\n",
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
                                text = "Seleccione una categoría",
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
                                onClick = { navController.navigate("AireAcondicionado") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(vertical = 8.dp)
                            ) {
                                Text(text = "Aire Acondicionado", fontSize = 18.sp)
                            }
                            Button(
                                onClick = { navController.navigate("Radiadores") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(60.dp)
                                    .padding(vertical = 8.dp)
                            ) {
                                Text(text = "Radiadores", fontSize = 18.sp)
                            }
                        }
                        LineChartView(consumoCalefaccion)
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

    @Composable
    fun LineChartView(consumo: Double) {
        val entries = listOf(Entry(0f, consumo.toFloat()))
        val dataSet = LineDataSet(entries, "Consumo").apply {
            color = Color.Blue.toArgb()
            valueTextColor = Color.Black.toArgb()
        }
        val lineData = LineData(dataSet)
        AndroidView(
            factory = { context ->
                LineChart(context).apply {
                    data = lineData
                    invalidate()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun CalefaccionScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            CalefaccionScreen(navController)
        }
    }
}