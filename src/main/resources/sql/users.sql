--------------------------------------------------------------------------------------------------------------------
--                                    THIS FILE IS ONLY FOR REFERENCE                                             --
--  Files are not run as part of the program, only data.sql, test-data.sql, and test-schema.sql are actually used --
--------------------------------------------------------------------------------------------------------------------
CREATE TABLE `users` (
  `id` BIGINT,
  `email` VARCHAR(1024),
  `firstname` VARCHAR(1024),
  `lastname` VARCHAR(1024),
  `password_hash` VARCHAR(1024),
  `profile_picture` VARCHAR(1024),
  `office` VARCHAR(1024),
  `points_remaining` BIGINT
);

INSERT INTO `users` (`id`,`email`,`firstname`,`lastname`,`password_hash`,`profile_picture`,`office`,`points_remaining`)
VALUES
(1,'will@sky.uk','will','moolman','23457andsf','default.jpg','Livingston',42);
