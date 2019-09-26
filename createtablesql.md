create table if not exists t_user(
id varchar(40) comment '用户id' primary key auto_increment,
name varchar(100) comment '用户昵称',
password varchar2(40) comment '密码'
)
engine=Innodb default charset=utf8;

create table if not exists t_friend(
uid varchar(40) comment '用户id',
fid varchar(40) comment '朋友id',
status int comment '状态(0-解除，1-是)',
primary key(uid,fid)
)
engine=Innodb default charset=utf8;

create table if not exists t_blog(
bid varchar(40) comment '博客id' primary key,
uid varchar(40) comment '用户Id',
bname varchar(4000) comment '博客名称',
text varchar(4000) comment '博客内容',
status int comment '博客状态(0-删除，1-使用)',
update_time date comment '更新时间'
)
engine=Innodb default charset=utf8;

create table if not exists t_comment(
cid varchar(40) comment '评论id' primary key,
bid varchar(40) comment '博客id',
uid varchar(40) comment '评论人id',
text varchar(4000) comment '评论内容',
status int comment '评论状态(0-删除，1-使用)',
update_time date comment '更新时间'
)
engine=Innodb default charset=utf8;
