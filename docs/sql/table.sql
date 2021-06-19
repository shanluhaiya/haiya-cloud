CREATE TABLE `hy_user` (
   `id` varchar(32) NOT NULL COMMENT 'UUID 主键',
   `username` varchar(32) NOT NULL COMMENT '用户名',
   `age` int(11) NOT NULL DEFAULT 0 COMMENT '年龄',
   `salary` bigint(20) NOT NULL DEFAULT 0 COMMENT '薪资: 单位分',
   `sex` char(1) DEFAULT '0' COMMENT '性别  m: 男性 f: 女性 u: 未知',
   `status` tinyint(2) NOT NULL DEFAULT 0 COMMENT '状态: 0禁用 1启用',
   `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
   `modify_time` timestamp NULL DEFAULT NULL COMMENT '修改时间',
   `login_time` timestamp NULL DEFAULT NULL COMMENT '登入时间',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

insert into hy_user (id, username, age, salary, sex, status, create_time, modify_time, login_time)
values ("bbe978ecd09b11eb8d8802f6c90fee7b", "haiya", 18, 4000000, "m", 1, "2021-06-10 12:00:00", "2021-06-10 12:00:00", "2021-06-10 12:00:00");
