# Purpose/Problem
Fantasy Flight Games’ Arkham Horror 3rd Edition Board Game is my favorite board game to play with friends, but the amount of organizing and bookkeeping involved is staggering. 

Despite being a board game (there's a separate card game version, Arkham Horror: The Card Game), there are over a half dozen different types of decks in the game. Each scenario for the

game has a 24-card Event Deck, six eight-card decks for Encounters, a handful of Archive Cards to track game objectives and event triggers, a deck of monsters that are spawned to 

challenge the investigators, and Mythos Tokens that are drawn each turn. 


Many similar games (Star Wars: Imperial Assault, LotR Journeys into Middle-Earth) have a companion app that take care of much of this bookkeeping, but Arkham Horror doesn’t. An app would 

simplify gameplay and make playing even more enjoyable. Furthermore, Arkham Horror is a long game. Setup takes 30 minutes to an hour by an experienced player, and game play can last 3-6 hours. 

When playing a scenario from one of the expansions, certain expansion-specific cards have to be shuffled into several decks and then removed from the decks afterwards. 


Because of the long play time, sometimes it's difficult to finish a game in one session. In the past, saved games with photos and carefully packed away cards, tokens, etc. in such a way to make

it possible to continue the game later. This process is tedious and error prone, plus only one game can be saved. A new game, even with a different scenario, can’t be started until the old game

is finished or abandoned. Soon, this app will incorporate a save feature to facilitate saving and resuming previous games.

## Scope/Strategy
This app is a work in progress. The overall architecture is a backend Java/Spring Boot API service with PostgreSQL database that stores each card type as its own table. I've implemented most of

the core game logic hard-coded for a single scenario: "Feast for Umordhoth". I plan to expand functionality to include other scenarios after the frontend app is complete. The frontend UI will be

a React app. 

Once the frontend app is finished, I'll test both apps in cloud deployment. I won't be able to host a sufficiently large enough instance for everyone who uses the apps, but I'll provide instructions

for cloud and local deployment.

## Roadmap/Next Steps
I'm currently working on a deep dive to learn React. Once I construct a working frontend, I'll circle back to continue refining core game logic. After that I'll provide images for the cards, and then

the app should be playable for the first scenario. 

The next features will be:
* Frontend UI
* Game session tracking and game save feature
* Additional scenarios. First I'll finish the other three core box scenarios and then scenarios from the expansions.
* Eventually a mobile app built in ReactNative
* A fully Java standalone desktop app version