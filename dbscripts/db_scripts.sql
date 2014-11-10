DROP Database IF EXISTS `dblp`;

CREATE Database `dblp`;

USE dblp;

CREATE TABLE `Publication` (
  `publicationId` int(11) NOT NULL AUTO_INCREMENT,
  `publicationChannel` varchar(100) DEFAULT NULL,
  `citationCount` int(11) DEFAULT NULL,
  `authorNames` varchar(1000) DEFAULT NULL,
  `publicationTitle` varchar(500) DEFAULT NULL,
  `year` varchar(5) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `keywords` varchar(100) DEFAULT NULL,
  `tags` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`publicationId`)
) ENGINE=InnoDB AUTO_INCREMENT=12258 DEFAULT CHARSET=latin1;

CREATE TABLE `Author` (
  `authorId` int(11) NOT NULL AUTO_INCREMENT,
  `authorName` varchar(100) NOT NULL,
  `institution` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`authorId`,`authorName`),
  UNIQUE KEY `uq_authorName` (`authorName`)
) ENGINE=InnoDB AUTO_INCREMENT=21781 DEFAULT CHARSET=latin1
PARTITION BY RANGE  COLUMNS(authorName)
(PARTITION pa VALUES LESS THAN ('b') ENGINE = InnoDB,
 PARTITION pb VALUES LESS THAN ('c') ENGINE = InnoDB,
 PARTITION pc VALUES LESS THAN ('d') ENGINE = InnoDB,
 PARTITION pd VALUES LESS THAN ('e') ENGINE = InnoDB,
 PARTITION pe VALUES LESS THAN ('f') ENGINE = InnoDB,
 PARTITION pf VALUES LESS THAN ('g') ENGINE = InnoDB,
 PARTITION pg VALUES LESS THAN ('h') ENGINE = InnoDB,
 PARTITION ph VALUES LESS THAN ('i') ENGINE = InnoDB,
 PARTITION pi VALUES LESS THAN ('j') ENGINE = InnoDB,
 PARTITION pj VALUES LESS THAN ('k') ENGINE = InnoDB,
 PARTITION pk VALUES LESS THAN ('l') ENGINE = InnoDB,
 PARTITION pl VALUES LESS THAN ('m') ENGINE = InnoDB,
 PARTITION pm VALUES LESS THAN ('n') ENGINE = InnoDB,
 PARTITION pn VALUES LESS THAN ('o') ENGINE = InnoDB,
 PARTITION po VALUES LESS THAN ('p') ENGINE = InnoDB,
 PARTITION pp VALUES LESS THAN ('q') ENGINE = InnoDB,
 PARTITION pq VALUES LESS THAN ('r') ENGINE = InnoDB,
 PARTITION pr VALUES LESS THAN ('s') ENGINE = InnoDB,
 PARTITION ps VALUES LESS THAN ('t') ENGINE = InnoDB,
 PARTITION pt VALUES LESS THAN ('u') ENGINE = InnoDB,
 PARTITION pu VALUES LESS THAN ('v') ENGINE = InnoDB,
 PARTITION pv VALUES LESS THAN ('w') ENGINE = InnoDB,
 PARTITION pw VALUES LESS THAN ('x') ENGINE = InnoDB,
 PARTITION px VALUES LESS THAN ('y') ENGINE = InnoDB,
 PARTITION pz VALUES LESS THAN (MAXVALUE) ENGINE = InnoDB);

CREATE TABLE `AuthorPublicationMap` (
  `authorPublicationMapId` int(11) NOT NULL AUTO_INCREMENT,
  `publicationId` int(11) DEFAULT NULL,
  `authorId` int(11) DEFAULT NULL,
  PRIMARY KEY (`authorPublicationMapId`),
  KEY `publicationId` (`publicationId`),
  KEY `authorId` (`authorId`)
) ENGINE=InnoDB AUTO_INCREMENT=30751 DEFAULT CHARSET=latin1;

CREATE TABLE `Book` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `publicationId` int(11) DEFAULT NULL,
  `editors` varchar(500) DEFAULT NULL,
  `pages` varchar(50) DEFAULT NULL,
  `month` varchar(15) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `publisher` varchar(100) DEFAULT NULL,
  `publisherAddress` varchar(200) DEFAULT NULL,
  `isbn` varchar(100) DEFAULT NULL,
  `series` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`bookId`),
  KEY `publicationId` (`publicationId`),
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`publicationId`) REFERENCES `Publication` (`publicationId`)
) ENGINE=InnoDB AUTO_INCREMENT=1755 DEFAULT CHARSET=latin1;

CREATE TABLE `BookChapterData` (
  `bookChapterDataId` int(11) NOT NULL AUTO_INCREMENT,
  `bookChapterName` varchar(300) DEFAULT NULL,
  `relevance` double DEFAULT NULL,
  PRIMARY KEY (`bookChapterDataId`),
  UNIQUE KEY `uq_bookChapterName` (`bookChapterName`)
) ENGINE=InnoDB AUTO_INCREMENT=8123 DEFAULT CHARSET=latin1;

CREATE TABLE `BookChapter` (
  `bookChapterId` int(11) NOT NULL AUTO_INCREMENT,
  `bookChapterDataId` int(11) DEFAULT NULL,
  `publicationId` int(11) DEFAULT NULL,
  `pages` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`bookChapterId`),
  KEY `publicationId` (`publicationId`),
  KEY `bookChapterDataId` (`bookChapterDataId`),
  CONSTRAINT `bookchapter_ibfk_1` FOREIGN KEY (`publicationId`) REFERENCES `Publication` (`publicationId`),
  CONSTRAINT `bookchapter_ibfk_2` FOREIGN KEY (`bookChapterDataId`) REFERENCES `BookChapterData` (`bookChapterDataId`)
) ENGINE=InnoDB AUTO_INCREMENT=8123 DEFAULT CHARSET=latin1;



CREATE TABLE `Conference` (
  `conferenceId` int(11) NOT NULL AUTO_INCREMENT,
  `conferenceName` varchar(100) DEFAULT NULL,
  `conferenceLocation` varchar(50) DEFAULT NULL,
  `relevance` double DEFAULT NULL,
  PRIMARY KEY (`conferenceId`),
  UNIQUE KEY `uq_conferenceName` (`conferenceName`)
) ENGINE=InnoDB AUTO_INCREMENT=2344 DEFAULT CHARSET=latin1;

CREATE TABLE `ConferencePaper` (
  `conferencePaperId` int(11) NOT NULL AUTO_INCREMENT,
  `conferenceId` int(11) DEFAULT NULL,
  `publicationId` int(11) DEFAULT NULL,
  `pages` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`conferencePaperId`),
  KEY `publicationId` (`publicationId`),
  KEY `conferenceId` (`conferenceId`),
  CONSTRAINT `conferencepaper_ibfk_1` FOREIGN KEY (`publicationId`) REFERENCES `Publication` (`publicationId`),
  CONSTRAINT `conferencepaper_ibfk_2` FOREIGN KEY (`conferenceId`) REFERENCES `Conference` (`conferenceId`)
) ENGINE=InnoDB AUTO_INCREMENT=2344 DEFAULT CHARSET=latin1;

CREATE TABLE `Journal` (
  `journalId` int(11) NOT NULL AUTO_INCREMENT,
  `journalName` varchar(100) DEFAULT NULL,
  `relevance` double DEFAULT NULL,
  PRIMARY KEY (`journalId`),
  UNIQUE KEY `uq_journalName` (`journalName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `JournalArticle` (
  `journalArticleId` int(11) NOT NULL AUTO_INCREMENT,
  `journalId` int(11) DEFAULT NULL,
  `publicationId` int(11) DEFAULT NULL,
  `pages` varchar(50) DEFAULT NULL,
  `volume` varchar(50) DEFAULT NULL,
  `columns` varchar(50) DEFAULT NULL,
  `month` varchar(15) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`journalArticleId`),
  KEY `publicationId` (`publicationId`),
  KEY `journalId` (`journalId`),
  CONSTRAINT `journalarticle_ibfk_1` FOREIGN KEY (`publicationId`) REFERENCES `Publication` (`publicationId`),
  CONSTRAINT `journalarticle_ibfk_2` FOREIGN KEY (`journalId`) REFERENCES `Journal` (`journalId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `School` (
  `schoolId` int(11) NOT NULL AUTO_INCREMENT,
  `schoolName` varchar(100) DEFAULT NULL,
  `schoolLocation` varchar(50) DEFAULT NULL,
  `relevance` double DEFAULT NULL,
  PRIMARY KEY (`schoolId`),
  UNIQUE KEY `uq_schoolName` (`schoolName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `PhdThesis` (
  `phdThesisId` int(11) NOT NULL AUTO_INCREMENT,
  `schoolId` int(11) DEFAULT NULL,
  `publicationId` int(11) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `advisorName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`phdThesisId`),
  KEY `publicationId` (`publicationId`),
  KEY `schoolId` (`schoolId`),
  CONSTRAINT `phdthesis_ibfk_1` FOREIGN KEY (`publicationId`) REFERENCES `Publication` (`publicationId`),
  CONSTRAINT `phdthesis_ibfk_2` FOREIGN KEY (`schoolId`) REFERENCES `School` (`schoolId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;





CREATE TABLE `WebPage` (
  `webPageId` int(11) NOT NULL AUTO_INCREMENT,
  `publicationId` int(11) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `accessDate` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`webPageId`),
  KEY `publicationId` (`publicationId`),
  CONSTRAINT `webpage_ibfk_1` FOREIGN KEY (`publicationId`) REFERENCES `Publication` (`publicationId`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=latin1;
