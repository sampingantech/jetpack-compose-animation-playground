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