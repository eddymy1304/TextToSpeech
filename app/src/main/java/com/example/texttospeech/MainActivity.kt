package com.example.texttospeech

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.texttospeech.ui.screen.MainScreen
import com.example.texttospeech.ui.theme.TextToSpeechTheme
import java.util.Locale

class MainActivity : ComponentActivity() {
    private lateinit var textToSpeech: TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textToSpeech = TextToSpeech(this) {
            if (it == TextToSpeech.SUCCESS) {
                textToSpeech.language = Locale.getDefault()
            }
        }
        setContent {
            TextToSpeechTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(textToSpeech)
                }
            }
        }

    }
}

