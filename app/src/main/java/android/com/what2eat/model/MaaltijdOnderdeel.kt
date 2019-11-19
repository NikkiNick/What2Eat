package android.com.what2eat.model

class MaaltijdOnderdeel {

    var naam: String = ""
    var ingredienten = mutableListOf<Ingredient>()

    fun addIngredient(ingredient: Ingredient){
        this.ingredienten.add(ingredient)
    }
    fun removeIngredient(ingredient: Ingredient){
        this.ingredienten.remove(ingredient)
    }

}