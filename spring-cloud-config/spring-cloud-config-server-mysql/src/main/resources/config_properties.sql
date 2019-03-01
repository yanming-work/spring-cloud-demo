CREATE TABLE `config_properties` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `key1` varchar(50) COLLATE utf8_bin NOT NULL,
  `value1` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `application` varchar(50) COLLATE utf8_bin NOT NULL,
  `profile` varchar(50) COLLATE utf8_bin NOT NULL,
  `label` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_bin


insert into `config_properties` ( `key1`, `value1`, `application`, `profile`, `label`) values('config.name','Yan Ming Mysql','config','dev','master');
insert into `config_properties` ( `key1`, `value1`, `application`, `profile`, `label`) values('config.age','29','config','dev','master');
insert into `config_properties` ( `key1`, `value1`, `application`, `profile`, `label`) values('config.version','jdbc-mysql','config','dev','master');


insert into `config_properties` ( `key1`, `value1`, `application`, `profile`, `label`) values('config.name','Gavin.Yan Mysql','config','pro','master');
insert into `config_properties` ( `key1`, `value1`, `application`, `profile`, `label`) values('config.age','29','config','pro','master');
insert into `config_properties` ( `key1`, `value1`, `application`, `profile`, `label`) values('config.version','jdbc-mysql','config','pro','master');


insert into `config_properties` ( `key1`, `value1`, `application`, `profile`, `label`) values('message','hello jdbc-mysql','config','dev','master');