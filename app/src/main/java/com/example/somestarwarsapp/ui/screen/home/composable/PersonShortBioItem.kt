package com.example.somestarwarsapp.ui.screen.home.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.somestarwarsapp.R

@Composable
fun PersonShortBioItem(
    name: String,
    birthYear: String,
    gender: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        modifier = modifier
            .padding(10.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.elevatedCardColors(
            containerColor = colorResource(R.color.secondary)
        )
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                color = colorResource(R.color.accent),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                text = name
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    color = colorResource(R.color.off_white),
                    fontSize = 16.sp,
                    text = "Birth Year: "
                )
                Text(
                    color = colorResource(R.color.white),
                    fontSize = 16.sp,
                    text = birthYear
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    color = colorResource(R.color.off_white),
                    fontSize = 16.sp,
                    text = "Gender: "
                )
                Text(
                    color = colorResource(R.color.white),
                    fontSize = 16.sp,
                    text = gender
                )
            }
        }
    }
}
