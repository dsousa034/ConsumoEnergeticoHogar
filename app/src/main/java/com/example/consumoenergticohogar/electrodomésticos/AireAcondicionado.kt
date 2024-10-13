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

class AireAcondicionado {
    var consumoAireAcondicionado = Random.nextDouble(80.0, 250.0)

    @Composable
    fun AireScreen(navController: NavController, modifier: Modifier = Modifier) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Consumo energético\n" +
                        "Aire acondicionado",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Box(modifier = Modifier.fillMaxSize()) {
                if (consumoAireAcondicionado > 200.0) {
                    Text(
                        text = "El aire acondicionado este mes ha tenido un consumo de $consumoAireAcondicionado kW/h \n" +
                                "Estás consumiendo más de lo recomendado\n" +
                                "¡¡DEBERÍAS REDUCIR EL CONSUMO!!",
                        modifier = modifier.padding(16.dp)
                    )
                } else if (consumoAireAcondicionado < 100.0) {
                    Text(
                        text = "El aire acondicionado este mes ha tenido un consumo de $consumoAireAcondicionado kW/h \n" +
                                "Estás consumiendo menos de lo recomendado\n" +
                                "¡¡DEBERÍAS AUMENTAR EL CONSUMO PARA EVITAR PROBLEMAS DE INACTIVIDAD!!",
                        modifier = modifier.padding(16.dp)
                    )
                } else {
                    Text(
                        text = "El aire acondicionado este mes ha tenido un consumo de $consumoAireAcondicionado kW/h \n" +
                                "Estás en el rango de valores óptimos\n" +
                                "¡¡SIGUE ASÍ!!",
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
fun AireScreenPreview() {
    val navController = rememberNavController()
    ConsumoEnergéticoHogarTheme {
        AireAcondicionado().AireScreen(navController)
    }
}
}