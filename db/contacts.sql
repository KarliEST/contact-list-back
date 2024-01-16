create table contacts
(
    id           integer generated always as identity,
    first_name   varchar not null,
    last_name    varchar not null,
    code_name    varchar not null,
    phone_number varchar not null
);


INSERT INTO public.contacts (first_name, last_name, code_name, phone_number) VALUES ('Ben', 'Dover', 'bender', '+555 55555555');
INSERT INTO public.contacts (first_name, last_name, code_name, phone_number) VALUES ('Post', 'Man', 'testman', '+122 4578765');
INSERT INTO public.contacts (first_name, last_name, code_name, phone_number) VALUES ('Kärol', 'Mõru', 'Ölü', '+1231354646');
INSERT INTO public.contacts (first_name, last_name, code_name, phone_number) VALUES ('Luke', 'Skywalker', 'Jedi', '+101 101010101');
INSERT INTO public.contacts (first_name, last_name, code_name, phone_number) VALUES ('Ívarr', 'Beinlausi', 'boneless', '+87654321');
INSERT INTO public.contacts (first_name, last_name, code_name, phone_number) VALUES ('Юрий', 'Живаго', 'Доктор', '+1 12345678');
INSERT INTO public.contacts (first_name, last_name, code_name, phone_number) VALUES ('Michael', 'Jordan', 'goat', '+99 987654321');
INSERT INTO public.contacts (first_name, last_name, code_name, phone_number) VALUES ('K@spar', 'K€€rup', '80085', '+95 95959595');
INSERT INTO public.contacts (first_name, last_name, code_name, phone_number) VALUES ('Ιάσονας', 'Αίσονα', 'Αργοναυτικής', '+1111 65165161');
INSERT INTO public.contacts (first_name, last_name, code_name, phone_number) VALUES ('Templeton', 'Peck', 'Faceman', '+121 213465464');
INSERT INTO public.contacts (first_name, last_name, code_name, phone_number) VALUES ('Dwayne', 'Johnson', 'The Rock', '+55 12124154');
