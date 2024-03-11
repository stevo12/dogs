package com.stefan.chipdogs.presentation.selectedbreed.view

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.stefan.chipdogs.presentation.GenericDialogComponent
import com.stefan.chipdogs.presentation.selectedbreed.viewmodel.SelectedDogViewModel
import com.stefan.chipdogs.presentation.selectedbreed.viewmodel.SelectedDogViewState
import com.stefan.chipdogs.ui.theme.AppSizes


@Composable
fun SelectedDogScreen(
    modifier: Modifier = Modifier,
    viewModel: SelectedDogViewModel = hiltViewModel()
) {
    val state by viewModel.container.stateFlow.collectAsStateWithLifecycle()

    if (state.isLoading) {
        Dialog(onDismissRequest = { }) {
            CircularProgressIndicator()
        }
    }

    if (state.appException != null) {
        GenericDialogComponent(
            onDismiss = { Unit },
            onButtonTap = {
                viewModel.dismissErrorDialog()
            }
        )
    }

    SelectedDogScreenContent(modifier, state)
}


@Composable
fun SelectedDogScreenContent(
    modifier: Modifier = Modifier,
    viewState: SelectedDogViewState
) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppSizes.Spacing.spacing_16,
                vertical = AppSizes.Spacing.spacing_20
            )
    ) {
        items(viewState.images.size) { index ->
            AsyncImage(
                model = viewState.images[index],
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(AppSizes.Radius.radius_10)),
            )
            Spacer(modifier = Modifier.height(AppSizes.Spacing.spacing_8))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SelectedDogScreenPreview() {
    SelectedDogScreen()
}