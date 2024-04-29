package com.codewars.codewarschallenges.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codewars.codewarschallenges.ui.theme.CodewarsChallengesTheme
import com.codewars.codewarschallenges.utils.RankUtils
import com.codewars.domain.model.Rank

@Composable
fun RankView(
    rank: Rank,
    modifier: Modifier = Modifier,
    darkTheme: Boolean = isSystemInDarkTheme()
) {
    val rankColor = remember { RankUtils.parseRankColor(rank.color) }
    val rankColorBackground = remember { RankUtils.parseRankColorBackground(rank.color) }
    Surface(
        modifier = modifier.wrapContentSize(),
        border = BorderStroke(4.dp, rankColor),
        shape = CutCornerShape(10.dp),
        color = rankColorBackground,
    ) {
        Text(
            text = rank.name,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
            color = rankColor,
            style = MaterialTheme.typography.labelMedium
        )
    }
}

@Preview(showBackground = false)
@Composable
fun RankPreview() {
    CodewarsChallengesTheme {
        RankView(Rank(8, "8 dan", "red"), Modifier)
    }
}
