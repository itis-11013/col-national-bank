create table organization
(
    id         bigint not null,
    innerid    uuid   not null,
    address    varchar(255),
    name       varchar(255),
    password   varchar(255),
    country_id bigint
        constraint fkodgf9ldern0bvgyin3xpcvwye
            references country,
    primary key (id, innerid)
);

alter table organization
    owner to postgres;

INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (1, 'efb816c6-d6bf-11ec-9d64-0242ac120002', 'street 102', 'admin', '$2a$10$8EpHGDGiWSNguyVW0NrMm.CLR8t8LiwPIDi62EPb1fhs7/.VQin36', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (6, 'cd92aa8d-a5d5-4f1a-b46f-8deb294b4eba', 'pespis', 'camilo', '4200', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (7, '5dc7a8a5-1b54-4be1-8436-a8232b7d077c', 'street 1281', 'KevinBarrero', '$2a$10$WjGNRhdx/XQCvb2KPpLV8.hOpVT61hCYPTPSMlPiMpHmeGCGogCl6', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (8, '11d139ab-fea2-44db-b94d-1ba3b8e87694', 'ajsaj', 'trolelcio', '$2a$10$DxaYOeYkbdJdlcoM2mrACO1ptxlZUzHd3mXVUCxBTVXJ13qvHIN/q', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (9, '418ad4ca-4f3b-41ef-957b-546b31f01d87', 'ksjjdj', 'lalsll', '$2a$10$GqkObdhYsn6V1XoBBNo1weGy2Wkqpl2V6Z6rQt0P9NWzq0eb5JPm.', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (10, '3f201fad-2aab-4d08-aaad-202147e86baf', 'street 2121', 'tapitas', '$2a$10$I7g41RoC8y81enegWbYr5O5XvOGtHcFlcEUEUuh3Vsf3AuMleggDu', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (11, '4e3f7696-1ef0-42e9-8e54-b96c5b5c4968', 'street 2121', 'tapitas', '$2a$10$uBLeU9G/fN5ZJNt5eGBIBO8uAoGdGdtjKEC6si/48rVZp9gsoimpa', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (12, '832a0194-9e36-4dc6-9d0a-599fad3479d4', 'jsjjja', 'ajsjj', '$2a$10$SXZioOPxo/cBv/9hUGW/WertooWwxFDolnvuhwPUaV780jKIF55n6', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (13, '193bd6db-7c99-4db0-926f-5c614d3140f4', 'nnsnann', 'samm', '$2a$10$.f1kIxabxS9vla7quMq7oePxFWPTqV5ThirV8JWYC8OpsYdu8bWqW', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (14, 'e181b8bb-27cb-4f3d-ae87-2666484f0acf', 'snnnsnam', 'sammm', '$2a$10$/C9ipGztOohcCBhZDeOhweJGMZBa/nzCbK1VHpALAo7nw26rmOic6', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (15, '54443c2a-81f6-4080-9faa-d8ea248a2461', 'smskkka', 'smmam', '$2a$10$fDzG27HeVVzds9aHNIjRiOSJz3ex.c0BPPK3xDHssmd40.AZ8NsV.', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (16, '21a84ce6-156d-4150-9e4e-6912ac18e466', 'smskkka', 'smmam', '$2a$10$Wy8P.6JJpshETQUQ7Cr.ZuzgRkt6.8pyqbEXGP9MEt1sFOUkE89vi', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (17, '6fe60870-b738-4633-b03c-7e067adf6cae', 'msmamm', 'samm', '$2a$10$OEV3eP9OQWf/uXmfvKE6UeNB2cg0FbDXHQWQOP8xdi4kpWkI8oNDy', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (18, '06cd9dc6-77a5-4ac4-ba5b-61c12eae4b6f', 'ms', 'sammm', '$2a$10$WvAeWmSLNHxoOK.wrkx/4uRISUgOGGovUdux/3v46yN9zTrvlvleq', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (19, '431fb543-6e2d-4843-a3e1-c0b4f0058abc', 'mmmsamm', 'sammm', '$2a$10$iSTHxPJbZIzamYb49sDbDuHDwe6QQqwl7qs1.iPGsVONsRuDMrlBK', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (20, '617c95ad-5166-4ac3-93b1-1fbd5f83c9d7', 'kazan', 'dianita', '$2a$10$U/F9MvA/q5tZtU/8C8Ytme9dE76oUPKzUc0ytiM.ZYpprN9bmHPdG', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (21, '5188c24a-1c27-4d53-a6ce-40432cf693b5', 'Bogota calle 121/ 12', 'OrgCoprobe', '$2a$10$DKUCn4JmYSoYrSsi29MWB.qOwIw3YKaEHzzMlG8F0LuAAWwvDbmmW', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (24, '4302ccd7-c1c3-4d96-84e9-ff1520381f4c', 'street 12121', 'test', '$2a$10$NNpzBV9VsUiMiCbtrOE/.uxSJBSfTk6.L0mjT5ZPkwBa3PKkJMEW.', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (26, '773a8478-a3f0-4a5b-bb6f-9688a31e37b1', 'Street 2121', 'kevincitoCORP', '$2a$10$EajBecgF8IhTIxD51DSKm.F5nwXIWt75H75v/Zqxa5tJcGxf9/KzG', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (27, '7eb0721a-f3d7-4d3e-98e9-80678e015593', 'street 9993', 'prueba121', '$2a$10$FjI4vWBdmcL9TS9tPcBW9.2p/Lq7OtcduicrIj8STPGC62k9nPEma', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (28, 'baffeff7-0017-4554-ac6d-d38d5f2415f1', 'street 9993', 'itiscop', '$2a$10$BO4tQwjXbrRuCEN4hSbZFu9AkU08n5vEfx3FR/eDKHTaJ/pHH8JFa', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (29, 'e327424d-2809-435f-bda2-321a12a548d9', 'lsllamk', 'lsolal', '$2a$10$63tw1UX1ZMjnWGGn7JwdxeQMnPCBAXB2NGkHXJ7Um5hn7OGpukx6y', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (31, '8cd90d0a-5990-412a-bbee-33afbfc2ffa4', 'loslla', 'kevin', '$2a$10$37TYlbjAUx6ld9V2D0OaEOPFQXqHsM7E66vccAGM81o63AULLiMmG', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (32, 'ebb2f857-f612-46c5-8269-147aeb1857a0', 'street 12121', 'kevin2', '$2a$10$M03MZsU65gvB.ETcP28x6OQTVxfrt1Nwv.yHAtjlB5Mvb/wMxZJpG', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (33, '29e98781-616f-46ab-bc1d-5d0c771b7580', '88281', 'probe121', '$2a$10$gx8mJodrFUxxsa.LBhJ5buXwmFpKshye49yVcLyIbghrxLEI72y9S', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (35, '425d250a-9196-4da6-99e5-257828681b2f', 'street 12121', 'pueba ', '$2a$10$kaxAXll.LuTAnEFndc40Ve9kg51Luk8WNkO4qXI3ikGJIajSYQW3K', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (37, 'dac2fded-bfd0-4c6f-b467-607236d87b71', 'calle200', 'kevin3', '$2a$10$4drTEUpBBCz1CJ4xz1Oav.sb/fh0jNxOFBDDDBG/T23vTIC3u2aOe', 1);
INSERT INTO public.organization (id, innerid, address, name, password, country_id) VALUES (38, 'f98caacb-9f18-40d5-abc7-16752fa07ae2', 'street 2121', 'kevin4', '$2a$10$owHsBWbHx4WsDvYZKNkmW.edCuIu7iWNSRss8WPXK4I6jhMhaJh1q', 1);
