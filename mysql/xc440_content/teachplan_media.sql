create table teachplan_media
(
    id             bigint auto_increment comment '主键'
        primary key,
    media_id       varchar(32)  null comment '媒资文件id',
    teachplan_id   bigint       not null comment '课程计划标识',
    course_id      bigint       not null comment '课程标识',
    media_fileName varchar(150) not null comment '媒资文件原始名称',
    create_date    datetime     null,
    create_people  varchar(60)  null comment '创建人',
    change_people  varchar(60)  null comment '修改人'
)
    row_format = DYNAMIC;

INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (35, '23f83ae728bd1269eee7ea2236e79644', 149, 82, '16-Nacos配置管理-课程总结.avi', '2022-09-15 08:02:26', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (38, '3a5a861d1c745d05166132c47b44f9e4', 147, 82, '01-Nacos配置管理-内容介绍.avi', '2022-09-15 08:02:55', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (40, '3a5a861d1c745d05166132c47b44f9e4', 269, 117, '01-Nacos配置管理-内容介绍.avi', '2022-10-04 19:04:45', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (41, '23f83ae728bd1269eee7ea2236e79644', 270, 117, '16-Nacos配置管理-课程总结.avi', '2022-10-04 19:04:55', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (42, '3a5a861d1c745d05166132c47b44f9e4', 271, 117, '01-Nacos配置管理-内容介绍.avi', '2022-10-04 19:05:03', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (43, '3a5a861d1c745d05166132c47b44f9e4', 272, 117, '01-Nacos配置管理-内容介绍.avi', '2022-10-04 19:05:10', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (44, '23f83ae728bd1269eee7ea2236e79644', 273, 117, '16-Nacos配置管理-课程总结.avi', '2022-10-04 19:05:14', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (45, '1f229319d6fed3431d2f9d06193a433b', 275, 117, '01-分布式事务专题课程介绍.avi', '2022-10-04 19:05:22', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (46, '6ad24a762f67c18f61966c1b8c55abe6', 276, 117, '07-分布式事务基础理论-BASE理论.avi', '2022-10-04 19:05:27', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (47, '1f229319d6fed3431d2f9d06193a433b', 277, 117, '01-分布式事务专题课程介绍.avi', '2022-10-04 19:05:31', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (48, '6ad24a762f67c18f61966c1b8c55abe6', 278, 117, '07-分布式事务基础理论-BASE理论.avi', '2022-10-04 19:05:35', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (49, '18f919e23bedab97a78762c4875addc4', 280, 18, '垂直分库-插入和查询测试.avi', '2022-12-15 19:49:47', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (51, '287cdd91c5d444e0752b626cbd95b41c', 283, 121, 'nacos01.mp4', '2023-02-09 11:13:27', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (52, '1f229319d6fed3431d2f9d06193a433b', 285, 121, '01-分布式事务专题课程介绍.avi', '2023-02-09 11:13:34', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (53, '18f919e23bedab97a78762c4875addc4', 286, 121, '垂直分库-插入和查询测试.avi', '2023-02-09 11:33:03', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (54, '1f229319d6fed3431d2f9d06193a433b', 287, 121, '01-分布式事务专题课程介绍.avi', '2023-02-09 11:33:07', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (55, '23f83ae728bd1269eee7ea2236e79644', 288, 121, '16-Nacos配置管理-课程总结.avi', '2023-02-09 11:33:12', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (56, '23f83ae728bd1269eee7ea2236e79644', 289, 121, '16-Nacos配置管理-课程总结.avi', '2023-02-09 11:33:16', null, null);
INSERT INTO xc440_content.teachplan_media (id, media_id, teachplan_id, course_id, media_fileName, create_date, create_people, change_people) VALUES (57, '1f229319d6fed3431d2f9d06193a433b', 282, 121, '01-分布式事务专题课程介绍.avi', '2023-02-09 11:45:52', null, null);
