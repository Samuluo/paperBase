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
    answer  varchar(6)   null,
    score   int          null
);