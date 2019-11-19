package android.com.what2eat.model

class Maaltijd() {

    lateinit var naam: String
    var maaltijdOnderdelen = mutableListOf<MaaltijdOnderdeel>()
    lateinit var score: Number

    fun addMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.add(maaltijdOnderdeel)
    }
    fun removeMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.remove(maaltijdOnderdeel)
    }


}