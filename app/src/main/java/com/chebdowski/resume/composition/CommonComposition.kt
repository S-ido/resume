package com.chebdowski.resume.composition

import androidx.annotation.StringRes
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import java.util.*

@Composable
fun SectionName(@StringRes nameId: Int) {
    val sectionName = stringResource(nameId)

    Text(
        text = sectionName.toUpperCase(Locale.getDefault()),
        modifier = Modifier
            .fillMaxWidth()
            .baselineHeight(24.dp),
        style = MaterialTheme.typography.h2,
        textAlign = TextAlign.Center
    )
}

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