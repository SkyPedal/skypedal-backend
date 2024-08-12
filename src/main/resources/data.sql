INSERT INTO `users` (`name`)
VALUES ('William Moolman'), ('Simonas Burkovskis'), ('Robert Pettit'), ('Vladimir Volgin'), ('Samuel Elliott');

INSERT INTO `rewards` (`name`,`description`,`point_cost`,`number_available`, `image_link`, `active`)
VALUES
('Free Cake', '1 delicious free cake of your choosing!', 1000, 10, '34552345-23452345-23452345.jpg', TRUE),
('Free Coffee', '1 delicious free coffee of your choosing!', 750, 25, '34552345-23452345-23452345.jpg', TRUE),
('Free Cookie', '1 delicious free cookie of your choosing!', 500, 50, '34552345-23452345-23452345.jpg', FALSE),
('Free Car', '1 delicious free car of your choosing!', 100000, 1, '34552345-23452345-23452345.jpg', TRUE);

INSERT INTO `users_rewards` (`reward_id`,`user_id`,`date_redeemed`,`date_expiry`,`has_used`)
VALUES
(1, 1, 'Thursday', '2024/09/06 T 12:00', FALSE),
(2, 1, 'Thursday', '2024/09/06 T 12:00', FALSE),
(3, 1, 'Thursday', '2024/09/06 T 12:00', FALSE),
(4, 1, 'Thursday', '2024/09/06 T 12:00', FALSE),
(1, 2, 'Thursday', '2024/09/06 T 12:00', FALSE),
(2, 2, 'Thursday', '2024/09/06 T 12:00', TRUE),
(1, 3, 'Thursday', '2024/09/06 T 12:00', FALSE),
(1, 4, 'Thursday', '2024/09/06 T 12:00', FALSE),
(1, 4, 'Thursday', '2024/09/06 T 12:00', TRUE),
(1, 5, 'Thursday', '2024/09/06 T 12:00', FALSE);