# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 10.0.34.46 (MySQL 5.6.25)
# Database: wave
# Generation Time: 2015-06-26 05:54:24 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table wave_cpny
# ------------------------------------------------------------

DROP TABLE IF EXISTS `wave_cpny`;

CREATE TABLE `wave_cpny` (
  `cpny_id` varchar(32) NOT NULL DEFAULT '',
  `cpny_name` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`cpny_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table wave_dept
# ------------------------------------------------------------

DROP TABLE IF EXISTS `wave_dept`;

CREATE TABLE `wave_dept` (
  `dept_id` varchar(32) NOT NULL DEFAULT '',
  `dept_name` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table wave_module
# ------------------------------------------------------------

DROP TABLE IF EXISTS `wave_module`;

CREATE TABLE `wave_module` (
  `module_id` varchar(32) NOT NULL DEFAULT '',
  `module_name` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table wave_user
# ------------------------------------------------------------

DROP TABLE IF EXISTS `wave_user`;

CREATE TABLE `wave_user` (
  `user_id` varchar(32) NOT NULL DEFAULT '',
  `user_name` varchar(32) DEFAULT NULL,
  `user_email` varchar(64) DEFAULT NULL,
  `user_password` varchar(256) DEFAULT NULL,
  UNIQUE KEY `UNI_user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table wave_user_cpny
# ------------------------------------------------------------

DROP TABLE IF EXISTS `wave_user_cpny`;

CREATE TABLE `wave_user_cpny` (
  `user_id` varchar(32) NOT NULL DEFAULT '',
  `cpny_id` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`,`cpny_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table wave_user_module
# ------------------------------------------------------------

DROP TABLE IF EXISTS `wave_user_module`;

CREATE TABLE `wave_user_module` (
  `user_id` varchar(32) NOT NULL DEFAULT '',
  `module_id` varchar(32) NOT NULL DEFAULT '',
  `index` int(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`,`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
