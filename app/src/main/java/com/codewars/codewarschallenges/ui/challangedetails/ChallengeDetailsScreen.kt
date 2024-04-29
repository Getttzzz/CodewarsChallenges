package com.codewars.codewarschallenges.ui.challangedetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codewars.codewarschallenges.R.string
import com.codewars.codewarschallenges.ui.components.CircularProgressHorizontallyCentered
import com.codewars.codewarschallenges.ui.components.CodewarsAppBar
import com.codewars.codewarschallenges.ui.components.RankView
import com.codewars.codewarschallenges.ui.theme.CodewarsChallengesTheme
import com.codewars.codewarschallenges.utils.DummyChallengeDetails
import com.codewars.domain.model.ChallengeDetails
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Destination
@Composable
fun ChallengeDetailsScreen(
    navigator: DestinationsNavigator,
    challengeId: String,
    viewModel: ChallengeDetailsViewModel = koinViewModel { parametersOf(challengeId) }
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CodewarsAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = stringResource(string.challenge_details),
                showNavigationIcon = true,
                onBackClicked = { navigator.navigateUp() }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val state = viewModel.state
            if (state.isLoading) {
                CircularProgressHorizontallyCentered()
            }
            if (state.error != null) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        textAlign = TextAlign.Center,
                        text = state.error.message.orEmpty(),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
            if (state.challengeDetails != null) {
                ChallengeDetailsContent(state.challengeDetails)
            }
        }
    }
}

@Composable
fun ChallengeDetailsContent(challengeDetails: ChallengeDetails) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RankView(
                modifier = Modifier.padding(16.dp),
                rank = challengeDetails.rank
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(1f),
                text = challengeDetails.name,
                maxLines = 2,
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChallengeDetailsScreenContentPreview() {
    CodewarsChallengesTheme {
        ChallengeDetailsContent(challengeDetails = DummyChallengeDetails)
    }
}
