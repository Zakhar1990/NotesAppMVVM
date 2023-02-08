package ru.zakharbondarev.notesappmvvm.screens

import android.annotation.SuppressLint
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ru.zakharbondarev.notesappmvvm.navigation.NavRoute
import ru.zakharbondarev.notesappmvvm.ui.theme.NotesAppMVVMTheme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(NavController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    NavController.navigate(NavRoute.Add.route)
                }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Content Description",
                    tint = Color.White
                )
            }

        }
    ) {
        Column() {
            Noteitem(title = "Note 1", subtitle = "Subtitle for note 1", NavController = NavController )
            Noteitem(title = "Note 2", subtitle = "Subtitle for note 2", NavController = NavController )
            Noteitem(title = "Note 3", subtitle = "Subtitle for note 3", NavController = NavController )
            Noteitem(title = "Note 4", subtitle = "Subtitle for note 4", NavController = NavController )
        }
        }

}
@Composable
fun Noteitem(title: String, subtitle: String,NavController: NavHostController){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                NavController.navigate(NavRoute.Note.route)
            },
        elevation = 6.dp
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subtitle
            )
        }


    }
}
@Composable
@Preview(showBackground = true)
fun prevMainScreen() {
    NotesAppMVVMTheme {
        MainScreen(NavController = rememberNavController())
    }
}