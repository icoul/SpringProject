show user;
-- USER이(가) "PMORAUSER"입니다.

-------------------------------------------------------------------
            -- *** 파일첨부(업로드 & 다운로드) *** --
-------------------------------------------------------------------
--drop table tblDoublefileContent purge;
create table tblDoublefileContent
(seqcontent   number               not null  -- 글번호
,name         Nvarchar2(20)        not null  -- 글쓴이  
,subject      Nvarchar2(200)       not null  -- 글제목
,content      Nvarchar2(2000)      not null  -- 글내용
,regDate      date default sysdate not null  -- 글쓴시간
,constraint PK_tblDoublefileContent primary key(seqcontent)
);

--drop sequence seq_tblDoublefileContent;
create sequence seq_tblDoublefileContent
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

--drop table tblDoublefileAttach purge;
create table tblDoublefileAttach
(seqfileno      number               not null  -- 파일번호
,fileName       varchar2(255)                  -- 웹서버에 저장될 파일명(2016082545435345464367524654634.png)
,orgFilename    varchar2(255)                  -- 진짜 파일명(강아지.png) // 사용자가 파일을 업로드 하거나 파일을 다운로드 할때 사용되어지는 파일명 
,fileSize       number                         -- 파일크기
,fk_seqcontent  number                         -- 글번호(참조키)                                            
,constraint PK_tblDoublefileAttach primary key(seqfileno)
,constraint FK_tblDoublefileAttach foreign key(fk_seqcontent) 
                                   references tblDoublefileContent(seqcontent)
);

--drop sequence seq_tblDoublefileAttach;
create sequence seq_tblDoublefileAttach
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;

select *
from tblDoublefileContent;

select *
from tblDoublefileAttach;

select C.seqcontent, C.name, C.subject, C.content, C.regDate
     , F.fileName, F.orgFilename, F.fileSize
from tblDoublefileContent C left join tblDoublefileAttach F
on C.seqcontent = F.fk_seqcontent
order by C.seqcontent desc, F.seqfileno desc;


-- 썸네일 파일명을 받는 컬럼 추가하기 
alter table tblDoublefileAttach
add thumbnailFileName varchar2(255); -- 웹서버에 저장될 썸네일 파일명(2016082513165790354388015717.png)


select C.seqcontent, C.name, C.subject, C.content, C.regDate
     , F.fileName, F.orgFilename, F.fileSize, F.thumbnailFileName
from tblDoublefileContent C left join tblDoublefileAttach F
on C.seqcontent = F.fk_seqcontent
order by C.seqcontent desc, F.seqfileno desc;

-------------------------------------------------------------------------

create table abc
(id varchar2(20)
,pwd varchar2(20)
);

insert into abc values('superman', translate('qwer1234$','0123456789','영일이삼사오육칠팔구') );

insert into abc values('songsh', translate('abc12ss34er$','0123456789','영일이삼사오육칠팔구') );

select * from abc;

select count(*) 
from abc
where id='songsh' 
and translate(pwd, '영일이삼사오육칠팔구', '0123456789') ='abc12ss34er$';
