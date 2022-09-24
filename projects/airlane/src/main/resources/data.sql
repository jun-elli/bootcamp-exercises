-- default credentials user/123
insert into user (password, username) values ('$2a$10$gMtf7P0819c9cbs0NfR9FOI.ojQcLeh4UcxHkwSFzb7WSRNlY5mgG', 'user');

insert into role(name, user_id) values ("ADMIN", 1);
insert into role(name, user_id) values ("USER", 1);
