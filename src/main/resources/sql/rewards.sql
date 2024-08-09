DROP TABLE IF EXISTS `rewards` CASCADE;

CREATE TABLE `rewards` (
  `id` BIGINT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(1024),
  `description` VARCHAR(1024),
  `point_cost` BIGINT,
  `number_available` BIGINT,
  `image_link` VARCHAR(1024),
  `active` BOOLEAN
);

INSERT INTO `rewards` (`name`,`description`,`point_cost`,`number_available`,`image_link`,`active`)
VALUES
('Free coffee','1 cool free coffee voucher',3000,10,'34552345-23452345-23452345.jpg',TRUE),
('Free cookie','1 cool free cookie voucher',800,15,'34552345-23452345-23452345.jpg',TRUE);