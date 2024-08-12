💡 SEMPLICE ARCHITETTURA A MICROSERVIZI 


Tecnologie utilizzate:


- SpringBoot

- SpringCloud

- Eureka Server

- Feign Client


🧙‍♂️ Analizza insieme a me!



📌 Il Progetto:


Ho sviluppato una semplice applicazione a microservizi composta da tre moduli principali:



1️⃣ Eureka Server:


Eureka è un registro di servizi che consente ai microservizi di registrarsi per essere invocati e comunicare tra di loro.


Come si evince dagli screenshot allegati, si è creato un primo progetto chiamato per l'appunto eureka-server che ha una solita classe di application, dove l'annotazione @SpringBootApplication sarà accompagnata dall'annotazione @EnableEurekaServer. Quest'ultima insieme alla dipendenza inserita nel Pom.xml trasformerà la classe in un server Eureka.




2️⃣ ServiceA:


ServiceA è un microservizio registrato in Eureka che espone un'API REST semplice. 

Che dispone di due istanze configurate sulle rispettive porte 8081, 8082, avranno i corrispettivi Id per differenziarle l'una dall'altra, che si andranno a registrare anch'esse in Eureka 

ServiceA ha inoltre un controller REST che gestisce le richieste GET all'endpoint "/api/hello" e restituisce una stringa che include l'ID dell'istanza del servizio.




3️⃣ Client1:


Client1 è un client che utilizza Feign per invocare l'API esposta su ServiceA.


La classe di application verrà annotata con @EnableDiscoveryClient (che abilita la registrazione del client in Eureka) e con @EnableFeignClients (che abilita l'utilizzo di Feign per le chiamate REST tra i microservizi) .


Client1 avrà un Interfaccia chiamata IServiceA.

Questa interfaccia definisce un client Feign che si connette a Service A tramite il nome registrato in Eureka e invia richieste all'endpoint /api/hello.


Infine avrà anche un REST controller chiamato ClientController.

Questo controller chiama l'endpoint /api/hello di Service A tramite Feign e restituisce il risultato. In praticà fungerà da invocatore.







-----------------------------------------------------------   EN VERSION   ------------------------------------------------------------------------------------------------




💡 SIMPLE MICROSERVICE ARCHITECTURE. 


Technologies used:


- SpringBoot

- SpringCloud

- Eureka Server

- Feign Client


🧙‍♂️ Analyze with me!



📌 The Project:


I developed a simple microservices application consisting of three main modules:



1️⃣ Eureka Server:


Eureka is a service registry that allows microservices to register to be invoked and communicate with each other.


As can be seen from the attached screenshots, a first project called precisely eureka-server was created that has a usual application class, where the @SpringBootApplication annotation will be accompanied by the @EnableEurekaServer annotation. The latter along with the dependency inserted in the Pom.xml will turn the class into a Eureka server.




2️⃣ ServiceA:


ServiceA is a microservice registered in Eureka that exposes a simple REST API. 

Which has two instances configured on the respective ports 8081, 8082, will have corresponding Ids to differentiate them from each other, which will also register in Eureka 

ServiceA also has a REST controller that handles GET requests to the "/api/hello" endpoint and returns a string that includes the service instance ID.




3️⃣ Client1:


Client1 is a client that uses Feign to invoke the API exposed on ServiceA.

The application class will be annotated with @EnableDiscoveryClient (enabling client registration in Eureka) and with @EnableFeignClients (enabling the use of Feign for REST calls between microservices) .


Client1 will have an Interface called IServiceA.

This interface defines a Feign client that connects to Service A via the name registered in Eureka and sends requests to the /api/hello endpoint.


Finally, it will also have a REST controller called ClientController.

This controller will call Service A's /api/hello endpoint via Feign and return the result. In practice it will act as an invoker.


Translated with DeepL.com (free version)
