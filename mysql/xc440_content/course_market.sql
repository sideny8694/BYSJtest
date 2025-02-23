create table course_market
(
    id             bigint       not null comment '主键，课程id'
        primary key,
    charge         varchar(32)  not null comment '收费规则，对应数据字典',
    price          float(10, 2) null comment '现价',
    original_price float(10, 2) null comment '原价',
    qq             varchar(32)  null comment '咨询qq',
    wechat         varchar(64)  null comment '微信',
    phone          varchar(32)  null comment '电话',
    valid_days     int          null comment '有效期天数'
)
    comment '课程营销信息' charset = utf8
                           row_format = DYNAMIC;

INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (1, '201001', 2, 11, '1', '1', '1', 1);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (2, '201001', 1, 11111, '2222', '3333', '4444', 555);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (7, '201000', null, null, null, null, null, null);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (18, '201001', 11, 111, '123456', '654321', '13333333', 365);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (22, '201001', 11, 1111, '334455', '223321', '1333333', 33);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (24, '201000', null, null, null, null, null, null);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (25, '201001', 222, 2222, '323232', '323232', '323232', 365);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (26, '201000', null, null, null, null, null, null);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (27, '201000', null, null, null, null, null, null);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (28, '201000', null, null, null, null, null, null);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (40, '201001', 11, 1111, null, null, null, null);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (74, '201001', 1, 100, '123456', '654321', '1333333', 365);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (82, '201001', 22, 222, '22', '33', '33', 33);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (84, '201001', 11, 11111, '11', '11', '22', 22);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (86, '201000', null, null, null, null, null, null);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (94, '201000', null, null, null, null, null, null);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (97, '201000', null, null, null, null, null, null);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (117, '201001', 1, 198, '24965575', '24965575', '24965575', 365);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (118, '201001', 10, 100, '43232', '4324322', '432432', 365);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (120, '201001', 111, 11, '432432', '432432', '43242', 365);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (121, '201001', 1, 100, '2323232', '3232432', '432432', 365);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (122, '201000', 101, 123, '1111', '22222', '33333', 365);
INSERT INTO xc440_content.course_market (id, charge, price, original_price, qq, wechat, phone, valid_days) VALUES (123, '201000', 0, null, '', '', '', 365);
