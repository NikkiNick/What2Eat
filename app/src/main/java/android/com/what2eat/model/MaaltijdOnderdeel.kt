package android.com.what2eat.model

class MaaltijdOnderdeel {

    lateinit var naam: String
    var producten = mutableListOf<Product>()

    fun addProduct(product: Product){
        this.producten.add(product)
    }
    fun removeProduct(product: Product){
        this.producten.remove(product)
    }

}