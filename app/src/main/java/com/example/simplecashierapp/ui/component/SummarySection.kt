package com.example.simplecashierapp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplecashierapp.model.CashierUiState

@Composable
fun SummarySection(
    uiState: CashierUiState,
    onCheckoutClick: () -> Unit,
    onResetClick: () -> Unit
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text("Total item: ${uiState.totalItems}")
            Text("Subtotal: Rp ${uiState.subtotalPrice}")
            Text("Pajak: Rp ${uiState.tax}")
            Text("Total bayar: Rp ${uiState.totalPrice}")

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onCheckoutClick
            ) {
                Text("Checkout")
            }

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onResetClick
            ) {
                Text("Reset Transaksi")
            }
        }
    }
}