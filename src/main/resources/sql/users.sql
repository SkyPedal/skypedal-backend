DROP TABLE IF EXISTS `users` CASCADE;

CREATE TABLE `users` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `email` VARCHAR(1024),
  `firstname` VARCHAR(1024),
  `lastname` VARCHAR(1024),
  `password_hash` VARCHAR(1024),
  `profile_picture` VARCHAR(1024),
  `office` VARCHAR(1024),
  `points_remaining` BIGINT
);

INSERT INTO `users` (`email`,`firstname`,`lastname`,`password_hash`,`profile_picture`,`office`,`points_remaining`)
VALUES
('will@sky.uk','will','moolman','23457andsf','default.jpg','Livingston',42);