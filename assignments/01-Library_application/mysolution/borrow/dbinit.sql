CREATE DATABASE "borrow" OWNER postgres;
\connect borrow
ALTER DATABASE "borrow" SET TIMEZONE TO 'Europe/Rome';
SET TIMEZONE TO 'Europe/Rome';

CREATE TABLE "borrowings"
(
    borrow_id integer,
    book_id character varying,
    customer_id character varying,
    notify_to_phone_nr character varying
) TABLESPACE pg_default;

ALTER TABLE "borrowings"
    OWNER to postgres;