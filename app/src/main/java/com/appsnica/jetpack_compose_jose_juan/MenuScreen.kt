package com.appsnica.jetpack_compose_jose_juan


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Menú Principal") })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate("contactos") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Ver Contactos")
            }
            Button(
                onClick = { navController.navigate("productos") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Ver Productos")
            }
            Button(
                onClick = { navController.navigate("informe") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Ver Informe de Ventas")
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MenuScreenPreview() {
    MenuScreen(navController = rememberNavController())
}