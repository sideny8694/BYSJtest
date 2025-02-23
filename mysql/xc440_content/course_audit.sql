create table course_audit
(
    id           bigint auto_increment
        primary key,
    course_id    bigint       not null comment '课程id',
    audit_mind   varchar(255) null comment '审核意见',
    audit_status varchar(10)  not null comment '审核状态',
    audit_people varchar(50)  null comment '审核人',
    audit_date   datetime     null comment '审核时间'
)
    row_format = DYNAMIC;

