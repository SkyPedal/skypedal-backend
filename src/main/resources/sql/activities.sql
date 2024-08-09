CREATE TABLE `activities` (
  `id` BIGINT,
  `date` VARCHAR(1024),
  `gps` JSON,
  `activity_time` VARCHAR(1024),
  `distance` VARCHAR(1024),
  `type` VARCHAR(1024),
  `user_id` VARCHAR(1024),
  `joined_friends` JSON,
  `co2_saving` VARCHAR(1024),
  `cost_saving` VARCHAR(1024),
  `points_earned` BIGINT
);

INSERT INTO `activities` (`id`,`date`,`gps`,`activity_time`,`distance`,`type`,`user_id`,`joined_friends`,`co2_saving`,`cost_saving`,`points_earned`)
VALUES
(1,'today','["coordinates"]','3h','3miles','cycling|running|walking','FK(user)','["FK(user)"]','3kg','3gbp',234);
