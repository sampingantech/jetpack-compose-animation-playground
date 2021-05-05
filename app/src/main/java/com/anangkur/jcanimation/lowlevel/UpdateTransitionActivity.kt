package com.anangkur.jcanimation.lowlevel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anangkur.jcanimation.R

class UpdateTransitionActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, UpdateTransitionActivity::class.java))
        }
    }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = getString(R.string.title_update_transition)) },
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
                        Text(text = getString(R.string.text_expanded_fab_animate_color_size_position_with_updatetransition), fontSize = 14.sp, fontWeight = FontWeight.Bold)
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
        val expand = remember { mutableStateOf(false) }
        val transition = updateTransition(expand.value)
        val contentColor = transition.animateColor() { expanded ->
            when (expanded) {
                true -> Color.Green
                false -> Color.Blue
            }
        }
        val contentSize = transition.animateIntSize { expanded ->
            when (expanded) {
                true -> IntSize(100, 20)
                false -> IntSize.Zero
            }
        }
        val contentPosition = transition.animateDp { expanded ->
            when (expanded) {
                true -> 20.dp
                false -> 0.dp
            }
        }
        val iconColor = transition.animateColor { expanded ->
            when (expanded) {
                true -> Color.Black
                false -> Color.White
            }
        }
        FloatingActionButton(
            modifier = modifier,
            onClick = { expand.value = expand.value.not() },
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
                            .absoluteOffset(x = contentPosition.value)
                            .size(
                                height = contentSize.value.height.dp,
                                width = contentSize.value.width.dp
                            )
                    )
                }
            },
            backgroundColor = contentColor.value
        )
    }
}