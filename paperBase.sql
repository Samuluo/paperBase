create table user
(
    id varchar(32) not null primary key
);

create table paper
(
    id      int auto_increment primary key,
    type    int          null,
    content varchar(512) null,
    optionA varchar(256) null,
    optionB varchar(256) null,
    optionC varchar(256) null,
    optionD varchar(256) null,
    optionE varchar(256) null,
    optionF varchar(256) null,
    answer  varchar(6)   null
);


create table record
(
    id            int auto_increment primary key,
    user_id       varchar(32) null,
    paper_id      int         null,
    origin_answer varchar(6)  null,
    foreign key (user_id) references user (id),
    foreign key (paper_id) references paper (id)
);

create table exam
(
    id          int auto_increment primary key,
    user_id     varchar(32) null,
    record_id1  int         null,
    record_id2  int         null,
    record_id3  int         null,
    record_id4  int         null,
    record_id5  int         null,
    record_id6  int         null,
    record_id7  int         null,
    record_id8  int         null,
    record_id9  int         null,
    record_id10 int         null,
);