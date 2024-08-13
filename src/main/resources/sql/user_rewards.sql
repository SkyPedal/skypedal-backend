--------------------------------------------------------------------------------------------------------------------
--                                    THIS FILE IS ONLY FOR REFERENCE                                             --
--  Files are not run as part of the program, only data.sql, test-data.sql, and test-schema.sql are actually used --
--------------------------------------------------------------------------------------------------------------------
CREATE TABLE `user_rewards` (
  `id` BIGINT,
  `reward_id` BIGINT,
  `user_id` BIGINT,
  `date_redeemed` VARCHAR(1024),
  `date_expiry` VARCHAR(1024),
  `has_used` BOOLEAN
);

INSERT INTO `user_rewards` (`id`,`reward_id`,`user_id`,`date_redeemed`,`date_expiry`,`has_used`)
VALUES
(1,1,1,'thursday','2024/09/06 T 12:00',FALSE),
(2,1,1,'last thursday','2024/09/09 T 10:00',TRUE),
(3,2,1,'last wednesday','2024/09/01 T 18:00',FALSE);
