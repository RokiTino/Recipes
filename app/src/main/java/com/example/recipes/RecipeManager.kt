package com.example.recipes


import android.os.Build
import androidx.annotation.RequiresApi
import com.example.recipes.data.Recipe
import java.time.Instant
import java.util.Date

object RecipeManager {

    @RequiresApi(Build.VERSION_CODES.O)
    private val recipeList = mutableListOf(
        Recipe(1, "Cake", Date.from(Instant.now()), "Something added for a cake"),
        Recipe(2, "Burek", Date.from(Instant.now()),""),
        Recipe(3, "Dow", Date.from(Instant.now()),""),
        Recipe(4, "Beens", Date.from(Instant.now()),""),
        Recipe(5, "Baked Beens", Date.from(Instant.now()),""),
        Recipe(6, "Something else", Date.from(Instant.now()),""),
        Recipe(7, "Wonk", Date.from(Instant.now()),""),
        Recipe(8, "Sushi", Date.from(Instant.now()),""),
        Recipe(9, "Fish", Date.from(Instant.now()),""),
        Recipe(10, "Exsample 1", Date.from(Instant.now()),""),
        Recipe(11, "Exsample 2", Date.from(Instant.now()),""),
        Recipe(12, "Exsample 3", Date.from(Instant.now()),"")
    )


    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllRecipe() : List<Recipe>{
        return recipeList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addRecipe(title : String,description:String){
        recipeList.add(Recipe(System.currentTimeMillis().toInt(),title, Date.from(Instant.now()),description))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun deleteRecipe(id : Int){
        recipeList.removeIf{
            it.id==id
        }
    }


}