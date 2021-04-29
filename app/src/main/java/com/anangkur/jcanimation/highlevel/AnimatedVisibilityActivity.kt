package com.anangkur.jcanimation.highlevel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.*
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
import androidx.compose.ui.text.font.FontWeight
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
                    Column(modifier = Modifier.fillMaxSize().padding(20.dp),) {
                        Text(text = "Default", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        DefaultAnimatedVisibilityExample(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))
                        Text(text = "Expanded FAB", fontSize = 18.sp, fontWeight = FontWeight.Bold)
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
            AnimatedVisibility(visible = visible.value,) {
                Text(text = "test animated visibility", fontSize = 14.sp)
            }
            Button(
                modifier = Modifier.padding(top = 10.dp),
                onClick = { visible.value = visible.value.not() },
                content = { Text(text = if (visible.value) "Visible" else "Not Visible") }
            )
        }
    }
}