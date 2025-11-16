package com.nguyenminhkhang.jarvisai.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nguyenminhkhang.jarvisai.R

@Composable
fun CustomTextField(modifier: Modifier, text: String?, textFieldTitle: String, trailingIcon: Painter?) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = textFieldTitle,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface,
        )
        BasicTextField(
            value = text ?: "",
            onValueChange = {},
            modifier = modifier
                .clip(shape = RoundedCornerShape(12.dp))
                .background(MaterialTheme.colorScheme.surfaceVariant),
            textStyle = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.onSurface),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth().weight(1f).padding(12.dp)
                    ) {
                        if(text.isNullOrEmpty()) {
                            Text(
                                "Enter text here...",
                                style = MaterialTheme.typography.bodyLarge,
                                color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                        innerTextField()
                    }
                    trailingIcon?.let {
                        Icon(
                            painter = trailingIcon,
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 8.dp).size(20.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            },
        )
    }
}