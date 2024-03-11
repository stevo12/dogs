package com.stefan.chipdogs.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import com.stefan.chipdogs.R
import com.stefan.chipdogs.ui.theme.AppSizes

@Composable
fun GenericDialogComponent(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onButtonTap: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card {
            Column(
                modifier = modifier
                    .background(
                        color = MaterialTheme.colorScheme.surface
                    )
                    .padding(
                        horizontal = AppSizes.Spacing.spacing_24,
                        vertical = AppSizes.Spacing.spacing_16
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_warning),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.size(AppSizes.Spacing.spacing_20))

                Text(text = stringResource(id = R.string.error_dialog_title))

                Spacer(modifier = Modifier.size(AppSizes.Spacing.spacing_12))

                Button(
                    onClick = { onButtonTap() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            shape = RoundedCornerShape(AppSizes.Radius.radius_10),
                            color = MaterialTheme.colorScheme.primary
                        )
                )
                {
                    Text(text = stringResource(id = R.string.error_dialog_dismiss_button_label))
                }
                Spacer(modifier = Modifier.size(AppSizes.Spacing.spacing_24))
            }
        }
    }
}
