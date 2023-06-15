create table tokens
(
    id      varchar(50) not null
        constraint tokens_pkey
            primary key,
    user_id varchar(50) not null,
    token   varchar(50) not null
);


INSERT INTO public.tokens (id, user_id, token) VALUES ('a2b0f3cc-ba1d-4c55-b94c-0238aa9564b5', '2ee40f84-33b6-4051-95b1-7e1459284132', '60b5656a-bec8-41cc-ab11-811022953b6c');
INSERT INTO public.tokens (id, user_id, token) VALUES ('770c5299-eafb-4000-9c25-63c025a824b3', 'e262185f-1fe4-4e7c-82d7-879c72f91760', 'f56dcc7e-9804-4a87-a3a6-25ceb660fe72');
INSERT INTO public.tokens (id, user_id, token) VALUES ('218f7fd2-23d6-426e-a96e-685df0245968', '83fb0723-f87e-464f-8e6d-75cb45143449', 'bf109dd8-fe46-4e4a-a9d6-de2ffe336479');
INSERT INTO public.tokens (id, user_id, token) VALUES ('c972cc5a-95d4-4f08-ae23-370333078d8a', '5c3282d5-b69c-4620-8480-53f6d52659ba', 'd8b7fc82-3446-4fa3-be34-5984bbf17269');
INSERT INTO public.tokens (id, user_id, token) VALUES ('69a98c5a-5b9b-4612-b164-4de645f0ac45', '7e56d7d8-78f2-4487-b7f5-8e8fcb972ec9', '60e8119a-fe3c-462a-bdf0-dd941d3394a7');
INSERT INTO public.tokens (id, user_id, token) VALUES ('7e190f65-d9d5-404b-a197-51163f55e47b', '905d6b93-8048-4a34-a9b4-aba50b5f22da', '39c9fc77-7d61-4fe7-8b71-382e22034b83');
INSERT INTO public.tokens (id, user_id, token) VALUES ('5615b445-196d-4430-b58f-a6eecc37536b', '6a473cf0-f650-43f1-a630-3af8069498fc', 'c15c421b-39d7-40fd-abb9-2d2ae9d71283');
INSERT INTO public.tokens (id, user_id, token) VALUES ('71174a87-6d9a-4250-9f89-9f812336664d', '74ca2947-316b-4b42-bee7-70b87c44adb3', '97122016-468a-40be-a8e4-5f6b249c3e3f');