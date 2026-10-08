package com.pnc.jetpackcomposedemos

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pnc.jetpackcomposedemos.core.EventPlannerApp
import com.pnc.jetpackcomposedemos.ui.theme.KazooTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class EventPlannerApplication: Application()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KazooTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(horizontal = 16.dp)

                    Box(
                        modifier = modifier
                    ) {
                        EventPlannerApp()
                    }
                }
            }

//            KazooTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    val modifier = Modifier
//                        .fillMaxSize()
//                        .padding(innerPadding)
//                        .padding(horizontal = 16.dp)
//
//                    Box(
//                        modifier = modifier
//                    ) {
//                        val sampleAccounts = listOf(
//                            Account("a1", "Everyday Checking", "\u2022\u2022\u2022\u2022 4471", 4281.16),
//                            Account("a2", "High Yield Savings", "\u2022\u2022\u2022\u2022 9902", 18340.50),
//                            Account("a3", "Rewards Credit Card", "\u2022\u2022\u2022\u2022 2216", -612.44),
//                            Account("1", "Everyday Checking", "\u2022\u2022\u2022\u2022 4471", 4281.16),
//                            Account("2", "High Yield Savings", "\u2022\u2022\u2022\u2022 9902", 18340.50),
//                            Account("3", "Rewards Credit Card", "\u2022\u2022\u2022\u2022 2216", -612.44),
//                            Account("11", "Everyday Checking", "\u2022\u2022\u2022\u2022 4471", 4281.16),
//                            Account("22", "High Yield Savings", "\u2022\u2022\u2022\u2022 9902", 18340.50),
//                            Account("33", "Rewards Credit Card", "\u2022\u2022\u2022\u2022 2216", -612.44),
//                            Account("111", "Everyday Checking", "\u2022\u2022\u2022\u2022 4471", 4281.16),
//                            Account("222", "High Yield Savings", "\u2022\u2022\u2022\u2022 9902", 18340.50),
//                            Account("333", "Rewards Credit Card", "\u2022\u2022\u2022\u2022 2216", -612.44),
//                        )
//
//                        AccountListScreen(sampleAccounts, {})
//                    }
//                }
//            }


        }
    }
}