create table teachplan_work
(
    id            bigint auto_increment comment '主键'
        primary key,
    work_id       bigint      not null comment '作业信息标识',
    work_title    varchar(60) not null comment '作业标题',
    teachplan_id  bigint      not null comment '课程计划标识',
    course_id     bigint      null comment '课程标识',
    create_date   datetime    null,
    course_pub_id bigint      null
)
    row_format = DYNAMIC;

INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (12, 8, '测试作业1', 138, 79, '2021-12-27 10:35:15', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (13, 8, '测试作业1', 144, 80, '2021-12-27 11:09:20', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (14, 8, '测试作业1', 129, 78, '2021-12-27 11:15:04', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (15, 8, '测试作业1', 147, 82, '2021-12-27 11:28:28', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (17, 8, '测试作业1', 155, 83, '2021-12-27 12:22:55', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (18, 8, '测试作业1', 160, 84, '2021-12-27 13:43:42', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (19, 24, '最终测试', 165, 85, '2021-12-27 15:55:17', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (21, 8, '测试作业1', 135, 76, '2021-12-27 16:06:23', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (22, 24, '最终测试', 166, 85, '2021-12-27 16:09:17', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (23, 24, '最终测试', 173, 86, '2021-12-27 20:02:03', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (24, 8, '测试作业1', 174, 86, '2021-12-27 20:02:34', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (25, 8, '测试作业1', 177, 86, '2021-12-27 20:03:03', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (26, 8, '测试作业1', 180, 87, '2021-12-27 20:14:25', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (27, 20, '测试作业', 181, 87, '2021-12-27 20:14:36', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (28, 8, '测试作业1', 184, 88, '2021-12-27 20:15:05', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (29, 8, '测试作业1', 192, 90, '2021-12-27 20:27:33', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (30, 8, '测试作业1', 196, 91, '2021-12-27 20:35:41', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (31, 24, '最终测试', 200, 92, '2021-12-27 20:53:50', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (32, 24, '最终测试', 201, 92, '2021-12-27 20:54:06', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (33, 25, '小母猪', 207, 93, '2021-12-27 23:23:38', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (34, 26, '小母牛', 208, 93, '2021-12-27 23:23:48', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (35, 24, '最终测试', 214, 94, '2021-12-27 23:48:28', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (36, 25, '小母猪', 215, 94, '2021-12-27 23:48:36', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (37, 26, '小母牛', 216, 94, '2021-12-27 23:48:44', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (39, 29, '真最终测试', 222, 95, '2021-12-28 02:08:28', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (40, 8, '测试作业1', 221, 95, '2021-12-28 02:08:36', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (41, 8, '测试作业1', 226, 96, '2021-12-28 03:11:04', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (42, 32, '项目展示', 233, 97, '2021-12-28 03:37:11', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (43, 20, '测试作业', 235, 97, '2021-12-28 03:39:08', null);
INSERT INTO xc440_content.teachplan_work (id, work_id, work_title, teachplan_id, course_id, create_date, course_pub_id) VALUES (44, 32, '项目展示', 236, 97, '2021-12-28 03:40:56', null);
