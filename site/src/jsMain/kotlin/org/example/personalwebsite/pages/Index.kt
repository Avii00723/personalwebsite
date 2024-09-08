package org.example.personalwebsite.pages

import androidx.compose.runtime.*
import com.stevdza_san.website.components.ProfileCard
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.localStorage

import org.example.personalwebsite.components.ThemeSwitchButton
import org.example.personalwebsite.util.Res
import org.jetbrains.compose.web.css.px

@Page
@Composable
fun HomePage() {
    var colorMode by ColorMode.currentState

    LaunchedEffect(colorMode) {
        val savedTheme = localStorage.getItem(Res.String.SAVED_THEME) ?: ColorMode.LIGHT.name
        colorMode = ColorMode.valueOf(savedTheme)
    }

    ThemeSwitchButton(
        colorMode = colorMode,
        onClick = {
            colorMode = colorMode.opposite
            localStorage.setItem(Res.String.SAVED_THEME, colorMode.name)
        }
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(16.px)
                .backgroundImage(
                    linearGradient(
                        dir = LinearGradient.Direction.ToRight,
                        from = if (colorMode.isLight) Res.Theme.GRADIENT_ONE.color
                        else Res.Theme.GRADIENT_ONE_DARK.color,
                        to = if (colorMode.isLight) Res.Theme.GRADIENT_TWO.color
                        else Res.Theme.GRADIENT_TWO_DARK.color
                    )
                ),

            contentAlignment = Alignment.Center
        ) {
            ProfileCard(colorMode = colorMode)
        }
        Box(
            Modifier
                .fillMaxSize()
                .padding(top = 16.px,left = 80.px, right = 80.px, bottom = 20.px)
                .backgroundImage(
                    linearGradient(
                        dir = LinearGradient.Direction.ToRight,
                        from = if (colorMode.isLight) Res.Theme.GRADIENT_ONE.color
                        else Res.Theme.GRADIENT_ONE_DARK.color,
                        to = if (colorMode.isLight) Res.Theme.GRADIENT_TWO.color
                        else Res.Theme.GRADIENT_TWO_DARK.color
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            ProjectBox(colorMode = colorMode)
        }
    }
}