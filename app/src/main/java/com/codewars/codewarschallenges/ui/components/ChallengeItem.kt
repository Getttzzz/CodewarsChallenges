package com.codewars.codewarschallenges.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedSuggestionChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codewars.codewarschallenges.R
import com.codewars.codewarschallenges.ui.theme.CodewarsChallengesTheme
import com.codewars.codewarschallenges.ui.theme.CodewarsMainColor
import com.codewars.codewarschallenges.utils.CodewarsDateUtils
import com.codewars.codewarschallenges.utils.DummyChallenge
import com.codewars.domain.model.Challenge

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChallengeItem(challenge: Challenge) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(end = 12.dp, top = 8.dp, start = 12.dp)),
            text = CodewarsDateUtils.format(challenge.completedAt),
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.labelSmall,
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                painter = painterResource(id = R.drawable.ic_codewars_logo),
                tint = CodewarsMainColor,
                contentDescription = "Codewars icon"
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .weight(1f),
                text = challenge.name,
                maxLines = 2,
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Ellipsis,
            )
        }
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 6.dp),
            horizontalArrangement = Arrangement.spacedBy(space = 8.dp),
        ) {
            challenge.completedLanguages.take(5).forEach {
                ElevatedSuggestionChip(
                    onClick = { },
                    label = { Text(text = it) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChallengeItemPreview() {
    CodewarsChallengesTheme {
        ChallengeItem(challenge = DummyChallenge)
    }
}
