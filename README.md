
# hibernate-issue

Just a demo repo for a problem I have.

https://stackoverflow.com/questions/67937327/how-to-implement-manytomany-with-unique-constraint

## Usage

Start Postgres db.

```bash
docker-compose up -d
```

Start the application. You should get the following error.

> Caused by: org.postgresql.util.PSQLException: ERROR: duplicate key value violates unique constraint "maintainer_email_key"
  Detail: Key (email)=(mirco.zeiss@gmail.com) already exists.

If you want to clean the database between trials.

```bash
./gradlew flywayclean
```