CREATE TABLE `lrr_account` (
	`account_id` varchar(100) NOT NULL COMMENT '账号id',
	`username` varchar(20) DEFAULT "" NOT NULL COMMENT '账户名',
	`password` varchar(200) DEFAULT "" NOT NULL COMMENT '密码',
	`balance` DOUBLE DEFAULT 0 COMMENT '余额'
)
ENGINE=InnoDB;

# 增删改查
--增
insert into lrr_account(account_id, username, password, balance) values
('1', '张三', '123', 10),
('2', '李四', '456', 100),
('3', '王五', '789', 1000);

--删
delete from lrr_account where balance > 100;

--改
update lrr_account set password = '456456' where account_id = '2';

--查
select account_id, username, balance from lrr_account where balance > 100;