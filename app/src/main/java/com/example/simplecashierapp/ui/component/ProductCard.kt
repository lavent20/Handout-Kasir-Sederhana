package com.example.simplecashierapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplecashierapp.model.Product

@Composable
fun ProductCard(
    product: Product,
    onAddClick: () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(product.name)
                Text("Rp ${product.price}")
            }

            Button(onClick = onAddClick) {
                Text("Tambah")
            }
        }
    }
}