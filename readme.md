

# Webservice-Lia-Opportunities

I detta projekt har vi byggt en webservice för att hantera sina LIA ansökningar på ett effektivt sätt.
Projektet är byggt som en microservice applikation i Spring-ramverket med en MariaDB relationsdatabas. Våra APIs är driftsatta på en Ubuntu-server hos DigitalOcean med hjälp av Docker.




## Specifikation

Sammankopplingen av information görs genom UserEndpoint som hämtar information från alla andra
services och som sammanställer informationen. 



## Endpoints

Servicen innehåller nedan endpoints.

`/companies` - Hanterar företagsinformation.

`/contacts` - Hanterar kontakter.

`/status` - Styr status på lead.

`/priority` - Styr prioritet på lead.

`/opportunity` - Innehåller referenser till information ovan. Även möjlighet att lägga till kommentar.

`/leads` - Sammanställer information ovan till en separat lead.



## Installation

Installation görs enklast via Docker. 

```
$ docker-compose up -d
```

Nu kan du hämta information via t.ex `localhost:5054/lead/1`.



## Todo

- Front-end (vue.js)
- OpenAPI / Swagger dokumentation
- Aktivera OAuth autensiering
- Flytta konfiguration till Consul



## Licens

[MIT License](https://opensource.org/licenses/MIT)



