package android.com.what2eat.model

class Maaltijd() {

    private lateinit var naam: String
    private var maaltijdOnderdelen = mutableListOf<MaaltijdOnderdeel>()
    private lateinit var score: Number

    fun addMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.add(maaltijdOnderdeel)
    }
    fun removeMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.remove(maaltijdOnderdeel)
    }


}