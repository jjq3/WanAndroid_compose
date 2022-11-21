package com.jjq.wanandroid_compose

import android.content.res.Resources.Theme
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.jjq.wanandroid_compose.ui.theme.BottomType
import com.jjq.wanandroid_compose.ui.theme.WanAndroid_composeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WanAndroid_composeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

/**
 * 底部导航栏
 */
@Composable
fun BottomNavigationContent(
    modifier: Modifier = Modifier,
    homeState: MutableState<BottomType>
) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            icon = {
                   BottomItem(name = "首页")
            },
            selected = homeState.value == BottomType.HOME,
            onClick = {
                homeState.value = BottomType.HOME
            },
            modifier = Modifier
        )
        NavigationBarItem(
            icon = {
                BottomItem(name = "体系")
            },
            selected = homeState.value == BottomType.SYSTEMS,
            onClick = {
                homeState.value = BottomType.SYSTEMS
            }
        )
        NavigationBarItem(
            icon = {
                BottomItem(name = "公众号")
            },
            selected = homeState.value == BottomType.PUBLICS,
            onClick = {
                homeState.value = BottomType.PUBLICS
            }
        )
        NavigationBarItem(
            icon = {
                BottomItem(name = "项目")
            },
            selected = homeState.value == BottomType.PROJECTS,
            onClick = {
                homeState.value = BottomType.PROJECTS
            }
        )
        NavigationBarItem(
            icon = {
                BottomItem(name = "我的")
            },
            selected = homeState.value == BottomType.MY,
            onClick = {
                homeState.value = BottomType.MY
            }
        )
    }
}

@Composable
fun BottomItem(name: String, modifier: Modifier = Modifier) {
    Column(modifier = Modifier
        .fillMaxHeight(1f)
        .padding(5.dp),
        verticalArrangement = Arrangement.Center) {

        val imageModifier = Modifier
            .width(20.dp)
            .height(20.dp)
            .clip(shape = shapes.extraLarge)

        Image(
            painter = painterResource(id = R.drawable.food1),
            contentDescription = "home image",
            modifier = imageModifier,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
        Text(
            text = name,
            modifier = modifier
        )
        
    }

}

@Composable
fun BaseView(
    appTheme: Theme
) {


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val homeState = rememberSaveable {
        mutableStateOf(BottomType.HOME)
    }
    BottomNavigationContent(
        modifier = Modifier,
        homeState = homeState
    )
}