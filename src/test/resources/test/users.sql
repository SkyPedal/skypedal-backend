DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS locations CASCADE;
DROP TABLE IF EXISTS routes CASCADE;
DROP TABLE IF EXISTS rewards CASCADE;
DROP TABLE IF EXISTS users_rewards CASCADE;


CREATE TABLE USERS (
  `ID` INT PRIMARY KEY AUTO_INCREMENT,
  `email` VARCHAR(1024),
  `first_name` VARCHAR(1024),
  `last_name` VARCHAR(1024),
  `office_location` VARCHAR(1024),
  `reward_points` INT,
  `password_hash` VARCHAR(1024),
  `user_rewards` VARCHAr(1024)
);

CREATE TABLE `locations` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `lat` FLOAT(53),
    `lng` FLOAT(53),
    `user_id` INTEGER,
    `name` VARCHAR(255),
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
);

CREATE TABLE `routes`(
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `distance_m` INTEGER,
    `duration_s` INTEGER,
    `start_id` INTEGER,
    `end_id` INTEGER,
    `user_id` INTEGER,
    `geo_json` TEXT,
    FOREIGN KEY (`start_id`) REFERENCES `locations` (`id`) ON DELETE CASCADE,
    FOREIGN KEY (`end_id`) REFERENCES `locations` (`id`) ON DELETE CASCADE,
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
);

CREATE TABLE `rewards` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(1024),
  `description` VARCHAR(1024),
  `point_cost` BIGINT,
  `number_available` BIGINT,
  `image_link` VARCHAR(1024),
  `active` BOOLEAN
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