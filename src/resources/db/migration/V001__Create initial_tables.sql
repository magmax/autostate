create table project (
    id int primary key auto_increment,
    name varchar(100) not null,
);

create table status (
    id int primary key auto_increment,
    name varchar(100) not null,
);

create table current_status (
    project_id int,
    status_id int,
    constraint current_status_pk_1 primary key (project_id, status_id),
    constraint current_status_fk_1 foreign key (project_id) references project (id),
    constraint current_status_fk_2 foreign key (status_id)  references status (id),
);

create table transitions (
    origin_id int,
    target_id int,
    constraint transitions_pk_1 primary key (origin_id, target_id),
    constraint transitions_fk_1 foreign key (origin_id, target_id) references status (id),
);
