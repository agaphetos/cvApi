CREATE TABLE message
(
    id serial NOT NULL PRIMARY KEY,
    name character varying(50) NOT NULL,
    email character varying(100) NOT NULL,
    content character varying(500) NOT NULL,
    date date DEFAULT ('now'::text)::date
);