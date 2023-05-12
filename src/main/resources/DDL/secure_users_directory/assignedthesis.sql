create table assignedthesis
(
    id           int auto_increment
        primary key,
    title        varchar(500) null,
    student_id int not null,
    professor_id int          not null,
    implementation_grade double null,
    report_grade double null,
    presentation_grade double null,
    total_grade double null,

    foreign key (professor_id) references secure_users_directory.professor (id)
    on update cascade on delete cascade,
    foreign key (student_id) references secure_users_directory.student (id)
    on update cascade on delete cascade
)
    charset = latin1;

