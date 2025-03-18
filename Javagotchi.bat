@echo off
start powershell -NoProfile -ExecutionPolicy Bypass -Command ^
"$host.UI.RawUI.BackgroundColor = 'Black'; Clear-Host; cd '%~dp0out/production/Javagotchi'; echo 'Starte Javagotchi...'; java Main; Read-Host 'Drücke Enter zum Beenden'"
exit
