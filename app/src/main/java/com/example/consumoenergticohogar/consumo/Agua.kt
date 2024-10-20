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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.consumoenergticohogar.ui.theme.ConsumoEnergéticoHogarTheme
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class Agua {
    var consumoAgua = 120.0
    private val mensaje = if (consumoAgua > 111.0) {
        "Este mes ha tenido un consumo de agua de $consumoAgua litros \n" +
                "Estás consumiendo más de lo recomendado\n" +
                "¡¡DEBERÍAS REDUCIR EL CONSUMO!!"
    } else {
        "Este mes ha tenido un consumo de agua de $consumoAgua litros \n" +
                "Estás en el rango de valores óptimos\n" +
                "¡¡SIGUE ASÍ!!"
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AguaScreen(navController: NavController, modifier: Modifier = Modifier) {
        val backgroundColor = if (mensaje.contains("¡¡SIGUE ASÍ!!")) Color(0xFFD0F0C0) else Color(0xFFFFC0C0)

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Consumo Agua") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = Color.White
                    )
                )
            },
            content = { paddingValues ->
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp)
                ) {
                    Column {
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            shape = RoundedCornerShape(8.dp),
                            elevation = CardDefaults.cardElevation(4.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .background(backgroundColor)
                                    .border(8.dp, Color.LightGray, RoundedCornerShape(8.dp))
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = mensaje,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            }
                        }
                        LineChartView(consumoAgua)
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
        )
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
    fun AguaScreenPreview() {
        val navController = rememberNavController()
        ConsumoEnergéticoHogarTheme {
            AguaScreen(navController)
        }
    }
}