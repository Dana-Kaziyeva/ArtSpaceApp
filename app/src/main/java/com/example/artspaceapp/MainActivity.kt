package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Preview
@Composable
fun ArtSpace(){
    ImageAndButton(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun ImageAndButton(modifier:Modifier = Modifier){
    var img by remember { mutableStateOf(1) }
    val imgResource = when (img) {
        1 -> R.drawable.girlwithapearlearring
        2 -> R.drawable.thestarrynight
        3 -> R.drawable.poker_game
        4 -> R.drawable.thesream
        else -> R.drawable.guernica
    }
    val nameResource = when (img) {
        1 -> R.string.art5_name
        2 -> R.string.art3_name
        3 -> R.string.art1_name
        4 -> R.string.art2_name
        else -> R.string.art4_name
    }
    val descResource = when (img) {
        1 -> R.string.art5_desc
        2 -> R.string.art3_desc
        3 -> R.string.art1_desc
        4 -> R.string.art2_desc
        else -> R.string.art4_desc
    }
    Column(modifier = Modifier.height(620.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(70.dp))
        Image(painter = painterResource(imgResource),
            contentDescription = img.toString(),
            modifier = Modifier
                .width(260.dp)
                .height(320.dp)
                .align(Alignment.CenterHorizontally)
        )
        Column(modifier = Modifier
            .alpha(0.8f)
            .width(280.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(nameResource),
                fontSize = 25.sp,
                lineHeight = 80.sp,
                color = Color.Gray,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(descResource),
                fontSize = 21.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
        }
        Row(modifier = modifier
            .width(260.dp)
            .align(Alignment.CenterHorizontally)
            ){
            Button(
                onClick = { img -= 1 },
                modifier = Modifier.size(100.dp, 40.dp)
            ) {
                Text(stringResource(R.string.buttonPrevious))
            }
            Spacer(modifier = Modifier.width(50.dp))
            Button(
                onClick = { img += 1 },
                modifier = Modifier.size(100.dp, 40.dp)
            ) {
                Text(stringResource(R.string.buttonNext))
            }
        }

    }
}
