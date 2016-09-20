﻿# Host: localhost  (Version: 5.6.25)
# Date: 2016-09-14 17:03:10
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "tbl_ads"
#

CREATE TABLE `tbl_ads` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT '' COMMENT '标题',
  `img_id` int(11) NOT NULL DEFAULT '0' COMMENT '图片地址id',
  `order_no` int(11) DEFAULT NULL COMMENT '排序号',
  `state` int(1) NOT NULL DEFAULT '0' COMMENT '发布状态 0、草稿 1、已发布 2、停用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告表';

#
# Data for table "tbl_ads"
#


#
# Source for table "tbl_news"
#

CREATE TABLE `tbl_news` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '新闻标题',
  `content` text COMMENT '新闻内容',
  `publish_state` int(1) DEFAULT '0' COMMENT '发布状态 0、草稿 1、已发布 2、过期不显示',
  `publish_time` datetime DEFAULT NULL COMMENT '发布时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='新闻表';

#
# Data for table "tbl_news"
#

INSERT INTO `tbl_news` VALUES (1,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:36','2016-09-14 15:57:36','2016-09-14 15:57:36'),(2,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:36','2016-09-14 15:57:36','2016-09-14 15:57:36'),(3,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:38','2016-09-14 15:57:38','2016-09-14 15:57:38'),(4,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:39','2016-09-14 15:57:39','2016-09-14 15:57:39'),(5,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:39','2016-09-14 15:57:39','2016-09-14 15:57:39'),(6,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:40','2016-09-14 15:57:40','2016-09-14 15:57:40'),(7,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:40','2016-09-14 15:57:40','2016-09-14 15:57:40'),(8,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:41','2016-09-14 15:57:41','2016-09-14 15:57:41'),(9,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:41','2016-09-14 15:57:41','2016-09-14 15:57:41'),(10,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:42','2016-09-14 15:57:42','2016-09-14 15:57:42'),(11,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:42','2016-09-14 15:57:42','2016-09-14 15:57:42'),(12,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:43','2016-09-14 15:57:43','2016-09-14 15:57:43'),(13,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:43','2016-09-14 15:57:43','2016-09-14 15:57:43'),(14,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:43','2016-09-14 15:57:43','2016-09-14 15:57:43'),(15,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:44','2016-09-14 15:57:44','2016-09-14 15:57:44'),(16,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:44','2016-09-14 15:57:44','2016-09-14 15:57:44'),(17,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:44','2016-09-14 15:57:44','2016-09-14 15:57:44'),(18,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:45','2016-09-14 15:57:45','2016-09-14 15:57:45'),(19,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:45','2016-09-14 15:57:45','2016-09-14 15:57:45'),(20,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:46','2016-09-14 15:57:46','2016-09-14 15:57:46'),(21,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:46','2016-09-14 15:57:46','2016-09-14 15:57:46'),(22,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:47','2016-09-14 15:57:47','2016-09-14 15:57:47'),(23,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:47','2016-09-14 15:57:47','2016-09-14 15:57:47'),(24,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:47','2016-09-14 15:57:47','2016-09-14 15:57:47'),(25,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:48','2016-09-14 15:57:48','2016-09-14 15:57:48'),(26,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:48','2016-09-14 15:57:48','2016-09-14 15:57:48'),(27,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:49','2016-09-14 15:57:49','2016-09-14 15:57:49'),(28,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:49','2016-09-14 15:57:49','2016-09-14 15:57:49'),(29,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:50','2016-09-14 15:57:50','2016-09-14 15:57:50'),(30,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:50','2016-09-14 15:57:50','2016-09-14 15:57:50'),(31,'家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些','家具是我们家居生活中最为重要的，有了好的家具才会有好的生活。随着社会经济的增长，人们的生活水平有了很大的提高，那么什么样的家具好呢？下面随小编去看看全区定制家具吧！看看全屋定制家具品牌有哪些。 ...',1,'2016-09-14 15:57:50','2016-09-14 15:57:50','2016-09-14 15:57:50');