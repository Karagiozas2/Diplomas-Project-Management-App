create table professor
(
    id         int auto_increment
        primary key,
    first_name varchar(45) null,
    last_name  varchar(45) null,
    email      varchar(45) null,
    specialty  varchar(45) null,
    username varchar(45) null
)
    charset = latin1;

