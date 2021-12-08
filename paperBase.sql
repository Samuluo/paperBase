create table paper
(
    id      int auto_increment primary key,
    type    varchar(32) null,
    content varchar(512) null,
    optionA varchar(256) null,
    optionB varchar(256) null,
    optionC varchar(256) null,
    optionD varchar(256) null,
    optionE varchar(256) null,
    optionF varchar(256) null,
    answer  varchar(6)   null,
    score   int          null,
    creator varchar(256) null,
);

create table mentality_paper
(
    id      int auto_increment primary key,
    type    varchar(32) null,
    exam_id varchar(64)  null,
    content varchar(512) null,
    optionA varchar(256) null,
    optionB varchar(256) null,
    optionC varchar(256) null,
    optionD varchar(256) null,
    optionE varchar(256) null,
    optionF varchar(256) null,
    answer  varchar(6)   null,
    score   int          null,
    creator varchar(256) null,
    foreign key (exam_id) references mentality_exam(id)
);

create table mentality_exam
(
    id       varchar(64) primary key,
    section1 varchar(2048),
    section2 varchar(2048),
    section3 varchar(2048),
    section4 varchar(2048),
    section5 varchar(2048),
    creator  varchar(256)
);