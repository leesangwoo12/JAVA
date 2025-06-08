


DROP TABLE IF EXISTS board_info_table;

CREATE TABLE board_info_table (
    board_info_idx INT PRIMARY KEY AUTO_INCREMENT,
    board_info_name VARCHAR(500) NOT NULL
);

-- 수동으로 PK 지정 시 AUTO_INCREMENT 의미 없음. AUTO_INCREMENT 원하면 idx 생략.
INSERT INTO board_info_table (board_info_idx, board_info_name) VALUES (1, '자유게시판');
INSERT INTO board_info_table (board_info_idx, board_info_name) VALUES (2, '유머게시판');
INSERT INTO board_info_table (board_info_idx, board_info_name) VALUES (3, '정치게시판');
INSERT INTO board_info_table (board_info_idx, board_info_name) VALUES (4, '스포츠게시판');

DROP TABLE IF EXISTS user_table;

CREATE TABLE user_table (
    user_idx INT PRIMARY KEY AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    user_id VARCHAR(100) NOT NULL,
    user_pw VARCHAR(100) NOT NULL
);

-- 수동 삽입 (시퀀스 없이 자동 증가 또는 직접 입력)
INSERT INTO user_table (user_idx, user_name, user_id, user_pw) VALUES (1, 'soldesk', 'soldesk', 'soldesk');
DELETE FROM user_table;

DROP TABLE IF EXISTS content_table;

CREATE TABLE content_table (
    content_idx INT PRIMARY KEY AUTO_INCREMENT,
    content_subject VARCHAR(100) NOT NULL,
    content_text VARCHAR(500) NOT NULL,
    content_file VARCHAR(500) NOT NULL,
    content_writer_idx INT NOT NULL,
    content_board_idx INT NOT NULL,
    content_date DATE NOT NULL,
    FOREIGN KEY (content_writer_idx) REFERENCES user_table(user_idx),
    FOREIGN KEY (content_board_idx) REFERENCES board_info_table(board_info_idx)
);

