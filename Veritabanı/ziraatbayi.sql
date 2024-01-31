-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 23 Haz 2023, 10:19:17
-- Sunucu sürümü: 8.0.18
-- PHP Sürümü: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `ziraatbayi`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `gecmis`
--

CREATE TABLE `gecmis` (
  `ID` int(11) NOT NULL,
  `Urun_ad` varchar(100) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Urun_fiyat` double NOT NULL,
  `Urun_sayi` int(11) NOT NULL,
  `Urun_tur` varchar(10) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Urun_alankisi` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Urun_satankisi` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Urun_borç` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Urun_Birimfiyat` double NOT NULL,
  `Urun_odedigi` double NOT NULL,
  `Urun_tarih` varchar(100) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `gecmis`
--

INSERT INTO `gecmis` (`ID`, `Urun_ad`, `Urun_fiyat`, `Urun_sayi`, `Urun_tur`, `Urun_alankisi`, `Urun_satankisi`, `Urun_borç`, `Urun_Birimfiyat`, `Urun_odedigi`, `Urun_tarih`) VALUES
(30, 'hh', 500, 10, 'g', 'emin', 'a,a,a', '+0.0', 50, 500, '06/22/2023 02:53 ÖS,06/22/2023 02:53 ÖS,06/22/2023 02:52 ÖS'),
(31, 'aa', 200, 10, 'i', 'ben', 'ali', '+0.0', 20, 200, '06/23/2023 11:23 ÖÖ'),
(32, 'aa', 200, 10, 'i', 'ali', 'ali,ali,ali', '+0.0', 20, 200, '06/23/2023 11:24 ÖÖ,06/23/2023 11:23 ÖÖ,06/23/2023 11:23 ÖÖ'),
(33, 'aa', 400, 20, 'i', 'ali', 'a,ali', '+0.0', 20, 400, '06/23/2023 11:24 ÖÖ,06/23/2023 11:24 ÖÖ'),
(34, 'aa', 400, 10, 'i', 'sen', 'll', '+0.0', 40, 400, '06/23/2023 11:55 ÖÖ'),
(35, 'hh', 500, 10, 'g', 'sen', 'a,ll,ll', '+0.0', 50, 500, '06/23/2023 11:56 ÖÖ,06/23/2023 11:56 ÖÖ,06/23/2023 11:56 ÖÖ');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `gi̇ri̇ş`
--

CREATE TABLE `gi̇ri̇ş` (
  `KID` int(11) NOT NULL,
  `Kullanıcı_AD` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `Sıfre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `Yetki` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `gi̇ri̇ş`
--

INSERT INTO `gi̇ri̇ş` (`KID`, `Kullanıcı_AD`, `Sıfre`, `Yetki`) VALUES
(1, 'admin', '123', 1),
(2, 'a', '123', 1),
(13, 'bb', '234', 2),
(17, 'aa', '123', 2),
(18, 'iste', '123', 1),
(19, 'is', '1234', 2),
(20, 's', '123', 2),
(21, 'devrim', '123', 2),
(24, 'ali', '123', 1),
(26, 'll', '123', 2),
(27, 'mami', '123', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `urunler`
--

CREATE TABLE `urunler` (
  `UID` int(11) NOT NULL,
  `Urun_ad` varchar(100) COLLATE utf8mb4_turkish_ci NOT NULL,
  `Urun_fiyat` double NOT NULL,
  `Urun_stok` int(11) NOT NULL,
  `Urun_Tur` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `Urun_Acıklama` varchar(200) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `urunler`
--

INSERT INTO `urunler` (`UID`, `Urun_ad`, `Urun_fiyat`, `Urun_stok`, `Urun_Tur`, `Urun_Acıklama`) VALUES
(3, 'ASD', 50, 100, 'ilaç', 'asd'),
(7, 'hh', 60, 280, 'g', 'jk'),
(8, 'nn', 70, 60, 'h', 'ot'),
(10, 'leleley', 30, 31, 'h', 'mantar'),
(15, 'll', 35, 100, 'i', 'böcek'),
(16, 'aa', 60, 100, 'i', 'böcek'),
(17, 'lele', 50, 100, 'h', 'ot'),
(18, 'bb', 50, 100, 'h', 'asd');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `gecmis`
--
ALTER TABLE `gecmis`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `gi̇ri̇ş`
--
ALTER TABLE `gi̇ri̇ş`
  ADD PRIMARY KEY (`KID`);

--
-- Tablo için indeksler `urunler`
--
ALTER TABLE `urunler`
  ADD PRIMARY KEY (`UID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `gecmis`
--
ALTER TABLE `gecmis`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Tablo için AUTO_INCREMENT değeri `gi̇ri̇ş`
--
ALTER TABLE `gi̇ri̇ş`
  MODIFY `KID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Tablo için AUTO_INCREMENT değeri `urunler`
--
ALTER TABLE `urunler`
  MODIFY `UID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
