CREATE TABLE IF NOT EXISTS `user`(
                       `id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                       `name` VARCHAR(255) NOT NULL ,
                       `password` VARCHAR(255) NOT NULL ,
                       `phone` VARCHAR(255) NOT NULL
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;