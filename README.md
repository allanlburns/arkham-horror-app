# Purpose/Problem
Fantasy Flight Games’ Arkham Horror 3rd Edition Board Game is my favorite board game to play with friends, but the amount of organizing and bookkeeping involved is staggering. 

(Elaborate on examples of different decks to track, mixing cards of one deck into another, etc).

Many similar games (Star Wars: Imperial Assault, LotR Journeys into Middle-Earth) have companion app that take care of much of this bookkeeping, but Arkham Horror doesn’t. An app would simplify gameplay and make playing even more enjoyable.

Furthermore, Arkham Horror is a long game. Setup takes 30 minutes to an hour by an experienced player, and game play can last 3-6 hours. Much of this time is spent (blahblahblah, cards). 

(So what we really need is a save feature!) In the past, saved games with photos and carefully packed away cards, tokens, etc. in such a way to make it possible to continue the game later. This process is tedious and error prone, plus only one game can be saved. A new game, even with a different scenario, can’t be started until the old game is finished or abandoned.

## Scope/Strategy
Start Small: Backend App from Command Line
Java/Spring Boot or Python/Flask? Leaning towards Java/Spring Boot.

Local Postgres DB to start, then migrate to Amazon RDS.

All text. Call methods manually.

Deploy to AWS.


Doom probably won’t need to be tracked per neighborhood but number of tokens on scenario sheet will be tracked in game state. No need to incorporate investigator skill checks or items since this is pretty straightforward. The goal of this app is to manage the cards.
