package com.anangkur.jcanimation.animationspecs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anangkur.jcanimation.R

class SpringActivity : AppCompatActivity() {

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, SpringActivity::class.java))
        }
    }

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = getString(R.string.title_spring)) },
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
                    Column(modifier = Modifier.padding(20.dp).verticalScroll(rememberScrollState())) {
                        Text(text = getString(R.string.text_expanded_fab), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFab(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_spring_high_bouncy_high_stiffness), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabSpringHighBouncyHighStiffness(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_high_bouncy_medium_stiffness), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabSpringHighBouncyMediumStiffness(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_spring_high_bouncy_low_stiffness), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabSpringHighBouncyLowStiffness(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_spring_high_bouncy_very_low_stiffness), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabSpringHighBouncyVeryLowStiffness(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_spring_medium_bouncy_medium_stiffness), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabSpringMediumBouncyMediumStiffness(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_spring_low_bouncy_medium_stiffness), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabSpringLowBouncyMediumStiffness(modifier = Modifier.padding(top = 10.dp))
                        Divider(modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp))

                        Text(text = getString(R.string.text_expanded_fab_spring_no_bouncy_medium_stiffness), fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        ExpandableFabSpringNoBouncyMediumStiffness(modifier = Modifier.padding(top = 10.dp))
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
                        enter = fadeIn() + slideInHorizontally(),
                        exit = fadeOut() + slideOutHorizontally(),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabSpringHighBouncyHighStiffness(
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
                        enter = fadeIn() + slideInHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioHighBouncy,
                                stiffness = Spring.StiffnessHigh
                            )
                        ),
                        exit = fadeOut() + slideOutHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioHighBouncy,
                                stiffness = Spring.StiffnessHigh
                            )
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabSpringHighBouncyMediumStiffness(
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
                        enter = fadeIn() + slideInHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioHighBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        ),
                        exit = fadeOut() + slideOutHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioHighBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabSpringHighBouncyLowStiffness(
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
                        enter = fadeIn() + slideInHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioHighBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        ),
                        exit = fadeOut() + slideOutHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioHighBouncy,
                                stiffness = Spring.StiffnessLow
                            )
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabSpringHighBouncyVeryLowStiffness(
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
                        enter = fadeIn() + slideInHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioHighBouncy,
                                stiffness = Spring.StiffnessVeryLow
                            )
                        ),
                        exit = fadeOut() + slideOutHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioHighBouncy,
                                stiffness = Spring.StiffnessVeryLow
                            )
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabSpringMediumBouncyMediumStiffness(
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
                        enter = fadeIn() + slideInHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        ),
                        exit = fadeOut() + slideOutHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabSpringLowBouncyMediumStiffness(
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
                        enter = fadeIn() + slideInHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioLowBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        ),
                        exit = fadeOut() + slideOutHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioLowBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }

    @ExperimentalAnimationApi
    @Composable
    private fun ExpandableFabSpringNoBouncyMediumStiffness(
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
                        enter = fadeIn() + slideInHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioNoBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        ),
                        exit = fadeOut() + slideOutHorizontally(
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioNoBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        ),
                    ) {
                        Text(text = getString(R.string.button_add_item), modifier = Modifier.padding(start = 4.dp))
                    }
                }
            }
        )
    }
}