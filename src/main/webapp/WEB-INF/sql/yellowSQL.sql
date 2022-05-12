/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS `mokropub` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mokropub`;

CREATE TABLE IF NOT EXISTS `address` (
  `address_no` int(11) NOT NULL AUTO_INCREMENT,
  `zipcode` varchar(50) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `town` varchar(50) DEFAULT NULL,
  `road_name` varchar(50) DEFAULT NULL,
  `build_number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`address_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `cart` (
  `cart_no` int(11) NOT NULL,
  `product_no` int(11) NOT NULL,
  `consumer_no` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`cart_no`) USING BTREE,
  KEY `FK_cart_product` (`product_no`) USING BTREE,
  KEY `FK_cart_customer` (`consumer_no`) USING BTREE,
  CONSTRAINT `FK_cart_customer` FOREIGN KEY (`consumer_no`) REFERENCES `consumer` (`consumer_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cart_product` FOREIGN KEY (`product_no`) REFERENCES `product` (`product_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `category` (
  `category_no` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`category_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `company` (
  `company_no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `address` varchar(150) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `detailed_address` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`company_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `consumer` (
  `consumer_no` int(11) NOT NULL AUTO_INCREMENT,
  `consumer_id` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `zipcode` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `Detailed_Address` varchar(50) DEFAULT NULL,
  `consumer_level` int(11) NOT NULL DEFAULT 0,
  `Adult_Certification` enum('Y','N') NOT NULL,
  `resident_number` varchar(50) NOT NULL,
  `Account` varchar(100) NOT NULL,
  `CREATE_DATE` datetime NOT NULL,
  `UPDATE_DATE` datetime NOT NULL,
  PRIMARY KEY (`consumer_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `consumer_coupon_list` (
  `consumer_coupon_list_no` int(11) NOT NULL AUTO_INCREMENT,
  `coupon_no` int(11) NOT NULL,
  `consumer_no` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`consumer_coupon_list_no`) USING BTREE,
  KEY `FK_consumer_coupon_list_coupon` (`coupon_no`) USING BTREE,
  KEY `FK_consumer_coupon_list_consumer` (`consumer_no`) USING BTREE,
  CONSTRAINT `FK_consumer_coupon_list_consumer` FOREIGN KEY (`consumer_no`) REFERENCES `consumer` (`consumer_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_consumer_coupon_list_coupon` FOREIGN KEY (`coupon_no`) REFERENCES `coupon` (`coupon_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `coupon` (
  `coupon_no` int(11) NOT NULL AUTO_INCREMENT,
  `validity` date NOT NULL,
  `discount` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`coupon_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `delivery` (
  `delivery_no` int(11) NOT NULL,
  `order_no` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `method` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`delivery_no`) USING BTREE,
  KEY `FK_delivery_order` (`order_no`) USING BTREE,
  CONSTRAINT `FK_delivery_order` FOREIGN KEY (`order_no`) REFERENCES `order` (`order_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `inquiry` (
  `inquiry_no` int(11) NOT NULL AUTO_INCREMENT,
  `consumer_no` int(11) NOT NULL,
  `category` varchar(50) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `password` varchar(50) NOT NULL,
  `status` varchar(50) NOT NULL,
  `answer` text NOT NULL,
  `photo` blob NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`inquiry_no`) USING BTREE,
  KEY `FK_inquiry_consumer` (`consumer_no`) USING BTREE,
  CONSTRAINT `FK_inquiry_consumer` FOREIGN KEY (`consumer_no`) REFERENCES `consumer` (`consumer_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `material` (
  `material_no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '',
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`material_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `material_origin_list` (
  `material_origin_no` int(11) NOT NULL,
  `material_no` int(11) NOT NULL,
  `origin_no` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`material_origin_no`) USING BTREE,
  KEY `FK_meterial_origin_list_origin` (`origin_no`) USING BTREE,
  KEY `FK_meterial_origin_list_material` (`material_no`) USING BTREE,
  CONSTRAINT `FK_material_origin_list_material` FOREIGN KEY (`material_no`) REFERENCES `material` (`material_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_material_origin_list_origin` FOREIGN KEY (`origin_no`) REFERENCES `origin` (`origin_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `notice` (
  `notice_no` int(11) NOT NULL AUTO_INCREMENT,
  `seller_no` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `password` varchar(50) NOT NULL,
  `photo` blob NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`notice_no`) USING BTREE,
  KEY `FK_notice_seller` (`seller_no`) USING BTREE,
  CONSTRAINT `FK_notice_seller` FOREIGN KEY (`seller_no`) REFERENCES `seller` (`seller_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `order` (
  `order_no` int(11) NOT NULL,
  `consumer_no` int(11) NOT NULL,
  `product_no` int(11) NOT NULL,
  `zipcode` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `detailed_address` varchar(50) DEFAULT NULL,
  `payment` varchar(50) NOT NULL,
  `method` varchar(50) NOT NULL,
  `count` int(11) NOT NULL,
  `consumer_coupon_list_no` varchar(50) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`order_no`) USING BTREE,
  KEY `FK_order_consumer` (`consumer_no`) USING BTREE,
  KEY `FK_order_product` (`product_no`) USING BTREE,
  CONSTRAINT `FK_order_consumer` FOREIGN KEY (`consumer_no`) REFERENCES `consumer` (`consumer_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_order_product` FOREIGN KEY (`product_no`) REFERENCES `product` (`product_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `origin` (
  `origin_no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`origin_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `product` (
  `product_no` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `price` int(11) NOT NULL,
  `volume` int(11) NOT NULL,
  `material_origin_no` int(11) NOT NULL,
  `manufacture_date` datetime NOT NULL,
  `Expiration_date` datetime NOT NULL,
  `alcohol_level` int(11) NOT NULL,
  `factory` varchar(50) NOT NULL,
  `color` varchar(50) NOT NULL,
  `bottle` varchar(50) NOT NULL,
  `region` varchar(50) NOT NULL,
  `smell` varchar(50) NOT NULL,
  `sweet` int(11) NOT NULL,
  `maturity` int(11) NOT NULL,
  `category_no` int(11) NOT NULL,
  `picture` blob DEFAULT NULL,
  `acidity` int(11) NOT NULL,
  `thin` int(11) NOT NULL,
  `refreshment` int(11) NOT NULL,
  `report_number` varchar(50) NOT NULL,
  `company_no` int(11) NOT NULL,
  `memo` mediumtext NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`product_no`) USING BTREE,
  KEY `FK_product_category` (`category_no`) USING BTREE,
  KEY `FK_product_company` (`company_no`) USING BTREE,
  KEY `FK_product_meterial_origin_list` (`material_origin_no`) USING BTREE,
  CONSTRAINT `FK_product_category` FOREIGN KEY (`category_no`) REFERENCES `category` (`category_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_product_company` FOREIGN KEY (`company_no`) REFERENCES `company` (`company_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_product_meterial_origin_list` FOREIGN KEY (`material_origin_no`) REFERENCES `material_origin_list` (`material_origin_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `review` (
  `review_no` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` int(11) NOT NULL,
  `star` decimal(20,6) NOT NULL,
  `content` text NOT NULL,
  `picture` blob NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`review_no`) USING BTREE,
  KEY `FK_review_order` (`order_no`) USING BTREE,
  CONSTRAINT `FK_review_order` FOREIGN KEY (`order_no`) REFERENCES `order` (`order_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `seller` (
  `seller_no` int(11) NOT NULL AUTO_INCREMENT,
  `seller_id` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `zipcode` varchar(50) NOT NULL,
  `address` varchar(150) NOT NULL,
  `detailed_address` varchar(50) NOT NULL,
  `resident_number` varchar(50) NOT NULL,
  `business_number` varchar(50) NOT NULL,
  `account` varchar(50) NOT NULL,
  `fax` varchar(50) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`seller_no`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `stock` (
  `stock_no` int(11) NOT NULL,
  `product_no` int(11) NOT NULL,
  `seller_no` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime NOT NULL,
  PRIMARY KEY (`stock_no`) USING BTREE,
  KEY `FK_stock_product` (`product_no`) USING BTREE,
  KEY `FK_stock_seller` (`seller_no`) USING BTREE,
  CONSTRAINT `FK_stock_product` FOREIGN KEY (`product_no`) REFERENCES `product` (`product_no`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_stock_seller` FOREIGN KEY (`seller_no`) REFERENCES `seller` (`seller_no`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
