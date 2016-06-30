# simple-pc-reminder
Projekt zaliczeniowy w języku Java.


Autorzy:
Witold Karaś - team leader, kodowanie GUI, kodowanie logiki

Paweł Kapuśniak - kodowanie GUI, kodowanie logiki

Mateusz Maciejak - kodowanie logiki

Mateusz Najbor - testy jednostkowe



Budowanie projektu - goals:
- jfx:jar 		- kompiluje do jara
- jfx:run 		- uruchamia program
- jfx:native 	- kompiluje do exe


Kryteria oceniania:

-czy wykorzystano co najmniej trzy wzorce projektowe					                  -3+1/3 (Prototyp, Adapter, Obserwator) + Singleton

-czy prawidłowo zdekomponowano odpowiedzialności						                  -myślę, że tak

-czy wykorzystano jakiś wzorzec architektoniczny 						                  -MVC

-czy projekt jest Mavenowy i czy poprawnie buduje się z linii komend	                  -tak

-czy budowany jest przez Mavena wykonywalny jar							                  -przy celu jfx:jr - tak, przy celu jfx:native exe, który uruchamia wyk. jara

-czy zrealizowano co najmniej 5 przykładowych testów jednostkowych		                  -7 testów

-czy testy jednostkowe mają status PASSED w trakcie procesu budowania 	                  -tak, wszystkie testy przechodzą się poprawnie
	projektu przez Mavena

-czy projekt został umieszczony pod kontrolą wersji za pomocą Gita		                  -tak

-czy struktura gałęzi repozytorium jest prawidłowo zarządzana			                  -mylę, że tak

-czy skorzystano z interfejsów i/lub klas abstrakcyjnych do 			                  -tak (klasa EventAbstract)
	reprezentowania abstrakcji jako jednego z elementów                                   
	programowania obiektowego

-czy skorzystano z polimorfizmu											                  tak (W klasie Scheduler obiekty klas Event lub EventNull)