package org.example.personalwebsite.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.window
import org.example.personalwebsite.util.Res
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun ProjectBox(colorMode: ColorMode) {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.px)
            .borderRadius(12.px)
            .background(
                if (colorMode.isLight) Colors.White else Res.Theme.DARK_BLUE.color
            )
    ) {
        SpanText(
            modifier = Modifier
                .fontFamily(Res.String.ROBOTO_REGULAR)
                .fontSize(30.px)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .opacity(50.percent)
                .lineHeight(2)
                .margin(bottom = 36.px)
                .fontWeight(FontWeight.Bold)
                .textAlign(
                    if (breakpoint <= Breakpoint.SM) TextAlign.Center
                    else TextAlign.Start
                ),
            text = "Projects"
        )

        // SimpleGrid for projects, with width matching profile card size
        SimpleGrid(
            numColumns = numColumns(base = 1, md = 2),
            modifier = Modifier.fillMaxWidth().padding(12.px)
        ) {
            ProjectCard(
                title = "Stay Cation App",
                description = "Developed an Android Hotel Booking application using Java and Android Studio to book hotels in various cities.",
                githubLink = "https://github.com/Avii00723/StayCation-version-1.0",
                colorMode = colorMode,
                cardWidth = 300.px  // Specify the width here
            )

            ProjectCard(
                title = "7 Minute Workout App",
                description = "Developed a Workout App With workout sessions with BMI Calculator",
                githubLink = "https://github.com/Avii00723/WorkoutApp",
                colorMode = colorMode,
                cardWidth = 300.px  // Specify the width here
            )

            ProjectCard(
                title = "Object Detection App using Flutter and TensorFlow Lite",
                description = "Developed a mobile application for object detection using Flutter framework and TensorFlow Lite library.",
                githubLink = "https://github.com/Avii00723/Realtime-Object-Detection",
                colorMode = colorMode,
                cardWidth = 300.px  // Specify the width here
            )
            ProjectCard(
                title = "Flutter Chat App Using Firebase",
                description = "Developed a fully functional chat application using Flutter for the front-end and Firebase for the back-end, enabling\n" +
                        "real-time messaging.",
                githubLink = "https://github.com/Avii00723/ChatApp/tree/master",
                colorMode = colorMode,
                cardWidth = 300.px  // Specify the width here
            )
        }
    }
}

@Composable
fun ProjectCard(title: String, description: String, githubLink: String, colorMode: ColorMode, cardWidth: CSSSizeValue<CSSUnit.px>) {
    val breakpoint = rememberBreakpoint()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 50.px),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = if (breakpoint <= Breakpoint.SM)
            Alignment.CenterHorizontally else Alignment.Start
    ) {
        // Project Title
        SpanText(
            text = title,
            modifier = Modifier
                .padding(bottom = 8.px)
                .fontFamily(Res.String.ROBOTO_CONDENSED)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .fontSize(24.px)
                .fontWeight(FontWeight.Bold)
        )

        // Project Description
        SpanText(
            text = description,
            modifier = Modifier
                .padding(bottom = 12.px)
                .fontFamily(Res.String.ROBOTO_REGULAR)
                .color(if (colorMode.isLight) Colors.Black else Colors.White)
                .fontSize(16.px)
        )

        // GitHub Button
        Button(
            onClick = { window.open(githubLink, "_blank") },
            modifier = Modifier
                .padding(top = 12.px,bottom=12.px)
                .borderRadius(8.px)
                .background(if (colorMode.isLight) Res.Theme.BLUE.color else Res.Theme.LIGHT_BLUE.color)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically, // Ensures vertical alignment
                modifier = Modifier.padding(leftRight = 8.px) // Adds padding inside the button
            ) {
                Image(
                    modifier = Modifier
                        .size(24.px) // Adjust the size of the icon
                        .margin(right = 8.px), // Adds space between the icon and text
                    src = if (colorMode.isLight) Res.Icon.GITHUB_LIGHT else Res.Icon.GITHUB
                )
                SpanText(
                    text = "View on GitHub",
                    modifier = Modifier
                        .fontSize(14.px)
                        .fontFamily(Res.String.ROBOTO_REGULAR)
                        .color(Colors.White)
                        .fontWeight(FontWeight.Bold)
                )
            }
        }

    }
    }

