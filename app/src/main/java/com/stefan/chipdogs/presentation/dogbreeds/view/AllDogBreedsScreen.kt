package com.stefan.chipdogs.presentation.dogbreeds.view

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.stefan.chipdogs.R
import com.stefan.chipdogs.navigation.Destinations
import com.stefan.chipdogs.presentation.GenericDialogComponent
import com.stefan.chipdogs.presentation.dogbreeds.components.DogItem
import com.stefan.chipdogs.presentation.dogbreeds.components.DogItemModel
import com.stefan.chipdogs.presentation.dogbreeds.viewmodel.AllDogBreedsSideEffects
import com.stefan.chipdogs.presentation.dogbreeds.viewmodel.AllDogBreedsViewModel
import com.stefan.chipdogs.presentation.dogbreeds.viewmodel.AllDogBreedsViewState
import com.stefan.chipdogs.ui.theme.AppSizes
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun AllDogBreedsScreen(
    modifier: Modifier = Modifier,
    viewModel: AllDogBreedsViewModel = hiltViewModel(),
    onNavigateTo: (Destinations) -> Unit
) {

    val activity = (LocalContext.current as? Activity)
    val state by viewModel.container.stateFlow.collectAsStateWithLifecycle()

    viewModel.collectSideEffect(sideEffect = { sideEffects ->
        when (sideEffects) {
            AllDogBreedsSideEffects.GoToSelectedDogSideEffect -> {
                onNavigateTo(Destinations.SelectedDogBreedDestination())
            }
        }
    })

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
                activity?.finish()
            }
        )
    }

    AllDogBreedsScreenContent(
        modifier,
        state,
        onDogBreedSelected = {
            viewModel.selectCurrentDogBreed(it)
            viewModel.goToSelectedDogScreen()
        }
    )
}


@Composable
fun AllDogBreedsScreenContent(
    modifier: Modifier = Modifier,
    viewState: AllDogBreedsViewState,
    onDogBreedSelected: (DogItemModel) -> Unit,
) {

    LazyColumn(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .padding(
                horizontal = AppSizes.Spacing.spacing_16,
                vertical = AppSizes.Spacing.spacing_20
            )
            .testTag(DOG_BREEDS_COLUMN_TEST_TAG)
    ) {
        item {
            Text(
                text = stringResource(id = R.string.all_dog_breeds_title),
                textAlign = TextAlign.Start,
                style = TextStyle(fontSize = AppSizes.FontSizes.title_size_28)
            )

            Spacer(modifier = Modifier.height(AppSizes.Spacing.spacing_16))
        }
        items(viewState.dogBreedModel.size) { index ->
            DogItem(
                model = viewState.dogBreedModel[index],
                onClick = onDogBreedSelected,
            )
            Spacer(modifier = Modifier.height(AppSizes.Spacing.spacing_8))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AllDogBreedsScreenPreview() {
    AllDogBreedsScreen(onNavigateTo = {})
}


const val DOG_BREEDS_COLUMN_TEST_TAG = "test_tag"