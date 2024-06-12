@file:OptIn(ExperimentalLayoutApi::class)

package com.codewars.codewarschallenges.ui.challangedetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Done
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.mukesh.MarkDown
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
            val readOnlyState by viewModel.readOnlyState.collectAsState()
            if (readOnlyState.isLoading) {
                CircularProgressHorizontallyCentered()
            }
            readOnlyState.error?.let { error ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        textAlign = TextAlign.Center,
                        text = error.message.orEmpty(),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
            readOnlyState.challengeDetails?.let { details ->
                ChallengeDetailsContent(details)
            }
        }
    }
}

@Composable
fun ChallengeDetailsContent(challenge: ChallengeDetails) {
    Column {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 8.dp, end = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RankView(
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, bottom = 16.dp),
                    rank = challenge.rank
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .weight(1f),
                    text = challenge.name,
                    maxLines = 2,
                    style = MaterialTheme.typography.titleLarge,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    imageVector = Icons.Outlined.Star,
                    contentDescription = stringResource(string.star_icon)
                )
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 4.dp),
                    text = challenge.totalStars.toString(),
                    style = MaterialTheme.typography.bodyMedium,
                )

                Icon(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .size(16.dp),
                    imageVector = Icons.Outlined.Done,
                    contentDescription = stringResource(string.attempts_icon)
                )
                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 4.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    text = stringResource(string.total_attempts, challenge.totalCompleted, challenge.totalAttempts),
                    style = MaterialTheme.typography.bodyMedium,
                )
            }

            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
            ) {
                challenge.tags.take(3).forEach {
                    ElevatedSuggestionChip(
                        onClick = { },
                        label = { Text(text = it) }
                    )
                }
            }
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 8.dp, end = 8.dp, bottom = 16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 8.dp, end = 8.dp, bottom = 10.dp),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
                text = stringResource(string.description_of_the_challenge)
            )
            MarkDown(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 24.dp),
                text = challenge.description
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChallengeDetailsScreenContentPreview() {
    CodewarsChallengesTheme {
        ChallengeDetailsContent(challenge = DummyChallengeDetails)
    }
}
