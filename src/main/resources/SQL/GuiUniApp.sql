-- ----------------------------------------
-- Table structure for Student
-- ----------------------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`
(
    `id`       INT AUTO_INCREMENT PRIMARY KEY COMMENT 'student id',
    `name`     VARCHAR(20) NOT NULL COMMENT 'student name',
    `email`    VARCHAR(40) NOT NULL COMMENT 'student email',
    `password` VARCHAR(20) NOT NULL COMMENT 'student password'
);

-- ----------------------------------------
-- Table structure for Managers
-- ----------------------------------------
DROP TABLE IF EXISTS `managers`;
CREATE TABLE `managers`
(
    `id`       INT AUTO_INCREMENT PRIMARY KEY COMMENT 'manager id',
    `name`     VARCHAR(20) NOT NULL COMMENT 'manager name',
    `email`    VARCHAR(40) NOT NULL COMMENT 'manager email',
    `password` VARCHAR(20) NOT NULL COMMENT 'manager password'
);

-- ----------------------------------------
-- Table structure for Subject
-- ----------------------------------------
DROP TABLE IF EXISTS `subjects`;
CREATE TABLE `subjects`
(
    `id`          INT AUTO_INCREMENT PRIMARY KEY COMMENT 'subject id',
    `name`        VARCHAR(20) NOT NULL COMMENT 'subject name',
    `description` TEXT        NOT NULL COMMENT 'subject description'
);

-- ----------------------------------------
-- Table structure for Grades
-- ----------------------------------------
DROP TABLE IF EXISTS `grades`;
CREATE TABLE `grades`
(
    `id`         INT AUTO_INCREMENT PRIMARY KEY COMMENT 'grades id',
    `student_id` VARCHAR(20) NOT NULL COMMENT 'student id',
    `subject_id` VARCHAR(20) NOT NULL COMMENT 'subject id',
    `score`      VARCHAR(10) NOT NULL COMMENT 'grade',
    `level`      VARCHAR(1) COMMENT ''
);
