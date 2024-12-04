DO $$
BEGIN
   -- Check if the table exists and create it if it doesn't
   IF NOT EXISTS (SELECT FROM information_schema.tables WHERE table_name = 'archive_card') THEN
       CREATE TABLE archive_card (
           id SERIAL PRIMARY KEY,
           number INT NOT NULL,
           title VARCHAR(255),
           flavor_text TEXT,
           effect TEXT,
           flipped_effect TEXT
       );
   END IF;
END $$;

DO $$
BEGIN
   -- Check if the table has no data and insert only if it's empty
   IF NOT EXISTS (SELECT 1 FROM archive_card) THEN
       INSERT INTO archive_card (id, number, title, flavor_text, effect, flipped_effect)
       VALUES
       (1, 1, 'Outbreak', 'Windows are shut, curtains drawn, doors locked. Citizens hurry...', 'If a space has four or more doom, remove three doom from that space. Then place one doom in each other space in that neighborhood and one doom on the scenario sheet.', NULL),
       (2, 10, 'Fresh Meat', 'The steep gabled roofs of Arkham jut like teeth into the night sky...', 'When there are three or more clues on the scenario sheet, discard all clues from the scenario sheet and flip this card.', 'The leader gains Lita Chantler. Spawn the set-aside masked hunter engaged with the leader. Take cards 13 through 17 from the archive. Shuffle each card into the top two cards of the corresponding neighborhood deck. Place one marker facedown in each neighborhood. Add card 12 to the codex and return this card to the archive.'),
       (3, 11, 'The Hunger Below', 'With every fog-haunted night...', 'When there is eight or more doom on the scenario sheet, flip this card.', 'If card 10 is still in the codex, flip that card before continuing. Take card 19 and spawn it at Hangmans Hill. Add card 18 to the codex and return this card to the archive.'),
       (4, 12, 'False Faces', 'Between your own investigation and Lita Chantler...', 'After a worshiper of Umordhoth spawns, discard the marker in its neighborhood. After a worshiper is defeated, return that worshiper to the game box and place one marker on the scenario sheet. After the fifth marker is placed on the scenario sheet, if card 11 is still in the codex flip that card.', 'Investigators win the game!'),
       (5, 18, 'The Feast of Ghouls', 'The Reason for the mysterious disappearances stands revealed...', 'The Umordhoth epic monsters health is reduced by two for each marker on the scenario sheet. After the Umordhoth epic monster is defeated, flip card 12. When there is fifteen or more doom on the scenario sheet, flip this card.', 'Investigators lose the game.'),
       (6, 19, 'Umordhoth', NULL, NULL, NULL);
   END IF;
END $$;
