# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 10.0.34.46 (MySQL 5.6.25)
# Database: wave
# Generation Time: 2015-06-26 05:55:16 +0000
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



# Dump of table wave_dept
# ------------------------------------------------------------



# Dump of table wave_module
# ------------------------------------------------------------

LOCK TABLES `wave_module` WRITE;
/*!40000 ALTER TABLE `wave_module` DISABLE KEYS */;

INSERT INTO `wave_module` (`module_id`, `module_name`)
VALUES
	('config','配置'),
	('dashboard','Dashboard'),
	('system','系统');

/*!40000 ALTER TABLE `wave_module` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table wave_user
# ------------------------------------------------------------

LOCK TABLES `wave_user` WRITE;
/*!40000 ALTER TABLE `wave_user` DISABLE KEYS */;

INSERT INTO `wave_user` (`user_id`, `user_name`, `user_email`, `user_password`)
VALUES
	('admin','Administrator',NULL,NULL);

/*!40000 ALTER TABLE `wave_user` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table wave_user_cpny
# ------------------------------------------------------------

LOCK TABLES `wave_user_cpny` WRITE;
/*!40000 ALTER TABLE `wave_user_cpny` DISABLE KEYS */;

INSERT INTO `wave_user_cpny` (`user_id`, `cpny_id`)
VALUES
	('admin','system');

/*!40000 ALTER TABLE `wave_user_cpny` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table wave_user_module
# ------------------------------------------------------------

LOCK TABLES `wave_user_module` WRITE;
/*!40000 ALTER TABLE `wave_user_module` DISABLE KEYS */;

INSERT INTO `wave_user_module` (`user_id`, `module_id`, `index`)
VALUES
	('admin','config',1),
	('admin','dashboard',0),
	('admin','system',2);

/*!40000 ALTER TABLE `wave_user_module` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
