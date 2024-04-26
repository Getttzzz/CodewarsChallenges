package com.codewars.codewarschallenges.ui.components

import androidx.compose.material.icons.Icons.AutoMirrored.Rounded
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.codewars.codewarschallenges.R
import com.codewars.codewarschallenges.ui.theme.CodewarsChallengesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CodewarsAppBar(
    title: String,
    modifier: Modifier = Modifier,
    showNavigationIcon: Boolean = true,
    onBackClicked: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                text = title,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            if (showNavigationIcon) {
                IconButton(onClick = onBackClicked) {
                    Icon(
                        imageVector = Rounded.ArrowBack,
                        contentDescription = stringResource(id = R.string.navigate_back)
                    )
                }
            }
        })
}

@Preview(showBackground = true)
@Composable
fun CodewarsAppBarPreview() {
    CodewarsChallengesTheme {
        CodewarsAppBar(
            title = "Challenges",
        )
    }
}
