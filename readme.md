用户表

|名称|类型|说明|
|----|---|----|
|id|int|用户id,主键|
|name|varchar2|用户昵称|

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
|text|varchar2|博客内容|
|status|int|博客状态(0-删除1-使用)|
|update_time|date|更新时间|

评论表

|名称|类型|说明|
|----|---|----|
|bid|int|博客id|
|id|int|评论人id|
|text|varchar2|评论内容|
|status|int|评论状态(0-删除1-使用|
|update_time|date|更新时间|
:|:外键（bid）
