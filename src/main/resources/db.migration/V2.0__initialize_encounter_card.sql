CREATE TABLE IF NOT EXISTS encounter_card (
    id SERIAL PRIMARY KEY,
    number VARCHAR(255),
    neighborhood VARCHAR(255),
    location1 VARCHAR(255),
    location2 VARCHAR(255),
    location3 VARCHAR(255),
    gameSet VARCHAR(255),
    location1Text TEXT,
    location2Text TEXT,
    location3Text TEXT
);