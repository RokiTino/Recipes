package com.example.recipes.RecipeList


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipes.R
import com.example.recipes.ViewModel.RecipeViewModel
import com.example.recipes.data.Recipe
import java.text.SimpleDateFormat
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RecipeListPage(viewModel: RecipeViewModel){

    val todoList by viewModel.todoList.observeAsState()
    var titleText by remember {
        mutableStateOf("")
    }
    var descritpionText by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
           Column(
               modifier = Modifier
                   .height(250.dp)
                   .padding(5.dp),
               verticalArrangement = Arrangement.SpaceEvenly
           ){
               OutlinedTextField(
                   modifier= Modifier.weight(1f).padding(bottom=5.dp),
                   value = titleText,
                   onValueChange = {
                       titleText = it
                   },
                   placeholder = {Text("Enter a Recipe Title")}
               )
               OutlinedTextField(
                   modifier= Modifier.weight(2f).padding(top=5.dp),
                   value = descritpionText,
                   onValueChange = {
                       descritpionText = it
                   },
                   placeholder = {Text("Enter the recipe ingredients")},
                   maxLines = 15,
                   )
           }

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                viewModel.addRecipe(titleText,descritpionText)
                titleText = ""
                descritpionText=""
            }) {
                Text(text = "Add")
            }
        }

        todoList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it){index: Int, item: Recipe ->
                        RecipeItem(item = item, onDelete = {
                            viewModel.deleteRecipe(item.id)
                        })
                    }
                }
            )
        }?: Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "No items yet",
            fontSize = 16.sp
        )


    }

}

@Composable
fun RecipeItem(item : Recipe,onDelete : ()-> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically

    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = SimpleDateFormat("HH:mm:aa, dd/mm", Locale.ENGLISH).format(item.createdAt),
                fontSize = 10.sp,
                color = Color.LightGray
            )
            Text(
                text = item.title,
                fontSize = 15.sp,
                color = Color.White
            )
            Text(
                text=item.description,
                fontSize = 12.sp,
                color = Color.White
            )
        }
        IconButton(onClick = onDelete) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete",
                tint = Color.White
            )
        }
    }
}