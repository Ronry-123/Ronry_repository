CREATE TABLE `lrr_transfer_order`(
    `order_id` VARCHAR(20) NOT NULL COMMENT '订单号',
    `from_account_id` VARCHAR(100) NOT NULL COMMENT '转账人账号',
    `to_account_id` VARCHAR(100) NOT NULL COMMENT '转账对象账号',
    `amount` double not null comment '金额',
    `is_success` TINYINT(1) DEFAULT 0 COMMENT '成功与否',
    `time` DATETIME DEFAULT NULL COMMENT '交易时间',
    primary key (`order_id`),
)
ENGINE=InnoDB COMMENT '转账记录';
insert into lrr_transfer_order(order_id, from_account_id, to_account_id, is_success, time)
values('1', '1', '2', 1, 1970-1-1-00:00);
update lrr_transfer_order set time = 2022-8-2-13:00 where order_id = '1';