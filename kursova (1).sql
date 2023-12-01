-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Дек 01 2023 г., 14:36
-- Версия сервера: 10.4.27-MariaDB
-- Версия PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `kursova`
--

-- --------------------------------------------------------

--
-- Структура таблицы `event`
--

CREATE TABLE `event` (
  `id` int(11) NOT NULL,
  `name_event` varchar(50) DEFAULT NULL,
  `event_date` date DEFAULT NULL,
  `event_start_time` varchar(50) DEFAULT NULL,
  `estimates_end_time` varchar(50) DEFAULT NULL,
  `venue` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `event`
--

INSERT INTO `event` (`id`, `name_event`, `event_date`, `event_start_time`, `estimates_end_time`, `venue`) VALUES
(1, 'International scientific and technical conference', '2023-09-21', '10:00', '16:00', 'Zoom Ідентифікатор конференції: 811 5740 2277 Код 2023'),
(2, 'Lecture \"IT IN LIFE\"', '2023-11-09', '9:00', '10:30', 'Zoom'),
(3, 'Lecture \"IT IN LIFE\" cyber security', '2023-11-03', '11:00', '12:30', 'Google Meet https://meet.google.com/pci-qxgg-zrv'),
(4, 'election of representatives', '2023-10-26', '14:00', '15:00', 'Zoom Ідентифікатор конференції: 897 6440 1371 Код: 277484');

-- --------------------------------------------------------

--
-- Структура таблицы `hostel`
--

CREATE TABLE `hostel` (
  `address` varchar(50) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `hostel_number` int(11) DEFAULT NULL,
  `total_number_place` int(11) NOT NULL,
  `number_free_p_boys` int(11) DEFAULT NULL,
  `number_free_p_girls` int(11) DEFAULT NULL,
  `phone_number` mediumtext DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `hostel`
--

INSERT INTO `hostel` (`address`, `id`, `hostel_number`, `total_number_place`, `number_free_p_boys`, `number_free_p_girls`, `phone_number`) VALUES
('vyl. Sadova', 1, 4, 1200, 14, 13, '0506584738'),
('vyl. Soborna', 2, 5, 450, 5, 11, '0502345412');

-- --------------------------------------------------------

--
-- Структура таблицы `payment`
--

CREATE TABLE `payment` (
  `id` int(11) NOT NULL,
  `last_payment_date` date DEFAULT NULL,
  `fix_payment_date` date DEFAULT NULL,
  `amount_of_last_payment` double DEFAULT NULL,
  `total_amount` double DEFAULT NULL,
  `fixed_amount` double DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `payment`
--

INSERT INTO `payment` (`id`, `last_payment_date`, `fix_payment_date`, `amount_of_last_payment`, `total_amount`, `fixed_amount`, `student_id`) VALUES
(17, '2023-08-02', '2023-08-09', 1200, 6132, 1200, 13),
(18, '2023-08-01', '2023-08-10', 1200, 9264, 1200, 14),
(20, '2023-08-02', '2023-08-11', 1200, 7665, 1200, 15),
(21, '2023-08-03', '2023-08-11', 1200, 1200, 1200, 11),
(22, '2023-08-04', '2023-08-10', 1200, 3600, 1200, 12),
(23, '2023-08-16', '2023-08-17', 1200, 1200, 1200, 16),
(24, '2023-08-08', '2023-08-10', 1200, 2400, 1200, 17),
(25, '2023-07-06', '2023-08-17', 1200, 1200, 1200, 18),
(26, '2023-07-31', '2023-08-19', 1200, 4800, 1200, 19),
(27, '2023-08-15', '2023-08-18', 1200, 6000, 1200, 20),
(28, '2023-07-21', '2023-08-09', 1200, 1200, 1200, 21),
(29, '2023-08-10', '2023-08-11', 1200, 6000, 1200, 22),
(30, '2023-08-03', '2023-08-10', 1200, 4800, 1200, 23),
(31, '2023-08-15', '2023-08-16', 1200, 2400, 1200, 24),
(32, '2023-08-15', '2023-08-16', 1200, 4800, 1200, 25);

-- --------------------------------------------------------

--
-- Структура таблицы `roles`
--

CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `roles`
--

INSERT INTO `roles` (`id`, `name`) VALUES
(3, 'ROLE_Accountant'),
(1, 'ROLE_ADMIN'),
(2, 'ROLE_Employee');

-- --------------------------------------------------------

--
-- Структура таблицы `room`
--

CREATE TABLE `room` (
  `id` int(11) NOT NULL,
  `room_number` varchar(50) DEFAULT NULL,
  `free/busy` varchar(50) DEFAULT NULL,
  `room_type` varchar(50) DEFAULT NULL,
  `cost_accommodation` double DEFAULT NULL,
  `hostel_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `room`
--

INSERT INTO `room` (`id`, `room_number`, `free/busy`, `room_type`, `cost_accommodation`, `hostel_id`) VALUES
(1, '23', 'busy', 'triple room', 1200, 2),
(2, '24', 'busy(1)', 'double room', 1200, 1),
(3, '12', 'busy', 'double room', 1200, 1),
(4, '31', 'busy(1)', 'triple room', 1200, 2),
(5, '14', 'busy(1)', 'triple room', 1200, 2),
(6, '17', 'busy', 'double room', 1200, 1),
(7, '22', 'busy(1)', 'double room', 1200, 1),
(8, '21', 'free', 'double room', 1200, 1),
(9, '13', 'free', 'triple room', 1200, 2),
(10, '25', 'busy', 'double room', 1200, 2),
(11, '32', 'free', 'double room', 1200, 1),
(12, '22', 'free', 'double room', 1200, 2),
(13, '33', 'busy(1)', 'triple room', 1200, 1),
(14, '34', 'free', 'triple room', 1200, 1),
(15, '11', 'busy(1)', 'double room', 1200, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `room_seq`
--

CREATE TABLE `room_seq` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;

--
-- Дамп данных таблицы `room_seq`
--

INSERT INTO `room_seq` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(50001, 1, 9223372036854775806, 1, 50, 1000, 0, 0);

-- --------------------------------------------------------

--
-- Структура таблицы `service`
--

CREATE TABLE `service` (
  `id` int(11) NOT NULL,
  `Name_service` varchar(50) DEFAULT NULL,
  `cost_service` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `service`
--

INSERT INTO `service` (`id`, `Name_service`, `cost_service`) VALUES
(1, 'dining room (month)', 2000),
(2, 'Repair and technical maintenance services', 200),
(3, 'Services for Internet access (month)', 150);

-- --------------------------------------------------------

--
-- Структура таблицы `student`
--

CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name_resident` varchar(150) DEFAULT NULL,
  `name_faculty` varchar(50) DEFAULT NULL,
  `group` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `room_number` varchar(50) DEFAULT NULL,
  `date_settlement` date DEFAULT NULL,
  `date_eviction` date DEFAULT NULL,
  `preferential_category` varchar(50) DEFAULT NULL,
  `budget_contract` varchar(50) DEFAULT NULL,
  `residence_status` varchar(50) DEFAULT NULL,
  `room_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `student`
--

INSERT INTO `student` (`id`, `name_resident`, `name_faculty`, `group`, `year`, `room_number`, `date_settlement`, `date_eviction`, `preferential_category`, `budget_contract`, `residence_status`, `room_id`) VALUES
(11, 'Kotov Victor Oleksandrovich', 'software Engineering', '1151', 1, '12', '2023-07-29', '2027-05-31', 'none', 'contract', 'lives', 3),
(12, 'Sova Anastasia Sergiivna', 'software engineering', '3151', 3, '31', '2020-08-27', '2024-05-31', 'none', 'budget', 'lives', 4),
(13, 'Volokov Oleksandr Anatolievich', 'design', '2114', 2, '12', '2021-08-26', '2025-05-31', 'none', 'contract', 'lives', 3),
(14, 'Hanich Yulia Volodymyrivna ', 'software engineering', '2151 st', 2, '23', '2022-08-29', '2025-05-29', 'none', 'budget', 'lives', 1),
(15, 'Chubak Nataliya Hryhorivna ', 'marine economics', '4444', 4, '24', '2019-08-21', '2024-05-30', 'none', 'budget', 'lives', 2),
(16, 'Fedorets Artem Valeriyovych', 'design', '1113', 1, '14', '2023-08-30', '2026-06-01', 'none', 'contract', 'lives', 5),
(17, 'Toporets Andriy Vasyliovych ', 'marine economics', '2131', 2, '17', '2021-08-27', '2025-05-30', 'none', 'contract', 'lives', 6),
(18, ' Obruch Anna Ivanivna', 'design', '1111 st', 1, '22', '2023-08-15', '2026-05-27', 'none', 'budget', 'lives', 7),
(19, 'Tchannikova Maria Valeriivna', 'software Engineering', '3151', 3, '23', '2021-08-18', '2025-05-30', 'none', 'budget', 'lives', 1),
(20, 'Yashchenko Yaroslav Yuriyovych', 'marine economics', '4353', 4, '17', '2020-08-05', '2024-05-30', 'none', 'contract', 'lives', 6),
(21, 'Dovbenko Maria Serhiyivna ', 'design', '1112', 1, '23', '2023-08-08', '2027-05-04', 'none', 'budget', 'lives', 1),
(22, 'Spivak Svitlana Oleksiivna', 'marine economics', '4353', 4, '25', '2020-08-12', '2024-05-08', 'none', 'budget', 'lives', 10),
(23, 'Ponomarenko Maria Mykhailivna', 'software Engineering', '3152', 3, '25', '2021-08-11', '2025-05-23', 'none', 'contract', 'lives', 10),
(24, 'Kosach Natalia Oleksiivna', 'design', '2111', 2, '33', '2021-08-04', '2026-05-15', 'none', 'contract', 'lives', 13),
(25, 'Kondratenko Mykola Serhiyovych', 'software Engineering', '3151', 3, '11', '2020-08-13', '2025-05-31', 'none', 'budget', 'lives', 15);

-- --------------------------------------------------------

--
-- Структура таблицы `student_events`
--

CREATE TABLE `student_events` (
  `id` int(11) NOT NULL,
  `events_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `student_events`
--

INSERT INTO `student_events` (`id`, `events_id`, `student_id`) VALUES
(1, 1, 13),
(2, 1, 11),
(3, 2, 12),
(4, 1, 17),
(5, 1, 20),
(6, 2, 18),
(7, 2, 20),
(8, 2, 19),
(9, 3, 21),
(10, 3, 22),
(11, 4, 23),
(12, 4, 24),
(13, 4, 25),
(14, 3, 14),
(15, 4, 15),
(16, 3, 16),
(17, 1, 16),
(18, 2, 25),
(19, 3, 25),
(20, 4, 11),
(21, 4, 13),
(22, 3, 13),
(23, 4, 20);

-- --------------------------------------------------------

--
-- Структура таблицы `student_services`
--

CREATE TABLE `student_services` (
  `id` int(11) NOT NULL,
  `payment_amount` double DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `student_services`
--

INSERT INTO `student_services` (`id`, `payment_amount`, `service_id`, `student_id`) VALUES
(1, 2000, 1, 11),
(2, 2000, 1, 12),
(3, 200, 2, 11),
(4, 150, 3, 13),
(5, 150, 3, 17),
(6, 150, 3, 18),
(7, 150, 3, 20),
(8, 150, 3, 21),
(9, 2000, 1, 20),
(10, 2000, 1, 13),
(11, 200, 2, 20);

-- --------------------------------------------------------

--
-- Структура таблицы `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `users`
--

INSERT INTO `users` (`id`, `email`, `name`, `password`) VALUES
(1, '211205@nuos.edu.ua', 'Nastya Filina', '$2a$10$xjcqxX9oJmJVo1W5SbJciOJZR8MzBNtsurDFZeKOG7pTNw74O/7Xu'),
(2, 'fiillina.anastasia@gmail.com', 'Анастасія Філіна', '$2a$10$czQJB3vyUGr6ww856Fl8bevVzYFOiJC0wT3AVBZncPRZ6yENWdP76'),
(3, 'nsf140504@gmail.com', 'Oksana Kosach', '$2a$10$Wecdb93wTysAxwGAJNnWZeaKIp3Qg6Uh/kKi8WQQTjgPhwd7jtmRy');

-- --------------------------------------------------------

--
-- Структура таблицы `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Дамп данных таблицы `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `hostel`
--
ALTER TABLE `hostel`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKq0mpbhvyrwyggk1gwjams69wf` (`student_id`);

--
-- Индексы таблицы `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`);

--
-- Индексы таблицы `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKh7ueokexskp911yuiijx60mph` (`hostel_id`);

--
-- Индексы таблицы `service`
--
ALTER TABLE `service`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp18j1374fj5si14u9xjty9b2o` (`room_id`);

--
-- Индексы таблицы `student_events`
--
ALTER TABLE `student_events`
  ADD PRIMARY KEY (`id`,`student_id`,`events_id`),
  ADD KEY `FKcondoy12ouc608w34ism49xtn` (`events_id`),
  ADD KEY `FKd7hibfqqvqb4k50cq612pe0fl` (`student_id`);

--
-- Индексы таблицы `student_services`
--
ALTER TABLE `student_services`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKachnog848pedp08t4jpodsq4c` (`service_id`),
  ADD KEY `FKa5k9gjntaea62mg80ue2xdmi8` (`student_id`);

--
-- Индексы таблицы `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- Индексы таблицы `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  ADD KEY `FK2o0jvgh89lemvvo17cbqvdxaa` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `event`
--
ALTER TABLE `event`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `hostel`
--
ALTER TABLE `hostel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `payment`
--
ALTER TABLE `payment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT для таблицы `roles`
--
ALTER TABLE `roles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `room`
--
ALTER TABLE `room`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT для таблицы `service`
--
ALTER TABLE `service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT для таблицы `student_events`
--
ALTER TABLE `student_events`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT для таблицы `student_services`
--
ALTER TABLE `student_services`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT для таблицы `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `FKq0mpbhvyrwyggk1gwjams69wf` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

--
-- Ограничения внешнего ключа таблицы `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `FKh7ueokexskp911yuiijx60mph` FOREIGN KEY (`hostel_id`) REFERENCES `hostel` (`id`);

--
-- Ограничения внешнего ключа таблицы `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `FKp18j1374fj5si14u9xjty9b2o` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`);

--
-- Ограничения внешнего ключа таблицы `student_events`
--
ALTER TABLE `student_events`
  ADD CONSTRAINT `FKcondoy12ouc608w34ism49xtn` FOREIGN KEY (`events_id`) REFERENCES `event` (`id`),
  ADD CONSTRAINT `FKd7hibfqqvqb4k50cq612pe0fl` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);

--
-- Ограничения внешнего ключа таблицы `student_services`
--
ALTER TABLE `student_services`
  ADD CONSTRAINT `FKa5k9gjntaea62mg80ue2xdmi8` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  ADD CONSTRAINT `FKachnog848pedp08t4jpodsq4c` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`);

--
-- Ограничения внешнего ключа таблицы `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FK2o0jvgh89lemvvo17cbqvdxaa` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
