
CREATE TABLE IF NOT EXISTS npm_package (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL UNIQUE
);
