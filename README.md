# Projectdocumentatie
##Introductie
Dit project is een microservices gebaseerde applicatie die een platform biedt voor het beheren van cursussen, studenten en feedback. Elk van deze functionaliteiten is ingekapseld binnen zijn eigen microservice, wat losse koppeling en hoge cohesie oplevert.

## Microservices
De applicatie bestaat uit de volgende microservices:

Cursus Service: Beheert cursusgegevens. Biedt eindpunten voor het creëren, ophalen, updaten en verwijderen van cursussen.
Studenten Service: Beheert studentengegevens. Biedt eindpunten voor het creëren, ophalen en verwijderen van studenten.
Feedback Service: Beheert feedbackgegevens. Biedt eindpunten voor het ophalen van feedback.

## Componenten
De applicatie bevat ook de volgende componenten:

API Gateway: Dient als het enige ingangs punt voor het systeem. Routeert inkomende aanvragen naar de juiste microservice op basis van het aanvraagpad en de methode.
Database: Bewaart gegevens voor elke microservice. Elke microservice heeft zijn eigen database om losse koppeling en hoge cohesie te garanderen.
Uitbreidingen
De applicatie kan op verschillende manieren worden uitgebreid:

## Extra Services: Nieuwe services kunnen worden toegevoegd om extra functionaliteit te bieden. Bijvoorbeeld, een service kan worden toegevoegd om docenten of afdelingen te beheren.
Schaalbaarheid: Elke microservice kan onafhankelijk worden geschaald om aan de vraag te voldoen. Dit maakt het systeem in staat om grote hoeveelheden verkeer te verwerken zonder de prestaties te beïnvloeden.
Resilientie: Het systeem kan snel herstellen na storingen omdat elke microservice geïsoleerd is en zelfstandig kan opereren.
Eindpunten
De applicatie biedt de volgende eindpunten:

POST /cursussen: Maak een nieuwe cursus.
GET /cursussen: Haal alle cursussen op.
GET /cursussen/{cursusNummer}: Haal een cursus op op basis van het cursusnummer.
PUT /cursussen/{cursusId}: Update een cursus.
DELETE /cursussen/{cursusId}: Verwijder een cursus.
GET /cursussen/{cursusNummer}/feedback: Haal feedback op voor een cursus.
Bevestiging van werkende eindpunten
Bevestiging van werkende eindpunten kan worden gevonden in de GitHub README onder de sectie "Bevestiging van werkende eindpunten". Deze screenshots tonen succesvolle POSTMAN aanvragen naar elk eindpunt.
