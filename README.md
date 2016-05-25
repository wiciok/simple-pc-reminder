# simple-pc-reminder
Projekt zaliczeniowy w języku Java.

Budowanie projektu:

W Eclipse:
PPM na projekt->Run As->Maven Build.
W goals wpisujecie:
- jfx:jar 		- kompiluje do jara
- jfx:run 		- uruchamia program
- jfx:native 	- kompiluje do exe
UWAGA: przy testowaniu działania klas (czyli wszystko na razie) nie uzywamy w ogole klas od GUI (paczka application), tylko maina w klasie TestUserInterface!
Aby skompilować projekt do konsoli robimy: PPM na projekt->Run As->Java Application, po czym wybieramy klasę TestUserInterface.

W IntelliJ jest podobnie.
