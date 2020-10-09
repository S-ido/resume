package com.chebdowski.resume.composition

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chebdowski.domain.person.Education
import com.chebdowski.resume.R
import java.util.*

@Composable
fun Education(education: Education) {
    SectionName(R.string.section_education)
    Spacer32()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Degree(education.degree)
        School(education.school)
        Date(education.date)
        Notes(education.notes)
        SectionDivider()
    }
}

@Composable
private fun Degree(degree: String) {
    Text(
        text = degree.toUpperCase(Locale.getDefault()),
        modifier = Modifier
            .fillMaxWidth()
            .baselineHeight(24.dp),
        style = MaterialTheme.typography.h4
    )
}

@Composable
private fun School(school: String) {
    CommonText(school, Modifier.baselineHeight(18.dp))
}

@Composable
private fun Date(date: String) {
    CommonText(date)
}

@Composable
private fun Notes(notes: String) {
    Spacer16()
    CommonText(notes)
}