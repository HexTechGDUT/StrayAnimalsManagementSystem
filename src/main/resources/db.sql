create database stray_animals_management_system character set utf8;

drop table location;
drop table animal;
drop table `user`;

create table `user` (
    uid varchar(16) not null primary key comment '用户帐号',
    name varchar(12) not null comment '用户名',
    pwd varchar(16) not null comment '密码',
    phone varchar(11) not null comment '电话号',
    email varchar(254) comment '邮箱',
    # 若不指定身份权限，默认为普通用户
    auth enum ('ORDINARY', 'ADMIN', 'FORBID') comment '身份权限',
    last_update_time datetime not null comment '最后更新时间'
) comment '用户';

create table animal (
    animal_id varchar(16) not null primary key comment '动物id',
    name varchar(12) not null comment '动物名字',
    age tinyint comment '年龄',
    appearance varchar(50) not null comment '外貌',
    introduction varchar(50) comment '介绍',
    # 若不指定动物状态，默认为待领养
    animal_status enum('STRAY', 'ADOPTED', 'LOST', 'RETAIN') not null comment '动物状态',
    is_healthy boolean not null default true comment '是否健康',
    last_update_time datetime not null comment '最后更新时间'
) comment '动物';

create table location (
    id varchar(16) not null primary key comment '地址id',
    uid varchar(16) comment '用户id',
    animal_id varchar(16) comment '动物id',
    # 若不指定所在区域，默认在西区
    zone enum ('WEST', 'EAST') comment '所在区域',
    specific_locate varchar(20) comment '精确地址',
    update_time datetime not null comment '更新时间',

    foreign key (uid) references user(uid) ,
    foreign key (animal_id) references animal(animal_id)
) comment '地址';