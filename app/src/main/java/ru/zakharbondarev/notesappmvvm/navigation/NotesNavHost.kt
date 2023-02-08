package ru.zakharbondarev.notesappmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.zakharbondarev.notesappmvvm.screens.Add
import ru.zakharbondarev.notesappmvvm.screens.Main
import ru.zakharbondarev.notesappmvvm.screens.Note
import ru.zakharbondarev.notesappmvvm.screens.Start


sealed class NavRoute(val route: String){
    object Start: NavRoute("start_screen")
    object Main: NavRoute("main_screen")
    object Add: NavRoute("add_screen")
    object Note: NavRoute("note_screen")
}

@Composable
fun NotesNavHost () {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route ){
        composable(NavRoute.Start.route){ Start(NavController =  navController) }
        composable(NavRoute.Main.route){ Main(NavController =  navController) }
        composable(NavRoute.Note.route){ Note(NavController =  navController) }
        composable(NavRoute.Add.route){ Add(NavController =  navController) }
    }
}