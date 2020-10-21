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

create table commit
(
    projectId integer not null,
    userId integer not null,
    day date not null,
    commitCount integer not null,
    primary key(projectId, userId, day),
    FOREIGN KEY(userId) REFERENCES user(userId),
    FOREIGN KEY(projectId) REFERENCES project(projectId)
);

create table project_user(
    projectId integer not null,
    userId integer not null,
    primary key(userId, projectId),
    FOREIGN KEY(userId) REFERENCES user(userId),
    FOREIGN KEY(projectId) REFERENCES project(projectId)
);


