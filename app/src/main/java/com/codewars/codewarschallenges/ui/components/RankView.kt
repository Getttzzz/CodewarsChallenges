package com.codewars.codewarschallenges.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
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
    val rankColor = remember {
        when (darkTheme) {
            true -> RankUtils.parseDarkRankColor(rank.color)
            false -> RankUtils.parseLightRankColor(rank.color)
        }
    }
    val rankColorBackground = remember {
        when (darkTheme) {
            true -> RankUtils.parseDarkRankColorBackground(rank.color)
            false -> RankUtils.parseLightRankColorBackground(rank.color)
        }
    }
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

@Preview(
    showBackground = true,
    backgroundColor = 0xFF_444444,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun RankPreviewDark() {
    CodewarsChallengesTheme {
        Column {
            RankView(Rank(8, "8 kyu", RankUtils.WHITE), Modifier)
            RankView(Rank(8, "6 kyu", RankUtils.YELLOW), Modifier)
            RankView(Rank(8, "4 kyu", RankUtils.BLUE), Modifier)
            RankView(Rank(8, "2 kyu", RankUtils.PURPLE), Modifier)
            RankView(Rank(8, "4 dan", RankUtils.BLACK), Modifier)
            RankView(Rank(8, "8 dan", RankUtils.RED), Modifier)
        }
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF_FFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun RankPreviewLight() {
    CodewarsChallengesTheme {
        Column {
            RankView(Rank(8, "8 kyu", RankUtils.WHITE), Modifier)
            RankView(Rank(8, "6 kyu", RankUtils.YELLOW), Modifier)
            RankView(Rank(8, "4 kyu", RankUtils.BLUE), Modifier)
            RankView(Rank(8, "2 kyu", RankUtils.PURPLE), Modifier)
            RankView(Rank(8, "4 dan", RankUtils.BLACK), Modifier)
            RankView(Rank(8, "8 dan", RankUtils.RED), Modifier)
        }
    }
}
