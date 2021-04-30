// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.4.32")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(Dependencies.Android.gradlePlugin)
        classpath(Dependencies.Kotlin.gradlePlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions.apply {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            useIR = true
            freeCompilerArgs += listOf(
                "-P",
                "plugin:androidx.compose.compiler.plugins.kotlin:suppressKotlinVersionCompatibilityCheck=true"
            )
        }
    }
}

val clean by tasks.registering(Delete::class) {
    delete = setOf(rootProject.buildDir)
}