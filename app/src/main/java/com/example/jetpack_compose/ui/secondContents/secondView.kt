package com.example.jetpack_compose.ui.secondContents

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpack_compose.ui.theme.JetpackcomposeTheme

@Composable
fun SecondView() {
    Text("Second View")
}

@Preview(showBackground = true)
@Composable
fun SecondPreview() {
    JetpackcomposeTheme {
        SecondView()
    }
}
