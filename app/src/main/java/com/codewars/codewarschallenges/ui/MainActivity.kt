package com.codewars.codewarschallenges.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.codewars.codewarschallenges.ui.destinations.ChallengesScreenDestination
import com.codewars.codewarschallenges.ui.theme.CodewarsChallengesTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodewarsChallengesTheme {
                Surface {
                    DestinationsNavHost(
                        modifier = Modifier.fillMaxSize(),
                        navGraph = NavGraphs.root,
                        startRoute = ChallengesScreenDestination,
                    )
                }
            }
        }
    }
}
