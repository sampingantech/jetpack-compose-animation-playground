object Versions {
    object Junit {
        const val junit = "4.+"
    }
    object Kotlin {
        const val kotlin = "1.4.32"
    }
    object Android {
        const val gradlePlugin = "4.1.3"
    }
    object AndroidX {
        const val coreKtx = "1.2.0"
        const val appCompat = "1.1.0"
        const val constraintLayout = "1.1.3"
        const val junit = "1.1.1"
        const val espresso = "3.2.0"
        object Compose {
            const val activity = "1.3.0-alpha03"
            const val compose = "1.0.0-beta01"
        }
    }
    object Google {
        const val material = "1.1.0"
    }
}

object Dependencies {
    object Android {
        const val gradlePlugin = "com.android.tools.build:gradle:${Versions.Android.gradlePlugin}"
    }
    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:${Versions.AndroidX.coreKtx}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appCompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintLayout}"
        const val junit = "androidx.test.ext:junit:${Versions.AndroidX.junit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.AndroidX.espresso}"
        object Compose {
            const val ui = "androidx.compose.ui:ui:${Versions.AndroidX.Compose.compose}"
            const val foundation = "androidx.compose.foundation:foundation:${Versions.AndroidX.Compose.compose}"
            const val activity = "androidx.activity:activity-compose:${Versions.AndroidX.Compose.activity}"
            const val material = "androidx.compose.material:material:${Versions.AndroidX.Compose.compose}"
            const val compiler = "androidx.compose.compiler:compiler:${Versions.AndroidX.Compose.compose}"
            const val icon = "androidx.compose.material:material-icons-core:${Versions.AndroidX.Compose.compose}"
        }
    }
    object Google {
        const val material = "com.google.android.material:material:${Versions.Google.material}"
    }
    object Junit {
        const val junit = "junit:junit:${Versions.Junit.junit}"
    }
    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.kotlin}"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.kotlin}"
    }
}