-- Catalogs
INSERT INTO CATALOGS (id, name) VALUES (1, 'Action');
INSERT INTO CATALOGS (id, name) VALUES (2, 'Adventure');
INSERT INTO CATALOGS (id, name) VALUES (3, 'Fiction');

-- Authors
INSERT INTO AUTHORS (id, name) VALUES (1, 'J.K. Rowling');
INSERT INTO AUTHORS (id, name) VALUES (2, 'George R. R. Martin');
INSERT INTO AUTHORS (id, name) VALUES (3, 'J.R.R. Tolkien');
INSERT INTO AUTHORS (id, name) VALUES (4, 'Agatha Christie');
INSERT INTO AUTHORS (id, name) VALUES (5, 'Stephen King');
INSERT INTO AUTHORS (id, name) VALUES (6, 'Neil Gaiman');

-- Books (23 total, with LOB summaries)
INSERT INTO BOOKS (title, author_id, catalog_id, summary) VALUES
('Harry Potter and the Sorcerer''s Stone', 1, 2, 'The first Harry Potter adventure, where Harry discovers he is a wizard.'),
('Harry Potter and the Chamber of Secrets', 1, 2, 'Harry returns to Hogwarts and faces the mystery of the Chamber of Secrets.'),
('Harry Potter and the Prisoner of Azkaban', 1, 2, 'Harry learns the truth about Sirius Black and his past.'),
('A Game of Thrones', 2, 1, 'The first novel of A Song of Ice and Fire, filled with political intrigue and battles.'),
('A Clash of Kings', 2, 1, 'The second book in the series, where rival kings clash for power.'),
('A Storm of Swords', 2, 1, 'The third book, with shocking twists and betrayals.'),
('The Hobbit', 3, 2, 'Bilbo Baggins embarks on an adventure with dwarves and Gandalf.'),
('The Lord of the Rings: Fellowship', 3, 2, 'The Fellowship sets out to destroy the One Ring.'),
('The Lord of the Rings: Two Towers', 3, 2, 'The Fellowship is divided, and great battles loom.'),
('Murder on the Orient Express', 4, 3, 'Hercule Poirot solves a murder aboard a luxury train.'),
('And Then There Were None', 4, 3, 'Ten strangers are trapped on an island and killed one by one.'),
('The Shining', 5, 1, 'A family becomes caretakers of a haunted hotel in winter.'),
('IT', 5, 1, 'A group of children face a terrifying entity in their town.'),
('Misery', 5, 3, 'A famous author is held captive by his number one fan.'),
('Coraline', 6, 3, 'A young girl discovers a sinister parallel world.'),
('American Gods', 6, 3, 'A modern fantasy exploring gods in contemporary America.'),
('Neverwhere', 6, 2, 'A man discovers a hidden world beneath London.'),
('Fantastic Beasts', 1, 2, 'A guide to magical creatures in the Harry Potter universe.'),
('The Silmarillion', 3, 2, 'The mythic history of Middle-earth before The Hobbit.'),
('The Winds of Winter', 2, 1, 'The long-awaited continuation of A Song of Ice and Fire.'),
('The Casual Vacancy', 1, 3, 'A contemporary novel about small-town politics.'),
('Sleeping Beauties', 5, 3, 'A world where women fall asleep in cocoons, written with Owen King.'),
('Stardust', 6, 2, 'A fairy tale adventure about a fallen star and a magical land.');

-- Users (1 admin ,1 user total 2)
INSERT INTO USERS (name, email, role) VALUES ('Vishwa', 'viswa.varanasi@gmail.com', 'user'), ('VishwaChary', 'vishwachary.varanasi@gmail.com', 'admin');