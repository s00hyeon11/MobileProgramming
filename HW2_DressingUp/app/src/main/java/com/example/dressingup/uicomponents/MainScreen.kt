package com.example.dressingup.uicomponents

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dressingup.R
import com.example.dressingup.model.ClothingItem
import com.example.dressingup.viewmodel.ClothingViewModel

@Composable
fun MainScreen() {
    val orientation = LocalConfiguration.current.orientation


    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        PortraitLayout()
    } else {
        LandscapeLayout()
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}