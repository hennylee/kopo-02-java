-- 게시판(자바콘솔)
CREATE TABLE tbl_board(
    no number(5) primary key,
    title varchar2(100) not null,
    writer varchar2(100) not null,
    reg_date date default sysdate
);

-- 게시판 일련번호 생성
create sequence seq_tbl_board_no;

-- 새글 입력
insert into tbl_board(no, title, writer) values(SEQ_TBL_BOARD_NO.NEXTVAL, 'aaa', 'bbb');