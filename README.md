  git pull origin main --rebase
  git push origin main



since we are using H2 in memory database


-- Users table
CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    role ENUM('admin', 'user') NOT NULL
);

-- Authors table
CREATE TABLE Authors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    bio TEXT
);

-- Catalogs table
CREATE TABLE Catalogs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Books table
CREATE TABLE Books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author_id INT NOT NULL,
    catalog_id INT NOT NULL,
    summary TEXT,
    FOREIGN KEY (author_id) REFERENCES Authors(id) ON DELETE CASCADE,
    FOREIGN KEY (catalog_id) REFERENCES Catalogs(id) ON DELETE CASCADE
);


-- Insert Users

INSERT INTO Users (name, email, role) VALUES
('Alice', 'alice@gmail.com', 'admin'),
('Bob', 'bob@gmail.com', 'user');

-- Insert Authors


INSERT INTO Authors (name, bio) VALUES
('J.K. Rowling', NULL),
('George R.R. Martin', NULL),
('J.R.R. Tolkien', NULL),
('Agatha Christie', NULL),
('Stephen King', NULL),
('Neil Gaiman', NULL);

-- Insert Catalogs


INSERT INTO Catalogs (name) VALUES
('Action'),
('Adventure'),
('Fiction'),
('GradmaStories');

-- Insert Books


INSERT INTO Books (title, author_id, catalog_id, summary) VALUES
('Harry Potter and the Sorcerer''s Stone', 1, 2, 'Harry discovers he is a wizard and begins his studies at Hogwarts.'),
('Harry Potter and the Chamber of Secrets', 1, 2, 'Harry returns to Hogwarts and faces the mystery of the Chamber of Secrets.'),
('Harry Potter and the Prisoner of Azkaban', 1, 2, 'Harry learns the truth about Sirius Black and his parents'' past.'),
('A Game of Thrones', 2, 1, 'Noble families vie for control of the Iron Throne in Westeros.'),
('A Clash of Kings', 2, 1, 'The Seven Kingdoms descend into war as kings rise and fall.'),
('A Storm of Swords', 2, 1, 'Betrayals and battles reshape the fate of Westeros.'),
('The Hobbit', 3, 2, 'Bilbo Baggins embarks on a quest with dwarves to reclaim their treasure.'),
('The Lord of the Rings: Fellowship', 3, 2, 'Frodo begins his journey to destroy the One Ring.'),
('The Lord of the Rings: Two Towers', 3, 2, 'The Fellowship is split, and Middle-earth prepares for war.'),
('Murder on the Orient Express', 4, 3, 'Poirot investigates a murder aboard a snowbound luxury train.'),
('And Then There Were None', 4, 3, 'Ten strangers are lured to an island and mysteriously killed one by one.'),
('The Shining', 5, 1, 'A family is trapped in a haunted hotel with terrifying consequences.'),
('IT', 5, 1, 'A group of children battle a shape-shifting monster in Derry, Maine.'),
('Misery', 5, 3, 'A writer is held captive by a fan who forces him to rewrite his story.'),
('Coraline', 6, 3, 'A young girl discovers a sinister parallel world behind a secret door.'),
('American Gods', 6, 3, 'Shadow becomes entangled in a war between old gods and new.'),
('Neverwhere', 6, 2, 'Richard Mayhew falls into a magical London Below filled with danger.'),
('Fantastic Beasts', 1, 2, 'A magical guidebook to the creatures of the wizarding world.'),
('The Silmarillion', 3, 2, 'A mythic history of Middle-earth from its creation to the First Age.'),
('The Winds of Winter', 2, 1, 'The next book in the saga of Westeros, full of war and intrigue.'),
('The Casual Vacancy', 1, 3, 'A small English town faces upheaval after a local official dies.'),
('Sleeping Beauties', 5, 3, 'A strange plague causes women to fall asleep in cocoons.'),
('Stardust', 6, 2, 'A young man crosses into a magical realm to find a fallen star.');



# MyBookStore
MyBookStore-With-Oauth2-and-JWT
Step 1

Go to Google Cloud Console   :  https://console.cloud.google.com/

Create a project -  MyBookStore

Enable Google OAuth2 API.

Create OAuth 2.0 credentials (Client ID & Secret).

remember while creating OAuth 2 credentials , please give the below as redirect url

Add http://localhost:8080/login/oauth2/code/google as redirect URI.

Once , this is done , you will get Client Id and Client Secret , There will be an option to download JSON , which has all the information w.r.t 
Client ID and Client Secret and other information like redirect URL , auth token url..

==================Next Steps ==================
Flow in Your Current Design

User logs in with Google (OAuth2).

Spring Security redirects them to Google.

Google validates credentials and returns user info (ID token with email, profile, etc.).

Spring Boot receives user info.

You extract the Gmail address.

You decide what role that email should have (ADMIN or USER).

Spring Boot issues its own JWT.

This JWT includes your app’s claims (roles, expiration, subject, etc.).

This is the token the frontend uses for all subsequent REST API calls (e.g. /api/books).

Spring Boot validates JWT on every API call.

Since it issued the JWT, it knows the secret key to validate it.

Checks the roles claim → decides whether to allow GET/POST/DELETE.
