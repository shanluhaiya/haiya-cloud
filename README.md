# haiya-cloud
采用Spring Cloud, Spring Cloud Alibaba, Dubbo等整合的一个框架。

版本选择: https://github.com/alibaba/spring-cloud-alibaba/wiki/版本说明
- Spring Cloud: Hoxton.SR8
- Spring Boot: 2.3.2.RELEASE
- Spring Cloud Alibaba: 2.2.5.RELEASE













# 问题记录
## 1. dubbo相关问题
1. dubbo消费者调用服务提供者设置: dubbo.cloud.subscribed-services, 多个服务提供者用逗号分隔。如需直连provider, 可以@DubboReference(url = "dubbo://localhost:20881") 点对点直连。

## 2. mybatis相关问题
1. tinyint(1)字段自动转Java问题: 在url后面添加tinyInt1isBit=false
2. mysql时区问题: 在url后面添加serverTimezone=UTC
3. mybatis中的字段和java属性之间的转化，默认下划线转驼峰。在update, insert的过程中，取值和向sql赋值的过程中特别需要注意这点。数据库下划线分隔、属性驼峰。

## 3. springX相关问题

## 4. 其他问题