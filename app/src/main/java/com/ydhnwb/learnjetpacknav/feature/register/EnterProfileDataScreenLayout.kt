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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterProfileDataScreenLayout(
    fullName: State<String>,
    fullNameUpdater: (String) -> Unit,
    bio: State<String>,
    bioUpdater: (String) -> Unit,
    onButtonClicked: () -> Unit,
    isButtonEnabled: State<Boolean>,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = fullName.value,
            singleLine = true,
            placeholder = { Text("Full name") },
            onValueChange = fullNameUpdater,
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = bio.value,
            singleLine = true,
            placeholder = { Text("Bio") },
            onValueChange = bioUpdater,
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = onButtonClicked, enabled = isButtonEnabled.value) {
            Text(text = "Next")
        }
    }
}

@Preview
@Composable
fun PreviewEnterProfileDataLayout() {
    EnterProfileDataScreenLayout(
        fullName = remember { mutableStateOf("Full Name") },
        fullNameUpdater = {},
        bio = remember { mutableStateOf("Bio") },
        bioUpdater = {},
        onButtonClicked = {},
        isButtonEnabled = remember { mutableStateOf(true) },
    )
}
