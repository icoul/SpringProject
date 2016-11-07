create table tbl_mybatistest
(no     number
,name   varchar2(20)
,email   varchar2(100)
,tel    varchar2(20)
,addr   varchar2(200)
,writeday date default sysdate
,constraint PK_tbl_mybatistest_no primary key(no)
);


create sequence seq_mybatistest

select *
from tbl_mybatistest