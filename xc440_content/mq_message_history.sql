create table mq_message_history
(
    id                 bigint                not null comment '消息id'
        primary key,
    message_type       varchar(32)           not null comment '消息类型代码',
    business_key1      varchar(64)           null comment '关联业务信息',
    business_key2      varchar(255)          null comment '关联业务信息',
    business_key3      varchar(512)          null comment '关联业务信息',
    execute_num        int unsigned          null comment '通知次数',
    state              int unsigned zerofill null comment '处理状态，0:初始，1:成功，2:失败',
    returnfailure_date datetime              null comment '回复失败时间',
    returnsuccess_date datetime              null comment '回复成功时间',
    returnfailure_msg  varchar(255)          null comment '回复失败内容',
    execute_date       datetime              null comment '最近通知时间',
    stage_state1       char                  null,
    stage_state2       char                  null,
    stage_state3       char                  null,
    stage_state4       char                  null
)
    charset = utf8
    row_format = DYNAMIC;

INSERT INTO xc440_content.mq_message_history (id, message_type, business_key1, business_key2, business_key3, execute_num, state, returnfailure_date, returnsuccess_date, returnfailure_msg, execute_date, stage_state1, stage_state2, stage_state3, stage_state4) VALUES (1, 'course_publish', '121', null, null, 0, null, null, null, null, null, '1', '1', '0', '0');
INSERT INTO xc440_content.mq_message_history (id, message_type, business_key1, business_key2, business_key3, execute_num, state, returnfailure_date, returnsuccess_date, returnfailure_msg, execute_date, stage_state1, stage_state2, stage_state3, stage_state4) VALUES (2, 'course_publish', '121', null, null, 0, null, null, null, null, null, '1', '1', '0', '0');
INSERT INTO xc440_content.mq_message_history (id, message_type, business_key1, business_key2, business_key3, execute_num, state, returnfailure_date, returnsuccess_date, returnfailure_msg, execute_date, stage_state1, stage_state2, stage_state3, stage_state4) VALUES (3, 'course_publish', '121', null, null, 0, null, null, null, null, null, '1', '1', '0', '0');
INSERT INTO xc440_content.mq_message_history (id, message_type, business_key1, business_key2, business_key3, execute_num, state, returnfailure_date, returnsuccess_date, returnfailure_msg, execute_date, stage_state1, stage_state2, stage_state3, stage_state4) VALUES (17, 'course_publish', '222', null, null, 0, null, null, null, null, null, '1', '0', '0', '0');
INSERT INTO xc440_content.mq_message_history (id, message_type, business_key1, business_key2, business_key3, execute_num, state, returnfailure_date, returnsuccess_date, returnfailure_msg, execute_date, stage_state1, stage_state2, stage_state3, stage_state4) VALUES (18, 'course_publish', '18', null, null, 0, null, null, null, null, null, '1', '0', '0', '0');
INSERT INTO xc440_content.mq_message_history (id, message_type, business_key1, business_key2, business_key3, execute_num, state, returnfailure_date, returnsuccess_date, returnfailure_msg, execute_date, stage_state1, stage_state2, stage_state3, stage_state4) VALUES (20, 'course_publish', '18', null, null, 0, null, null, null, null, null, '1', '1', '0', '0');
