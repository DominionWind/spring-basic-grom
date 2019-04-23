CREATE TABLE FILE(
ID NUMBER,
CONSTRAINT FILE_FK PRIMARY KEY(ID),
NAME NVARCHAR2(10) NOT NULL,
FORMAT NVARCHAR2(10),
SIZE NUMBER,
STORAGE_ID NUMBER REFERENCES STORAGE(ID)
);

CREATE TABLE STORAGE(
ID NUMBER,
CONSTRAINT FILE_FK PRIMARY KEY(ID),
FORMAT_SUPPORTED NVARCHAR2(50) CHECK (FORMAT LIKE txt OR FORMAT LIKE jpg),
-- тут надо подумать как сделать список форматов todo
STORAGE_COUNTRY NVARCHAR2(50),
STORAGE_SIZE NUMBER,
)