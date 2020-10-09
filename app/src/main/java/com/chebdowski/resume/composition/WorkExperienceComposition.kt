package com.chebdowski.resume.composition

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chebdowski.domain.person.Person
import com.chebdowski.domain.person.Responsibilities
import com.chebdowski.domain.person.WorkExperience
import com.chebdowski.resume.R
import java.util.*

@Composable
fun WorkExperience(workExperience: WorkExperience) {
    SectionName(R.string.section_work_experience)
    Spacer32()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        ExperienceList(workExperience)
        SectionDivider()
    }
}

@Composable
private fun ExperienceList(workExperience: WorkExperience) {
    workExperience.experience.forEach { work ->
        Position(work.position)
        CompanyAndDate(work.company, work.date)
        Spacer16()
        ResponsibilitiesComposition(work.responsibilities)
        Spacer32()
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
    CommonText("$company / $date", Modifier.baselineHeight(18.dp))
}

@Composable
private fun ResponsibilitiesComposition(responsibilities: List<Responsibilities>) {
    responsibilities.forEach {
        CommonText("${it.responsibility}:")
        it.achievements.forEach { achievement ->
            Achievement(achievement)
        }
    }
}

@Composable
private fun Achievement(achievement: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
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
            .padding(horizontal = 16.dp)
            .preferredWidth(16.dp),
        style = MaterialTheme.typography.body1
    )
}