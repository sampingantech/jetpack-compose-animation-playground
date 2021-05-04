package com.anangkur.jcanimation.animationspecs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.*
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anangkur.jcanimation.R

class KeyFramesActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, KeyFramesActivity::class.java))
        }
    }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = getString(R.string.title_keyframe)) },
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
                    Column(modifier = Modifier.padding(20.dp).verticalScroll(rememberScrollState())) {
                        Text(text = getString(R.string.text_expanded_fab), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFab(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))
                    }
                }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFab(
        modifier: Modifier = Modifier,
    ) {
        val expanded = remember { mutableStateOf(false) }
        FloatingActionButton(
            modifier = modifier,
            onClick = { expanded.value = expanded.value.not() },
            content = {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = null,
                    )
                    AnimatedVisibility(
                        visible = expanded.value,
                        enter = fadeIn() + slideInHorizontally(
                            animationSpec = keyframes {
                                durationMillis = 1000
                                IntOffset(100,0) at 100 with LinearOutSlowInEasing
                                IntOffset(200, 0) at 500 with LinearEasing
                            }
                        ),
                        exit = fadeOut() + slideOutHorizontally(
                            animationSpec = keyframes {
                                durationMillis = 1000
                                IntOffset(-100,0) at 100 with FastOutLinearInEasing
                                IntOffset(-200, 0) at 500 with LinearEasing
                            }
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }
}