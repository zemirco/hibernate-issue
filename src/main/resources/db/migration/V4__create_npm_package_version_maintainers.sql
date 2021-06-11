
CREATE TABLE IF NOT EXISTS npm_package_version_maintainers (
    npm_package_versions_id BIGINT NOT NULL REFERENCES npm_package_version,
    maintainers_id INT NOT NULL REFERENCES maintainer
)
