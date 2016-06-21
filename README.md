# simple-pc-reminder
Projekt zaliczeniowy w języku Java.



ToDo:


-wyswietlanie w glownym oknie wszystkich informacji, a nie tylko tytułów

-okno z ustawieniami zawierajace konfiguracje horyzontu czasowego wyswietlanych Eventow i czestotliwosci przypomnien

-przypomnienia o Eventach (jakis popup), myslalem nad osobnym watkiem ktory bedzie sie tym zajmowal

-poprawki wyswietlania na dalszych stronach (po wcisnieciu przycisku Next)

-testy jednostkowe

-info dla usera w AddEventStage jeśli wprowadził błędne dane






Nowe funkjonalności robimy NA NOWYCH BRANCHACH, nazwanych do tego co robimy!





Budowanie projektu:
W Eclipse PPM na projekt->Run As->Maven Build.
W goals wpisujecie:
- jfx:jar 		- kompiluje do jara
- jfx:run 		- uruchamia program
- jfx:native 	- kompiluje do exe
W IntelliJ podobnie.


Kryteria oceniania:

-czy wykorzystano co najmniej trzy wzorce projektowe					                  -2/3 (Prototyp, Adapter) + Singleton(nie wlicza się do wymaganych 3)
                                                                                          
-czy prawidłowo zdekomponowano odpowiedzialności						                  -w trakcie
                                                                                          
-czy wykorzystano jakiś wzorzec architektoniczny 						                  -MVC
                                                                                          
-czy projekt jest Mavenowy i czy poprawnie buduje się z linii komend	                  -tak
                                                                                          
-czy budowany jest przez Mavena wykonywalny jar							                  -exe, ale wyk jar również buduje się przy okazji
                                                                                          
-czy zrealizowano co najmniej 5 przykładowych testów jednostkowych		                  -
                                                                                          
-czy testy jednostkowe mają status PASSED w trakcie procesu budowania 	                  -
	projektu przez Mavena                                                                 
	                                                                                      
-czy projekt został umieszczony pod kontrolą wersji za pomocą Gita		                  -tak
                                                                                          
-czy struktura gałęzi repozytorium jest prawidłowo zarządzana			                  -w trakcie
                                                                                          
-czy skorzystano z interfejsów i/lub klas abstrakcyjnych do 			                  -tak (EventAbstract)
	reprezentowania abstrakcji jako jednego z elementów                                   
	programowania obiektowego                                                             
	                                                                                      
-czy skorzystano z polimorfizmu											                  tak (W Scheduler Event lub EventNull)