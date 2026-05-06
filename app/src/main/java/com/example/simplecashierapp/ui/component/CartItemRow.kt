package com.example.simplecashierapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplecashierapp.model.CartItem

@Composable
fun CartItemRow(
    cartItem: CartItem,
    onAddClick: () -> Unit,
    onDecreaseClick: () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(12.dp)) {

            Text(cartItem.product.name)
            Text("Jumlah: ${cartItem.quantity}")
            Text("Subtotal: Rp ${cartItem.subtotal}")

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = onAddClick) { Text("+") }
                Button(onClick = onDecreaseClick) { Text("-") }
            }
        }
    }
}