--------------------------------------------------------------------------------------------------------------------
--                                    THIS FILE IS ONLY FOR REFERENCE                                             --
--  Files are not run as part of the program, only data.sql, test-data.sql, and test-schema.sql are actually used --
--------------------------------------------------------------------------------------------------------------------
CREATE TABLE `locations` (
  `id` BIGINT,
  `name` VARCHAR(1024),
  `coordinates` JSON,
  `user_id` BIGINT
);

INSERT INTO `locations` (`name`,`coordinates`,`user_id`)
VALUES
('Home','[55.9391172,-3.1866364]',1),
('Work - Watermark','[55.8737717,-3.5436674999999997]',1);
