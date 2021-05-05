package com.anangkur.jcanimation.lowlevel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anangkur.jcanimation.R

class RememberInfiniteTransitionActivity  : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, RememberInfiniteTransitionActivity::class.java))
        }
    }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = getString(R.string.title_remember_infinite_transition)) },
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
                        Text(text = getString(R.string.text_expanded_fab_animate_color_size_position_with_rememberinfinitetransition), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabAnimateColorSizePosition(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))
                    }
                }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabAnimateColorSizePosition(
        modifier: Modifier = Modifier,
    ) {
        val transition = rememberInfiniteTransition()
        val contentColor = transition.animateColor(
            targetValue = Color.Green,
            initialValue = Color.Blue,
            animationSpec = infiniteRepeatable(
                animation = tween(1000),
                repeatMode = RepeatMode.Reverse
            )
        )
        val contentWidth = transition.animateFloat(
            targetValue = 100f,
            initialValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000),
                repeatMode = RepeatMode.Reverse
            ),
        )
        val contentHeight = transition.animateFloat(
            targetValue = 20f,
            initialValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000),
                repeatMode = RepeatMode.Reverse
            ),
        )
        val contentPosition = transition.animateFloat(
            targetValue = 20f,
            initialValue = 0f,
            animationSpec = infiniteRepeatable(
                animation = tween(1000),
                repeatMode = RepeatMode.Reverse
            ),
        )

        val iconColor = transition.animateColor(
            targetValue = Color.Black,
            initialValue = Color.White,
            animationSpec = infiniteRepeatable(
                animation = tween(1000),
                repeatMode = RepeatMode.Reverse
            )
        )

        FloatingActionButton(
            modifier = modifier,
            onClick = {},
            content = {
                Row(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = null,
                        tint = iconColor.value
                    )
                    Text(
                        text = getString(R.string.button_add_item),
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .absoluteOffset(x = contentPosition.value.dp)
                            .size(
                                height = contentHeight.value.dp,
                                width = contentWidth.value.dp
                            )
                    )
                }
            },
            backgroundColor = contentColor.value
        )
    }
}