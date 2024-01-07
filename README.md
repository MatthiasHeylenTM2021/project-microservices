# Projectdocumentatie
## Introductie
Dit project is een (lokaal) microservices gebaseerde applicatie die een platform biedt voor het beheren van cursussen, studenten en feedback. Elk van deze functionaliteiten is ingekapseld binnen zijn eigen microservice, wat losse koppeling en hoge cohesie oplevert.<br /><br /> De basisfunctionaliteiten zouden normaal volledig moeten zijn, inclusief een Rate Limiter uitbreiding.

## Microservices
De applicatie bestaat uit de volgende microservices:

Cursus Service: Beheert cursusgegevens. Biedt eindpunten voor het creëren, ophalen, updaten en verwijderen van cursussen.<br />
Student Service: Beheert studentengegevens. Biedt eindpunten voor het creëren en ophalen van studenten.<br />
Feedback Service: Beheert feedbackgegevens. Biedt eindpunten voor het ophalen van feedback.<br />

<img src="https://firebasestorage.googleapis.com/v0/b/microservices-402412.appspot.com/o/matthias%2Fmicroservices.drawio.png?alt=media&token=c1c47d50-f4aa-4e08-994d-827a71d4e161"><br />
## Componenten
De applicatie bevat ook de volgende componenten:

API Gateway: Dient als het enige ingangs punt voor het systeem. Routeert inkomende aanvragen naar de juiste microservice op basis van het aanvraagpad en de methode.<br />
Database: Bewaart gegevens voor elke microservice. Elke microservice heeft zijn eigen database om losse koppeling en hoge cohesie te garanderen.

## Uitbreidingen
De enige uitbreiding die ik heb succesvol heb geïmplementeerd is de Rate Limiter (2.5)

## Eindpunten
De applicatie biedt de volgende eindpunten:

POST /cursussen: Maak een nieuwe cursus.<br />
GET /cursussen: Haal alle cursussen op.<br />
GET /cursussen/{cursusNummer}: Haal een cursus op op basis van het cursusnummer.<br />
PUT /cursussen/{cursusId}: Update een cursus.<br />
DELETE /cursussen/{cursusId}: Verwijder een cursus.<br />
GET /feedback: Haal feedback op voor een cursus.<br />
GET /students: Haal studenten op voor een cursus.

## Bevestiging van werkende eindpunten

### Get all courses
<img src="https://firebasestorage.googleapis.com/v0/b/microservices-402412.appspot.com/o/matthias%2Fgetcourses.png?alt=media&token=6f28ec5a-5fe5-420e-a009-dcfd7e05b8f2" width="300px"><br />
### Get all students (Auth)
<img src="https://firebasestorage.googleapis.com/v0/b/microservices-402412.appspot.com/o/matthias%2Fgetstudents.png?alt=media&token=08b55750-962f-41e8-9627-849fdd325eb8" width="300px"><br />
### Get all feedback (Auth)
<img src="https://firebasestorage.googleapis.com/v0/b/microservices-402412.appspot.com/o/matthias%2Fgetfeedback.png?alt=media&token=d3b96806-ec18-4481-9739-bd5e8f270b19" width="300px"><br />
### Create Course (Auth)
<img src="https://firebasestorage.googleapis.com/v0/b/microservices-402412.appspot.com/o/matthias%2Fcreatecourse.png?alt=media&token=19955410-23e2-4445-833a-8db5f7fe0d2c" width="300px"><br />
### Delete Course (Auth)
<img src="https://firebasestorage.googleapis.com/v0/b/microservices-402412.appspot.com/o/matthias%2Fdeletecourse.png?alt=media&token=de57e644-cd73-4780-a6b2-26b0fef5e414" width="300px"><br />
### Update Course (Auth)
<img src="https://firebasestorage.googleapis.com/v0/b/microservices-402412.appspot.com/o/matthias%2Fupdatecourse.png?alt=media&token=60188e1c-4f3e-49f8-980c-8e17da851f73" width="300px">

