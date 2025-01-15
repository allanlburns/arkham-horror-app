CREATE TABLE IF NOT EXISTS archive_card (
    id SERIAL PRIMARY KEY,
    number INT NOT NULL,
    title VARCHAR(255),
    flavor_text TEXT,
    effect TEXT,
    flipped_effect TEXT,
    in_codex BOOLEAN NOT NULL DEFAULT FALSE
);