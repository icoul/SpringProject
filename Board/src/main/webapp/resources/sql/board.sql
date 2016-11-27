create table tblBoard
(seq          number                  not null -- 글번호
,name         Nvarchar2(20)           not null -- 글쓴이
,subject      Nvarchar2(200)          not null -- 글제목
,content      Nvarchar2(2000)         not null -- 글내용 -- clob
,pw           varchar2(20)            not null -- 글비번
,readCount    number default 0        not null -- 글 조회수
,regDate      date default sysdate    not null -- 글쓴시간
,status       number(1) default 1     not null -- 글상태 1: 사용가능, 0: 삭제된글
,constraint PK_tblBoard_seq primary key(seq)
,constraint CK_tblBoard_status check(status in(0,1))
);


create sequence boardSeq
start with 1
increment by 1
nomaxvalue
nominvalue  
nocycle
nocache;


insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일미자', '일미자입니다.', '안녕하세요? 일미자입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '이미자', '이미자입니다.', '안녕하세요? 이미자입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일미자', '일미자입니다.', '안녕하세요? 일미자입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '삼미자', '삼미자입니다.', '안녕하세요? 삼미자입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '사미자', '사미자입니다.', '안녕하세요? 사미자입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '오미자', '오미자입니다.', '안녕하세요? 오미자입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '육미자', '육미자입니다.', '안녕하세요? 육미자입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '칠미자', '칠미자입니다.', '안녕하세요? 칠미자입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '팔미자', '팔미자입니다.', '안녕하세요? 팔미자입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '구미자', '구미자입니다.', '안녕하세요? 구미자입니다.', '1234', default, default, default);
-----------------------------------------------------------------------------
insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일석규', '일석규입니다.', '안녕하세요? 일석규입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '이석규', '이석규입니다.', '안녕하세요? 이석규입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일석규', '일석규입니다.', '안녕하세요? 일석규입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '삼석규', '삼석규입니다.', '안녕하세요? 삼석규입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '사석규', '사석규입니다.', '안녕하세요? 사석규입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '오석규', '오석규입니다.', '안녕하세요? 오석규입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '육석규', '육석규입니다.', '안녕하세요? 육석규입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '칠석규', '칠석규입니다.', '안녕하세요? 칠석규입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '팔석규', '팔석규입니다.', '안녕하세요? 팔석규입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '구석규', '구석규입니다.', '안녕하세요? 구석규입니다.', '1234', default, default, default);
------------------------------------------------------------------------
insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일설현', '일설현입니다.', '안녕하세요? 일설현입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '이설현', '이설현입니다.', '안녕하세요? 이설현입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일설현', '일설현입니다.', '안녕하세요? 일설현입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '삼설현', '삼설현입니다.', '안녕하세요? 삼설현입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '사설현', '사설현입니다.', '안녕하세요? 사설현입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '오설현', '오설현입니다.', '안녕하세요? 오설현입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '육설현', '육설현입니다.', '안녕하세요? 육설현입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '칠설현', '칠설현입니다.', '안녕하세요? 칠설현입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '팔설현', '팔설현입니다.', '안녕하세요? 팔설현입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '구설현', '구설현입니다.', '안녕하세요? 구설현입니다.', '1234', default, default, default);
-------------------------------------------------------
insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일순신', '일순신입니다.', '안녕하세요? 일순신입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '이순신', '이순신입니다.', '안녕하세요? 이순신입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일순신', '일순신입니다.', '안녕하세요? 일순신입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '삼순신', '삼순신입니다.', '안녕하세요? 삼순신입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '사순신', '사순신입니다.', '안녕하세요? 사순신입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '오순신', '오순신입니다.', '안녕하세요? 오순신입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '육순신', '육순신입니다.', '안녕하세요? 육순신입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '칠순신', '칠순신입니다.', '안녕하세요? 칠순신입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '팔순신', '팔순신입니다.', '안녕하세요? 팔순신입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '구순신', '구순신입니다.', '안녕하세요? 구순신입니다.', '1234', default, default, default);
---------------------------------------------------------------------------------------------------------
insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일영우', '일영우입니다.', '안녕하세요? 일영우입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '이영우', '이영우입니다.', '안녕하세요? 이영우입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일영우', '일영우입니다.', '안녕하세요? 일영우입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '삼영우', '삼영우입니다.', '안녕하세요? 삼영우입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '사영우', '사영우입니다.', '안녕하세요? 사영우입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '오영우', '오영우입니다.', '안녕하세요? 오영우입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '육영우', '육영우입니다.', '안녕하세요? 육영우입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '칠영우', '칠영우입니다.', '안녕하세요? 칠영우입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '팔영우', '팔영우입니다.', '안녕하세요? 팔영우입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '구영우', '구영우입니다.', '안녕하세요? 구영우입니다.', '1234', default, default, default);
---------------------------------------------------------------------------------------------------------
insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일길동', '일길동입니다.', '안녕하세요? 일길동입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '이길동', '이길동입니다.', '안녕하세요? 이길동입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '일길동', '일길동입니다.', '안녕하세요? 일길동입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '삼길동', '삼길동입니다.', '안녕하세요? 삼길동입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '사길동', '사길동입니다.', '안녕하세요? 사길동입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '오길동', '오길동입니다.', '안녕하세요? 오길동입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '육길동', '육길동입니다.', '안녕하세요? 육길동입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '칠길동', '칠길동입니다.', '안녕하세요? 칠길동입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '팔길동', '팔길동입니다.', '안녕하세요? 팔길동입니다.', '1234', default, default, default);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status)
values(boardSeq.nextval, '구길동', '구길동입니다.', '안녕하세요? 구길동입니다.', '1234', default, default, default);
---------------------------------------------------------------------------------------------------------
commit;

select *
from tblBoard
order by seq desc;

---------------------------------------------------------------------------------------------------------

-- 댓글 테이블 생성

create table tblComment
(seq        number                not null -- 댓글번호
,name       varchar2(20)          not null -- 성명
,content    varchar2(1000)        not null -- 댓글내용
,regDate    date default sysdate  not null -- 작성일자
,parentSeq  number                not null -- 게시글 번호
,status     number(1) default 1   not null -- 글 삭제 여부(1:사용, 2:삭제됨) : 게시글이 삭제되면 자동적으로 삭제되어야한다.
,constraint PK_tblComment_seq primary key(seq)
,constraint FK_tblComment_parentSeq foreign key(parentSeq)
                                    references tblBoard(seq)
,constraint CK_tblComment_status check (status in (1,0))
);

create sequence commentSeq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

/*
  댓글쓰기를 성공하면 원게시물에 댓글의 갯수를 알려주는 컬럼
*/

alter table tblBoard
add commentCount number default 0;

select *
from tblComment;

update tblBoard set subject = '안녕하세요. 반갑습니다. 또 만나요. 졸려요. 자고싶어요.'
where seq = 41

select T.*
from
(
select rownum as RNO, V.seq, V.name, V.subject, V.content, V.readcount, V.regdate, V.commentCount
from
(
select seq, name, case when length(subject) > 20 then substr(subject, 1, 18) || '..'
                       else subject end as subject
    , content, readcount, to_char(regdate, 'yyyy-mm-dd hh24:mi:ss') as regdate
    , commentCount
from tblBoard
where status = 1 
order by seq desc
)V
)T
where T.RNO >= 1 and T.RNO <= 5;

-----------------------------------------------------------------------------------------------


rename tblBoard to tblBoard_copy;

rename tblComment to tblComment_copy;

drop sequence boardseq;
drop sequence commentseq;

alter table tblComment_copy
drop constraint FK_tblComment_parentSeq;

alter table tblComment_copy
drop constraint CK_tblComment_status;

alter table tblComment_copy
drop constraint PK_tblComment_seq;

alter table tblBoard_copy
drop constraint PK_tblBoard_seq;

alter table tblBoard_copy
drop constraint CK_tblBoard_status;



create table tblBoard
(seq          number                  not null -- 글번호
,name         Nvarchar2(20)           not null -- 글쓴이
,subject      Nvarchar2(200)          not null -- 글제목
,content      Nvarchar2(2000)         not null -- 글내용 -- clob
,pw           varchar2(20)            not null -- 글비번
,readCount    number default 0        not null -- 글 조회수
,regDate      date default sysdate    not null -- 글쓴시간
,status       number(1) default 1     not null -- 글상태 1: 사용가능, 0: 삭제된글
,commentCount number    default 0     not null -- 댓글 수
,groupno      number                  not null -- 그룹번호, 답변글 아닌 원글의 경우 groupno의 값은 groupno컬럼의 최대값 +1로 한다
,fk_seq       number    default 0     not null -- fk_seq 컬럼은 절대로 foreign key가 아니다 fk_seq 컬럼은 자신의 글(답변글)에 있어서 원글(부모글)이 누구인지에 대한 정보값
                                               -- 답변글쓰기에 있어서 답변글이라면 fk_seq 컬럼의 값음 원글의 seq컬럼의 값을 가지게 되며
                                               -- 답변글이 아닌 원글일 경우 0을 가지도록 한다.
,depth        number    default 0     not null -- 답변글쓰기에 있어서 답변글이라면 원글의 depthno+1을 가지게 되며 원글이면 0
,constraint PK_tblBoard_seq primary key(seq)
,constraint CK_tblBoard_status check(status in(0,1))
);


create sequence boardSeq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;


create table tblComment
(seq        number                not null -- 댓글번호
,name       varchar2(20)          not null -- 성명
,content    varchar2(1000)        not null -- 댓글내용
,regDate    date default sysdate  not null -- 작성일자
,parentSeq  number                not null -- 게시글 번호
,status     number(1) default 1   not null -- 글 삭제 여부(1:사용, 2:삭제됨) : 게시글이 삭제되면 자동적으로 삭제되어야한다.
,constraint PK_tblComment_seq primary key(seq)
,constraint FK_tblComment_parentSeq foreign key(parentSeq)
                                    references tblBoard(seq)
,constraint CK_tblComment_status check (status in (1,0))
);

create sequence commentSeq
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;


select *
from tblBoard;

commit;

select *
from tblComment;
---------------------------------------------------------------------------------


insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일미자', '일미자입니다.', '안녕하세요? 일미자입니다.', '1234', default, default, default, 4);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '이미자', '이미자입니다.', '안녕하세요? 이미자입니다.', '1234', default, default, default, 5);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일미자', '일미자입니다.', '안녕하세요? 일미자입니다.', '1234', default, default, default, 6);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '삼미자', '삼미자입니다.', '안녕하세요? 삼미자입니다.', '1234', default, default, default, 7);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '사미자', '사미자입니다.', '안녕하세요? 사미자입니다.', '1234', default, default, default, 8);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '오미자', '오미자입니다.', '안녕하세요? 오미자입니다.', '1234', default, default, default, 9);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '육미자', '육미자입니다.', '안녕하세요? 육미자입니다.', '1234', default, default, default, 10);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '칠미자', '칠미자입니다.', '안녕하세요? 칠미자입니다.', '1234', default, default, default, 11);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '팔미자', '팔미자입니다.', '안녕하세요? 팔미자입니다.', '1234', default, default, default, 12);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '구미자', '구미자입니다.', '안녕하세요? 구미자입니다.', '1234', default, default, default, 13);
-----------------------------------------------------------------------------
insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일석규', '일석규입니다.', '안녕하세요? 일석규입니다.', '1234', default, default, default, 14);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '이석규', '이석규입니다.', '안녕하세요? 이석규입니다.', '1234', default, default, default, 15);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일석규', '일석규입니다.', '안녕하세요? 일석규입니다.', '1234', default, default, default, 16);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '삼석규', '삼석규입니다.', '안녕하세요? 삼석규입니다.', '1234', default, default, default, 17);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '사석규', '사석규입니다.', '안녕하세요? 사석규입니다.', '1234', default, default, default, 18);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '오석규', '오석규입니다.', '안녕하세요? 오석규입니다.', '1234', default, default, default, 19);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '육석규', '육석규입니다.', '안녕하세요? 육석규입니다.', '1234', default, default, default, 20);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '칠석규', '칠석규입니다.', '안녕하세요? 칠석규입니다.', '1234', default, default, default, 21);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '팔석규', '팔석규입니다.', '안녕하세요? 팔석규입니다.', '1234', default, default, default, 22);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '구석규', '구석규입니다.', '안녕하세요? 구석규입니다.', '1234', default, default, default, 23);
------------------------------------------------------------------------
insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일설현', '일설현입니다.', '안녕하세요? 일설현입니다.', '1234', default, default, default, 24);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '이설현', '이설현입니다.', '안녕하세요? 이설현입니다.', '1234', default, default, default, 25);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일설현', '일설현입니다.', '안녕하세요? 일설현입니다.', '1234', default, default, default, 26);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '삼설현', '삼설현입니다.', '안녕하세요? 삼설현입니다.', '1234', default, default, default, 27);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '사설현', '사설현입니다.', '안녕하세요? 사설현입니다.', '1234', default, default, default, 28);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '오설현', '오설현입니다.', '안녕하세요? 오설현입니다.', '1234', default, default, default, 29);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '육설현', '육설현입니다.', '안녕하세요? 육설현입니다.', '1234', default, default, default, 30);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '칠설현', '칠설현입니다.', '안녕하세요? 칠설현입니다.', '1234', default, default, default, 31);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '팔설현', '팔설현입니다.', '안녕하세요? 팔설현입니다.', '1234', default, default, default, 32);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '구설현', '구설현입니다.', '안녕하세요? 구설현입니다.', '1234', default, default, default, 33);
-------------------------------------------------------
insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일순신', '일순신입니다.', '안녕하세요? 일순신입니다.', '1234', default, default, default, 34);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '이순신', '이순신입니다.', '안녕하세요? 이순신입니다.', '1234', default, default, default, 35);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일순신', '일순신입니다.', '안녕하세요? 일순신입니다.', '1234', default, default, default, 36);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '삼순신', '삼순신입니다.', '안녕하세요? 삼순신입니다.', '1234', default, default, default, 37);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '사순신', '사순신입니다.', '안녕하세요? 사순신입니다.', '1234', default, default, default, 38);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '오순신', '오순신입니다.', '안녕하세요? 오순신입니다.', '1234', default, default, default, 39);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '육순신', '육순신입니다.', '안녕하세요? 육순신입니다.', '1234', default, default, default, 40);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '칠순신', '칠순신입니다.', '안녕하세요? 칠순신입니다.', '1234', default, default, default, 41);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '팔순신', '팔순신입니다.', '안녕하세요? 팔순신입니다.', '1234', default, default, default, 42);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '구순신', '구순신입니다.', '안녕하세요? 구순신입니다.', '1234', default, default, default, 43);
---------------------------------------------------------------------------------------------------------
insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일영우', '일영우입니다.', '안녕하세요? 일영우입니다.', '1234', default, default, default, 44);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '이영우', '이영우입니다.', '안녕하세요? 이영우입니다.', '1234', default, default, default, 45);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일영우', '일영우입니다.', '안녕하세요? 일영우입니다.', '1234', default, default, default, 46);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '삼영우', '삼영우입니다.', '안녕하세요? 삼영우입니다.', '1234', default, default, default, 47);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '사영우', '사영우입니다.', '안녕하세요? 사영우입니다.', '1234', default, default, default, 48);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '오영우', '오영우입니다.', '안녕하세요? 오영우입니다.', '1234', default, default, default, 49);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '육영우', '육영우입니다.', '안녕하세요? 육영우입니다.', '1234', default, default, default, 50);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '칠영우', '칠영우입니다.', '안녕하세요? 칠영우입니다.', '1234', default, default, default, 51);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '팔영우', '팔영우입니다.', '안녕하세요? 팔영우입니다.', '1234', default, default, default, 52);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '구영우', '구영우입니다.', '안녕하세요? 구영우입니다.', '1234', default, default, default, 53);
---------------------------------------------------------------------------------------------------------
insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일길동', '일길동입니다.', '안녕하세요? 일길동입니다.', '1234', default, default, default, 54);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '이길동', '이길동입니다.', '안녕하세요? 이길동입니다.', '1234', default, default, default, 55);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '일길동', '일길동입니다.', '안녕하세요? 일길동입니다.', '1234', default, default, default, 56);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '삼길동', '삼길동입니다.', '안녕하세요? 삼길동입니다.', '1234', default, default, default, 57);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '사길동', '사길동입니다.', '안녕하세요? 사길동입니다.', '1234', default, default, default, 58);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '오길동', '오길동입니다.', '안녕하세요? 오길동입니다.', '1234', default, default, default, 59);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '육길동', '육길동입니다.', '안녕하세요? 육길동입니다.', '1234', default, default, default, 60);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '칠길동', '칠길동입니다.', '안녕하세요? 칠길동입니다.', '1234', default, default, default, 61);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '팔길동', '팔길동입니다.', '안녕하세요? 팔길동입니다.', '1234', default, default, default, 62);

insert into tblBoard(seq, name, subject, content, pw, readCount, regDate, status, groupno)
values(boardSeq.nextval, '구길동', '구길동입니다.', '안녕하세요? 구길동입니다.', '1234', default, default, default, 63);


-------------------------------------------------------------------------------------------

select T.*
		from
		(
			select rownum as RNO, V.seq, V.name, V.subject, V.content, V.readcount, V.regdate, V.commentCount, V.groupno, V.fk_seq, V.depth
			from
				(
					select seq, name, case when length(subject) > 20 then substr(subject, 1, 18) || '..'
					                       else subject end as subject
					    , content, readcount, to_char(regdate, 'yyyy-mm-dd hh24:mi:ss') as regdate
					    , commentCount, groupno, fk_seq, depth
					from tblBoard
					where status = 1
              --and ${colname} like '%' || #{search} || '%'
          start with fk_seq = 0
          connect by prior seq = fk_seq
					order siblings by groupno desc, seq asc
				)V
			)T
		where T.RNO >= 1 and T.RNO <= 10;
    
select *
from tblBoard
order by groupno;

commit;

select substr(content, instr(content, '하세', 1, 1), length('하세')) as searchword
      ,substr(content, instr(content, '하세', 1, 1) + length('하세'), 5) as content
from tblBoard
where lower(content) like '%' || lower('하세') || '%'

select distinct subject
from tblBoard
where lower(subject) like '%' || lower('입니') || '%';

select distinct
       substr(subject, 1, instr(subject, '입니', 1, 1)-1) as forwardWord 
      ,substr(subject, instr(subject, '입니', 1, 1), length('입니')) as searchword
      ,substr(subject, instr(subject, '입니', 1, 1)+length('입니'), length(subject)-instr(subject, '입니', 1, 1)+length('입니')) as backword
from tblBoard
where lower(subject) like '%' || lower('입니') || '%';
    
alter table tblBoard
add fileName varchar2(255);-- WAS(톰캣)에 저장될 파일명(201611211433243323421.png)

alter table tblBoard
add orgFileName varchar2(255);-- 원본 파일명(강아지.png) 사용자가 파일을 upload하거나, downlaod할 때 사용되어지는 파일명

alter table tblBoard
add fileSize  number;-- 파일 크기, 단위는 byte이다.

select seq, name, subject, readCount, regdate, rank
from
(
select rank() over(order by readCount desc, regDate desc) as rank, seq, name
     , case when length(subject) > 20 then substr(subject, 1, 18)
            else subject end as subject
     , readcount, to_char(regDate, 'yyyy-mm-dd hh24:mi:ss') as regDate 
from tblBoard
where status = 1
)V
where V.rank <= to_number('10');



create table testTBL
(seq number not null
,namea varchar2(100) not null
,constraint UK_testTBL_namea unique(namea)
);


insert into testTBL values(1, 'aaa');

select *
from testTBL;
commit;
update testTBL set namea = 'bb';

insert into testTBL values(3, 'bb');