create table users
(
    id       varchar(50)  not null
        constraint users_pkey
            primary key,
    login    varchar(100) not null,
    email    varchar(30),
    password varchar(128) not null,
    username varchar(30)  not null,
    salt     varchar(16)  not null
);


INSERT INTO public.users (id, login, email, password, username, salt) VALUES ('5c3282d5-b69c-4620-8480-53f6d52659ba', 'denidsd', 'testsdfsdfd@test.ru', 'd59932edcad474dd4430e0c786ee3a856a34957f3bce7440dfcb77f87aa59c4af8a178b0b6714bb208ea1328871d8dc8e8024dce4efba0fb90199e2e20c0bab9', 'denidsd', 'qQjISuRR3FcbsDG3');
INSERT INTO public.users (id, login, email, password, username, salt) VALUES ('7e56d7d8-78f2-4487-b7f5-8e8fcb972ec9', 'denids', 'testsdfsdfd@test.ru', '5d2e8948445cddbe4e9d0cca8ac8ab40d3aa90fb73fbe282f2edd28165213ae13fb5269fda05dd2af00af8d44ab8d8ffa996b2db564198027013ef1c1001a6c2', 'denids', 'X6l7nD4ViMhrc0Im');
INSERT INTO public.users (id, login, email, password, username, salt) VALUES ('905d6b93-8048-4a34-a9b4-aba50b5f22da', 'denidsdfs', 'testsdfsdfd@test.ru', '73c001aa84983a6b1862746ad052516cd511324b31f8da88624c54c146adb961bccd81b5b72a10d414fdaf1d737a1cbdeba244d0ef2ff0da8f4fde7013a2b8f5', 'denidsdfs', 'DhudyQOy3LdKxBKY');
INSERT INTO public.users (id, login, email, password, username, salt) VALUES ('6a473cf0-f650-43f1-a630-3af8069498fc', 'we', 'testsdfsdfd@test.ru', '130be1907af967ab117da609528dc1cc54535b806d7c0f3d58d495a8b795126bec587eaf54151ac7e43ed958a0f45a49eabd3e190dbb0b8c358edada7a40a9d3', 'we', 'WYOeMUiXZ14GfkfB');
INSERT INTO public.users (id, login, email, password, username, salt) VALUES ('74ca2947-316b-4b42-bee7-70b87c44adb3', 'wesss', 'testsdfsdfd@test.ru', '8cb28ce9e424996cff94a77358161028ecf3c23afd418a5ef4205758378061ddcd8478f19ef8ca48c83d86e15c464803cab820edc54c2221b64b7eea8aa2b1c6', 'wesss', 'sRHLVZJqxW8JV9MS');