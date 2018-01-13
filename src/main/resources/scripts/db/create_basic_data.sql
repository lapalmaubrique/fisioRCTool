CREATE TABLE `basic_data` (
  `basic_data_id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `age` smallint(3),
  `phone` varchar(15),
  `job` varchar(90),
  `gendre` varchar(1),
  `physical_activity` varchar(90),
  `days_a_week` smallint(1),
  `height` varchar(5),
  `weight` varchar(5),
  `email` varchar(90),
  PRIMARY KEY (`basic_data_id`),
  KEY `idx_basic_data_last_name` (`last_name`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;