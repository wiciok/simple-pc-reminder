# simple-pc-reminder
Projekt zaliczeniowy w języku Java.

Budowanie projektu:

W Eclipse:
PPM na projekt->Run As->Maven Build.
W goals wpisujecie:
- jfx:jar 		- kompiluje do jara
- jfx:run 		- uruchamia program
- jfx:native 	- kompiluje do exe
UWAGA: przy testowaniu działania klas (czyli wszystko na razie) nie uzywamy w ogole klas od GUI (paczka presentation), tylko maina w klasie TestUserInterface!
Aby skompilować projekt do konsoli robimy: PPM na projekt->Run As->Java Application, po czym wybieramy klasę TestUserInterface.

W IntelliJ jest podobnie.


UWAGA ODNOŚNIE GUI:
Ważne - SceneBuilder jest na tyle głupi, że żeby móc jak biały człowiek wybrać w nim z rozwijalnej listy klasę kontrolera i metody obsługi zdarzeń, to plik fxml musi być w jednym katalogu (nie tylko paczce! katalogu!) z tymi klasami.
Z kolei jeśli fxml będzie w katalogu src, to Maven nam nie zbuduje projektu... Albo trzeba chamsko wpisywać w scenebuilderze nazwę pakietu i klasę (mimo, iż jest to ten sam pakiet, w którym się znakdujemy), albo na czas pracy w scenebuilderze przenieść plik fxml do bieżącego katalogu, a po jej zakończeniu przenieść go z powrotem do resources.
Nie wiem, czy ta druga opcja zadziała w Eclipse, natomiast IntelliJ radzi sobie z tym bardzo dobrze.


Kryteria oceniania

-czy wykorzystano co najmniej trzy wzorce projektowe						-w trakcie (singleton(?), będzie prototyp, trzeba jeszcze coś)

-czy prawidłowo zdekomponowano odpowiedzialności							-w trakcie

-czy wykorzystano jakiś wzorzec architektoniczny 							-na razie jest pseudo multi-tier architecture, ale przerobie to na mvc

-czy projekt jest Mavenowy i czy poprawnie buduje się z linii komend		-tak

-czy budowany jest przez Mavena wykonywalny jar								-trochę nie dotyczy naszego projektu bo robimy exe

-czy zrealizowano co najmniej 5 przykładowych testów jednostkowych			-

-czy testy jednostkowe mają status PASSED w trakcie procesu budowania 		-
	projektu przez Mavena
	
-czy projekt został umieszczony pod kontrolą wersji za pomocą Gita			-tak

-czy struktura gałęzi repozytorium jest prawidłowo zarządzana				-w trakcie

-czy skorzystano z interfejsów i/lub klas abstrakcyjnych do 				-hmmm są wykorzystywane iterfejsy, ale nie ma żadnego naszego własnego
	reprezentowania abstrakcji jako jednego z elementów
	programowania obiektowego
	
-czy skorzystano z polimorfizmu												tak