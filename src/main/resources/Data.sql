INSERT INTO roles VALUES(1,'ROLE_ADMIN');
INSERT INTO roles VALUES(2,'ROLE_USER');
INSERT INTO users  (USERNAME,PASSWORD,NOM) VALUES ('issam','issam','issam ben messaoud');
INSERT INTO users  (USERNAME,PASSWORD,NOM) VALUES ('moh','moh','moh ben messaoud');
INSERT INTO user_roles (user_id,role_id) VALUES (1,1);
INSERT INTO user_roles (user_id,role_id) VALUES (2,2);
INSERT INTO users  (USERNAME,PASSWORD,NOM,ETAT) VALUES ('za','za','zaaaaaa','LIBRE');

