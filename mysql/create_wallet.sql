create database wallet;

CREATE TABLE `transactions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,2) NOT NULL,
  `closing_balance` decimal(10,2) NOT NULL,
  `account_number` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `remarkr` varchar(50) NOT NULL,
  `created_on` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `updated_on` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`),
  KEY `account_number` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `balance_tracker` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,2) NOT NULL,
  `currency` varchar(10) NOT NULL,
  `account_number` varchar(20) NOT NULL,
  `created_on` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  `updated_on` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3),
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_number` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1