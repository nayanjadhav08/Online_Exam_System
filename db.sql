-- Create Table OESUser (
--     id number(5) primary key ,
--     firstName varchar(30)  ,
--     lastName varchar(30) ,
--     userName varchar(20) ,
--     password varchar(20) ,
--     profile varchar(10) ,
--     register_date date default SYSDATE 
-- ) ;


-- Create Table Exams(
--     id int primary key,
--     examName varchar(100) ,
--     totalMarks int ,
--     examCode int
-- )
-- ;

--not created 
-- CREATE SEQUENCE exam_seq START WITH 1;

-- CREATE OR REPLACE TRIGGER exam_bir 
-- BEFORE INSERT ON Exams 
-- FOR EACH ROW

-- BEGIN
--   SELECT exam_seq.NEXTVAL
--   INTO   :new.id
--   FROM   dual;
-- END;
-- /





-- Create Table Question_Bank (
--     id number(5) primary key ,
--     question varchar(200)  ,
--     option1 varchar(50) ,
--     option2 varchar(50) ,
--     option3 varchar(50) ,
--     option4 varchar(50) ,
--     correctOp int ,
--     mark int,
--     examcode int ,
--     FOREIGN KEY (examcode) References Exams(id)
-- ) ;

-- Create Table Result_Data
--     (
--         id int primary key ,
--         userId number(5) ,
--         ObtainedMarks int ,
--         totalMarks int ,
--         examId int ,
--         FOREIGN KEY(userId) References OESUser(id) ,
--         FOREIGN key(examId) References Exams(id)
--     ) ;


-- INSERT INTO OESUser( firstName ,lastName , userName , password , profile ) values( 'Nayan' , 'Jadhav' , 'nayan' , 'nayan1234' ,'student') ;

-- INSERT INTO Question_Bank values(1, 'This is test question no_1 ??' , 'this is Q1 -> op1' ,'this is Q1 -> op2' ,'this is Q1 -> op3' , 'this is Q1 -> op4' , 4 , 10 , 1  );
-- INSERT INTO Question_Bank values(2, 'This is test question no_2 ??' , 'this is Q2 -> op1' ,'this is Q2 -> op2' ,'this is Q2 -> op3' , 'this is Q2 -> op4' , 3 , 10 , 1  );
-- INSERT INTO Question_Bank values(3, 'This is test question no_3 ??' , 'this is Q3 -> op1' ,'this is Q3 -> op2' ,'this is Q3 -> op3' , 'this is Q3 -> op4' , 2 , 10 , 1  );
-- INSERT INTO Question_Bank values(4, 'This is test question no_4 ??' , 'this is Q4 -> op1' ,'this is Q4 -> op2' ,'this is Q4 -> op3' , 'this is Q4 -> op4' , 1 , 10 , 1  );
-- INSERT INTO Question_Bank values(5, 'This is test question no_5 ??' , 'this is Q5 -> op1' ,'this is Q5 -> op2' ,'this is Q5 -> op3' , 'this is Q5 -> op4' , 3 , 10 , 1  );


-- CREATE SEQUENCE user_seq START WITH 1;

-- CREATE OR REPLACE TRIGGER user_bir 
-- BEFORE INSERT ON OESUser 
-- FOR EACH ROW

-- BEGIN
--   SELECT user_seq.NEXTVAL
--   INTO   :new.id
--   FROM   dual;
-- END;





