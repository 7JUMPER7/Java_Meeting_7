DROP TABLE IF EXISTS AUTHORITIES;
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS LOG;

--USER TABLE
CREATE TABLE IF NOT EXISTS USER (
    ID INT GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) NOT NULL PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    PHONE VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    BLOG VARCHAR(255),
    NOTE VARCHAR(255)
);
