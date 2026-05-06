package com.example.simplecashierapp.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.simplecashierapp.model.CashierUiState
import com.example.simplecashierapp.model.Product
import com.example.simplecashierapp.ui.component.CartItemRow
import com.example.simplecashierapp.ui.component.ProductCard
import com.example.simplecashierapp.ui.component.SummarySection

@Composable
fun CashierScreen(
    uiState: CashierUiState,
    onAddProduct: (Product) -> Unit,
    onDecreaseItem: (Int) -> Unit,
    onCheckout: () -> Unit,
    onResetTransaction: () -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            Text("Kasir Sederhana", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(12.dp))

            Text(uiState.message)

            Spacer(modifier = Modifier.height(16.dp))

            Text("Daftar Produk", style = MaterialTheme.typography.titleMedium)

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(uiState.products) { product ->
                    ProductCard(
                        product = product,
                        onAddClick = { onAddProduct(product) }
                    )
                }
            }

            Text("Keranjang")

            Column {
                uiState.cartItems.forEach { cartItem ->
                    CartItemRow(
                        cartItem = cartItem,
                        onAddClick = { onAddProduct(cartItem.product) },
                        onDecreaseClick = { onDecreaseItem(cartItem.product.id) }
                    )
                }
            }

            SummarySection(
                uiState = uiState,
                onCheckoutClick = onCheckout,
                onResetClick = onResetTransaction
            )
        }
    }
}