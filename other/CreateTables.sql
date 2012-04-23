delimiter $$

CREATE TABLE `Entries` (
  `id` int(11) NOT NULL,
  `isbn` int(13) DEFAULT NULL,
  `author` varchar(45) NOT NULL,
  `title` varchar(45) NOT NULL,
  `edition` varchar(45) DEFAULT NULL,
  `year` year(4) DEFAULT NULL,
  `course` varchar(45) DEFAULT NULL,
  `period` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `sold` tinyint(1) DEFAULT NULL,
  `price` varchar(45) NOT NULL,
  `expires` date NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1$$