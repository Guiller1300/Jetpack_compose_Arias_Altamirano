package com.appsnica.jetpack_compose_jose_juan

import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.appsnica.jetpack_compose_jose_juan.ui.theme.Jetpack_compose_Jose_JuanTheme


data class Contacto(val nombre: String, val numero: String, val email: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactListScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contactos") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { innerPadding ->
        val contactos = listOf(
            Contacto("Ana Trabajo", "8884555", "ana@yahoo.es"),
            Contacto("Juan Mecanico", "87784566", "marina@gmail.com"),
            Contacto("Mi amor", "7848488", "danapaola@yahoo.es"),
            Contacto("Mi amor2", "5788448", "griselda@gmail.com")
        )

        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(contactos) { contacto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.elevatedCardElevation(4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = contacto.nombre, style = MaterialTheme.typography.titleLarge)
                        Spacer(modifier = Modifier.height(8.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Call, contentDescription = "Teléfono")
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = contacto.numero)
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Send, contentDescription = "Email")
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = contacto.email)
                        }
                    }
                }
            }
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ContactListScreenPreview() {
    val navController = rememberNavController()
    Jetpack_compose_Jose_JuanTheme {
        ContactListScreen(navController = navController)
    }
}
