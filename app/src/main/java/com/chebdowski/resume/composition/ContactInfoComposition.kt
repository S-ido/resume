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
import com.chebdowski.resume.R

@Composable
fun ContactInfo(
    person: Person
) {
    ContactRow(person.phone, R.drawable.ic_phone)
    Spacer16()
    ContactRow(person.email, R.drawable.ic_email)
    Spacer16()
    ContactRow(person.linkedIn, R.drawable.ic_linkedin)
    Spacer16()
    ContactRow(person.location, R.drawable.ic_location)

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