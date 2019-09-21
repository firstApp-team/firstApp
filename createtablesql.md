create table if not exists t_user(
id int comment '用户id' primary key auto_increment,
name varchar(100) comment '用户昵称',
password varchar2(40) comment '密码'
)
engine=Innodb default charset=utf8;

create table if not exists t_firends(
id int comment '用户id',
fid int comment '朋友id',
status int comment '状态(0-解除，1-是)',
primary key(id,fid)
)
engine=Innodb default charset=utf8;

create table if not exists t_blog(
bid int comment '博客id' primary key auto_increment,
id int comment '用户Id',
bname varchar(4000) comment '博客名称',
text varchar(4000) comment '博客内容',
status int comment '博客状态(0-删除，1-使用)',
update_time date comment '更新时间',
constraint fk_blog_uid foreign key (id) references t_user(id) 
)
engine=Innodb default charset=utf8;

create table if not exists t_remark(
rid int comment '评论id' primary key auto_increment,
bid int comment '博客id',
id int comment '评论人id',
text varchar(4000) comment '评论内容',
status int comment '评论状态(0-删除，1-使用)',
update_time date comment '更新时间',
constraint fk_remark_bid foreign key (bid) references t_blog(bid),
constraint fk_remark_uid foreign key (id) references t_user(id)
)
engine=Innodb default charset=utf8;
