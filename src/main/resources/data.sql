INSERT INTO CUSTOMER(HN,PID,NAME,BIRTHDAY,SEX,BLOOD,NATION,RACE,ADDRESS,TEL,MOBILE,JOB,EMAIL)
VALUES('100','1730200213549','jasin','1993-07-28','M','B','thai','thai','155/8','034589948','0964747468','ProProgrammer','meta.vin@hotmail.com');
INSERT INTO CUSTOMER(EMAIL,NAME,MOBILE) VALUES('aaa@aaa.com','aaaaaa','0000000');
INSERT INTO CUSTOMER(EMAIL,NAME,MOBILE) VALUES('bbb@bbb.com','bbbbbb','1111111');
INSERT INTO CUSTOMER(EMAIL,NAME,MOBILE) VALUES('ccc@ccc.com','cccccc','2222222');


INSERT INTO DEPARTMENTEMPLOYEE(NAME) VALUES('software development');
INSERT INTO DEPARTMENTEMPLOYEE(NAME) VALUES('software Engineering');
INSERT INTO DEPARTMENTEMPLOYEE(NAME) VALUES('software singular');
INSERT INTO DEPARTMENTEMPLOYEE(NAME) VALUES('Apple');
INSERT INTO DEPARTMENTEMPLOYEE(NAME) VALUES('Orange');
INSERT INTO DEPARTMENTEMPLOYEE(NAME) VALUES('Coconut');
INSERT INTO DEPARTMENTEMPLOYEE(NAME) VALUES('Banana');
INSERT INTO DEPARTMENTEMPLOYEE(NAME) VALUES('Mangko');

INSERT INTO MEDICALHISTORY(DISEASE) VALUES('Nomal');
INSERT INTO MEDICALHISTORY(DISEASE) VALUES('High Blood Pressure');
INSERT INTO MEDICALHISTORY(DISEASE) VALUES('Anemia');
INSERT INTO MEDICALHISTORY(DISEASE) VALUES('Diabetes');
INSERT INTO MEDICALHISTORY(DISEASE) VALUES('Dissolves blood clots');
INSERT INTO MEDICALHISTORY(DISEASE) VALUES('Heart disease');
INSERT INTO MEDICALHISTORY(DISEASE) VALUES('Hepatitis');
INSERT INTO MEDICALHISTORY(DISEASE) VALUES('Losers drug history');

INSERT INTO STAFF(WORD_STATUS,EMAIL,NAMETH,MOBILE,ENABLED) VALUES('makework','Staff@staff.com','STAFF','0964747468',TRUE);

INSERT INTO DOCTOR(WORD_STATUS,CER_NO,EMAIL,NAMETH,MOBILE,ENABLED) VALUES('makework','123CERN','Doctor@Doctor.com','DOCTOR','0964747468',TRUE);

INSERT INTO AUTHORITY(ROLES) VALUES('add');
INSERT INTO AUTHORITY(ROLES) VALUES('update');
INSERT INTO AUTHORITY(ROLES) VALUES('delete');

INSERT INTO TYPEPRODUCT(NAME,CREATE_DATE) VALUES('drug','2557-05-21');
INSERT INTO TYPEPRODUCT(NAME,CREATE_DATE) VALUES('equipment','2557-05-22');

INSERT INTO UNIT(NAME) VALUES('piece');
INSERT INTO UNIT(NAME) VALUES('seed');
INSERT INTO UNIT(NAME) VALUES('milliliter');
INSERT INTO UNIT(NAME) VALUES('gram');

INSERT INTO PRODUCT(NAME,BARCODE_MAIN,BARCODE_SUB,TYPEPRODUCT_ID,UNIT_ID) 
VALUES('xxxx','codemian1','codesub1',1,2);
INSERT INTO PRODUCT(NAME,BARCODE_MAIN,BARCODE_SUB,TYPEPRODUCT_ID,UNIT_ID) 
VALUES('bbbb','codemian2','codesub2',2,4);
INSERT INTO PRODUCT(NAME,BARCODE_MAIN,BARCODE_SUB,TYPEPRODUCT_ID,UNIT_ID) 
VALUES('cccc','codemian3','codesub3',1,3);


