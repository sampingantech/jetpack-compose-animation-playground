package com.anangkur.jcanimation.animationspecs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.*
import androidx.compose.animation.core.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anangkur.jcanimation.R

class RepeatableActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, RepeatableActivity::class.java))
        }
    }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = getString(R.string.title_repeatable)) },
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

                        Text(text = getString(R.string.text_expanded_fab_with_iteration_3_and_repeat_mode_reverse), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabIteration3RepeatModeReverse(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_with_iteration_3_and_repeat_mode_restart), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabIteration3RepeatModeRestart(modifier = Modifier.padding(top = 10.dp))
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
                        enter = fadeIn() + slideInHorizontally(),
                        exit = fadeOut() + slideOutHorizontally(),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabIteration3RepeatModeReverse(
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
                            animationSpec = repeatable(
                                iterations = 3,
                                animation = tween(durationMillis = 500),
                                repeatMode = RepeatMode.Reverse
                            )
                        ),
                        exit = fadeOut() + slideOutHorizontally(),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabIteration3RepeatModeRestart(
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
                            animationSpec = repeatable(
                                iterations = 3,
                                animation = tween(durationMillis = 500),
                                repeatMode = RepeatMode.Restart
                            )
                        ),
                        exit = fadeOut() + slideOutHorizontally(),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }
}