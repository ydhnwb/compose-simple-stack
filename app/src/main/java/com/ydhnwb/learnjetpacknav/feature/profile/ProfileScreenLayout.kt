package com.ydhnwb.learnjetpacknav.feature.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ProfileScreenLayout(
    username: String,
    onLogoutClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center,) {
        ClickableText(AnnotatedString("Hello ${username}!"), onClick = {
            print("Clicked!")
            onLogoutClick()
        } )
    }
}

@Preview
@Composable
fun PreviewProfileLayout() {
    ProfileScreenLayout(
        username = "username",
        onLogoutClick = {}
    )
}