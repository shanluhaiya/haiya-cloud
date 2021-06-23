Seata 2PC实现演示
------

## 1. 案例描述
下单减库存，有三个module:
1. seata-order-service: 订单服务
2. seata-warehouse-service: 仓库服务
3. seata-warehouse-api: 仓库暴露API

### 1.1 数据库
数据库MySQL, 包括seata_order_service和seata_warehouse_service两个数据库。

Order数据库(seata_order_service):

```mysql
CREATE DATABASE IF NOT EXISTS `seata_order_service` DEFAULT CHARACTER SET = utf8;
USE `seata_order_service`;
CREATE TABLE `hy_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `commodity_code` varchar(255) NOT NULL COMMENT '商品编码',
  `order_num` int(11) NOT NULL COMMENT '下单数量',
  `price` int(11) NOT NULL COMMENT '订单成交单价, 单位分',
  `total_price` int(11) NOT NULL COMMENT '订单成交单总价, 单位分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';
```

仓库数据库(seata_warehouse_service):
```mysql
CREATE DATABASE IF NOT EXISTS `seata_warehouse_service` DEFAULT CHARACTER SET = utf8;
USE `seata_warehouse_service`;
CREATE TABLE `hy_storage` (
    `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
    `commodity_code` varchar(255) NOT NULL COMMENT '商品编码',
    `count` int(11) NOT NULL COMMENT '库存数量',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='库存表';

INSERT INTO hy_storage VALUES (1, 'mackbook pro 2021', 100);
```

```mysql
CREATE DATABASE IF NOT EXISTS `seata_account_service` DEFAULT CHARACTER SET = utf8;
USE `seata_account_service`;
CREATE TABLE `hy_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(32) NOT NULL COMMENT '用户ID',
  `money` int(11) DEFAULT 0 COMMENT '账户余额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '用户账户表';

INSERT INTO hy_account VALUES (1, "1", 1000000);
```
```sql

CREATE TABLE `undo_log` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id` bigint(20) NOT NULL,
    `xid` varchar(100) NOT NULL,
    `context` varchar(128) NOT NULL,
    `rollback_info` longblob NOT NULL,
    `log_status` int(11) NOT NULL,
    `log_created` datetime NOT NULL,
    `log_modified` datetime NOT NULL,
    `ext` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

select * from seata_warehouse_service.hy_storage;
select * from seata_order_service.hy_order;
select * from seata_account_service.hy_account;
```
### 1.2 框架和环境
JDK:64位 jdk1.8.0_201

微服务框架:
- spring-boot: 2.3.2.RELEASE
- spring-cloud: Hoxton.SR8
- spring-cloud-alibaba: 2.2.5.RELEASE
- seata客户端(RM、TM): spring-cloud-alibaba-seata-2.2.5.RELEASE 
- seata服务端(TC):seata-server-0.7.1


