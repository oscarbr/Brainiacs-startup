1. Chalmers bookstore project

En app för att köpa och sälja begagnade böcker på Chalmers. Det finns många köpare och säljare men inte en direkt plattform. Här kommer vi in, en enkel app för att lägga upp sina begagnade böcker till försäljning. Funktion för att fota boken. Kunna lägga attribut till boken exempelvis: program, kurs, årskurs, författare osv. samt valfria kommentarer. Alternativt även möjlighet för andra att kommentera på din artikel. Det skall vara enklare än att lägga upp på Blocket eller Tradera då det är en specifikt avsedd marknad och du vet ungefär vem du handlar med och byte av bok och pengar kan ske personligen. Om en databas med olika böcker för olika kurser finns att tillgå kommer denna att användas för att kategorisera vilken bok som ligger uppe till försäljning. Detta kan också underlätta sökfunktioner och liknande. Annars kan sökning göras på andra attribut, exempelvis: titel, program, år och läsperiod för att hitta rätt bok.

Eventuell bonusfunktion: En koppling till Cremona för att man ska kunna göra prisjämförelser och möjliggöra köp därifrån om begagnad bok inte finns.
Eventuell köpare och intressent: Studienämnder på de olika institutionerna på Chalmers

1.1 Motivering av val
Efter bollande och diskussioner kom vi fram till att både mentometer-knappen och Chalmers Bookstore kräver ganska mycket backbone och kommunikation med server. Detta blir därför inte en avgörande faktor för valet mellan dessa två. 

1.2 Avgörande faktorer till förmån för Chalmers Bookstore
1. Mer användning och relevans för målgruppen och intressenterna
2. Chalmers Bokkstore har ett konkret värde för Studienämnden på Industriell ekonomi, vore kul att få göra den för dem. Vore kul att ha en riktig stake holder, studienämnder.
3. Det finns redan flera bra alternativ för mentometer-knappen på marknaden.

2. Motivering av licens

Eftersom vi kan komma att använda oss av kod som är copyleftad i vårt projekt samt att vi vill använda Github för versionshantering, utgår vi från att en GPLv3-licens blir lämplig för vårt projekt. Vi ställer oss bakom alla fyra krav för fri mjukvara. Vi vill också ställa liknande krav på de som använder vår mjukvara och väljer därför bort LGPL. 

3. Krav

Det finns flera intressenter till vår applikation. Från användarsidan finns det till exempel: studenter på Chalmers tekniska högskola som vill köpa och sälja böcker (här behöver vi göra skillnad på krav från köpare respektive säljare), studienämnder och andra student-organisationer, Cremona bokhandel, andra bokhandlare, lärare etc. 

Från utvecklarsidan finns det till exempel:
Handledare, utvecklare, testare, beta-testare etc. 

Vi ser studienämnder och de faktiska användarna av vår applikation som de två största kravställarna. Eftersom vi kommer hantera användare för vår programvara räknar vi med att många testfall kommer behövas.

Example of requirement:
Requirement ID 1.1.1 A book needs to have a title		
Use case: A book needs to have a title
Trigger: Adding a new book to the market
Precondition: A person is authorized to add a new book to the market
Basic path: A person is writing in a name for the book, there must be more than 10 characters and less than 150 characters. 
Exception path: The person uploading a book should get a message: “a book needs a title”
Post condition: A new book is uploaded to the market with a title


-------------------SOFTWARE REQUIREMENTS DOCUMENT [VERY WORK IN PROGRESS]-------------------

1 Introduction
	1.1 Purpose of application
	1.2 General characteristics of application
	1.3 Scope of application
	1.4 Objectives and success criteria of the project
	1.5 Definitions, acronyms and abbreviations
2 Proposed application
	2.1 Overview
	2.2 Functional requirements
	2.3 Non-functional requirements
		2.3.1 Usability
		2.3.2 Reliability
		2.3.3 Performance
		2.3.4 Supportability
		2.3.5 Implementation
		2.3.6 Verification
		2.3.7 Packaging and installation
		2.3.8 Legal
	2.4 Application models
		2.4.1 Scenarios
		2.4.2 Use case model Use cases priority
		2.4.3 Static model
		2.4.4 Dynamic model
		2.4.5 User interface
	2.5 Test cases
	2.6 Possible future directions
	2.7 References

Requirement ID 1 A book store that provides the possibility for a seller to register a book for sale and that this book is then marketed to potential buyers

Requirement ID 1.1 The seller can register a book for sale
Use case: The seller can register a book for sale
Trigger: A seller press the button for "uploading a book"
Precondition: The seller is logged in
Basic path: The seller presses the button for uploading a book and then gives the possibility to fill in title, edition of the book, actual course, quality of the book, minimum price, and contact details. 
Exception path: The seller should get a exception if some of the required fields are not filled in. The seller should also have the possibility to quit the uploading process at any time through a cancel-button.
Post condition: A new book is uploaded to the market.


Requirement ID 1.1.1 The seller can set a minimum price for the book
Use case: The seller can set a minimum price for the book
Trigger: A seller are in the process of uploading a book
Precondition: The seller is logged in
Basic path: The seller presses the button for uploading a book and then needs to fill in the required field regarding price. 
Exception path: The seller should get a exception if no character is typed into the price-filed.
Post condition: A new book is uploaded to the market with a minimum price.


Requirement ID 1.1.2 The seller can upload a picture of the book for sale
Use case: The seller can upload a picture of the book for sale
Trigger: A seller are in the process of uploading a book
Precondition: The seller is logged in
Basic path: The seller presses the button for uploading a book and then gives the possibility to upload a picture of the book. Either from the phones picture library or by taking a new photo with the phone-camera.
Exception path: The seller should get a exception if the picture is too big to handle or in a wrong format. 
Post condition: A new book is uploaded to the market with a picture showing the book.


Functional
Requirement ID 1.1.3 The seller have to set a title for the book
Requirement ID 1.1.4 The seller have to specify type of sell format: Auction or set price

Requirement ID 1.2 The seller can take a book of off the market
Requirement ID 1.2.1 The seller can specify what he/she sold the book for


Requirement ID 2 A book store that provides the possibility for a buyer to search for and browse books and put him/her in touch with sellers

Requirement ID 2.1 A buyer can search the database for available books

Requirement ID 2.1.1 In a search a buyer can specify title
Requirement ID 2.1.2 In a search a buyer can specify author
Requirement ID 2.1.2 In a search a buyer can specify which course the book was used for

Requirement ID 2.2 A buyer can place a bid for a book out on auction
Requirement ID 2.3 A buyer can reserve a book on a set-price auction
 

