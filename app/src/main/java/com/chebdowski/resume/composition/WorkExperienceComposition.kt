package com.chebdowski.resume.composition

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chebdowski.domain.person.Person
import com.chebdowski.domain.person.Responsibilities
import com.chebdowski.domain.person.WorkExperience
import com.chebdowski.resume.R
import java.util.*

@Composable
fun WorkExperience(person: Person) {
    SectionName()
    Spacer32()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        ExperienceList(person.workExperience)
    }
}

@Composable
private fun SectionName() {
    val sectionName = stringResource(R.string.section_work_experience)

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
private fun ExperienceList(workExperience: WorkExperience) {
    workExperience.experience.forEach { work ->
        Position(work.position)
        CompanyAndDate(work.company, work.date)
        Spacer16()
        ResponsibilitiesComposition(work.responsibilities)
    }
}

@Composable
private fun Position(position: String) {
    Text(
        text = position.toUpperCase(Locale.getDefault()),
        modifier = Modifier
            .fillMaxWidth()
            .baselineHeight(24.dp),
        style = MaterialTheme.typography.h4
    )
}

@Composable
private fun CompanyAndDate(company: String, date: String) {
    CommonText("$company / $date")
}

@Composable
private fun ResponsibilitiesComposition(responsibilities: Responsibilities) {
    CommonText("${responsibilities.responsibility}:")
    responsibilities.achievements.forEach { achievement ->
        Achievement(achievement)
    }
}

@Composable
private fun Achievement(achievement: String) {
    Row(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.Start,
//        verticalAlignment = Alignment.CenterVertically
    ) {
        Bullet()
        CommonText(achievement)
    }
}

@Composable
private fun Bullet() {
    Text(
        text = "•",
        modifier = Modifier
            .baselineHeight(24.dp)
            .padding(horizontal = 16.dp)
            .preferredWidth(16.dp),
        style = MaterialTheme.typography.body1
    )
}

@Composable
private fun CommonText(text: String) {
    Text(
        text = text,
        modifier = Modifier.baselineHeight(24.dp),
        style = MaterialTheme.typography.body1
    )
}