
create table thesis_directory.thesis
(
    id           int auto_increment
        primary key,
    title        varchar(500) null,
    objectives   varchar(45)  null,
    professor_id int          not null,
    constraint fk_thesis_professor_id
        foreign key (professor_id) references professor_directory.professor (id)
            on update cascade on delete cascade
)
    charset = latin1;

