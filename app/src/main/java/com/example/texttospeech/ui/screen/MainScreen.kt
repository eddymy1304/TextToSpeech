package com.example.texttospeech.ui.screen

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.texttospeech.ui.components.MyButton
import com.example.texttospeech.ui.components.MyEditText
import com.example.texttospeech.ui.components.MyTitleText
import com.example.texttospeech.ui.theme.TextToSpeechTheme

@Composable
fun MainScreen(textToSpeech: TextToSpeech) {
    var textField by rememberSaveable {
        mutableStateOf("")
    }

    Column {
        MyTitleText(text = "Text To Speech App")
        MyEditText(hint = "Enter text", text = textField) { text ->
            textField = text
        }
        MyButton(text = "Speech") {
            textToSpeech.speak(textField, TextToSpeech.QUEUE_FLUSH, null, null)
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainScreenPreview() {
    TextToSpeechTheme {
        //MainScreen(TextToSpeech(LocalContext.current))
    }
}