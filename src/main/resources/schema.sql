create table user
(
   userId integer not null AUTO_INCREMENT,
   name varchar(255) not null,
   surname varchar(255) not null,
   salary integer not null,
   primary key(userId)
);

create table project
(
   projectId integer not null AUTO_INCREMENT,
   projectName varchar(255) not null,
   primary key(projectId)
);


