# RandomMyHero

Random your hero in Dota2!

Java app:

Install Java.

Double-click the .jar file to start the app. Press a button to random your hero and pick it in DOTA 2. Or re-random if you don't wanna play what you randomed, I don't judge you.

AHK script:

Install AHK (https://autohotkey.com/)

Double-click the .ahk file to open the script. Once in pick screen press one of the hotkeys to random your hero:
Ctrl-Alt-1 to random from all heroes.
Ctrl-Alt-2 to random a strength hero.
Ctrl-Alt-3 to random an agility hero.
Ctrl-Alt-4 to random an intelligence hero.

The script will attempt to pick the hero by sending Alt+Enter, but that might fail if your game lags at this very moment, then you'll have to do it yourself. You can close the script afterwards.

The getHeroList.py file:

This is a Python script to parse the hero database in the DOTA 2 wiki. You don't need to execute this, as I provided the resulting file (heroList.txt). Should Valve release a new hero, you can execute this script to get the text file updated. It serves no other purpose, I just included it, because why not.
