package com.nguyenminhkhang.jarvisai.presentation.screens.auth.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DividerOr(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(modifier = Modifier.weight(1f))
        Text(
            text = "Or",
            modifier = Modifier.padding(horizontal = 8.dp),
            fontSize = 16.sp
        )
        Divider(modifier = Modifier.weight(1f))
    }
}
