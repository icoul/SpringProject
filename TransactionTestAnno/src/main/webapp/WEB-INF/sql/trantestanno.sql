--- *** Spring의 트랜잭션 처리 *** ---
/* 

 ACID : 트랜잭션을 설명할 때 4가지 특징을 이용한다. 
 1) A 
   ㄱ. Atomicity ( 원자성 ) : 원자성은 트랜잭션 범위에 있는 모든 동작이
   모두 실행되거나 또는 모두 실행이 취소됨을 보장한다.
 2) C
   ㄱ. Consistency ( 일관성 ) : 트랜잭션이 종료되면, 시스템은 비즈니스에서
   기대하는 상태가 된다. 
   예) 서적 구매 트랜잭션이 성공적으로 실행되면 결제 내역, 구매 내역
   , 잔고 정보가 비즈니스에 맞게 저장되고 변경된다.

 3) I
   ㄱ. Isolation ( 고립성 ) : 트랜잭션은 다른 트랜잭션과 독립적으로 
   실행되어야 하며, 서로 다른 트랜잭션이 동일한 데이터에 동시에 접근
   할 경우 알맞게 동시 접근을 제어해야 한다. ( 격리레벨에 따라 동시 접근 제어 )  

 4) D
  ㄱ. Durability ( 지속성 ) : 트랜잭션이 완료되면, 그 결과는 지속적으로 
  유지되어야 한다. 


 === 트랜잭션 처리 상황 === 
 ㄱ. 계좌 이체 = 계좌출금 + 타 계좌입금
  *** ㄴ. 회원이 특정 게시판에 게시글을 추가하면 회원의 포인트가 올라가는 상황
 ㄷ. 원글에 댓글이 추가되면 댓글 테이블에 게시물 등록되고, 원글에는 댓글의 숫자가 업데이트되는 상황
 ㄹ. 문의 게시판에 글을 등록하면 데이터베이스에도 글이 등록되지만, 담당자에게도 메일이 발송되는 상황

*/
 

   create table tx_member
   (  id varchar2(50) 
    , pwd varchar2(50)
    , name varchar2(50)
    , point number(10) default 0
    , constraint PK_tx_member_id primary key(id)
    , constraint CK_tx_member_point check( point < 3 )
   );

   insert into tx_member(id, pwd, name) values('hongkd','1234','홍길동');
   
   commit;
   

   create table tx_notices
   ( seq varchar2(10) 
   , writerid varchar2(50)
   , title varchar2(200) 
   , content varchar2(4000)
   , constraint PK_tx_notices_seq primary key(seq)
   , constraint FK_tx_notices_writerid foreign key(writerid) references tx_member(id)
   );
  
   
   create sequence seq_tx_notices
   start with 1
   increment by 1
   nomaxvalue
   nominvalue
   nocycle
   nocache;
   
   
   select * from tx_notices;
   
   select * from tx_member;
   
   delete from tx_notices;
   update tx_member set point = 0;
   commit;
   
