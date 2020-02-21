
--
CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1000000;
CREATE TABLE public.album (
    id bigint NOT NULL,
    name character varying(255),
    year date,
    artist_id bigint NOT NULL
);


ALTER TABLE public.album OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 16481)
-- Name: artist; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.artist (
    id bigint NOT NULL,
    name character varying(255),
    country character varying(255)
);


ALTER TABLE public.artist OWNER TO postgres;

--
-- TOC entry 2691 (class 2606 OID 16493)
-- Name: album artist_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.album
    ADD CONSTRAINT artist_id PRIMARY KEY (id);


--
-- TOC entry 2689 (class 2606 OID 16488)
-- Name: artist artist_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.artist
    ADD CONSTRAINT artist_pkey PRIMARY KEY (id);


--
-- TOC entry 2692 (class 2606 OID 16494)
-- Name: album pk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.album
    ADD CONSTRAINT pk FOREIGN KEY (artist_id) REFERENCES public.artist(id);


-- Completed on 2020-02-13 19:33:26

--
-- PostgreSQL database dump complete
--

