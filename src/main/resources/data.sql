INSERT INTO tb_user (name, email, password) VALUES ('Bob Yellow', 'bob@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (name, email, password) VALUES ('Ana Green', 'ana@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_VISITOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_MEMBER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_genre (name) VALUES ('Action');
INSERT INTO tb_genre (name) VALUES ('Thriller');

INSERT INTO tb_movie (title, sub_title, year, img_Url, synopsis, genre_id) VALUES ('O Enfermeiro da Noite','',2022,'https://www.oficinadanet.com.br/imagens/post/23817/o-enfermeiro-da-noite.jpg','Uma história comovente e assustadora de uma pessoa com uma frieza questionável', 2);

INSERT INTO tb_review (text, user_id, movie) VALUES ('Good Movie', 2, 1);