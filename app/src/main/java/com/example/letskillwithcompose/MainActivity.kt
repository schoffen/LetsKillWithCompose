package com.example.letskillwithcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.letskillwithcompose.components.CoilImage
import com.example.letskillwithcompose.components.ExpandablePersonCard
import com.example.letskillwithcompose.components.GoogleButton
import com.example.letskillwithcompose.components.GradientButton
import com.example.letskillwithcompose.components.LimitTextField
import com.example.letskillwithcompose.components.PasswordTextField
import com.example.letskillwithcompose.projects.SpeedCheckUI
import com.example.letskillwithcompose.repository.PersonRepository
import com.example.letskillwithcompose.ui.navigation.SetupNavGraph
import com.example.letskillwithcompose.ui.screens.HomeScreen
import com.example.letskillwithcompose.ui.theme.LetsKillWithComposeTheme
import com.example.letskillwithcompose.ui.theme.Pink40
import com.example.letskillwithcompose.ui.theme.Purple40
import com.example.letskillwithcompose.ui.theme.Purple80

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LetsKillWithComposeTheme {
                navHostController = rememberNavController()
                SetupNavGraph(navHostController = navHostController)
            }
        }
    }
}