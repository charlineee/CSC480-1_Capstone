package com.example.npsapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.npsapp.ui.theme.lemonFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dropDownMenu(options: List<String>) : String {
    var expanded by remember { mutableStateOf(false) }
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier
            .padding(16.dp, 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
    ) {
        TextField(
            modifier = Modifier
                .menuAnchor(),
            textStyle = TextStyle(color = Color.Black, fontFamily = lemonFontFamily, fontSize = 16.sp),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                containerColor = Color.Transparent
            ),
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(Color.White)
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        selectedOptionText = selectionOption
                        expanded = false
                    },
                )
            }
        }
    }
    return selectedOptionText
}

@Composable
fun SelectionButton(onClick: () -> Unit) {
    OutlinedButton(onClick = { onClick() }) {
        Text(text="Lets go!",
            fontSize =24.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            fontFamily = lemonFontFamily,
        )
    }
}