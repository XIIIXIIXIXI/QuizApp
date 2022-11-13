package com.example.quizapp.presentation.categoryScreens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quizapp.presentation.composables.TopAppBar
import com.ramcosta.composedestinations.annotation.Destination
import com.example.quizapp.domain.model.categories
import com.example.quizapp.presentation.destinations.SelectedCategoryScreenDestination
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.ui.theme.TopBarExpendedHeight
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

/*TODO
TODO - BottomNavigation
TODO - Navigator
TODO - More Categories
*/
@Composable
@Destination(start = true)
fun ChooseCategoryScreen(
    navigator: DestinationsNavigator
){
    TopAppBar(screenName = "Select Category")
    Box() {
        Content(navigator)
    }

}

@Composable
fun Content(
    navigator: DestinationsNavigator
){
    LazyColumn(contentPadding = PaddingValues(top = TopBarExpendedHeight)) {
        item {
            CategoryList(navigator)
        }

    }
}

@Composable
fun CategoryList(
    navigator: DestinationsNavigator
){
    Grid(nColoumn = 2, items = categories.categories){
        CategoryElement(color = it.color, category = it.name){ it ->
            navigator.navigate(
                SelectedCategoryScreenDestination(
                    it
                )
            )
            println("navigate to: $it")
        }
    }
}

@Composable
fun <T> Grid(items: List<T>, nColoumn: Int, content: @Composable (T) -> Unit){
    Column(Modifier.padding(16.dp)) {
        for (n in items.indices step nColoumn){
            Row {
                for (m in 0 until nColoumn){
                    if (n + m < items.size){
                        Box(
                            modifier = Modifier.weight(1f),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            content(items[n + m])
                        }
                     } else {
                         Spacer(modifier = Modifier.weight(1f, fill = true))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ChooseCategoryScreenPreview(){
    QuizAppTheme {
        Surface(
            color = MaterialTheme.colors.background
        ){
       //     ChooseCategoryScreen()
        }
    }

}