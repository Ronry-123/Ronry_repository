CREATE TABLE `lrr_cash_order` (
	`order_id` varchar(20) NOT NULL COMMENT '订单号',
	`account_id` varchar(100) NOT NULL '账户号',
	`amount` DOUBLE NOT NULL COMMENT '金额'.
	`is_success` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '成功与否',
	`time` DATETIME DEFAULT NULL COMMENT '交易时间',
	`type` VARCHAR(100) NOT NULL COMMENT '交易类型',
)
ENGINE=InnoDB COMMENT '交易记录';

insert into lrr_cash_order(order_id, account_id, amount, is_success, time, type) values('1', '1', 50, 1, 2022-8-2-12:00, DEPOSIT);
select order_id, account_id, amount from lrr_cash_order where amount > 10;
delete amount from lrr_cash_order where is_success = 1;