-- 리스트	/boards	GET
select board.board_no
      , title
      , hit
      , board.user_id
      , category_no
      , udate
      , count(comment.comment_no) as comment_cnt
from board LEFT OUTER JOIN comment
    on board.board_no = comment.board_no
where category_no = 1
  GROUP BY board.board_no
LIMIT 0, 10;


-- 글쓰기	/boards	POST
insert into board (
  title
  , content
  , user_id
  , category_no
) VALUES (
  :title, :content, :user_id, :category_no
);


-- 글수정	/boards	PUT
update board set
  title = :title
  , content = :content
  , udate = CURRENT_TIMESTAMP
where board_no = :board_no;


-- 글내용보기	/boards/{boardId}	GET
select board_no
      , title
      , content
      , hit
      , board.user_id
      , category_no
      , udate
from board
where board_no = :board_no;


-- 댓글 리스트 가져오기
select comment_no
    , user_id
    , content
    , regdate
    , depth
from comment
where board_no = :board_no
order by comment_group, comment_no
LIMIT 0, 10;


-- 글삭제	/boards/{boardId}	DELETE
DELETE from board where board_no = :board_no;


-- 로그인	/boards/login	POST
select id
      , pwd
from user_info
WHERE id = :id;


-- 회원가입	/boards/signup	POST
INSERT INTO user_info (
  id
  , pwd
  , email
  , nickname
  , name
) VALUES (:id, :pwd, :email, :nickname, :name);


-- 아이디찾기	/boards/findid	POST
select id
from user_info
where email = :email and name = :name;


-- 비밀번호찾기	/boards/findpw	POST
select pwd
from user_info
WHERE id = :id and email = :email;


-- 댓글달기	/boards/{boardId}/comment	POST
INSERT INTO COMMENT	(
  board_no
  , content
  , user_id
  , depth
)	VALUES (:board_no, :content, :user_id, :depth);

UPDATE comment set comment_group = comment_no where comment_no = :comment_no;


-- 댓글삭제	/boards/{boardId}/comment	DELETE
DELETE from comment where comment_no = :comment_no;


-- cascade 제약조건
ALTER TABLE file_attch_info
ADD CONSTRAINT CAS
FOREIGN KEY ( board_no )
REFERENCES board ( board_no )
ON DELETE CASCADE;