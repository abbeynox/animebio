CREATE TABLE UserProfile(
    id INT AUTO_INCREMENT PRIMARY KEY UNIQUE,
    user_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    Animes VARCHAR(255),
    anime_list_idfs INT
);

CREATE TABLE AnimeList(
    id INT AUTO_INCREMENT PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    score FLOAT(2,1) NOT NULL DEFAULT(0),
    score_rank INT NOT NULL,
    popularity_rank INT NOT NULL,
    air_date VARCHAR(255) NOT NULL,
    studio VARCHAR(255) NOT NULL,
    num_of_episode INT NOT NULL DEFAULT(0),
    genres VARCHAR(255) NOT NULL,
    themes VARCHAR(255) NOT NULL,
    demographic VARCHAR(255) NOT NULL
);

ALTER TABLE UserProfile
ADD FOREIGN KEY (anime_list_idfs) REFERENCES AnimeList(id);

LOAD DATA INFILE 'mal_top2000_anime.csv'
INTO TABLE AnimeList
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES;