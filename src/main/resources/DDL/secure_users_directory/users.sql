create table users
(
    id        int auto_increment
        primary key,
    user_name text null,
    password  text null,
    role      text null
)
    charset = latin1;

