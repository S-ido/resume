package com.chebdowski.resume.features.resume

import android.content.Context
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.EmphasisAmbient
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideEmphasis
import androidx.compose.material.Snackbar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.DensityAmbient
import androidx.compose.ui.unit.dp
import com.chebdowski.resume.R
import com.chebdowski.resume.core.exception.Failure
import com.chebdowski.resume.core.ui.baselineHeight
import dev.chrisbanes.accompanist.coil.CoilImage

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
            Header(scrollState, person)
        }
    }
}

@Composable
private fun Header(scrollState: ScrollState, person: Person) {
    val offset = scrollState.value / 2
    val offsetDp = with(DensityAmbient.current) { offset.toDp() }

    CoilImage(
        data = person.pictureUrl,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = offsetDp),
        contentScale = ContentScale.Crop
    )

    NameAndPosition(person)
}

@Composable
private fun NameAndPosition(person: Person) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Name(person)
        Position(person)
    }
}

@Composable
private fun Name(person: Person) {
    ProvideEmphasis(emphasis = EmphasisAmbient.current.high) {
        Text(
            text = "${person.firstName} ${person.lastName}",
            modifier = Modifier.baselineHeight(32.dp),
            style = MaterialTheme.typography.h5
        )
    }
}

@Composable
private fun Position(person: Person) {
    ProvideEmphasis(emphasis = EmphasisAmbient.current.medium) {
        Text(
            text = person.position,
            modifier = Modifier.padding(bottom = 20.dp).baselineHeight(24.dp),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun HandleFailure(failure: Failure?, context: Context) {
    when (failure) {
        is Failure.ServerError -> notify(context.getString(R.string.failure_server_error))
    }
}

@Composable
private fun notify(message: String) {
    Column {
        Snackbar(
            text = { Text(text = message) }
        )
    }
}