package com.appsnica.jetpack_compose_jose_juan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class InformeVentas(
    val producto: String,
    val q1: Int,
    val q2: Int,
    val q3: Int,
    val q4: Int
) {
    val total: Int
        get() = q1 + q2 + q3 + q4
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InformeVentasScreen(navController: NavController) {
    val informes = listOf(
        InformeVentas("Laptop", 20, 18, 25, 30),
        InformeVentas("Mouse Gamer", 40, 42, 38, 44),
        InformeVentas("Teclado RGB", 22, 20, 30, 28),
        InformeVentas("Monitor 4K", 15, 18, 17, 19),
        InformeVentas("Audífonos", 35, 38, 40, 42)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Informe de Ventas") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            items(informes) { informe ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.elevatedCardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = informe.producto,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text("Q1: ${informe.q1} | Q2: ${informe.q2} | Q3: ${informe.q3} | Q4: ${informe.q4}")
                        Text("Total: ${informe.total}", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        }
    }
}

