CREATE TABLE `text`(
    `order_id` VARCHAR(20) NOT NULL COMMENT '订单号',
    `from_account_id` VARCHAR(100) NOT NULL COMMENT '转账人账号',
    `to_account_id` VARCHAR(100) NOT NULL COMMENT '转账对象账号',
    `amount` double not null comment '金额',
    `is_success` TINYINT(1) DEFAULT 0 COMMENT '成功与否',
    `time` DATETIME DEFAULT NULL COMMENT '交易时间',
    --增加索引
    index `idx_to_account_id`(`to_account_id`, `from_account_id`, `time`) using btree,
    unique index `idx_to_from_account_id`(`from_account_id`, `to_account_id`) using btree,
    primary key (`order_id`),
);


# 表的增删改
--列
alter table test add column `order_id` varchar(100) not null comment '资产类型';
alter table test modify column `amount` decimal(18) default 0 comment '金额';
alter table test drop column `time`;
--索引
alter table test add (index | unique index) `idx_from_account_id`(`from_account_id`) using btree;
alter table test drop index `idx_from_account_id`;

