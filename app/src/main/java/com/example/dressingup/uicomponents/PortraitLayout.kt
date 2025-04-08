package com.example.dressingup.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dressingup.R
import com.example.dressingup.model.ClothingItem
import com.example.dressingup.viewmodel.ClothingViewModel

@Composable
fun PortraitLayout(
    clothingViewModel: ClothingViewModel = viewModel(),
    modifier: Modifier = Modifier
) {
    val visibility = clothingViewModel.visibility
    val itemList = ClothingItem.itemList

    Column(modifier = Modifier.fillMaxWidth()) {
        Box{
            Image(
                painter = painterResource(R.drawable.body),
                contentDescription = "Body",
                modifier = Modifier
            )
            itemList.forEach{
                if(visibility[it] == true){
                    var imageRes = it.imageRes
                    Image(
                        painter = painterResource(imageRes),
                        contentDescription = it.id,
                        modifier = Modifier
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Column {
                ClothingItem.itemList.forEachIndexed{ index, item ->
                    if(index % 2 != 0){
                        Row {
                            Checkbox(
                                checked = visibility[item] == true,
                                onCheckedChange = { isChecked ->
                                    clothingViewModel.setVisibility(item, isChecked)
                                }
                            )
                            Text(text = item.id)
                        }
                    }
                }
                Text(text = "202212376 차수현")
            }
            Spacer(modifier = Modifier.width(40.dp))
            Column {
                ClothingItem.itemList.forEachIndexed{ index, item ->
                    if(index % 2 == 0){
                        Row {
                            Checkbox(
                                checked = visibility[item] == true,
                                onCheckedChange = { isChecked ->
                                    clothingViewModel.setVisibility(item, isChecked)
                                }
                            )
                            Text(text = item.id)
                        }
                    }
                }
            }
        }

    }
}

@Preview
@Composable
private fun PortraitLayoutPreview() {
    PortraitLayout()
}