package com.anangkur.jcanimation.highlevel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.anangkur.jcanimation.R

class AnimateContentSizeActivity: AppCompatActivity() {
    
    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, AnimateContentSizeActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = getString(R.string.title_animated_content_size))},
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
                        DefaultAnimatedContentSizeExample()
                    }
                }
            )
        }
    }

    @Composable
    private fun DefaultAnimatedContentSizeExample() {
        val expandWithout = remember { mutableStateOf(false) }
        val expandWith = remember { mutableStateOf(false) }
        Column {
            Text(text = getString(R.string.text_without_animate_content_size), modifier = Modifier.padding(bottom = 10.dp))
            Box(modifier = Modifier.background(Color.Gray)
                .clickable { expandWithout.value = expandWithout.value.not() }
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = if (expandWithout.value)
                        getString(R.string.long_lorem_ipsum)
                    else
                        getString(R.string.short_lorem_ipsum),
                    style = TextStyle(color = Color.White)
                )
            }

            Divider(modifier = Modifier.padding(vertical = 20.dp))

            Text(text = getString(R.string.text_with_animate_content_size), modifier = Modifier.padding(bottom = 10.dp))
            Box(modifier = Modifier.background(Color.Blue).animateContentSize()
                .clickable { expandWith.value = expandWith.value.not() }
            ) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = if (expandWith.value)
                        getString(R.string.long_lorem_ipsum)
                    else
                        getString(R.string.short_lorem_ipsum),
                    style = TextStyle(color = Color.White)
                )
            }
        }
    }
}