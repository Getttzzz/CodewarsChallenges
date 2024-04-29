package com.codewars.codewarschallenges.ui.challenges

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState.Loading
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.codewars.codewarschallenges.ui.components.CircularProgressHorizontallyCentered
import com.codewars.codewarschallenges.ui.components.CodewarsAppBar
import com.codewars.codewarschallenges.ui.destinations.ChallengeDetailsScreenDestination
import com.codewars.domain.model.Challenge
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

const val USER_NAME = "wichu" // 1946 challenges; 10 pages; 200 items per page

@RootNavGraph(start = true)
@Destination
@Composable
fun ChallengesScreen(
    navigator: DestinationsNavigator,
    userName: String = USER_NAME,
    viewModel: ChallengesViewModel = koinViewModel { parametersOf(userName) }
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CodewarsAppBar(
                modifier = Modifier.fillMaxWidth(),
                title = userName,
                showNavigationIcon = false,
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            val lazyColumnState: LazyListState = rememberLazyListState()
            val challenges: LazyPagingItems<Challenge> = viewModel.challenges.collectAsLazyPagingItems()

            LazyColumn(
                state = lazyColumnState,
                contentPadding = PaddingValues(all = 8.dp),
            ) {
                if (challenges.loadState.refresh is Loading) {
                    item { CircularProgressHorizontallyCentered() }
                }
                items(count = challenges.itemCount) { i ->
                    challenges[i]?.let { challenge ->
                        ChallengeItem(challenge) { clickedItemId ->
                            navigator.navigate(ChallengeDetailsScreenDestination(clickedItemId))
                        }
                    }
                }
                if (challenges.loadState.append is Loading) {
                    item { CircularProgressHorizontallyCentered() }
                }
            }
        }
    }
}
