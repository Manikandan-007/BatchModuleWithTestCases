create table trainers (id int primary key auto_increment,
name varchar(50) not null,
mobile bigint not null unique,
email varchar(50) not null,
created_on timestamp default now());

create table candidate (id int primary key auto_increment,
name varchar(50) not null,
mobile bigint not null unique,
email varchar(50) not null,
created_on timestamp default now());

create table batches (id int primary key auto_increment,
name varchar(50) not null,
start_date timestamp not null,
end_date timestamp not null,
trainer_id int not null,
active_hrs int not null,
start_time time not null,
created_on timestamp default now(),
foreign key (trainer_id) references trainers(id));

create table days (id int primary key auto_increment,
day varchar(50) not null
);

create table active_day (id int primary key auto_increment,
day_id int not null,
batch_id int not null,
foreign key (day_id) references days(id),
foreign key (batch_id) references batches(id)
);

create table cotrainers (id int primary key auto_increment,
trainer_id int not null,
batch_id int not null,
foreign key (trainer_id) references trainers(id),
foreign key (batch_id) references batches(id)
);

create table batch_trainees (id int primary key auto_increment,
batch_id int not null,
candidate_id int not null,
active_status bool default 1,
added_on timestamp default now(),
foreign key (batch_id) references batches(id),
foreign key (candidate_id) references candidate(id)
);