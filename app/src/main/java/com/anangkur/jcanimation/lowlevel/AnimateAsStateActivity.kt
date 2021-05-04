package com.anangkur.jcanimation.lowlevel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anangkur.jcanimation.R

class AnimateAsStateActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, AnimateAsStateActivity::class.java))
        }
    }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = getString(R.string.title_animate_as_state)) },
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
                    Column(modifier = Modifier.padding(20.dp)) {
                        Text(text = getString(R.string.text_expanded_fab_animate_color_with_animate_color_as_state), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabAnimateColor(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_animate_size_with_animate_int_size_as_state), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabAnimateIntSize(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_animate_position_with_animate_dp_as_state), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabAnimateDp(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))
                    }
                }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabAnimateColor(
        modifier: Modifier = Modifier,
    ) {
        val enable = remember { mutableStateOf(false) }
        val contentColor = animateColorAsState(
            targetValue = if (enable.value) Color.LightGray else Color.Green,
            animationSpec = tween(1000),
        )
        FloatingActionButton(
            modifier = modifier,
            onClick = { enable.value = enable.value.not() },
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
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            },
            backgroundColor = contentColor.value
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabAnimateIntSize(
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
    private fun ExpandableFabAnimateDp(
        modifier: Modifier = Modifier,
    ) {
        val expanded = remember { mutableStateOf(false) }
        val contentPosition = animateDpAsState(
            targetValue = if (expanded.value) 200.dp else 0.dp,
            animationSpec = tween(1000),
        )
        Box(modifier = Modifier.fillMaxWidth()) {
            FloatingActionButton(
                modifier = modifier.absoluteOffset(x = contentPosition.value),
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
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }
            )
        }
    }
}