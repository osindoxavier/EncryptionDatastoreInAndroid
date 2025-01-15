package com.xavier.encpypt

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.datastore.dataStore
import com.xavier.encpypt.ui.theme.EncpyptTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

private val Context.dataStore by dataStore(
    fileName = "User_preferences",
    serializer = UserPreferencesSerializer
)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EncpyptTheme {

                val scope = rememberCoroutineScope()
                val text = remember {
                    mutableStateOf(UserPreferences())
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally){
                        Button(
                            onClick = {
                                scope.launch {
                                    dataStore.updateData {
                                        UserPreferences(
                                            token = "wv5XosXBU5EBv1OfT31POJ0MgGGbHgbtIRYxq9k4GRgg",
                                            userID = "user01"
                                        )
                                    }
                                }
                            }
                        ) {
                            Text(text = "Decrypt")
                        }
                        Spacer(modifier = Modifier.height(50.dp))
                        Button(
                            onClick = {
                                scope.launch {
                                    text.value = dataStore.data.first()
                                }
                            }
                        ) {
                            Text(text = "Decrypt")
                        }
                        Spacer(modifier = Modifier.height(50.dp))

                        Text(text = "token = ${text.value.token}")
                        Text(text = "userId = ${text.value.userID}")
                    }
                }
            }
        }
    }
}

