package com.appsnica.jetpack_compose_jose_juan

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack

data class Producto(
    val sku: Int,
    val nombre: String,
    val descripcion: String,
    val precio: Float,
    val stock: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(navController: NavController) {
    val productos = listOf(
        Producto(1, "Laptop", "Laptop con 16GB de RAM y 512GB SSD", 999.99f, 5),
        Producto(2, "Smartphone", "Pantalla OLED, 128GB", 799.99f, 0),
        Producto(3, "Auriculares", "Cancelación de ruido", 199.99f, 15),
        Producto(4, "Monitor", "4K, 27 pulgadas", 349.99f, 7),
        Producto(5, "Teclado", "RGB mecánico", 129.99f, 12)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Productos") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(productos) { producto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.elevatedCardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = producto.nombre, style = MaterialTheme.typography.titleLarge)
                        Text(text = producto.descripcion, modifier = Modifier.padding(vertical = 4.dp))
                        Text(text = "Precio: $${producto.precio}")
                        Text(text = "Stock: ${producto.stock}")
                        Button(
                            onClick = {},
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .fillMaxWidth()
                        ) {
                            Text("Agregar a mi carrito")
                        }
                    }
                }
            }
        }
    }
}

