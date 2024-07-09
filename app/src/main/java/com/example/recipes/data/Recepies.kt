package com.example.recipes.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date

data class Recipe(
    var id: Int,
    var title : String,
    var createdAt : Date,
    var description: String
)



@RequiresApi(Build.VERSION_CODES.O)
fun getRecepies() : List<Recipe> {
    return listOf<Recipe>(
        Recipe(1, "Donuts", Date.from(Instant.now()), "Milk: Liquid activates the yeast. Whole milk is a must for a super tender dough—or you can try buttermilk. Lower-fat or nondairy milks work in a pinch, but the doughnuts aren’t as flavorful or rich.\n" +
                "Yeast: You can use active dry yeast or instant yeast. If using an instant yeast, your rise time will be a little shorter.\n" +
                "Sugar: Sugar sweetens the doughnuts, but it also feeds the yeast, increases its activity, and tenderizes the dough.\n" +
                "Eggs: Eggs provide structure and flavor.\n" +
                "Butter: Melted butter promises enhanced flavor.\n" +
                "Salt & Vanilla Extract: Both add flavor. You could even try using homemade vanilla extract!\n" +
                "Nutmeg: A little nutmeg is the secret ingredient to that cozy, comforting bakery taste. If you’ve ever made my chocolate chip muffins, you know it adds a delicious pop of flavor!\n" +
                "Flour: All-purpose flour is the dough’s structure. You’ll be tempted to add more and more flour as you mix the dough, but don’t. You want a very soft, pillowy dough for soft, pillowy doughnuts. The dough can still be slightly sticky. When kneading, use extra flour on your hands and work surface."),
        Recipe(2, "Cake ", Date.from(Instant.now()), "1 cup white sugar\n" +
                "\n" +
                "½ cup unsalted butter\n" +
                "\n" +
                "2 large eggs\n" +
                "\n" +
                "2 teaspoons vanilla extract\n" +
                "\n" +
                "1 ½ cups all-purpose flour\n" +
                "\n" +
                "1 ¾ teaspoons baking powder\n" +
                "\n" +
                "½ cup milk"),
        Recipe(3, "Burek ", Date.from(Instant.now()), "1 pound lean ground beef\n" +
                "\n" +
                "1 tablespoon ground allspice\n" +
                "\n" +
                "1 tablespoon paprika\n" +
                "\n" +
                "salt and freshly ground pepper to taste\n" +
                "\n" +
                "1 medium potato, finely chopped\n" +
                "\n" +
                "1 medium onion, chopped\n" +
                "\n" +
                "16 sheets phyllo dough, thawed\n" +
                "\n" +
                "¼ cup melted butter"),
        Recipe(4, "Burger", Date.from(Instant.now()),"1 large egg\n" +
                "\n" +
                "½ teaspoon salt\n" +
                "\n" +
                "½ teaspoon ground black pepper\n" +
                "\n" +
                "1 pound ground beef\n" +
                "\n" +
                "½ cup fine dry bread crumbs")
    );
}