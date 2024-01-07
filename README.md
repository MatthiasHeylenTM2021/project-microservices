# Projectdocumentatie
## Introductie
Dit project is een (lokaal) microservices gebaseerde applicatie die een platform biedt voor het beheren van cursussen, studenten en feedback. Elk van deze functionaliteiten is ingekapseld binnen zijn eigen microservice, wat losse koppeling en hoge cohesie oplevert. De basisfunctionaliteiten zouden normaal volledig moeten zijn, inclusief een Rate Limiter uitbreiding.

## Microservices
De applicatie bestaat uit de volgende microservices:

Cursus Service: Beheert cursusgegevens. Biedt eindpunten voor het creëren, ophalen, updaten en verwijderen van cursussen.
Studenten Service: Beheert studentengegevens. Biedt eindpunten voor het creëren en ophalen van studenten.
Feedback Service: Beheert feedbackgegevens. Biedt eindpunten voor het ophalen van feedback.

<img src="https://firebasestorage.googleapis.com/v0/b/microservices-402412.appspot.com/o/matthias%2Fmicroservices.drawio.png?alt=media&token=c1c47d50-f4aa-4e08-994d-827a71d4e161">
## Componenten
De applicatie bevat ook de volgende componenten:

API Gateway: Dient als het enige ingangs punt voor het systeem. Routeert inkomende aanvragen naar de juiste microservice op basis van het aanvraagpad en de methode.<br /><br />
Database: Bewaart gegevens voor elke microservice. Elke microservice heeft zijn eigen database om losse koppeling en hoge cohesie te garanderen.

## Uitbreidingen
De enige uitbreiding die ik heb gedaan is de Rate Limiter (2.5)

## Eindpunten
De applicatie biedt de volgende eindpunten:

POST /cursussen: Maak een nieuwe cursus.<br />
GET /cursussen: Haal alle cursussen op.<br />
GET /cursussen/{cursusNummer}: Haal een cursus op op basis van het cursusnummer.<br />
PUT /cursussen/{cursusId}: Update een cursus.<br />
DELETE /cursussen/{cursusId}: Verwijder een cursus.<br />
GET /cursussen/{cursusNummer}/feedback: Haal feedback op voor een cursus.<br />
GET /cursussen/{cursusNummer}/student: Haal studenten op voor een cursus.

## Bevestiging van werkende eindpunten
Bevestiging van werkende eindpunten kan worden gevonden in de GitHub README onder de sectie "Bevestiging van werkende eindpunten". Deze screenshots tonen succesvolle POSTMAN aanvragen naar elk eindpunt.
