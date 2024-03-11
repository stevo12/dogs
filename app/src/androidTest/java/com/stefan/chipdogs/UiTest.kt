package com.stefan.chipdogs

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.stefan.chipdogs.navigation.NavGraph
import com.stefan.chipdogs.presentation.dogbreeds.view.DOG_BREEDS_COLUMN_TEST_TAG
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class UiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        composeTestRule.activity.setContent {
            NavGraph()
        }
    }


    @Test
    fun `checkTitleIsDisplayed`() {
        composeTestRule.apply {
            waitForIdle()
            onNodeWithText("All dog breeds").assertIsDisplayed()
        }
    }

    @Test
    fun `checkListIsDisplayed`() {
        composeTestRule.apply {
            waitForIdle()
            onNodeWithTag(DOG_BREEDS_COLUMN_TEST_TAG)
                .assertIsDisplayed()

        }
    }
}