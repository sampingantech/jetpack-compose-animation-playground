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
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
                topBar = { TopAppBar(title = { Text(text = getString(R.string.title_animated_content_size)) }) },
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
        val expand = remember { mutableStateOf(false) }
        Column {
            Text(text = "without animateContentSize()", modifier = Modifier.padding(vertical = 10.dp))
            Box(modifier = Modifier.background(Color.Gray)) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = if (expand.value)
                        getString(R.string.long_lorem_ipsum)
                    else
                        getString(R.string.short_lorem_ipsum),
                    style = TextStyle(color = Color.White)
                )
            }
            Text(text = "with animateContentSize()", modifier = Modifier.padding(vertical = 10.dp))
            Box(modifier = Modifier.background(Color.Blue).animateContentSize()) {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = if (expand.value)
                        getString(R.string.long_lorem_ipsum)
                    else
                        getString(R.string.short_lorem_ipsum),
                    style = TextStyle(color = Color.White)
                )
            }
            Button(
                modifier = Modifier.padding(top = 10.dp).fillMaxWidth(),
                onClick = { expand.value = expand.value.not() },
                content = {
                    Text(text = if (expand.value)
                        getString(R.string.collapse)
                    else
                        getString(R.string.text_expand))
                }
            )
        }
    }
}