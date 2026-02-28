package com.example.somestarwarsapp.ui.screen.home.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.somestarwarsapp.R

@Composable
fun PageNavigation(
    isLoading: Boolean,
    isNext: Boolean,
    isPrevious: Boolean,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(colorResource(R.color.background))
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.secondary),
                contentColor = colorResource(R.color.secondary)
            ),
            enabled = !isLoading && isPrevious,
            onClick = { onPreviousClick() }
        ) {
            Text(
                "Previous Page",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = colorResource(if (isPrevious) R.color.accent else R.color.secondary)
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(R.color.secondary),
                contentColor = colorResource(R.color.secondary)
            ),
            enabled = !isLoading && isNext,
            onClick = { onNextClick() }
        ) {
            Text(
                "Next Page",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = colorResource(if (isNext) R.color.accent else R.color.secondary)
            )
        }
    }
}