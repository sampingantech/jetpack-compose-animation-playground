package com.anangkur.jcanimation.highlevel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.anangkur.jcanimation.R

class CrossFadeActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, CrossFadeActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = getString(R.string.title_cross_fade)) },
                        navigationIcon = {
                            IconButton(
                                onClick = ::onBackPressed,
                                content = {
                                    Icon(
                                        imageVector = Icons.Filled.ArrowBack,
                                        contentDescription = null
                                    )
                                }
                            )
                        }
                    )
                },
                content = {
                    val pageCrossFade = remember { mutableStateOf(0) }
                    val colors = arrayOf(
                        Pair(Color.Red, "Red"),
                        Pair(Color.Blue, "Blue"),
                        Pair(Color.Gray, "Gray"),
                        Pair(Color.Black, "Black"),
                        Pair(Color.Yellow, "Yellow"),
                        Pair(Color.LightGray, "LightGray"),
                        Pair(Color.Cyan, "Cyan"),
                        Pair(Color.Green, "Green"),
                        Pair(Color.Magenta, "Magenta"),
                        Pair(Color.DarkGray, "DarkGray"),
                    )
                    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
                        Crossfade(
                            modifier = Modifier.weight(1f),
                            targetState = pageCrossFade,
                            content = { index ->
                                Box(
                                    modifier = Modifier.fillMaxSize()
                                        .background(color = colors[index.value].first)
                                        .clickable {
                                            if (pageCrossFade.value == colors.size - 1)
                                                pageCrossFade.value = 0
                                            else
                                                pageCrossFade.value++
                                        },
                                    contentAlignment = Alignment.Center,
                                ) {
                                    Text(text = colors[index.value].second, fontWeight = FontWeight.Bold)
                                }
                            }
                        )
                    }
                }
            )
        }
    }
}