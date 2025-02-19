create table course_publish_pre
(
    id             bigint                  not null comment '主键'
        primary key,
    company_id     bigint                  not null comment '机构ID',
    company_name   varchar(255)            null comment '公司名称',
    name           varchar(100)            not null comment '课程名称',
    users          varchar(500)            not null comment '适用人群',
    tags           varchar(32)             null comment '标签',
    username       varchar(32)             null comment '创建人',
    mt             varchar(20)             not null comment '大分类',
    mt_name        varchar(255)            not null comment '大分类名称',
    st             varchar(20)             not null comment '小分类',
    st_name        varchar(255)            not null comment '小分类名称',
    grade          varchar(32)             not null comment '课程等级',
    teachmode      varchar(32)             not null comment '教育模式',
    pic            varchar(500)            not null comment '课程图片',
    description    text                    null comment '课程介绍',
    market         text                    null comment '课程营销信息，json格式',
    teachplan      text                    null comment '所有课程计划，json格式',
    teachers       text                    null comment '教师信息，json格式',
    create_date    datetime                null comment '提交时间',
    audit_date     datetime                null comment '审核时间',
    status         varchar(10) default '1' null comment '状态',
    remark         varchar(500)            null comment '备注',
    charge         varchar(32)             null comment '收费规则，对应数据字典--203',
    price          float(10, 2)            null comment '现价',
    original_price float(10, 2)            null comment '原价',
    valid_days     int                     null comment '课程有效期天数'
)
    comment '课程发布' charset = utf8
                       row_format = DYNAMIC;

