package com.stefan.chipdogs.presentation.dogbreeds.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stefan.chipdogs.ui.theme.AppSizes

@Composable
fun DogItem(
    modifier: Modifier = Modifier,
    model: DogItemModel,
    onClick: (DogItemModel) -> Unit = {},
) {
    Column(
        modifier = modifier
            .clickable {
                onClick(model)
            }
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(AppSizes.Radius.radius_10)
            )
            .padding(
                horizontal = AppSizes.Spacing.spacing_16,
                vertical = AppSizes.Spacing.spacing_12
            )) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = model.name)
        }
    }
}


@Preview
@Composable
fun DogItemPreview() {

    DogItem(modifier = Modifier, DogItemModel("Azorel"))
}