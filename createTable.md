用户表

|名称|类型|说明|
|----|---|----|
|id|int|用户id,主键,自增|
|name|varchar|用户昵称|
|password|varchar|密码|


朋友表

|名称|类型|说明|
|----|---|----|
|id|int|用户id|
|fid|int|朋友id|
|status|int|状态(0-解除1-是)|
主键(id,fid)

博客表

|名称|类型|说明|
|----|---|----|
|id|int|用户Id,外键|
|bid|int|博客id,主键|
|bname|varchar|博客名称|
|text|varchar|博客内容|
|status|int|博客状态(0-删除1-使用)|
|update_time|date|更新时间|

评论表

|名称|类型|说明|
|----|---|----|
|rid|int|评论id,主键,自增|
|bid|int|博客id|
|id|int|评论人id|
|text|varchar|评论内容|
|status|int|评论状态(0-删除1-使用|
|update_time|date|更新时间|
外键：bid，id
