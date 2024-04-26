package com.codewars.codewarschallenges

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codewars.codewarschallenges.ui.components.CodewarsAppBar
import com.codewars.codewarschallenges.ui.theme.CodewarsChallengesTheme
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
                    Main(userName = "jhoffner")
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
            Text(text = userName)
        }
    }
}
