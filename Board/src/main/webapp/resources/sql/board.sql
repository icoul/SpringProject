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
