package com.example.composequotesapp.ui

import android.content.Context
import androidx.activity.compose.setContent
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.core.app.ApplicationProvider
import com.example.composequotesapp.R
import com.example.composequotesapp.di.RepositoryModule
import com.example.composequotesapp.ui.theme.ComposeQuotesAppTheme
import com.example.composequotesapp.util.TestTags
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(RepositoryModule::class)
class NotesEndToEndTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        hiltRule.inject()
        composeRule.activity.setContent {
            ComposeQuotesAppTheme {
                App()
            }
        }
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun clickOnQuote_openCorrectQuoteDetail() {
        val applicationContext = ApplicationProvider.getApplicationContext<Context>()

        composeRule.apply{
            onNodeWithText(applicationContext.getString(R.string.loading)).isDisplayed()
            waitUntilDoesNotExist(hasText(applicationContext.getString(R.string.loading)))
            onNodeWithTag(TestTags.QUOTE_DETAIL_CARD).isNotDisplayed()
            onNodeWithText("1").performClick()

            onNodeWithTag(TestTags.QUOTE_DETAIL_CARD).isDisplayed()
            onNodeWithText("1").isDisplayed()
        }
    }

}