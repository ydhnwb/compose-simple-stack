@file:OptIn(ExperimentalMaterial3Api::class)

package com.ydhnwb.learnjetpacknav.feature.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
@Composable
fun LoginScreenLayout(
    username: State<String>,
    usernameUpdater: (String) -> Unit,
    password: State<String>,
    passwordUpdater: (String) -> Unit,
    isLoginEnabled: State<Boolean>,
    onLoginClicked: () -> Unit,
    onRegisterClicked: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = username.value,
            placeholder = { Text("Username") },
            onValueChange = usernameUpdater,
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = password.value,
            placeholder = { Text("Password") },
            onValueChange = passwordUpdater,
            visualTransformation = remember { PasswordVisualTransformation() },
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = onLoginClicked, enabled = isLoginEnabled.value) {
            Text(text = "LOGIN")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onRegisterClicked) {
            Text(text = "REGISTER")
        }
    }
}