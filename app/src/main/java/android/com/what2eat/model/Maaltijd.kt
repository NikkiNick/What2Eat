package android.com.what2eat.model

class Maaltijd() {

    var naam: String = ""
    var maaltijdOnderdelen = mutableListOf<MaaltijdOnderdeel>()
    var score: Number = 0

    fun addMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.add(maaltijdOnderdeel)
    }
    fun removeMaaltijdOnderdeel(maaltijdOnderdeel: MaaltijdOnderdeel){
        this.maaltijdOnderdelen.remove(maaltijdOnderdeel)
    }


}