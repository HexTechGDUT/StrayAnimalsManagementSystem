create database stray_animals_management_system character set utf8;

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
    upload_user varchar(16) not null comment '上传该动物的用户id',
    last_update_time datetime not null comment '最后更新时间',

    foreign key (upload_user) references user(uid)
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

create table animal_picture (
    animal_id varchar(16) not null comment '动物id',
    pic_path varchar(50) not null comment '存储路径',
    upload_time datetime not null comment '上传时间',

    foreign key (animal_id) references animal(animal_id)
)comment '动物图片';

create table comment (
    id varchar(16) not null primary key comment '评论id',
    uid varchar(16) not null comment '用户id',
    animal_id varchar(16) not null comment '动物id',
    # parent_id varchar(16) comment '父评论id',
    comment_str varchar(50) not null comment '评论内容',
    publish_time datetime not null comment '发布时间',

    foreign key (uid) references user(uid),
    foreign key (animal_id) references animal(animal_id)
)comment '评论';

create table application (
    apply_id varchar(16) not null primary key comment '申请id',
    uid varchar(16) not null comment '申请用户id',
    animal_id varchar(16) not null comment '相关动物id',
    # 默认申请类型：领养
    type enum('ADOPT', 'ABANDON', 'LOST', 'RECALL') not null comment '申请类型',
    brief_info varchar(50) not null comment '简要描述',
    apply_time datetime not null comment '申请时间',
    # 默认申请状态：等待处理
    status enum('WAIT', 'PROCESSING', 'FINISHED', 'CANCEL') not null comment '申请状态',

    foreign key (uid) references user(uid),
    foreign key (animal_id) references animal(animal_id)
)comment '申请';

create table answer (
    apply_id varchar(16) not null comment '申请id',
    uid varchar(16) not null comment '处理人id',
    # 默认回复：申请不通过
    answer_type enum('REJECT', 'PERMIT') not null comment '回复类型',
    details varchar(50) not null comment '详细信息',
    answer_time datetime not null comment '回复时间',

    foreign key (apply_id) references application(apply_id),
    foreign key (uid) references user(uid)
)comment '回复';

create table article(
    id varchar(16) not null primary key comment '文章id',
    # 默认类型：相关知识TIPS
    type enum('TIPS', 'INTRO', 'GUIDE') not null comment '文章类型',
    article_path varchar(50) not null comment '存储路径',
    uid varchar(16) not null comment '发布者id',
    update_time datetime not null comment '更新时间',

    foreign key (uid) references user(uid)
)comment '文章';