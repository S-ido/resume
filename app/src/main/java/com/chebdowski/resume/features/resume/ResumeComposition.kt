package com.chebdowski.resume.features.resume

import android.content.Context
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chebdowski.resume.R
import com.chebdowski.core.exception.Failure
import com.chebdowski.resume.core.ui.baselineHeight
import dev.chrisbanes.accompanist.coil.CoilImage
import java.util.*

@Composable
fun HandlePerson(person: Person?) {
    val scrollState = rememberScrollState()

    ScrollableColumn(
        modifier = Modifier.fillMaxSize(),
        scrollState = scrollState
    ) {
        if (person == null) {
            //TODO Handle null person data
        } else {
            Header(person)
            SectionDivider()
            ProfessionalSummary(person)
            SectionDivider()
        }
    }
}

@Composable
fun HandleFailure(failure: Failure?, context: Context) {
    when (failure) {
        is Failure.ServerError -> notify(context.getString(R.string.failure_server_error))
    }
}

@Composable
private fun Header(person: Person) {
    Picture(person)
    NameAndPosition(person)
}

@Composable
private fun Picture(person: Person) {
    CoilImage(
        data = person.pictureUrl,
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
        FirstName(person)
        LastName(person)
        Position(person)
        if (person.secondPosition.isNotEmpty()) SecondPosition(person)
    }
}

@Composable
private fun FirstName(person: Person) {
    Text(
        text = person.firstName,
        modifier = Modifier
            .fillMaxWidth()
            .baselineHeight(64.dp),
        style = MaterialTheme.typography.h1,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun LastName(person: Person) {
    Text(
        text = person.lastName,
        modifier = Modifier
            .fillMaxWidth()
            .baselineHeight(52.dp),
        style = MaterialTheme.typography.h1,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun Position(person: Person) {
    Text(
        text = person.position.toUpperCase(Locale.getDefault()),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 42.dp)
            .baselineHeight(24.dp),
        style = MaterialTheme.typography.h2,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun SecondPosition(person: Person) {
    Text(
        text = person.secondPosition.toUpperCase(Locale.getDefault()),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .baselineHeight(24.dp),
        style = MaterialTheme.typography.h2,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun ProfessionalSummary(person: Person) {
    Text(
        text = person.professionalSummary,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 40.dp)
            .baselineHeight(24.dp),
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun SectionDivider() {
    Divider(
        modifier = Modifier
            .padding(vertical = 32.dp, horizontal = 96.dp)
            .preferredHeight(8.dp)
            .background(MaterialTheme.colors.primary)
    )
}

@Composable
private fun notify(message: String) {
    Column {
        Snackbar(
            text = { Text(text = message) }
        )
    }
}