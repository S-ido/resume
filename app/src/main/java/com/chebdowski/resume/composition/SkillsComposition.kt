package com.chebdowski.resume.composition

import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.chebdowski.domain.person.Skills
import com.chebdowski.resume.R

@Composable
fun Skills(skills: Skills) {
    SectionName(R.string.section_skills)
    Spacer32()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        SkillsList(skills.skills)
    }
}

@Composable
private fun SkillsList(skills: List<String>) {
    val skillCount = skills.size

    Row {
        Column(Modifier.weight(1f)) {
            for (i in 0 until (skillCount / 2)) {
                Skill(skills[i])
            }
        }

        Column(Modifier.weight(1f)) {
            for (i in (skillCount / 2) until skillCount) {
                Skill(skills[i])
            }
        }
    }
}

@Composable
private fun Skill(skill: String) {
    Row(
        horizontalArrangement = Arrangement.Start,
    ) {
        Bullet()
        CommonText(skill)
    }
}

@Composable
private fun Bullet() {
    Text(
        text = "•",
        Modifier.padding(horizontal = 2.dp),
        style = MaterialTheme.typography.body1
    )
}