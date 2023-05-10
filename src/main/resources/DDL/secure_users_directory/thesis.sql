create table thesis_directory.thesis
(
    id           int auto_increment
        primary key,
    title        varchar(500) null,
    objectives   varchar(45)  null,
    professor_id int          not null,
        foreign key (professor_id) references secure_users_directory.professor (id)
            on update cascade on delete cascade
)
    charset = latin1;

