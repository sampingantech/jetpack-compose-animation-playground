package com.anangkur.jcanimation.highlevel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
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
                        Text(text = "Default", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        DefaultAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = "Slide", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        SlideAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = "Slide Horizontal", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        SlideHorizontalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = "Slide Vertical", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        SlideVerticalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = "Expand Horizontal", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        ExpandHorizontalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = "Expand Vertical", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        ExpandVerticalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = "Fade", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        FadeAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = "Shrink Out", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        ShrinkOutAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = "Shrink Horizontal", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        ShrinkHorizontalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = "Shrink Vertical", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        ShrinkVerticalAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = "Bonus Expanded FAB", fontSize = 18.sp, fontWeight = FontWeight.Bold)
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
                        enter = slideInHorizontally(),
                        exit = slideOutHorizontally()
                    ) {
                        Text(text = "Add Item", modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
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
                        text = "default animated visibility",
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
                        text = "slide vertical animated visibility",
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
                        text = "slide horizontal animated visibility",
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
                        text = "expand horizontal animated visibility",
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
                        text = "expand vertical animated visibility",
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
                        text = "fade animated visibility",
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
                        text = "slide animated visibility",
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
                        text = "shrink out animated visibility",
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
                        text = "shrink horizontal animated visibility",
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
                        text = "shrink vertical animated visibility",
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