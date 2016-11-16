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
