INSERT INTO demo(name, age, hobby)
     VALUES ('하니', 14, '달리기');
INSERT INTO demo(name, age, hobby)
     VALUES ('홍길동', 18, '반항');

-- 비밀번호는 media!@34
INSERT INTO member(member_id, member_pw, member_name, member_email, regi_date, del_yn)    
     VALUES ('abc', '$2a$10$oagao9FGvso6Jy4bHgzf4.rWSINknboRhC/wRYyOiK3cjcQkEdO/S', '사용자', 'abc@simpolor.com', now(), 'N'); 
INSERT INTO member(member_id, member_pw, member_name, member_email, regi_date, del_yn)  
     VALUES ('admin', '$2a$10$oagao9FGvso6Jy4bHgzf4.rWSINknboRhC/wRYyOiK3cjcQkEdO/S', '관리자', 'admin@simpolor.com', now(), 'N'); 

INSERT INTO member_role(member_id, member_roles, regi_id, regi_name, regi_date, del_yn)
     VALUES ('abc', 'USER', 'abc', '사용자', now(), 'N');
INSERT INTO member_role(member_id, member_roles, regi_id, regi_name, regi_date, del_yn)
     VALUES ('admin', 'ADMIN', 'admin', '관리자', now(), 'N');

INSERT INTO role(role_code, role_name, regi_id, regi_name, regi_date, del_yn)
     VALUES ('USER', '사용자', 'admin', '관리자', now(), 'N');
INSERT INTO role(role_code, role_name, regi_id, regi_name, regi_date, del_yn)
     VALUES ('ADMIN', '관리자', 'admin', '관리자', now(), 'N');

INSERT INTO access(access_url, access_roles, regi_id, regi_name, regi_date, del_yn)
     VALUES ('/member/info', 'USER', 'admin', '관리자', now(), 'N');
INSERT INTO access(access_url, access_roles, regi_id, regi_name, regi_date, del_yn)
     VALUES ('/admin/home', 'USER, ADMIN', 'admin','관리자', now(), 'N');