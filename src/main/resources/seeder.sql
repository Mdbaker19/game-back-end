create database if not exists apiBase;
# drop database apiBase;
use apiBase;


insert into users (name, lvl, player_lvl, player_image) values ('matt', 1, 2, 'https://images.ctfassets.net/hrltx12pl8hq/61DiwECVps74bWazF88Cy9/2cc9411d050b8ca50530cf97b3e51c96/Image_Cover.jpg?fit=fill&w=480&h=270');
insert into users (name, lvl, player_lvl, player_image) values ('mandy', 1, 1, 'https://images.ctfassets.net/hrltx12pl8hq/61DiwECVps74bWazF88Cy9/2cc9411d050b8ca50530cf97b3e51c96/Image_Cover.jpg?fit=fill&w=480&h=270');

insert into items (cost, name) VALUES (5, 'potion');
insert into items (cost, name) VALUES (10, 'antidote');
insert into items (cost, name) VALUES (15, 'bomb');

insert into user_to_items (user_id, item_id) VALUES (1, 1);
insert into user_to_items (user_id, item_id) VALUES (1, 2);
insert into user_to_items (user_id, item_id) VALUES (1, 1);
insert into user_to_items (user_id, item_id) VALUES (2, 3);
insert into user_to_items (user_id, item_id) VALUES (2, 2);
insert into user_to_items (user_id, item_id) VALUES (2, 2);
insert into user_to_items (user_id, item_id) VALUES (2, 3);
insert into user_to_items (user_id, item_id) VALUES (2, 3);

insert into accounts (account_name) values ('matt');

insert into save_states (data, account_id) values ('{"id":1,"lvl":1,"playerLvl":2,"name":"matt","playerImage":"https://images.ctfassets.net/hrltx12pl8hq/61DiwECVps74bWazF88Cy9/2cc9411d050b8ca50530cf97b3e51c96/Image_Cover.jpg?fit=fill&w=480&h=270","inventory":[{"id":1,"name":"potion","cost":5.0},{"id":1,"name":"potion","cost":5.0},{"id":2,"name":"antidote","cost":10.0}]}', 1);
insert into accounts_save_state_list (account_id, save_state_list_id) VALUES (1, 1);