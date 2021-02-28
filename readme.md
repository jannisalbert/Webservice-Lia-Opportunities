

# Webserice-Lia-Opportunities


I detta sidoporjekt byggar vi en web service för att hantera sina LIA ansökningar på ett effektivt sätt.
Webservice är byggt som en modulär applikation i Java.


## Specifikation

Programmet innehåler följande webservices/API som modul

`Companies`
Port 5050

`Contact`
Port 5051

`ContextInfo` 
Port 5052

`Opportunities`
Port 5053

`UserEndPoint`
Port 5054

Sammankopplingen av information görs genom UserEndpoint som hämtar information från alla andra
services och som sammanställa information. UserEndPoint ger användaren möjligheten att lägga till en lead (med information
om företaget, kontaktperson, prioritet och status av ansökningen) och att uppdatera en befindligt lead. 



## Installation



## Licens

[MIT License](https://opensource.org/licenses/MIT)



