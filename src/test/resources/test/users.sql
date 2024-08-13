DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE USERS (
  `ID` INT PRIMARY KEY AUTO_INCREMENT,
  `email` VARCHAR(1024),
  `first_name` VARCHAR(1024),
  `last_name` VARCHAR(1024),
  `office_location` VARCHAR(1024),
  `reward_points` INT
);

