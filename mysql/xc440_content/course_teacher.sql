create table course_teacher
(
    id           bigint auto_increment comment '主键'
        primary key,
    course_id    bigint        null comment '课程标识',
    teacher_name varchar(60)   null comment '教师标识',
    position     varchar(255)  null comment '教师职位',
    introduction varchar(1024) null comment '教师简介',
    photograph   varchar(1024) null comment '照片',
    create_date  datetime      null comment '创建时间',
    constraint courseid_teacherId_unique
        unique (course_id, teacher_name)
)
    comment '课程-教师关系表' row_format = DYNAMIC;

INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (1, 72, 'wangxu', 'java高级讲师', '1111', 'http://r3zc5rung.hd-bkt.clouddn.com/2424e25d-b3ff-4ea2-92a5-249af918a42dGDSzBXIgWuwMCiZ4', '2021-12-25 17:44:07');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (3, 79, '博文', '教师', '帅哥', 'http://r3zc5rung.hd-bkt.clouddn.com/5fc0c47f-a3b4-4d93-b618-bb1cce8271f065L1s0qQjE1eLUAS', '2021-12-27 10:35:49');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (4, 80, '小王吧', 'SaaS', 'ASAD', 'http://r3zc5rung.hd-bkt.clouddn.com/bbdca546-524e-4938-abda-41b221642e7b4KtfBnPKutsdcqwI', '2021-12-27 11:09:43');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (5, 82, '驱蚊器', '为', '去', null, '2021-12-27 11:29:16');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (6, 83, '111', '111', '111', 'http://r3zc5rung.hd-bkt.clouddn.com/e169c906-a32a-4d0d-8262-e050de0f5f78obzlSd955zLAdeqv', '2021-12-27 12:24:01');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (7, 84, '123', '123', '123', 'http://r3zc5rung.hd-bkt.clouddn.com/6f6ac157-fc87-4bcc-a0ea-6c1e7c802fa6Igv8qAA9vwVYuNEv', '2021-12-27 13:44:01');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (8, 85, '黄哥', '大牛', 'nb', 'http://r3zc5rung.hd-bkt.clouddn.com/0ac34fcb-009c-40d3-9a67-9615d2d2e079ZR3JLyZNbcpdhdZF', '2021-12-27 16:11:30');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (9, 86, '1', '1', '1', 'http://r3zc5rung.hd-bkt.clouddn.com/625f7d6b-eeb8-4b24-aa9c-d2dd7fc0a3f2FXkxFmophiqhz5au', '2021-12-27 20:03:21');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (10, 88, '1', '1', '1', 'http://r3zc5rung.hd-bkt.clouddn.com/4fd7bfaa-f374-44c9-a4db-aa8ef23a76ddhvlJXSn6zcGKQS1u', '2021-12-27 20:15:19');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (11, 89, 'q', 'qq', '去', 'http://r3zc5rung.hd-bkt.clouddn.com/5e7a6877-39e2-4269-a656-c6c56c4ee259DVa7QIBQHs0OQ3yI', '2021-12-27 20:22:40');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (12, 90, '1', '11', '1', 'http://r3zc5rung.hd-bkt.clouddn.com/b3aeddb4-b4a4-4707-a4dc-16b9a9b04ddbATTiKwht7R3UFem6', '2021-12-27 20:27:43');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (13, 91, '1', '1', '1', 'http://r3zc5rung.hd-bkt.clouddn.com/28535bad-5186-4b93-b949-85af1f9698157U9V9ybKbD6eMIym', '2021-12-27 20:35:55');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (14, 92, '1', '1', '1', 'http://r3zc5rung.hd-bkt.clouddn.com/347a1e0d-793c-4b7f-8c26-2f3b1d2509aardGNVuaR19aV9EYW', '2021-12-27 20:54:23');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (15, 93, '小公牛', '欢喜', '欢喜', 'http://r3zc5rung.hd-bkt.clouddn.com/7b60fbeb-1857-4881-b4f1-1752e7c897ecQJGFVRhfevzXqVIU', '2021-12-27 23:24:27');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (16, 94, '最最最最最最最最最最终测试', '最最最最最最最最最最终测试', '最最最最最最最最最最终测试', null, '2021-12-27 23:48:59');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (17, 95, '1', '1', '1', 'http://r3zc5rung.hd-bkt.clouddn.com/490587bd-21df-4739-bcfb-dd0dbcad9a58OW3cttni1nlacpmZ', '2021-12-28 02:08:54');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (18, 96, '究极测试', '究极测试', '究极测试', 'http://r3zc5rung.hd-bkt.clouddn.com/8bc6a8be-df5c-4456-82c0-edc4c51731f1gkuxrGC7Jwlj7RKT', '2021-12-28 03:11:24');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (19, 22, '王老师', '高级讲师', '', null, '2022-08-21 21:17:53');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (20, 74, '张老师', 'java老师', '讲课生动。', '/bucket-pic/2022/08/25/a0950c47-ed28-4dec-8a87-76ff108448d7.jpg', '2022-08-23 15:46:27');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (21, 1232141425, '王老师', '高级讲师001', '', null, '2022-08-21 21:17:53');
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (24, 1232141425, '李老师 ', '实习讲师', '', null, null);
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (28, 1232141425, '霍老师', '初级教师', '0001', null, null);
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (30, 1232141425, '乌老师', '初级教师', '', null, null);
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (31, 1232141425, '1老师', '222', '', null, null);
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (32, 1232141425, '7老师', '1111', '', null, null);
INSERT INTO xc440_content.course_teacher (id, course_id, teacher_name, position, introduction, photograph, create_date) VALUES (33, 1232141425, '16516老师', 'dadad', '', null, null);
