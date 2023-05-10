create table student
(
    id                                         int auto_increment
        primary key,
    first_name                                 varchar(45) null,
    last_name                                  varchar(45) null,
    email                                      varchar(45) null,
    year_of_studies                            int         null,
    current_average_grade                      int         null,
    number_of_remaining_courses_for_graduation int         null,
    username text not null
)
    charset = latin1;

