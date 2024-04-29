package com.codewars.codewarschallenges.utils

import androidx.compose.ui.graphics.Color
import com.codewars.codewarschallenges.ui.theme.DarkRankBlack
import com.codewars.codewarschallenges.ui.theme.DarkRankBlackBackground
import com.codewars.codewarschallenges.ui.theme.DarkRankBlue
import com.codewars.codewarschallenges.ui.theme.DarkRankBlueBackground
import com.codewars.codewarschallenges.ui.theme.DarkRankPurple
import com.codewars.codewarschallenges.ui.theme.DarkRankPurpleBackground
import com.codewars.codewarschallenges.ui.theme.DarkRankRed
import com.codewars.codewarschallenges.ui.theme.DarkRankRedBackground
import com.codewars.codewarschallenges.ui.theme.DarkRankWhite
import com.codewars.codewarschallenges.ui.theme.DarkRankWhiteBackground
import com.codewars.codewarschallenges.ui.theme.DarkRankYellow
import com.codewars.codewarschallenges.ui.theme.DarkRankYellowBackground
import com.codewars.codewarschallenges.ui.theme.LightRankBlack
import com.codewars.codewarschallenges.ui.theme.LightRankBlackBackground
import com.codewars.codewarschallenges.ui.theme.LightRankBlue
import com.codewars.codewarschallenges.ui.theme.LightRankBlueBackground
import com.codewars.codewarschallenges.ui.theme.LightRankPurple
import com.codewars.codewarschallenges.ui.theme.LightRankPurpleBackground
import com.codewars.codewarschallenges.ui.theme.LightRankRed
import com.codewars.codewarschallenges.ui.theme.LightRankRedBackground
import com.codewars.codewarschallenges.ui.theme.LightRankWhite
import com.codewars.codewarschallenges.ui.theme.LightRankWhiteBackground
import com.codewars.codewarschallenges.ui.theme.LightRankYellow
import com.codewars.codewarschallenges.ui.theme.LightRankYellowBackground

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
    fun parseDarkRankColor(color: String): Color {
        return when (color) {
            WHITE -> DarkRankWhite
            YELLOW -> DarkRankYellow
            BLUE -> DarkRankBlue
            PURPLE -> DarkRankPurple
            BLACK -> DarkRankBlack
            RED -> DarkRankRed
            else -> DarkRankWhite
        }
    }

    fun parseDarkRankColorBackground(color: String): Color {
        return when (color) {
            WHITE -> DarkRankWhiteBackground
            YELLOW -> DarkRankYellowBackground
            BLUE -> DarkRankBlueBackground
            PURPLE -> DarkRankPurpleBackground
            BLACK -> DarkRankBlackBackground
            RED -> DarkRankRedBackground
            else -> DarkRankWhiteBackground
        }
    }

    fun parseLightRankColor(color: String): Color {
        return when (color) {
            WHITE -> LightRankWhite
            YELLOW -> LightRankYellow
            BLUE -> LightRankBlue
            PURPLE -> LightRankPurple
            BLACK -> LightRankBlack
            RED -> LightRankRed
            else -> LightRankWhite
        }
    }

    fun parseLightRankColorBackground(color: String): Color {
        return when (color) {
            WHITE -> LightRankWhiteBackground
            YELLOW -> LightRankYellowBackground
            BLUE -> LightRankBlueBackground
            PURPLE -> LightRankPurpleBackground
            BLACK -> LightRankBlackBackground
            RED -> LightRankRedBackground
            else -> LightRankWhiteBackground
        }
    }

    const val WHITE = "white"
    const val YELLOW = "yellow"
    const val BLUE = "blue"
    const val PURPLE = "purple"
    const val BLACK = "black"
    const val RED = "red"
}
