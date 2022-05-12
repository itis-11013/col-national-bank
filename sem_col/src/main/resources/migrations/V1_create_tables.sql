create table country
(
    id   bigint not null
        primary key,
    code varchar(255),
    name varchar(255)
);

alter table country
    owner to postgres;

create table nationalbank
(
    innerid    bigint not null,
    id         bigint not null,
    address    varchar(255),
    country_id bigint
        constraint fkpvptn88de7lbjbn9nfnkren5g
            references country,
    primary key (innerid, id)
);

alter table nationalbank
    owner to postgres;

create table organization
(
    innerid    bigint not null,
    id         bigint not null,
    address    varchar(255),
    password   varchar(255),
    country_id bigint
        constraint fkodgf9ldern0bvgyin3xpcvwye
            references country,
    primary key (innerid, id)
);

alter table organization
    owner to postgres;

create table acount
(
    id              bigint not null
        primary key,
    amount          bigint,
    currency        varchar(255),
    nationalbank_id bigint,
    country_id      bigint,
    organization_id bigint,
    constraint fkapghgyueuqc6tmoaf3i16edvl
        foreign key (nationalbank_id, country_id) references nationalbank,
    constraint fk4cyum18pfwj0wxsyic2mxp75t
        foreign key (organization_id, country_id) references organization
);

alter table acount
    owner to postgres;

create table units
(
    id   bigint not null
        primary key,
    code varchar(255),
    type varchar(255)
);

alter table units
    owner to postgres;

create table product
(
    innerid         bigint not null,
    id              bigint not null,
    code            varchar(255),
    count           integer,
    name            varchar(255),
    price           bigint,
    unit            varchar(255),
    organization_id bigint,
    country_id      bigint,
    unit_id         bigint
        constraint fkert3rp0wapn5pl45xsbbp3ws5
            references units,
    primary key (innerid, id),
    constraint fk27o3ig787s5e9oqktxi01x2uk
        foreign key (organization_id, country_id) references organization
);

alter table product
    owner to postgres;
