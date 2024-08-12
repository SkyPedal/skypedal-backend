DROP TABLE IF EXISTS `rewards` CASCADE;
DROP TABLE IF EXISTS `users` CASCADE;
DROP TABLE IF EXISTS `users_rewards` CASCADE;


CREATE TABLE `rewards` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(1024),
  `description` VARCHAR(1024),
  `point_cost` BIGINT,
  `number_available` BIGINT,
  `image_link` VARCHAR(1024),
  `active` BOOLEAN
);

CREATE TABLE `users` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `email` VARCHAR(1024),
  `name` VARCHAR(1024),
--  `lastname` VARCHAR(1024),
  `password_hash` VARCHAR(1024),
  `profile_picture` VARCHAR(1024),
  `office` VARCHAR(1024),
  `points_remaining` BIGINT
);

CREATE TABLE `users_rewards` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `reward_id` BIGINT,
  `user_id` BIGINT,
  `date_redeemed` VARCHAR(1024),
  `date_expiry` VARCHAR(1024),
  `has_used` BOOLEAN,
  FOREIGN KEY (`reward_id`) REFERENCES `rewards`(`id`) ON DELETE CASCADE,
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE
);