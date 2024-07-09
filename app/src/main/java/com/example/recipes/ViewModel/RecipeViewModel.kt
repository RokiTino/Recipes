package com.example.recipes.ViewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipes.RecipeManager
import com.example.recipes.data.Recipe

@RequiresApi(Build.VERSION_CODES.O)
class RecipeViewModel: ViewModel() {

    private var _todoList = MutableLiveData<List<Recipe>>()
    val todoList : LiveData<List<Recipe>> = _todoList

    init {
        getAllRecipe()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun getAllRecipe(){
        _todoList.value = RecipeManager.getAllRecipe().reversed()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addRecipe(title : String,description: String){
        RecipeManager.addRecipe(title, description)
        getAllRecipe()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun deleteRecipe(id : Int){
        RecipeManager.deleteRecipe(id)
        getAllRecipe()
    }


}