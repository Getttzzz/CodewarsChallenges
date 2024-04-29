package com.codewars.codewarschallenges.utils

import androidx.compose.ui.graphics.Color
import com.codewars.codewarschallenges.ui.theme.RankBlack
import com.codewars.codewarschallenges.ui.theme.RankBlackBackground
import com.codewars.codewarschallenges.ui.theme.RankBlue
import com.codewars.codewarschallenges.ui.theme.RankBlueBackground
import com.codewars.codewarschallenges.ui.theme.RankPurple
import com.codewars.codewarschallenges.ui.theme.RankPurpleBackground
import com.codewars.codewarschallenges.ui.theme.RankRed
import com.codewars.codewarschallenges.ui.theme.RankRedBackground
import com.codewars.codewarschallenges.ui.theme.RankWhite
import com.codewars.codewarschallenges.ui.theme.RankWhiteBackground
import com.codewars.codewarschallenges.ui.theme.RankYellow
import com.codewars.codewarschallenges.ui.theme.RankYellowBackground

object RankUtils {

    /**
     * The color of the rank.
     * Possible colors are
     * 1) white (7-8 kyu),
     * 2) yellow (5-6 kyu),
     * 3) blue (3-4 kyu),
     * 4) purple (1-2 kyu),
     * 5) black (1-4 dan),
     * 6) red (5-8 dan).
     * */
    fun parseRankColor(color: String): Color {
        return when (color) {
            "white" -> RankWhite
            "yellow" -> RankYellow
            "blue" -> RankBlue
            "purple" -> RankPurple
            "black" -> RankBlack
            "red" -> RankRed
            else -> RankWhite
        }
    }

    fun parseRankColorBackground(color: String): Color {
        return when (color) {
            "white" -> RankWhiteBackground
            "yellow" -> RankYellowBackground
            "blue" -> RankBlueBackground
            "purple" -> RankPurpleBackground
            "black" -> RankBlackBackground
            "red" -> RankRedBackground
            else -> RankWhiteBackground
        }
    }
}
