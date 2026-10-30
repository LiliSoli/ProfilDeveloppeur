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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.profildeveloppeur.ui.theme.ProfilDeveloppeurTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        modifier = modifier.fillMaxWidth()
    ) {
        ProfileCard(
            name = "Aurélie S.",
            role = "Développeuse Java",
            description = "En alternance chez Worldline",
            skills = listOf("Java", "Spring Boot", "React"),
            isAvailable = true,
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
    description: String,
    skills: List<String>,
    isAvailable: Boolean,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color.White,
        modifier = modifier
    ) {
        ProfileCardContent(
            name = name,
            role = role,
            description = description,
            skills = skills,
            isAvailable = isAvailable
        )
    }
}

@Composable
fun ProfileCardContent(
    name: String,
    role: String,
    description: String,
    skills: List<String>,
    isAvailable: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        ProfileHeader(
            name = name,
            role = role,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            modifier = Modifier.padding(bottom = 8.dp)        )
        Text(
            text = "Compétences :",
            modifier = Modifier.padding(bottom = 4.dp)
        )
        skills.forEach { skill ->
            SkillItem(
                skill = skill,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
        Availability(
            isAvailable = isAvailable,
            modifier = Modifier.padding(top = 12.dp)

        )
    }
}

@Composable
fun ProfileHeader(
    name: String,
    role: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = name, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = role, fontSize = 16.sp, color = Color.DarkGray)
    }
}

@Composable
fun SkillItem(
    skill: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "• $skill",
        modifier = modifier
    )
}

@Composable
fun Availability(
    isAvailable: Boolean,
    modifier: Modifier = Modifier
) {
    Text(
        text = if (isAvailable) {
            "Disponible"
        } else {
            "Non disponible actuellement"
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfilDeveloppeurTheme {
        ProfileScreen()
    }
}