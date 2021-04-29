package com.anangkur.jcanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anangkur.jcanimation.highlevel.AnimateContentSizeActivity
import com.anangkur.jcanimation.highlevel.AnimatedVisibilityActivity

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
                        modifier = Modifier.fillMaxSize().padding(20.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            modifier = Modifier.padding(10.dp),
                            onClick = { AnimatedVisibilityActivity.startActivity(this@MainActivity) },
                            content = { Text(text = getString(R.string.title_animated_visibility)) }
                        )
                        Button(
                            modifier = Modifier.padding(10.dp),
                            onClick = { AnimateContentSizeActivity.startActivity(this@MainActivity) },
                            content = { Text(text = getString(R.string.title_animated_content_size)) }
                        )
                    }
                }
            )
        }
    }
}