package com.codewars.codewarschallenges.ui.challangedetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel

@Destination
@Composable
fun ChallengeDetailsScreen(
    navigator: DestinationsNavigator,
    challengeId: String,
    viewModel: ChallengeDetailsViewModel = koinViewModel()
) {
    Text(text = "This is details screen; challengeId=$challengeId")
}
