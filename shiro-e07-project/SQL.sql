--t_user
create table t_user(
       id number(38) primary key,
       username varchar2(200),
       password varchar2(200),
       status number(38)
);
create sequence seq_t_user;
--t_role
create table t_role(
       id number(38) primary key,
       name varchar2(200)
);
create sequence seq_t_role;
--t_resource
create table t_resource(
       id number(38) primary key,
       name varchar2(200),
       permission varchar2(200),
       url varchar2(200)
);
create sequence seq_t_resource;
--t_user_role
create table t_user_role(
       id number(38) primary key,
       user_id number(38),
       role_id number(38)
);
create sequence seq_t_user_role;
--t_role_res
create table t_role_res(
       id number(38) primary key,
       role_id number(38),
       res_id number(38)
);
create sequence seq_t_role_res;
