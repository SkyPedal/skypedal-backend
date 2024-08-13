CREATE TABLE `activities` (
  `id` BIGINT,
  `date` VARCHAR(1024),
  `gps` JSON,
  `activity_time` VARCHAR(1024),
  `distance` BIGINT,
  `type` VARCHAR(1024),
  `user_id` BIGINT,
  `joined_friends` JSON,
  `co2_saving` BIGINT,
  `cost_saving` BIGINT,
  `points_earned` BIGINT
);

INSERT INTO `activities` (`id`,`date`,`gps`,`activity_time`,`distance`,`type`,`user_id`,`joined_friends`,`co2_saving`,`cost_saving`,`points_earned`)
VALUES
(1,'today','','3h',3,'cycling',1,[1],3,3,234);
