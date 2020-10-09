package com.chebdowski.resume.composition

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chebdowski.domain.person.Person
import dev.chrisbanes.accompanist.coil.CoilImage
import java.util.*

val baseHorizontalPadding = 40.dp

@Composable
fun ComposeResume(person: Person) {
    val scrollState = rememberScrollState()

    ScrollableColumn(
        modifier = Modifier.fillMaxSize(),
        scrollState = scrollState
    ) {
        Header(person)
        ProfessionalSummary(person.professionalSummary)
        ContactInfo(person)
        WorkExperience(person.workExperience)
        Education(person.education)
        Spacer(Modifier.padding(bottom = 16.dp))
    }
}

@Composable
private fun Header(person: Person) {
    Picture(person.pictureUrl)
    NameAndPosition(person)
    SectionDivider()
}

@Composable
private fun Picture(pictureUrl: String) {
    CoilImage(
        data = pictureUrl,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)
            .padding(horizontal = 64.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
private fun NameAndPosition(person: Person) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        FirstName(person.firstName)
        LastName(person.lastName)
        Position(person.position)
        if (person.secondPosition.isNotEmpty()) SecondPosition(person.secondPosition)
    }
}

@Composable
private fun FirstName(firstName: String) {
    Text(
        text = firstName,
        modifier = Modifier
            .fillMaxWidth()
            .baselineHeight(64.dp),
        style = MaterialTheme.typography.h1,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun LastName(lastName: String) {
    Text(
        text = lastName,
        modifier = Modifier
            .fillMaxWidth()
            .baselineHeight(52.dp),
        style = MaterialTheme.typography.h1,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun Position(position: String) {
    Text(
        text = position.toUpperCase(Locale.getDefault()),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 42.dp)
            .baselineHeight(24.dp),
        style = MaterialTheme.typography.h2,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun SecondPosition(secondPosition: String) {
    Text(
        text = secondPosition.toUpperCase(Locale.getDefault()),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .baselineHeight(24.dp),
        style = MaterialTheme.typography.h2,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun ProfessionalSummary(professionalSummary: String) {
    Text(
        text = professionalSummary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = baseHorizontalPadding)
            .baselineHeight(24.dp),
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Center
    )

    SectionDivider()
}