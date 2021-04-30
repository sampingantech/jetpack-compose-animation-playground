package com.anangkur.jcanimation.highlevel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anangkur.jcanimation.R

class AnimatedVisibilityActivity: AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, AnimatedVisibilityActivity::class.java))
        }
    }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = getString(R.string.title_animated_visibility))},
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
                    Column(modifier = Modifier.fillMaxSize()
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState()),
                    ) {
                        Text(
                            text = getString(R.string.text_default_animated_visibility),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        DefaultAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_slide_animated_visibility), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        SlideAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_slide_horizontal_animated_visibility), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        SlideHorizontalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_slide_vertical_animated_visibility), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        SlideVerticalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expand_horizontal_animated_visibility), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        ExpandHorizontalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expand_vertical_animated_visibility), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        ExpandVerticalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_fade_animated_visibility), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        FadeAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_shrink_out_animated_visibility), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        ShrinkOutAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_shrink_horizontal_animated_visibility), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        ShrinkHorizontalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_shrink_vertical_animated_visibility), fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        ShrinkVerticalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))
                    }
                }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun DefaultAnimatedVisibilityExample(
        modifier: Modifier = Modifier,
    ) {
        Column(modifier = modifier) {
            val visible = remember { mutableStateOf(true) }
            AnimatedVisibility(
                visible = visible.value
            ) {
                Box(modifier = Modifier.background(color = Color.Gray)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = getString(R.string.text_default_animated_visibility_2),
                        fontSize = 14.sp,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { visible.value = visible.value.not() },
                content = { Text(text = if (visible.value) getString(R.string.text_hide) else getString(R.string.text_show)) }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun SlideVerticalAnimatedVisibilityExample(
        modifier: Modifier = Modifier,
    ) {
        val visible = remember { mutableStateOf(true) }
        Column(modifier = modifier) {
            AnimatedVisibility(
                visible = visible.value,
                enter = slideInVertically(),
                exit = slideOutVertically(),
            ) {
                Box(modifier = Modifier.background(color = Color.Red)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = getString(R.string.text_slide_vertical_animated_visibility),
                        fontSize = 14.sp,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { visible.value = visible.value.not() },
                content = { Text(text = if (visible.value) getString(R.string.text_hide) else getString(R.string.text_show)) }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun SlideHorizontalAnimatedVisibilityExample(
        modifier: Modifier = Modifier,
    ) {
        val visible = remember { mutableStateOf(true) }
        Column(modifier = modifier) {
            AnimatedVisibility(
                visible = visible.value,
                enter = slideInHorizontally(),
                exit = slideOutHorizontally(),
            ) {
                Box(modifier = Modifier.background(color = Color.Red)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = getString(R.string.text_slide_horizontal_animated_visibility),
                        fontSize = 14.sp,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { visible.value = visible.value.not() },
                content = { Text(text = if (visible.value) getString(R.string.text_hide) else getString(R.string.text_show)) }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandHorizontalAnimatedVisibilityExample(
        modifier: Modifier = Modifier,
    ) {
        val visible = remember { mutableStateOf(true) }
        Column(modifier = modifier) {
            AnimatedVisibility(
                visible = visible.value,
                enter = expandHorizontally(),
            ) {
                Box(modifier = Modifier.background(color = Color.Blue)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = getString(R.string.text_expand_horizontal_animated_visibility),
                        fontSize = 14.sp,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { visible.value = visible.value.not() },
                content = { Text(text = if (visible.value) getString(R.string.text_hide) else getString(R.string.text_show)) }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandVerticalAnimatedVisibilityExample(
        modifier: Modifier = Modifier,
    ) {
        val visible = remember { mutableStateOf(true) }
        Column(modifier = modifier) {
            AnimatedVisibility(
                visible = visible.value,
                enter = expandVertically(),
            ) {
                Box(modifier = Modifier.background(color = Color.Blue)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = getString(R.string.text_expand_vertical_animated_visibility),
                        fontSize = 14.sp,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { visible.value = visible.value.not() },
                content = { Text(text = if (visible.value) getString(R.string.text_hide) else getString(R.string.text_show)) }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun FadeAnimatedVisibilityExample(
        modifier: Modifier = Modifier,
    ) {
        val visible = remember { mutableStateOf(true) }
        Column(modifier = modifier) {
            AnimatedVisibility(
                visible = visible.value,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Box(modifier = Modifier.background(color = Color.Green)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = getString(R.string.text_fade_animated_visibility),
                        fontSize = 14.sp,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { visible.value = visible.value.not() },
                content = { Text(text = if (visible.value) getString(R.string.text_hide) else getString(R.string.text_show)) }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun SlideAnimatedVisibilityExample(
        modifier: Modifier = Modifier,
    ) {
        val visible = remember { mutableStateOf(true) }
        Column(modifier = modifier) {
            AnimatedVisibility(
                visible = visible.value,
                enter = slideIn({ value -> return@slideIn IntOffset(value.width,value.height) }),
                exit = slideOut({ value -> return@slideOut IntOffset(value.width,value.height) })
            ) {
                Box(modifier = Modifier.background(color = Color.Red)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = getString(R.string.text_slide_animated_visibility),
                        fontSize = 14.sp,
                        style = TextStyle(color = Color.White),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { visible.value = visible.value.not() },
                content = { Text(text = if (visible.value) getString(R.string.text_hide) else getString(R.string.text_show)) }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ShrinkOutAnimatedVisibilityExample(
        modifier: Modifier = Modifier,
    ) {
        val visible = remember { mutableStateOf(true) }
        Column(modifier = modifier) {
            AnimatedVisibility(
                visible = visible.value,
                exit = shrinkOut()
            ) {
                Box(modifier = Modifier.background(color = Color.Yellow)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = getString(R.string.text_shrink_out_animated_visibility),
                        fontSize = 14.sp,
                        style = TextStyle(color = Color.Black),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { visible.value = visible.value.not() },
                content = { Text(text = if (visible.value) getString(R.string.text_hide) else getString(R.string.text_show)) }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ShrinkHorizontalAnimatedVisibilityExample(
        modifier: Modifier = Modifier,
    ) {
        val visible = remember { mutableStateOf(true) }
        Column(modifier = modifier) {
            AnimatedVisibility(
                visible = visible.value,
                exit = shrinkHorizontally()
            ) {
                Box(modifier = Modifier.background(color = Color.Yellow)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = getString(R.string.text_shrink_horizontal_animated_visibility),
                        fontSize = 14.sp,
                        style = TextStyle(color = Color.Black),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { visible.value = visible.value.not() },
                content = { Text(text = if (visible.value) getString(R.string.text_hide) else getString(R.string.text_show)) }
            )
        }
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ShrinkVerticalAnimatedVisibilityExample(
        modifier: Modifier = Modifier,
    ) {
        val visible = remember { mutableStateOf(true) }
        Column(modifier = modifier) {
            AnimatedVisibility(
                visible = visible.value,
                exit = shrinkVertically()
            ) {
                Box(modifier = Modifier.background(color = Color.Yellow)
                    .fillMaxWidth()
                ) {
                    Text(
                        text = getString(R.string.text_shrink_vertical_animated_visibility),
                        fontSize = 14.sp,
                        style = TextStyle(color = Color.Black),
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { visible.value = visible.value.not() },
                content = { Text(text = if (visible.value) getString(R.string.text_hide) else getString(R.string.text_show)) }
            )
        }
    }
}