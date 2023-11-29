package com.example.texttospeech.ui.screen

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.getSystemService
import com.example.texttospeech.ui.components.MyButton
import com.example.texttospeech.ui.components.MyEditText
import com.example.texttospeech.ui.components.MyTitleText
import com.example.texttospeech.ui.theme.TextToSpeechTheme

@Composable
fun MainScreen(textToSpeech: TextToSpeech? = null) {
    val context = LocalContext.current
    var textField by rememberSaveable {
        mutableStateOf("")
    }

    Column {
        MyTitleText(text = "Text To Speech App")
        MyEditText(hint = "Enter text", text = textField) { text ->
            textField = text
        }
        MyButton(text = "Speech") {
            vibrate(context, 500)
            textToSpeech?.speak(textField, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }
}

fun vibrate(context: Context, millis: Long) {
    val vibrator = getSystemService(context, Vibrator::class.java)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        vibrator?.vibrate(VibrationEffect.createOneShot(millis, VibrationEffect.DEFAULT_AMPLITUDE))
    } else {
        @Suppress("DEPRECATION")
        vibrator?.vibrate(millis)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainScreenPreview() {
    TextToSpeechTheme {
        MainScreen()
    }
}