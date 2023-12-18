create table organizer
(
    login    varchar(45)  not null
        constraint organizer_pkey
            primary key,
    org_name varchar(45)  not null,
    password varchar(255) not null
);

create table sessions
(
    login   varchar(255)                        not null
        constraint sessions_pkey
            primary key
        constraint sessions_organizer_login_fk
            references organizer
            on update cascade on delete cascade,
    date    timestamp default CURRENT_TIMESTAMP not null,
    session varchar(255)                        not null
);

create table visitor
(
    id_v         serial      not null
        constraint visitor_pkey
            primary key,
    visitor_name varchar(45) not null,
    email        varchar(45) not null
        constraint visitor_email_key
            unique
);

create table event
(
    id_e        serial      not null
        constraint event_pkey
            primary key,
    event_name  varchar(45) not null,
    date        timestamp   not null,
    organizer_n varchar(45) not null
        constraint org_fk
            references organizer
            on update cascade on delete cascade,
    location    varchar(45) not null,
    vis_count   integer default 0
);

create table registration
(
    id_r      serial  not null
        constraint registration_pkey
            primary key,
    event_n   integer not null
        constraint event_fk
            references event
            on update cascade on delete cascade,
    visitor_n integer not null
        constraint visitor_fk
            references visitor
            on update cascade on delete cascade,
    reg_time  timestamp
);

create function update_vis_count() returns trigger
    language plpgsql
as
$$
BEGIN
    UPDATE event
    SET vis_count = vis_count + 1
    WHERE id_e = NEW.event_n;
    RETURN NEW;
END;
$$;

create trigger registration_after_insert
    after insert
    on registration
    for each row
execute procedure update_vis_count();

create function decrease_vis_count() returns trigger
    language plpgsql
as
$$
BEGIN
    UPDATE event
    SET vis_count = vis_count - 1
    WHERE id_e = OLD.event_n
      AND vis_count > 0;
    RETURN OLD;
END;
$$;

create trigger registration_after_delete
    after delete
    on registration
    for each row
execute procedure decrease_vis_count();

