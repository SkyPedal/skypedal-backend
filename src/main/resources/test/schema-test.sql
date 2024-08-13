DROP TABLE IF EXISTS `users` CASCADE;
DROP TABLE IF EXISTS `locations` CASCADE;
DROP TABLE IF EXISTS `routes` CASCADE;

CREATE TABLE `users` (
    `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255)
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
