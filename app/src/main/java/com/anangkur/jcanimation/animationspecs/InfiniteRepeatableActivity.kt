package com.anangkur.jcanimation.animationspecs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateIntSizeAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
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
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anangkur.jcanimation.R

class InfiniteRepeatableActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, InfiniteRepeatableActivity::class.java))
        }
    }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = getString(R.string.title_infinite_repeatable)) },
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

                        Text(text = getString(R.string.text_expanded_fab_with_infinite_repeatable_and_repeat_mode_reverse), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabInfiniteRepeatableReverse(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_with_infinite_repeatable_and_repeat_mode_restart), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabInfiniteRepeatableRestart(modifier = Modifier.padding(top = 10.dp))
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
        val contentSize = animateIntSizeAsState(
            targetValue = if (expanded.value) IntSize(100, 20) else IntSize.Zero,
            animationSpec = tween(1000),
        )
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
                    Text(
                        text = getString(R.string.button_add_item),
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .size(height = contentSize.value.height.dp, width = contentSize.value.width.dp)
                    )
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabInfiniteRepeatableReverse(
        modifier: Modifier = Modifier,
    ) {
        val expanded = remember { mutableStateOf(false) }
        val contentSize = animateIntSizeAsState(
            targetValue = if (expanded.value) IntSize(100, 20) else IntSize.Zero,
            animationSpec = infiniteRepeatable(
                animation = tween(1000),
                repeatMode = RepeatMode.Reverse,
            ),
        )
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
                    Text(
                        text = getString(R.string.button_add_item),
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .size(height = contentSize.value.height.dp, width = contentSize.value.width.dp)
                    )
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabInfiniteRepeatableRestart(
        modifier: Modifier = Modifier,
    ) {
        val expanded = remember { mutableStateOf(false) }
        val contentSize = animateIntSizeAsState(
            targetValue = if (expanded.value) IntSize(100, 20) else IntSize.Zero,
            animationSpec = infiniteRepeatable(
                animation = tween(1000),
                repeatMode = RepeatMode.Restart
            ),
        )
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
                    Text(
                        text = getString(R.string.button_add_item),
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .size(height = contentSize.value.height.dp, width = contentSize.value.width.dp)
                    )
                }
            }
        )
    }
}