
CREATE TABLE public.gigs (
    id bigint NOT NULL,
    venue character varying(255),
    country character varying(255),
    isSoldOut BOOLEAN DEFAULT FALSE,
    dateOfGig date,
    artist_id bigint NOT NULL
);

CREATE TABLE public.songs (
    id bigint NOT NULL,
    title character varying(255),
    album_id bigint NOT NULL
);

ALTER TABLE ONLY public.gigs
    ADD CONSTRAINT gigs_pkey PRIMARY KEY (id);

    ALTER TABLE ONLY public.songs
    ADD CONSTRAINT songs_pkey PRIMARY KEY (id);

    ALTER TABLE ONLY public.gigs
    ADD CONSTRAINT pk FOREIGN KEY (artist_id) REFERENCES public.artist(id);

    ALTER TABLE ONLY public.songs
    ADD CONSTRAINT pk FOREIGN KEY (album_id) REFERENCES public.album(id);