# What2Eat
---
What2Eat is een Android mobile application.

In de applicatie is het de bedoeling om een eigen repository (databank) aan te vullen met maaltijdonderdelen (mealparts).
U kan eigen maaltijdonderdelen toevoegen, aanpassen en verwijderen. U kan ook online zoeken naar inspirationele recepten die het geselecteerde maaltijdonderdeel bevatten als ingredient.

Eenmaal u maaltijdonderdelen toegevoegd heeft kan u met deze maaltijdonderdelen uw maaltijden samenstellen. Ook hier kan u maaltijden toevoegen, aanpassen en verwijderen. Wanneer een maaltijdonderdeel gelinked wordt aan maaltijden zullen deze maaltijden ook beschikbaar zijn in het detail scherm van het maaltijdonderdeel. Daanaast kan u voor een maaltijd ook een foto nemen om deze aan de maaltijd te linken.

Mocht u niet weten wat te bereiden, neem dan een kijkje in uw eigen repository beheerd in de What2Eat app. U kan u laten inspireren door eerder toegevoegde maaltijden of maaltijden opzoeken op basis van een geselecteerd maaltijdonderdeel.

# Functies
---
- Beheer maaltijdonderdelen:
  - Overzicht (incl. zoekfunctie)
  - Nieuw aanmaken
  - Bestaand bekijken in detail
    - Gelinkte maaltijden weergeven die horen bij het geselecteerd maaltijdonderdeel
    - Online recepten zoeken die het geselecteerd maaltijdonderdeel als ingredient 
    - Verwijderen (enkel mogelijk wanneer niet gelinked aan een maaltijd)
    - Aanpassen (naam)
- Beheer maaltijden:
  - Overzicht (incl. zoekfunctie)
  - Nieuw aanmaken
  - Bestaand bekijken in detail (naam, rating, afbeelding, datum van toevoeging, maaltijdonderdelen)
  - Aanpassen:
    - Naam en/of rating aanpassen
    - Foto nemen of verwijderen
    - Maaltijdonderdelen toevoegen of verwijderen
  - Verwijderen

# Technische specificaties
---
Programmeertaal: Kotlin<br/>
Minimum SDK versie: 19<br/>
Doel SDK versie: 29<br/>

- Gebruik van Activity en verschillende Fragments doorheen de applicatie.
- De UI wordt enkel gereguleerd door Fragments.
- Business logica gebeurd aan de hand van ViewModels.
- Communicatie van ViewModel naar Fragments gebeurd aan de hand van LiveData.
- Gebruik van RecyclerViews voor het weergeven van overzichten.
- Navigatie via NavGraph, alsook voorzien van NavDrawer en OptionsMenu's waar nodig.
- Room (ver. 2.2.2) database creatie en connectie.
- Retrofit (ver. 2.7.0) voor API calls en Moshi (ver. 1.9.2) voor het converteren van netwerkobjecten.
- Gebruik van Co-routines (ver. 1.3.0) om Room (database) operaties of Retrofit (API) calls uit te voeren.
- Gebruik van Glide (ver. 4.8.0) voor het importeren van afbeeldingen.
- Dagger dependecy injection (ver. 2.25.3) voor het voorzien van singletons in de applicatie.
- Dokka (ver. 0.9.17) documentatie voorzien ([Bekijk de Dokka documentatie](app/src/main/dokka-documentation/app/index.md)).
