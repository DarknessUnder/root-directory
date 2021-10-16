DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
    `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'user_name',
    `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'password',
    `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'email',
     PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_collection`;
CREATE TABLE `user_collection` (
                        `user_id` int(11),
                        `collection_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'collection id',
                        `collection_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'collection name',
                        `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'description',
                        FOREIGN KEY (`user_id`) REFERENCES user(`user_id`),
                        PRIMARY KEY (`collection_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
                          `course_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'course id',
                          `course_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'course_name',
                          `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'description',
                          `color` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'color',
                          `instructor` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'instructor',
                          `collection` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'collection',
                          PRIMARY KEY (`course_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_courses`;
CREATE TABLE `user_courses` (
                        `collection_id` int(11),
                        `course_id` int(11),
                        FOREIGN KEY (`collection_id`) REFERENCES user_collection(`collection_id`),
                        FOREIGN KEY (`course_id`) REFERENCES course(`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `links`;
CREATE TABLE `links` (
                          `course_id` int(11),
                          `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'description',
                          `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'url',
                          FOREIGN KEY (`course_id`) REFERENCES course(`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
                         `course_id` int(11),
                         `dropped` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'dropped',
                         `total_grade` int(11) NOT NULL DEFAULT 0 COMMENT 'total_grade',
                         `current_grade` int(11) NOT NULL DEFAULT 0 COMMENT 'current_grade',
                         FOREIGN KEY (`course_id`) REFERENCES course(`course_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
                          `task_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'task id',
                          `task_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'task_name',
                          `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'description',
                          `color` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'color',
                          `instructor` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'instructor',
                          `collection` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'collection',
                          PRIMARY KEY (`task_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `course_task`;
CREATE TABLE `course_task` (
                         `course_id` int(11),
                         `task_id` int(11),
                         FOREIGN KEY (`course_id`) REFERENCES course(`course_id`),
                         FOREIGN KEY (`task_id`) REFERENCES task(`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                        `course_id` int(11),
                        `category_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'category_name',
                        `task_category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'category_id',
                        `description` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'description',
                        FOREIGN KEY (`course_id`) REFERENCES course(`course_id`),
                        PRIMARY KEY (`task_category_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `task_in_category`;
CREATE TABLE `task_in_category` (
                         `task_category_id` int(11),
                         `task_id` int(11),
                         FOREIGN KEY (`task_category_id`) REFERENCES category(`task_category_id`),
                         FOREIGN KEY (`task_id`) REFERENCES task(`task_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
