INSERT INTO demo(name, age, hobby)
     VALUES ('하니', 14, '달리기');
INSERT INTO demo(name, age, hobby)
     VALUES ('홍길동', 18, '반항');

-- 비밀번호는 media!@34
INSERT INTO member    
     VALUES ('abc', '$2a$10$oagao9FGvso6Jy4bHgzf4.rWSINknboRhC/wRYyOiK3cjcQkEdO/S', '사용자', 'abc@simpolor.com'); 
INSERT INTO member 
     VALUES ('admin', '$2a$10$oagao9FGvso6Jy4bHgzf4.rWSINknboRhC/wRYyOiK3cjcQkEdO/S', '관리자', 'admin@simpolor.com'); 

INSERT INTO member_role
     VALUES ('abc', 'USER');
INSERT INTO member_role
     VALUES ('admin', 'ADMIN');

INSERT INTO role(role_code, role_name)
     VALUES ('USER', '사용자');
INSERT INTO role(role_code, role_name)
     VALUES ('ADMIN', '관리자');

INSERT INTO access(access_url, access_role)
     VALUES ('/member/home', 'USER');
INSERT INTO access(access_url, access_role)
     VALUES ('/member/register', 'USER');
INSERT INTO access(access_url, access_role)
     VALUES ('/admin/home', 'ADMIN');