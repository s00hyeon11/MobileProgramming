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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
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
fun MainScreen(
    modifier: Modifier = Modifier,
    clothingViewModel: ClothingViewModel = viewModel()
) {
    val orientation = LocalConfiguration.current.orientation
    val visibility = clothingViewModel.visibility
    val itemList = ClothingItem.itemList

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Box {
                Image(
                    painter = painterResource(R.drawable.body),
                    contentDescription = "body",
                    modifier = Modifier
                )

                itemList.forEach() {
                    if (visibility[it] == true) {
                        val imageRes = it.imageRes
                        Image(
                            painter = painterResource(imageRes),
                            contentDescription = it.id,
                            modifier = Modifier
                        )
                    }
                }
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(itemList) {
                    Row {
                        Checkbox(
                            checked = visibility[it] == true,
                            onCheckedChange = { isChecked ->
                                clothingViewModel.setVisibility(it, isChecked)
                            }
                        )
                        Text(text = it.id)
                    }
                }
            }
            Text(text = "202212376 차수현")
        }
    } else {
        Row {
            Box {
                Image(
                    painter = painterResource(R.drawable.body),
                    contentDescription = "body",
                    modifier = Modifier
                )

                itemList.forEach() {
                    if (visibility[it] == true) {
                        val imageRes = it.imageRes
                        Image(
                            painter = painterResource(imageRes),
                            contentDescription = it.id,
                            modifier = Modifier
                        )
                    }
                }
            }
            Column(
                modifier = Modifier.padding(vertical = 32.dp)
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2)
                ) {
                    items(itemList) {
                        Row {
                            Checkbox(
                                checked = visibility[it] == true,
                                onCheckedChange = { isChecked ->
                                    clothingViewModel.setVisibility(it, isChecked)
                                }
                            )
                            Text(text = it.id)
                        }
                    }
                }
                Text(text = "202212376 차수현")
            }

        }
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}