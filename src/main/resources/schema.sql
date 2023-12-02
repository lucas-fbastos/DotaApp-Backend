CREATE SEQUENCE IF NOT EXISTS hero_entity_id_seq
    INCREMENT 1
    START 1;

CREATE TABLE IF NOT EXISTS hero_entity (
                                          id INTEGER DEFAULT nextval('hero_entity_id_seq') PRIMARY KEY,
                                          name TEXT NOT NULL,
                                          localized_name TEXT,
                                          primary_attribute TEXT,
                                          attack_type TEXT,
                                          image TEXT,
                                          icon TEXT
);

CREATE TABLE IF NOT EXISTS hero_role (
                                        id INTEGER PRIMARY KEY,
                                        role_name TEXT NOT NULL,
                                        hero_id INTEGER,
                                        FOREIGN KEY(hero_id) REFERENCES hero_entity(id)
    );