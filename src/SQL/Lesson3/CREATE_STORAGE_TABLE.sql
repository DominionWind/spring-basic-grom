CREATE TABLE STORAGE(
    ID NUMBER,
    CONSTRAINT STORAGE_PK PRIMARY KEY(ID),
    FORMATS_SUPPORTED NVARCHAR2(50) NOT NULL,
    STORAGE_COUNTRY NVARCHAR2(50),
    STORAGE_SIZE NUMBER
);