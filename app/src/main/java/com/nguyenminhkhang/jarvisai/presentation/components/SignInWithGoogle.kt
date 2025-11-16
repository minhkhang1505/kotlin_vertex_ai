package com.nguyenminhkhang.jarvisai.presentation.components

import android.provider.CalendarContract
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignInWithGoogle(modifier : Modifier, buttonText : String, leadingIcon: Painter?, onClick: () -> Unit) {
    val colorScheme = MaterialTheme.colorScheme;
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = colorScheme.primary
        ),
        border = BorderStroke(1.dp, colorScheme.primary),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(vertical = 4.dp).background(Color.Transparent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            leadingIcon.let {
                Icon(
                    painter = it!!,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp),
                    tint = colorScheme.primary
                )
            }
            Spacer(Modifier.width(4.dp))
            Text(
                text = buttonText,
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}