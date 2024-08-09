CREATE TABLE `routes` (
  `id` BIGINT,
  `start_id` BIGINT,
  `end_id` BIGINT,
  `user_id` BIGINT,
  `used` BIGINT,
  `distance` BIGINT,
  `duration` BIGINT
);

INSERT INTO `routes` (`id`,`start_id`,`end_id`,`user_id`,`used`,`distance`,`duration`)
VALUES
(1,1,2,1,0,3400,1200),
(1,2,1,1,0,3500,1200);
