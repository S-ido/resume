package com.chebdowski.resume.composition

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.chebdowski.domain.person.Person

@Composable
fun ContactInfo(
    person: Person,
    @DrawableRes phoneImageId: Int,
    @DrawableRes emailImageId: Int,
    @DrawableRes linkedinImageId: Int,
    @DrawableRes locationImageId: Int
) {
    ContactRow(person.phone, phoneImageId)
    ContactSpacer()
    ContactRow(person.email, emailImageId)
    ContactSpacer()
    ContactRow(person.linkedIn, linkedinImageId)
    ContactSpacer()
    ContactRow(person.location, locationImageId)

    SectionDivider()
}

@Composable
private fun ContactRow(info: String, @DrawableRes imageId: Int) {
    val image = imageResource(imageId)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = baseHorizontalPadding),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically

    ) {
        Image(
            image,
            Modifier.preferredHeight(32.dp).preferredWidth(32.dp),
        )
        Text(
            text = info,
            Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.body1,
        )
    }
}

@Composable
private fun ContactSpacer() {
    Spacer(modifier = Modifier.preferredHeight(16.dp))
}