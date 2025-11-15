package com.nguyenminhkhang.jarvisai.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(modifier: Modifier, text: String?, textFieldTitle: String) {
    Column {
        Text(
            text = textFieldTitle,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        BasicTextField(
            value = text ?: "",
            onValueChange = {},
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier.fillMaxWidth().clip(shape = RoundedCornerShape(16.dp)).padding(12.dp)
                ) {
                    if(text.isNullOrEmpty()) {
                        Text("Enter text here...", color = Color.LightGray)
                    }
                    innerTextField()
                }
            },
            modifier = modifier.clip(shape = RoundedCornerShape(16.dp)).background(Color.Gray)
        )
    }

}

@Preview
@Composable
fun CustomTextFieldPreview() {

    CustomTextField(modifier = Modifier.fillMaxWidth(), text ="", textFieldTitle = "Username")
}