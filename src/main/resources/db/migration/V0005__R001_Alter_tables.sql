ALTER TABLE artist
ADD  COLUMN created_at DATE, ADD COLUMN updated_at DATE;

ALTER TABLE album
ADD  COLUMN created_at DATE, ADD COLUMN updated_at DATE;

ALTER TABLE gigs
ADD  COLUMN created_at DATE, ADD COLUMN updated_at DATE;

ALTER TABLE songs
ADD  COLUMN created_at DATE, ADD COLUMN updated_at DATE;

