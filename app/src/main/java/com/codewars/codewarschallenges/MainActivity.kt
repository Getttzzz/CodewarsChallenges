package com.codewars.codewarschallenges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.codewars.codewarschallenges.ui.components.ChallengeItem
import com.codewars.codewarschallenges.ui.components.CircularProgressHorizontallyCentered
import com.codewars.codewarschallenges.ui.components.CodewarsAppBar
import com.codewars.codewarschallenges.ui.theme.CodewarsChallengesTheme
import com.codewars.domain.model.Challenge
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodewarsChallengesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Main(userName = "wichu")
                }
            }
        }
    }
}

@Composable
fun Main(
    userName: String,
    viewModel: MainViewModel = koinViewModel { parametersOf(userName) }
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
                if (challenges.loadState.refresh is LoadState.Loading) {
                    item { CircularProgressHorizontallyCentered() }
                }
                items(count = challenges.itemCount) { i ->
                    challenges[i]?.let { challenge ->
                        ChallengeItem(challenge)
                    }
                }
                if (challenges.loadState.append is LoadState.Loading) {
                    item { CircularProgressHorizontallyCentered() }
                }
            }
        }
    }
}
