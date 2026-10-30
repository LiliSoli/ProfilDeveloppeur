package com.example.profildeveloppeur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilDeveloppeurTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Surface(
        color = Color.LightGray,
        modifier = modifier.fillMaxSize()
    ) {
        ProfileCard(
            name = "Aurélie S.",
            role = "Développeuse Java",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}

@Composable
fun ProfileCard(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color.White,
        modifier = modifier
    ) {
        ProfileCardContent(
            name = name,
            role = role
        )
    }
}

@Composable
fun ProfileCardContent(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = role,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfilDeveloppeurTheme {
        ProfileScreen()
    }
}