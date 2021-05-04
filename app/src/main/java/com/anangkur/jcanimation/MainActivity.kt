package com.anangkur.jcanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anangkur.jcanimation.animationspecs.*
import com.anangkur.jcanimation.highlevel.AnimateContentSizeActivity
import com.anangkur.jcanimation.highlevel.AnimatedVisibilityActivity
import com.anangkur.jcanimation.highlevel.CrossFadeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text(text = getString(R.string.app_name)) })
                },
                content = {
                    Column(
                        modifier = Modifier.fillMaxSize().padding(20.dp).verticalScroll(rememberScrollState()),
                    ) {
                        Text(getString(R.string.title_high_level_api), modifier = Modifier.padding(10.dp))
                        Button(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            onClick = { AnimatedVisibilityActivity.startActivity(this@MainActivity) },
                            content = { Text(text = getString(R.string.title_animated_visibility)) }
                        )
                        Button(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            onClick = { AnimateContentSizeActivity.startActivity(this@MainActivity) },
                            content = { Text(text = getString(R.string.title_animated_content_size)) }
                        )
                        Button(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            onClick = { CrossFadeActivity.startActivity(this@MainActivity) },
                            content = { Text(text = getString(R.string.title_cross_fade)) }
                        )
                        Text(getString(R.string.title_animation_spec), modifier = Modifier.padding(10.dp))
                        Button(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            onClick = { TweenActivity.startActivity(this@MainActivity) },
                            content = { Text(text = getString(R.string.title_tween)) }
                        )
                        Button(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            onClick = { SpringActivity.startActivity(this@MainActivity) },
                            content = { Text(text = getString(R.string.title_spring)) }
                        )
                        Button(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            onClick = { KeyFramesActivity.startActivity(this@MainActivity) },
                            content = { Text(text = getString(R.string.title_keyframe)) }
                        )
                        Button(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            onClick = { RepeatableActivity.startActivity(this@MainActivity) },
                            content = { Text(text = getString(R.string.title_repeatable)) }
                        )
                        Button(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            onClick = { InfiniteRepeatableActivity.startActivity(this@MainActivity) },
                            content = { Text(text = getString(R.string.title_infinite_repeatable)) }
                        )
                        Button(
                            modifier = Modifier.padding(10.dp).fillMaxWidth(),
                            onClick = { SnapActivity.startActivity(this@MainActivity) },
                            content = { Text(text = getString(R.string.title_snap)) }
                        )
                    }
                }
            )
        }
    }
}