package com.chebdowski.resume.composition

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SectionDivider() {
    Divider(
        modifier = Modifier
            .padding(vertical = 32.dp, horizontal = 96.dp)
            .preferredHeight(8.dp)
            .background(MaterialTheme.colors.primary)
    )
}

@Composable
fun notify(message: String) {
    Column {
        Snackbar(
            text = { Text(text = message) }
        )
    }
}

@Composable
fun Spacer16() {
    Spacer(modifier = Modifier.preferredHeight(16.dp))
}

@Composable
fun Spacer32() {
    Spacer(modifier = Modifier.preferredHeight(32.dp))
}