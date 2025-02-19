create table mq_message
(
    id                 bigint auto_increment comment '消息id'
        primary key,
    message_type       varchar(32)              not null comment '消息类型代码: course_publish ,  media_test',
    business_key1      varchar(64)              null comment '关联业务信息',
    business_key2      varchar(255)             null comment '关联业务信息',
    business_key3      varchar(512)             null comment '关联业务信息',
    execute_num        int unsigned default '0' not null comment '通知次数',
    state              char         default '0' not null comment '处理状态，0:初始，1:成功',
    returnfailure_date datetime                 null comment '回复失败时间',
    returnsuccess_date datetime                 null comment '回复成功时间',
    returnfailure_msg  varchar(2048)            null comment '回复失败内容',
    execute_date       datetime                 null comment '最近通知时间',
    stage_state1       char         default '0' not null comment '阶段1处理状态, 0:初始，1:成功',
    stage_state2       char         default '0' not null comment '阶段2处理状态, 0:初始，1:成功',
    stage_state3       char         default '0' not null comment '阶段3处理状态, 0:初始，1:成功',
    stage_state4       char         default '0' not null comment '阶段4处理状态, 0:初始，1:成功'
)
    charset = utf8
    row_format = DYNAMIC;

