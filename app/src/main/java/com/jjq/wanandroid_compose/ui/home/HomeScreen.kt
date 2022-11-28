

package com.jjq.wanandroid_compose.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.testTag("test"),
        topBar = {
            SmallTopAppBar(
                title = { Text(text = "") },
                actions = {

                }
            )
        },
        content = { paddingValues ->
            HomeScreenContent(
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier
) {
    //banner
    //listview


}

@Composable
fun HomeScreenListView(

){

}