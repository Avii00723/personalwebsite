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
import com.varabyte.kobweb.compose.ui.styleModifier
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
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.times

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
                .margin(bottom = 30.px)
                .fontWeight(FontWeight.Bold)
                .textAlign(
                    if (breakpoint <= Breakpoint.SM) TextAlign.Center
                    else TextAlign.Start
                ),
            text = "Projects"
        )

        // SimpleGrid for projects, with width matching profile card size
        SimpleGrid(
            numColumns = numColumns(base = 1, md = 1),
            modifier = Modifier.fillMaxWidth().padding(12.px)
        ) {
            ProjectCard(
                title = "Stay Cation App",
                description = "Developed an Android Hotel Booking application using Java and Android Studio to book hotels in various cities.\n" +
                        "Implemented Firebase authentication using Email credentials to verify the customers.\n" +
                        "Used SMS Manager API to automatically send text messages to customers after every hotel reservation is made.\n" +
                        "Processed user inputted information in the back-end of the app to return a price based on the type of hotels selected.",

                githubLink = "https://github.com/Avii00723/StayCation-version-1.0",
                imageUrl = "staycartion.svg", // Provide the image URL here
                colorMode = colorMode,
                cardWidth = 300.px
            )

            ProjectCard(
                title = "7 Minute Workout App",
                description = "Developed a Workout App With workout sessions with BMI CalculatorUsed Text to Speech Function and Stored Data of your workout sessions.\n" +
                        "Developed a Workout Session for Daily basis.\n" +
                        "Given a history of workout and BMI calculator to take daily notes.",
                githubLink = "https://github.com/Avii00723/WorkoutApp",
                imageUrl = "workout1.svg", // Provide the image URL here
                colorMode = colorMode,
                cardWidth = 300.px
            )

            ProjectCard(
                title = "Object Detection App using Flutter and TensorFlow Lite",
                description = "Developed a mobile application for object detection using Flutter framework and TensorFlow Lite library.Integrated Firebase Authentication to securely manage user sign-up, login, and profile management\n" +
                        "Managed data synchronization and error handling for an uninterrupted messaging experience.",
                githubLink = "https://github.com/Avii00723/Realtime-Object-Detection/tree/master",
                imageUrl = "object detection.svg", // Provide the image URL here
                colorMode = colorMode,
                cardWidth = 300.px
            )
            ProjectCard(
                title = "Flutter Chat App Using Firebase",
                description = "Developed a fully functional chat application using Flutter for the front-end and Firebase for the back-end, enabling\n" +
                        "real-time messaging.Implemented object detection functionality using pre-trained models in TensorFlow Lite.\n" +
                        "Optimized performance to achieve real-time or near real-time object detection on mobile devices",
                githubLink = "https://github.com/Avii00723/ChatApp/tree/master",
                imageUrl = "chat2.svg", // Provide the image URL here
                colorMode = colorMode,
                cardWidth = 300.px
            )
        }
    }
}


@Composable
fun ProjectCard(
    title: String,
    description: String,
    githubLink: String,
    imageUrl: String,  // Added parameter for the image URL
    colorMode: ColorMode,
    cardWidth: CSSSizeValue<CSSUnit.px>
) {
    val breakpoint = rememberBreakpoint()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.px)
            .background(if (colorMode.isLight) Colors.White else Res.Theme.DARK_BLUE.color)
            .borderRadius(12.px),
        verticalAlignment = Alignment.CenterVertically,  // Aligns content vertically in the row
        horizontalArrangement = Arrangement.SpaceBetween // Align content to have space between the image and text
    ) {
        // Left side for Project Title, Description, and GitHub Button
        Column(
            modifier = Modifier
                .fillMaxWidth() // Adjust the width of the text container
                .padding(16.px),
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
                    .padding(top = 12.px)
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

        // Right side for Project Image
        Box(
            modifier = Modifier
                .fillMaxWidth() // Adjust the width of the image container
                .height(450.px) // Set a height for the image box
                .borderRadius(8.px)
                .boxShadow(color = Colors.Black.copy(alpha = 0.1.toInt()), blurRadius = 16.px, spreadRadius = 8.px)
                .background(if (colorMode.isLight) Colors.White else Res.Theme.DARK_BLUE.color)
                .padding(16.px) // Adds padding to separate the image from the edges
        ) {
            Image(
                src = imageUrl,  // Use the image URL for the project
                modifier = Modifier
                    .width(80.percent) // Scale the image width to 25% of the container's width
                    .height(80.percent) // Set the height for the image
                    .borderRadius(8.px)
                    .thenIf(breakpoint <= Breakpoint.SM) {
                        Modifier.width(50.percent) // Adjust the image to 50% width for small screens
                    }
                    .styleModifier {
                        property("object-fit", "contain") // Ensures the image maintains aspect ratio
                        property("object-position", "center") // Centers the image within the box
                    }
            )
        }



    }
    }


