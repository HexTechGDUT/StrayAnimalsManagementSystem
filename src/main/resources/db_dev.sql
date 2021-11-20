create database stray_animals_management_system character set utf8;

drop database stray_animals_management_system;

create table `user`(
    id int not null primary key auto_increment,
    user_id varchar(16) not null comment '用户id',
    user_name varchar(12) not null default 'user' comment '用户名',
    phone_number varchar(16) not null comment '电话号',
    password varchar(16) not null comment '密码',
    # 默认为普通用户：0普通用户，1管理员
    user_type int not null default 0 comment '用户类型',
    contact_address varchar(50) not null comment '联系地址',
    additional_information text null default null comment '额外信息',
    create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
    update_time timestamp not null default current_timestamp comment '更新时间'
)comment '用户';

create table animal_record (
    id int not null primary key auto_increment,
    user_id varchar(16) not null comment '上传该记录的用户id',
    previous_record_id int null default null comment '该动物更早的记录的id',
    # 若为弃养动物则为null
    found_date timestamp null default null comment '发现的时间',
    # 若为弃养动物则为null
    last_address varchar(50) null default null comment '最后出现的地址',
    # 猫，狗的品种等
    animal_type varchar(10) not null comment '动物类型',
    additional_information text null default null comment '额外信息',
    # 动物目前的状态
    # 流浪动物：0:未被领养；1已被领养
    # 寻找丢失动物：0:未找到，1已找到
    # 弃养：0:未被领养，1已被领养，2放弃弃养
    status int not null comment '动物状态',
    # 为流浪动物，还是弃养动物，还是寻找失去的宠物
    record_type varchar(10) not null comment '记录类型',
    create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
    update_time timestamp not null default current_timestamp comment '更新时间'

)comment '动物记录';

create table animal_img (
    id int not null primary key auto_increment,
    animal_record_id int not null comment '动物记录id',
    name varchar(16) null default null comment '名字',
    path varchar(50) not null comment '存储路径',
    create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
    update_time timestamp not null default current_timestamp comment '更新时间'

)comment '动物图片';

create table application (
    id int not null primary key auto_increment,
    user_id varchar(16) not null comment '申请的用户id',
    animal_record_id int not null comment '相关动物记录id',
    information text null default null comment '申请的具体信息',
    type int not null comment '申请类型',
    # 默认申请状态为等待处理
    status int not null default 0 comment '申请状态',
    create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
    update_time timestamp not null default current_timestamp comment '更新时间'

)comment '申请';

create table  tips (
    id int not null primary key auto_increment,
    title varchar(16) not null comment '标题',
    content text not null comment '内容',
    create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
    update_time timestamp not null default current_timestamp comment '更新时间'
)comment '提示';

create table comment (
    id int not null primary key auto_increment,
    animal_record_id int not null comment '评论所属的动物id',
    user_id varchar(16) not null comment '评论的用户id',
    content text not null comment '评论内容',
    previous_comment_id int null default null comment '若为回复的评论，则为被回复的评论id',
    create_time timestamp not null default '0000-00-00 00:00:00' comment '创建时间',
    update_time timestamp not null default current_timestamp comment '更新时间'

)comment '评论';

# 默认三个管理员帐号
insert into user(user_id, user_name, phone_number, password, user_type, contact_address, additional_information, create_time)
values ('admin1', 'admin_name1', '123456', 'admin', 1, 'address1', 'info1', '2021-11-11 11:11:11'),
       ('admin2', 'admin_name2', '123456', 'admin', 1, 'address2', 'info2', '2021-11-11 11:11:11'),
       ('admin3', 'admin_name3', '123456', 'admin', 1, 'address3', 'info3', '2021-11-11 11:11:11');

