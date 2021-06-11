
CREATE TABLE IF NOT EXISTS npm_package_version (
    id BIGSERIAL PRIMARY KEY,
    npm_package_id BIGINT NOT NULL REFERENCES npm_package,
    version TEXT NOT NULL,
    description TEXT,
    homepage TEXT,

    UNIQUE(npm_package_id, version)
)
