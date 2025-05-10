-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2025. Máj 10. 15:26
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
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 7);

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
(7, 5, 1, 1);

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
(1, 'Test Item', 5, 1),
(3, 'The Badass Sword of Epicness', 5, 4),
(5, 'Pooh', 3, 0.75),
(7, 'Anby Demara', 4, 2),
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
(1, 'admin', 'admin', 80),
(2, 'Pity', 'Pity', 15),
(3, 'asd', 'asd', 20),
(4, 'asd123', 'asd123', 18),
(5, 'max', 'max', 14);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT a táblához `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT a táblához `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

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
