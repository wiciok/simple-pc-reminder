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