package com.ydhnwb.learnjetpacknav.feature.register

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateLoginCredentialsScreenLayout(
    username: State<String>,
    usernameUpdater: (String) -> Unit,
    password: State<String>,
    passwordUpdater: (String) -> Unit,
    isButtonEnabled: State<Boolean>,
    onButtonClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = username.value,
            singleLine = true,
            placeholder = { Text("Username") },
            onValueChange = usernameUpdater,
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password.value,
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            placeholder = { Text("Password") },
            onValueChange = passwordUpdater,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onButtonClicked, enabled = isButtonEnabled.value) {
            Text(text = "Register and login")
        }
    }
}


@Preview
@Composable
fun PreviewCreateLoginCredentialsLayout() {
    CreateLoginCredentialsScreenLayout(
        username = remember { mutableStateOf("Username") },
        usernameUpdater = {},
        password = remember { mutableStateOf("password") },
        passwordUpdater = {},
        isButtonEnabled = remember { mutableStateOf(true) },
        onButtonClicked = {},
    )
}