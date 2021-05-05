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

class TweenActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, TweenActivity::class.java))
        }
    }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = getString(R.string.title_tween)) },
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

                        Text(text = getString(R.string.text_expanded_fab_tween_fast_out_slow_in), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabTweenFastOutSlowInEasing(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_tween_linear_out_slow_in), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabTweenLinearOutSlowInEasing(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_tween_fast_out_linear_in), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabTweenFastOutLinearInEasing(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_tween_linear), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabTweenLinearEasing(modifier = Modifier.padding(top = 10.dp))
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
    private fun ExpandableFabTweenFastOutSlowInEasing(
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
                        enter = fadeIn(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = FastOutSlowInEasing
                            )
                        ) + slideInHorizontally(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = FastOutSlowInEasing
                            )
                        ),
                        exit = fadeOut(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = FastOutSlowInEasing
                            )
                        ) + slideOutHorizontally(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = FastOutSlowInEasing
                            )
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabTweenLinearOutSlowInEasing(
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
                        enter = fadeIn(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = LinearOutSlowInEasing
                            )
                        ) + slideInHorizontally(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = LinearOutSlowInEasing
                            )
                        ),
                        exit = fadeOut(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = LinearOutSlowInEasing
                            )
                        ) + slideOutHorizontally(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = LinearOutSlowInEasing
                            )
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabTweenFastOutLinearInEasing(
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
                        enter = fadeIn(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = FastOutLinearInEasing
                            )
                        ) + slideInHorizontally(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = FastOutLinearInEasing
                            )
                        ),
                        exit = fadeOut(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = FastOutLinearInEasing
                            )
                        ) + slideOutHorizontally(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = FastOutLinearInEasing
                            )
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabTweenLinearEasing(
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
                        enter = fadeIn(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = LinearEasing
                            )
                        ) + slideInHorizontally(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = LinearEasing
                            )
                        ),
                        exit = fadeOut(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing = LinearEasing
                            )
                        ) + slideOutHorizontally(
                            animationSpec = tween(
                                durationMillis = 1000,
                                delayMillis = 0,
                                easing =  LinearEasing
                            )
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }
}