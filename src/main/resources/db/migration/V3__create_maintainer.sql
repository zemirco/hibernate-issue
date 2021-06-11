
CREATE TABLE IF NOT EXISTS maintainer (
    id SERIAL PRIMARY KEY,
    name TEXT,
    email TEXT UNIQUE,
    url TEXT
)
