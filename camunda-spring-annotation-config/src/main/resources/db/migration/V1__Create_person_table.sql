CREATE TABLE PERSON 
    ( 
     ID NUMBER NOT NULL ,
     SURNAME VARCHAR2(255 CHAR), 
     LASTNAME VARCHAR2(255 CHAR),
     AGE NUMBER
    );
    

ALTER TABLE PERSON 
    ADD CONSTRAINT PRIM_PERSON PRIMARY KEY ( ID )  USING INDEX ;
CREATE SEQUENCE SEQ_PERSON_PERSON_ID
    INCREMENT BY 1
    START WITH 1
    CACHE 100;
    
grant INSERT, UPDATE, DELETE, SELECT on PERSON to demo;
grant SELECT on SEQ_PERSON_PERSON_ID to demo;