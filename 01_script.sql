
create table tasks (
    id          varchar(50) not null
        constraint tasks_pkey
            primary key,
    label       varchar(100),
    description text,
    deadline_dt timestamp with time zone,
    completed   boolean
);

INSERT INTO public.tasks (id, label, description, deadline_dt, completed) VALUES ('11a77932-7b0e-4bcb-bfb5-9a30bc64a406', 'Новая задача', '', null, true);
INSERT INTO public.tasks (id, label, description, deadline_dt, completed) VALUES ('95ffcdca-cc80-40d6-8718-c7a5dda6dcc9', 'Новая задача', '', null, true);
INSERT INTO public.tasks (id, label, description, deadline_dt, completed) VALUES ('1b9957a4-6a4c-40aa-b130-f7fe88f2cd45', 'Таска', 'Описание', null, true);
INSERT INTO public.tasks (id, label, description, deadline_dt, completed) VALUES ('826818ce-a8be-439c-8734-b413b37f1cd0', 'Очередная задача', '', null, true);
INSERT INTO public.tasks (id, label, description, deadline_dt, completed) VALUES ('e05d45bb-62e5-4062-8c3f-3f8940568325', 'Задача', 'С описанием', null, true);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO postgres