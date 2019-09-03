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

