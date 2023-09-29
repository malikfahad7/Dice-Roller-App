package com.example.dicerollerapplication

import android.media.Image
import android.os.Bundle
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicerollerapplication.ui.theme.DicerollerapplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DicerollerapplicationTheme {
             DiceRollerApp()
            }
        }
    }
}
@Preview
@Composable

fun DiceRollerApp(){

   DiceWithButtonAndImage(modifier = Modifier
       .fillMaxSize()
       .wrapContentSize(Alignment.Center))
}
@Composable
fun DiceWithButtonAndImage(modifier: Modifier){
   var result by remember {
       mutableStateOf(1)
   }
    val imagResource=when(result){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5

  else
      ->R.drawable.dice_6
    }
  Column(modifier = modifier,
  horizontalAlignment = Alignment.CenterHorizontally) {
      androidx.compose.foundation.Image(painter = painterResource(id = imagResource), contentDescription = result.toString() )
      Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier=Modifier.size(height = 50.dp, width = 150.dp),
            colors = ButtonDefaults.buttonColors(Color.Black),
            onClick = {result=(1..6).random()}) {

                Text(
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    text = stringResource(R.string.Button),
                )
            }
      Spacer(modifier = Modifier.height(16.dp))
      Text(text="Your score is : $result")

        }
  }
