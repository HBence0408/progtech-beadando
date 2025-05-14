-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2025. Máj 14. 08:21
-- Kiszolgáló verziója: 10.4.32-MariaDB
-- PHP verzió: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `gatchasim`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `banner`
--

CREATE TABLE `banner` (
  `banner_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `three_star_item` int(11) NOT NULL,
  `four_star_item` int(11) NOT NULL,
  `five_star_item` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `banner`
--

INSERT INTO `banner` (`banner_id`, `name`, `three_star_item`, `four_star_item`, `five_star_item`) VALUES
(1, 'Beginner Banner', 5, 7, 9);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `equiped_item`
--

CREATE TABLE `equiped_item` (
  `user_id` int(11) NOT NULL,
  `equiped_item_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `equiped_item`
--

INSERT INTO `equiped_item` (`user_id`, `equiped_item_id`) VALUES
(1, 79),
(2, 2),
(3, 3),
(4, 4),
(5, 7),
(6, 174),
(7, 455);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `inventory`
--

CREATE TABLE `inventory` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `item_id` int(2) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `inventory`
--

INSERT INTO `inventory` (`id`, `user_id`, `item_id`, `quantity`) VALUES
(1, 1, 1, 2),
(2, 2, 1, 1),
(3, 3, 1, 1),
(4, 4, 1, 1),
(5, 1, 3, 5),
(7, 5, 1, 1),
(8, 1, 5, 1),
(9, 1, 5, 1),
(10, 1, 5, 1),
(11, 1, 5, 1),
(12, 1, 5, 1),
(13, 1, 5, 1),
(14, 1, 5, 1),
(15, 1, 5, 1),
(16, 1, 5, 1),
(17, 1, 5, 1),
(18, 1, 5, 1),
(19, 1, 7, 1),
(20, 1, 5, 1),
(21, 1, 5, 1),
(22, 1, 5, 1),
(23, 1, 5, 1),
(24, 1, 5, 1),
(25, 1, 5, 1),
(26, 1, 5, 1),
(27, 1, 5, 1),
(28, 1, 7, 1),
(29, 1, 7, 1),
(30, 1, 7, 1),
(31, 1, 5, 1),
(32, 1, 5, 1),
(33, 1, 7, 1),
(34, 1, 5, 1),
(35, 1, 5, 1),
(36, 1, 5, 1),
(37, 1, 5, 1),
(38, 1, 5, 1),
(39, 1, 5, 1),
(40, 1, 5, 1),
(41, 1, 5, 1),
(42, 1, 5, 1),
(43, 1, 5, 1),
(44, 1, 5, 1),
(45, 1, 5, 1),
(46, 1, 5, 1),
(47, 1, 5, 1),
(48, 1, 5, 1),
(49, 1, 5, 1),
(50, 1, 5, 1),
(51, 1, 5, 1),
(52, 1, 5, 1),
(53, 1, 5, 1),
(54, 1, 7, 1),
(55, 1, 7, 1),
(56, 1, 5, 1),
(57, 1, 5, 1),
(58, 1, 5, 1),
(59, 1, 5, 1),
(60, 1, 5, 1),
(61, 1, 5, 1),
(62, 1, 5, 1),
(63, 1, 5, 1),
(64, 1, 7, 1),
(65, 1, 5, 1),
(66, 1, 5, 1),
(67, 1, 5, 1),
(68, 1, 5, 1),
(69, 1, 5, 1),
(70, 1, 5, 1),
(71, 1, 5, 1),
(72, 1, 5, 1),
(73, 1, 5, 1),
(74, 1, 7, 1),
(75, 1, 7, 1),
(76, 1, 9, 1),
(77, 1, 7, 1),
(78, 1, 5, 1),
(79, 1, 9, 1),
(80, 1, 5, 1),
(81, 1, 5, 1),
(82, 1, 5, 1),
(83, 1, 5, 1),
(84, 1, 5, 1),
(85, 1, 5, 1),
(86, 1, 5, 1),
(87, 1, 5, 1),
(88, 1, 7, 1),
(89, 1, 5, 1),
(90, 1, 5, 1),
(91, 1, 7, 1),
(92, 1, 7, 1),
(93, 1, 7, 1),
(94, 1, 7, 1),
(95, 1, 5, 1),
(96, 1, 5, 1),
(97, 1, 5, 1),
(98, 6, 1, 1),
(99, 6, 5, 1),
(100, 6, 7, 1),
(101, 6, 7, 1),
(102, 6, 7, 1),
(103, 6, 7, 1),
(104, 6, 7, 1),
(105, 6, 5, 1),
(106, 6, 5, 1),
(107, 6, 5, 1),
(108, 6, 5, 1),
(109, 6, 5, 1),
(110, 6, 5, 1),
(111, 6, 5, 1),
(112, 6, 5, 1),
(113, 6, 7, 1),
(114, 6, 5, 1),
(115, 6, 5, 1),
(116, 6, 5, 1),
(117, 6, 5, 1),
(118, 6, 5, 1),
(119, 6, 7, 1),
(120, 6, 5, 1),
(121, 6, 5, 1),
(122, 6, 5, 1),
(123, 6, 5, 1),
(124, 6, 5, 1),
(125, 6, 7, 1),
(126, 6, 7, 1),
(127, 6, 5, 1),
(128, 6, 5, 1),
(129, 6, 7, 1),
(130, 6, 5, 1),
(131, 6, 5, 1),
(132, 6, 5, 1),
(133, 6, 5, 1),
(134, 6, 5, 1),
(135, 6, 7, 1),
(136, 6, 5, 1),
(137, 6, 7, 1),
(138, 6, 5, 1),
(139, 6, 5, 1),
(140, 6, 5, 1),
(141, 6, 5, 1),
(142, 6, 5, 1),
(143, 6, 5, 1),
(144, 6, 5, 1),
(145, 6, 5, 1),
(146, 6, 5, 1),
(147, 6, 5, 1),
(148, 6, 5, 1),
(149, 6, 5, 1),
(150, 6, 5, 1),
(151, 6, 5, 1),
(152, 6, 5, 1),
(153, 6, 5, 1),
(154, 6, 5, 1),
(155, 6, 7, 1),
(156, 6, 5, 1),
(157, 6, 5, 1),
(158, 6, 5, 1),
(159, 6, 5, 1),
(160, 6, 7, 1),
(161, 6, 5, 1),
(162, 6, 5, 1),
(163, 6, 5, 1),
(164, 6, 5, 1),
(165, 6, 5, 1),
(166, 6, 5, 1),
(167, 6, 7, 1),
(168, 6, 5, 1),
(169, 6, 5, 1),
(170, 6, 5, 1),
(171, 6, 5, 1),
(172, 6, 5, 1),
(173, 6, 5, 1),
(174, 6, 9, 1),
(175, 6, 9, 1),
(176, 6, 5, 1),
(177, 6, 5, 1),
(178, 6, 7, 1),
(179, 6, 5, 1),
(180, 1, 5, 1),
(181, 1, 5, 1),
(182, 1, 5, 1),
(183, 1, 5, 1),
(184, 1, 7, 1),
(185, 1, 5, 1),
(186, 1, 5, 1),
(187, 1, 5, 1),
(188, 1, 7, 1),
(189, 1, 5, 1),
(190, 1, 7, 1),
(191, 1, 5, 1),
(192, 1, 7, 1),
(193, 1, 5, 1),
(194, 1, 5, 1),
(195, 1, 5, 1),
(196, 1, 5, 1),
(197, 1, 5, 1),
(198, 1, 5, 1),
(199, 1, 7, 1),
(200, 1, 5, 1),
(201, 1, 5, 1),
(202, 1, 5, 1),
(203, 1, 5, 1),
(204, 1, 5, 1),
(205, 1, 5, 1),
(206, 1, 7, 1),
(207, 1, 7, 1),
(208, 1, 5, 1),
(209, 1, 5, 1),
(210, 1, 7, 1),
(211, 1, 9, 1),
(212, 1, 5, 1),
(213, 1, 5, 1),
(214, 1, 5, 1),
(215, 1, 5, 1),
(216, 1, 5, 1),
(217, 1, 5, 1),
(218, 1, 7, 1),
(219, 1, 5, 1),
(220, 1, 5, 1),
(221, 1, 5, 1),
(222, 1, 5, 1),
(223, 1, 5, 1),
(224, 1, 5, 1),
(225, 1, 5, 1),
(226, 1, 5, 1),
(227, 1, 5, 1),
(228, 1, 5, 1),
(229, 1, 5, 1),
(230, 1, 5, 1),
(231, 1, 7, 1),
(232, 1, 5, 1),
(233, 1, 5, 1),
(234, 1, 7, 1),
(235, 1, 5, 1),
(236, 1, 5, 1),
(237, 1, 5, 1),
(238, 1, 5, 1),
(239, 1, 5, 1),
(240, 1, 7, 1),
(241, 1, 5, 1),
(242, 1, 5, 1),
(243, 1, 5, 1),
(244, 1, 5, 1),
(245, 1, 5, 1),
(246, 1, 5, 1),
(247, 1, 5, 1),
(248, 1, 5, 1),
(249, 1, 5, 1),
(250, 1, 5, 1),
(251, 1, 5, 1),
(252, 1, 5, 1),
(253, 1, 5, 1),
(254, 1, 5, 1),
(255, 1, 5, 1),
(256, 1, 5, 1),
(257, 1, 5, 1),
(258, 1, 7, 1),
(259, 1, 5, 1),
(260, 1, 7, 1),
(261, 1, 5, 1),
(262, 1, 5, 1),
(263, 1, 5, 1),
(264, 1, 7, 1),
(265, 1, 7, 1),
(266, 1, 7, 1),
(267, 1, 5, 1),
(268, 1, 5, 1),
(269, 1, 5, 1),
(270, 1, 5, 1),
(271, 1, 5, 1),
(272, 1, 5, 1),
(273, 1, 5, 1),
(274, 1, 5, 1),
(275, 1, 5, 1),
(276, 1, 5, 1),
(277, 1, 5, 1),
(278, 1, 5, 1),
(279, 1, 7, 1),
(280, 1, 5, 1),
(281, 1, 5, 1),
(282, 1, 5, 1),
(283, 1, 5, 1),
(284, 1, 5, 1),
(285, 1, 5, 1),
(286, 1, 5, 1),
(287, 1, 5, 1),
(288, 1, 5, 1),
(289, 1, 7, 1),
(290, 1, 5, 1),
(291, 1, 5, 1),
(292, 1, 5, 1),
(293, 1, 5, 1),
(294, 1, 5, 1),
(295, 1, 7, 1),
(296, 1, 5, 1),
(297, 1, 7, 1),
(298, 1, 5, 1),
(299, 1, 5, 1),
(300, 1, 5, 1),
(301, 1, 5, 1),
(302, 1, 5, 1),
(303, 1, 5, 1),
(304, 1, 5, 1),
(305, 1, 7, 1),
(306, 1, 5, 1),
(307, 1, 5, 1),
(308, 1, 5, 1),
(309, 1, 5, 1),
(310, 1, 7, 1),
(311, 1, 5, 1),
(312, 1, 5, 1),
(313, 1, 7, 1),
(314, 1, 5, 1),
(315, 1, 5, 1),
(316, 1, 5, 1),
(317, 1, 5, 1),
(318, 1, 5, 1),
(319, 1, 9, 1),
(320, 1, 5, 1),
(321, 1, 7, 1),
(322, 1, 5, 1),
(323, 1, 7, 1),
(324, 1, 5, 1),
(325, 1, 5, 1),
(326, 1, 5, 1),
(327, 1, 5, 1),
(328, 1, 5, 1),
(329, 1, 5, 1),
(330, 1, 5, 1),
(331, 1, 5, 1),
(332, 1, 5, 1),
(333, 1, 5, 1),
(334, 1, 5, 1),
(335, 1, 5, 1),
(336, 1, 5, 1),
(337, 1, 5, 1),
(338, 1, 5, 1),
(339, 1, 7, 1),
(340, 1, 5, 1),
(341, 1, 5, 1),
(342, 1, 5, 1),
(343, 1, 7, 1),
(344, 1, 5, 1),
(345, 1, 5, 1),
(346, 1, 7, 1),
(347, 1, 5, 1),
(348, 1, 5, 1),
(349, 1, 5, 1),
(350, 1, 5, 1),
(351, 1, 5, 1),
(352, 1, 5, 1),
(353, 1, 7, 1),
(354, 1, 5, 1),
(355, 1, 5, 1),
(356, 1, 5, 1),
(357, 1, 5, 1),
(358, 1, 5, 1),
(359, 1, 5, 1),
(360, 1, 5, 1),
(361, 1, 5, 1),
(362, 1, 5, 1),
(363, 1, 7, 1),
(364, 1, 7, 1),
(365, 1, 7, 1),
(366, 1, 5, 1),
(367, 1, 5, 1),
(368, 1, 5, 1),
(369, 1, 5, 1),
(370, 1, 5, 1),
(371, 1, 5, 1),
(372, 1, 5, 1),
(373, 1, 7, 1),
(374, 1, 5, 1),
(375, 1, 5, 1),
(376, 1, 5, 1),
(377, 1, 5, 1),
(378, 1, 5, 1),
(379, 1, 5, 1),
(380, 1, 5, 1),
(381, 1, 5, 1),
(382, 1, 5, 1),
(383, 1, 5, 1),
(384, 1, 5, 1),
(385, 1, 5, 1),
(386, 1, 5, 1),
(387, 1, 7, 1),
(388, 1, 5, 1),
(389, 1, 7, 1),
(390, 1, 5, 1),
(391, 1, 5, 1),
(392, 1, 5, 1),
(393, 1, 5, 1),
(394, 1, 5, 1),
(395, 1, 5, 1),
(396, 1, 5, 1),
(397, 1, 7, 1),
(398, 1, 7, 1),
(399, 1, 5, 1),
(400, 1, 5, 1),
(401, 1, 9, 1),
(402, 1, 5, 1),
(403, 1, 5, 1),
(404, 1, 5, 1),
(405, 1, 5, 1),
(406, 1, 5, 1),
(407, 1, 5, 1),
(408, 1, 5, 1),
(409, 1, 7, 1),
(410, 1, 5, 1),
(411, 1, 7, 1),
(412, 1, 5, 1),
(413, 1, 7, 1),
(414, 1, 5, 1),
(415, 1, 7, 1),
(416, 1, 5, 1),
(417, 1, 5, 1),
(418, 1, 7, 1),
(419, 1, 5, 1),
(420, 1, 7, 1),
(421, 1, 5, 1),
(422, 1, 5, 1),
(423, 1, 5, 1),
(424, 1, 7, 1),
(425, 1, 5, 1),
(426, 1, 5, 1),
(427, 1, 5, 1),
(428, 1, 7, 1),
(429, 1, 5, 1),
(430, 1, 7, 1),
(431, 1, 5, 1),
(432, 1, 5, 1),
(433, 1, 7, 1),
(434, 1, 5, 1),
(435, 1, 5, 1),
(436, 1, 5, 1),
(437, 1, 5, 1),
(438, 1, 5, 1),
(439, 1, 5, 1),
(440, 1, 5, 1),
(441, 1, 5, 1),
(442, 1, 5, 1),
(443, 1, 7, 1),
(444, 1, 5, 1),
(445, 1, 5, 1),
(446, 1, 5, 1),
(447, 1, 7, 1),
(448, 1, 5, 1),
(449, 1, 9, 1),
(450, 7, 1, 1),
(451, 7, 5, 1),
(452, 7, 5, 1),
(453, 7, 7, 1),
(454, 7, 5, 1),
(455, 7, 9, 1),
(456, 7, 5, 1),
(457, 7, 5, 1),
(458, 7, 7, 1),
(459, 7, 5, 1),
(460, 7, 5, 1),
(461, 7, 5, 1),
(462, 7, 5, 1),
(463, 7, 5, 1),
(464, 7, 5, 1),
(465, 7, 5, 1),
(466, 7, 5, 1),
(467, 7, 5, 1),
(468, 7, 5, 1),
(469, 7, 5, 1),
(470, 7, 7, 1),
(471, 7, 5, 1),
(472, 7, 5, 1),
(473, 7, 5, 1),
(474, 7, 5, 1),
(475, 7, 5, 1),
(476, 7, 5, 1),
(477, 7, 5, 1),
(478, 7, 5, 1),
(479, 7, 7, 1),
(480, 7, 5, 1),
(481, 7, 5, 1),
(482, 7, 5, 1),
(483, 7, 5, 1),
(484, 7, 5, 1),
(485, 7, 5, 1),
(486, 7, 5, 1),
(487, 7, 7, 1),
(488, 7, 5, 1),
(489, 7, 7, 1),
(490, 7, 7, 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `rarity` int(2) NOT NULL,
  `multiplier` float NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `items`
--

INSERT INTO `items` (`id`, `name`, `rarity`, `multiplier`) VALUES
(1, 'Beginner\'s Friend', 1, 1),
(3, 'The Badass Sword of Epicness', 5, 4),
(5, 'Pooh', 3, 2),
(7, 'Anby Demara', 4, 3),
(9, 'Grace Howard', 5, 5);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `coins` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- A tábla adatainak kiíratása `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `coins`) VALUES
(1, 'admin', 'admin', 105),
(2, 'Pity', 'Pity', 15),
(3, 'asd', 'asd', 20),
(4, 'asd123', 'asd123', 18),
(5, 'max', 'max', 14),
(6, 'tester', 'tester', 148),
(7, 'demo', 'demo', 6);

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`banner_id`),
  ADD KEY `fk_three_star_item` (`three_star_item`),
  ADD KEY `fk_four_star_item` (`four_star_item`),
  ADD KEY `five_star_item` (`five_star_item`);

--
-- A tábla indexei `equiped_item`
--
ALTER TABLE `equiped_item`
  ADD PRIMARY KEY (`user_id`,`equiped_item_id`) USING BTREE,
  ADD KEY `equiped_item_id` (`equiped_item_id`);

--
-- A tábla indexei `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id`),
  ADD KEY `item.id` (`item_id`),
  ADD KEY `user_id` (`user_id`);

--
-- A tábla indexei `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- A tábla indexei `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `banner`
--
ALTER TABLE `banner`
  MODIFY `banner_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT a táblához `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=491;

--
-- AUTO_INCREMENT a táblához `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT a táblához `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `banner`
--
ALTER TABLE `banner`
  ADD CONSTRAINT `banner_ibfk_1` FOREIGN KEY (`three_star_item`) REFERENCES `items` (`id`),
  ADD CONSTRAINT `banner_ibfk_3` FOREIGN KEY (`five_star_item`) REFERENCES `items` (`id`),
  ADD CONSTRAINT `banner_ibfk_4` FOREIGN KEY (`four_star_item`) REFERENCES `items` (`id`);

--
-- Megkötések a táblához `equiped_item`
--
ALTER TABLE `equiped_item`
  ADD CONSTRAINT `equiped_item_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `equiped_item_ibfk_2` FOREIGN KEY (`equiped_item_id`) REFERENCES `inventory` (`id`);

--
-- Megkötések a táblához `inventory`
--
ALTER TABLE `inventory`
  ADD CONSTRAINT `inventory_ibfk_1` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`),
  ADD CONSTRAINT `inventory_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
