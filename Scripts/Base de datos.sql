-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.10.1-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for tecnoshop
DROP DATABASE IF EXISTS `tecnoshop`;
CREATE DATABASE IF NOT EXISTS `tecnoshop` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tecnoshop`;

-- Dumping structure for table tecnoshop.productos
DROP TABLE IF EXISTS `productos`;
CREATE TABLE IF NOT EXISTS `productos` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `marca` varchar(100) NOT NULL,
  `modelo` varchar(100) NOT NULL,
  `nombre` varchar(200) NOT NULL,
  `precio` double NOT NULL,
  `descripcion_adicional` varchar(5000) DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `categoria` varchar(100) NOT NULL,
  `url_imagen` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `Productos_categoria` (`categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=latin1;

-- Dumping data for table tecnoshop.productos: ~25 rows (approximately)
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` (`id_producto`, `marca`, `modelo`, `nombre`, `precio`, `descripcion_adicional`, `stock`, `activo`, `categoria`, `url_imagen`) VALUES
	(16, 'Sony', 'SRS-XP700', 'Bocina', 1391904, 'Funcion de karaoke bateria recargable a prueba de agua ', 50, 1, 'Bocinas', 'https://http2.mlstatic.com/D_NQ_NP_952015-MLA48688136415_122021-O.webp'),
	(17, 'Speaker', 'B28S', 'Bocina Speaker B28S', 49900, 'Manos libres conectividad bluetooth bateria recargable', 15, 1, 'Bocinas', 'https://http2.mlstatic.com/D_NQ_NP_2X_603612-MLA50482220861_062022-F.webp'),
	(18, ' Bose', 'Soundlink ColorII', 'Parlante BOSE Soundlink Color II', 540000, 'Bateria recargable incluida manos libres a prueba de agua', 9, 1, 'Bocinas', 'https://http2.mlstatic.com/D_NQ_NP_883715-MLA47289976509_082021-O.webp'),
	(19, 'Genius', 'SP-HF180', 'Bocina Genius SP-HF180 madera', 38200, 'Dos parlantes alimentacion USB Potencia 6W', 35, 1, 'Bocinas', 'https://http2.mlstatic.com/D_NQ_NP_2X_786264-MLA45733894163_042021-F.webp'),
	(20, 'JBL', 'Pulse 4', 'Bocina JBL Pulse 4 portátil', 780000, 'Conectividad bluetooth bateria recargable cargador incluido luces led', 40, 1, 'Bocinas', 'https://http2.mlstatic.com/D_NQ_NP_908256-MLA45733772990_042021-O.webphttps://http2.mlstatic.com/D_NQ_NP_908256-MLA45733772990_042021-O.webp'),
	(21, 'Samsung', 'A13 Dual SIM', 'Samsung Galaxy', 674900, 'Procesador Exynos 850 octa-core 4 camaras traseras', 12, 1, 'Smartphone', 'https://http2.mlstatic.com/D_NQ_NP_769792-MLA49703502446_042022-O.webp'),
	(22, 'Apple', 'iPhone 11', 'Apple iPhone 11 (128 GB)', 2779900, 'carga inalambrica Nombre del sistema operativo iOS 16', 2, 1, 'Smartphone', 'https://http2.mlstatic.com/D_NQ_NP_990246-MLA46153276373_052021-O.webp'),
	(23, 'Xiaomi', 'Note 10S', 'Xiaomi Redmi Note 10S Dual SIM', 925900, 'Memoria interna 128 GB Memoria RAM 6 GB Capacidad de la batería 5000 mAh', 0, 1, 'Smartphone', 'https://http2.mlstatic.com/D_NQ_NP_737594-MLA48991682753_022022-O.webp'),
	(24, 'HF 50', 'A8', 'Celular rompe muros hf50', 199999, 'Antena expansiva de seÃ±al para lugares de difÃ­cil acceso radio FM', 4, 1, 'Smartphone', 'https://http2.mlstatic.com/D_NQ_NP_2X_676914-MCO51357975687_082022-F.webp'),
	(25, 'Samsung', 'Z Flip3', 'Samsung Galaxy Z Flip3', 3969900, 'Compatible con redes 5G Pantalla plegable con una extensión total de 6.7', 17, 1, 'Smartphone', 'https://http2.mlstatic.com/D_NQ_NP_852078-MLA47887476718_102021-O.webp'),
	(26, 'AMD', 'RYZEN 7', 'Cpu Torre Pc Gamer', 3179900, 'PROCESADOR: AMD RYZEN ™ 7 5700G N.º DE NUCLEOS DE CPU: 8', 7, 1, 'computadores', 'https://http2.mlstatic.com/D_NQ_NP_661268-MCO47189663977_082021-O.webp'),
	(27, 'Intel', 'Intel UHD 630', 'Cpu Intel Core I3 10100', 1826913, 'Acrílico Lateral Transparente 2 Ventiladores de 21cm (1 LED + 1 Normal) núcleos 4', 3, 1, 'computadores', 'https://http2.mlstatic.com/D_NQ_NP_2X_852241-MCO49324798603_032022-F.webp'),
	(28, 'HP', 'Hp Pro 3000 Mt', 'Torre Cpu Hp Corporativa Core 2', 299000, 'PROCESADOR 4 NUCLEOS Core 2 QUAD 2.4 GHz Disco Duro: 500 Gigas', 0, 1, 'computadores', 'https://http2.mlstatic.com/D_NQ_NP_749728-MCO48851217617_012022-O.webp'),
	(29, 'AMD', 'MD Radeon Vega 8', 'Torre Cpu Gamer Ryzen 7 5700g Vega 8 1tb 16gb', 3001413, 'Vidrio lateral templado 3 Ventiladores RGB de 21cm Fuente de poder real de 350W', 10, 1, 'computadores', 'https://http2.mlstatic.com/D_NQ_NP_661268-MCO47189663977_082021-O.webp'),
	(30, 'AMD', 'AMD ATHLON 3000G', 'Torre Cpu Gamer Athlon 3000g ', 1350000, 'ALMACENAMIENTO DISCO SSD 240 GB FUENTE: 750w UNITEC', 5, 1, 'computadores', 'https://http2.mlstatic.com/D_NQ_NP_826731-MCO51164758653_082022-O.webp'),
	(31, 'Asus', 'FX506LH', 'Laptop gamer Asus TUF Gaming', 3300000, 'Tarjeta grafica = NVIDIA GeForce GTX Memoria RAM 8GB Tamaño de la pantalla = 15.6', 13, 1, 'Laptops', 'https://http2.mlstatic.com/D_NQ_NP_932735-MLA48633018935_122021-O.webp'),
	(32, 'MSI', '0SCXR-884IN', 'Laptop gamer MSI Thin GF63', 3465430, 'Procesador Intel Core i5 Memoria RAM de 8GB Tarjeta gráfica NVIDIA GeForce GTX 1650 Max-Q', 22, 1, 'Laptops', 'https://http2.mlstatic.com/D_NQ_NP_640492-MLA47861783711_102021-O.webp'),
	(33, 'Asus', ' E410MA-BV162T', 'Laptop Asus VivoBook E410MA', 859000, 'Procesador Intel Celeron Memoria RAM de 4GB Tarjeta gráfica Intel UHD Graphics 600', 19, 1, 'Laptops', 'https://http2.mlstatic.com/D_NQ_NP_768346-MLA46231822487_062021-O.webp'),
	(34, 'MSI', 'A10sc', 'Msi Prestige14 Laptop Core I7 ', 3999000, 'sistema operativo W 10 Home Memoria RAM 16GB Memoria de video 4GB', 19, 1, 'Laptops', 'https://http2.mlstatic.com/D_NQ_NP_929609-MCO50924796913_072022-O.webp'),
	(35, 'Lenovo', 'Gaming 3', 'Laptop Lenovo Ryzen 7', 3979900, 'Capacidad del disco duro 1TB Tarjeta grafica  NVIDIA GeForce GTX 1650 Cantidad de núcleos 8', 24, 1, 'Laptops', 'https://http2.mlstatic.com/D_NQ_NP_640887-MCO50542812289_072022-O.webp'),
	(36, 'JBL', '510BT', 'Audífonos inalámbricos', 167400, 'La batería dura 40 h Modo manos libres incluido Sonido superior y sin límites', 38, 1, 'Audífonos', 'https://http2.mlstatic.com/D_NQ_NP_628634-MLA46540625627_062021-O.webp'),
	(37, 'Apple', 'AirPods with charging case', 'Apple AirPods', 599899, 'Ajuste universal para usarlos con comodidad Activación y conexión automática Acceso rápido a Siri', 34, 1, 'Audífonos', 'https://http2.mlstatic.com/D_NQ_NP_968214-MLA46317822784_062021-O.webp'),
	(38, 'Genérica', 'F9-5', 'Audífonos in-ear inalámbricos', 43800, 'Cuenta con tecnología True Wireless Alcance inalámbrico de 10 m Con micrófono incorporado', 42, 1, 'Audífonos', 'https://http2.mlstatic.com/D_NQ_NP_938092-MLA45480677826_042021-O.webp'),
	(39, 'Sony', 'WF-XB700', 'Audífonos in-ear inalámbricos Sony', 335904, 'Cuenta con tecnología True Wireless La batería dura 9 Modo manos libres incluido Con micrófono incorporado', 50, 1, 'Audífonos', 'https://http2.mlstatic.com/D_NQ_NP_618976-MLA45668238412_042021-O.webp'),
	(40, 'Motorola', 'Escape 220', 'Audífonos inalámbricos Motorola Escape 220', 127400, 'La batería dura 23 h Asistentes de voz integrados: Alexa, Siri y Google Assistant Con micrófono incorporado', 23, 1, 'Audífonos', 'https://http2.mlstatic.com/D_NQ_NP_862580-MLA46478680211_062021-O.webp');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;

-- Dumping structure for table tecnoshop.usuarios
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `numero_identificacion` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `direccion` varchar(300) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `numero_identificacion` (`numero_identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- Dumping data for table tecnoshop.usuarios: ~3 rows (approximately)
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`id_usuario`, `numero_identificacion`, `nombre`, `apellido`, `email`, `telefono`, `direccion`) VALUES
	(1, 13579, 'Pablo', 'Padilla', 'Pperez1234@gmail.com', '987654', 'calle 5a # 134 - 28'),
	(2, 111122, 'pedro ', 'picapiedra', 'pepica@gmail.com', '222222', 'mmmmmmmmmmmmmmmm'),
	(4, 33510, 'pepita', 'Flores', 'pepiflo@gmail.com', '999999', 'mz45 casa142'),
	(5, 10102020, 'Juan', 'Suarez', 'jsuarez@amail.com', '7456123', '123 alguna'),
	(7, 123456789, 'dasdasd', 'sdasd', '', '', ''),
	(9, 2121212, 'adasda', 'asdasd', '', '', ''),
	(12, 132435, 'dfggghh', 'cxvxcvxcv', 'aaaa@aaaa.com', '13579246', 'xcxcxcxc'),
	(13, 798345, 'dfggghh', 'cxvxcvxcv', 'aaaa@aaaa.com', '13579246', 'xcxcxcxc'),
	(14, 456987, 'dfggghh', 'cxvxcvxcv', 'aaaa@aaaa.com', '13579246', 'xcxcxcxc'),
	(15, 19823764, 'asdasdasd', 'asdasdas', 'dasdas@dsfdsfdf.com', '1234568', 'adsdasdasd'),
	(17, 14802, 'Carlos', 'Lopez', 'andres@amail.com', '5557771', 'Calle 1 233');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

-- Dumping structure for table tecnoshop.venta
DROP TABLE IF EXISTS `venta`;
CREATE TABLE IF NOT EXISTS `venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `id_producto` int(11) NOT NULL,
  `valor` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id_venta`),
  KEY `fk_producto` (`id_producto`),
  KEY `fk_usuario` (`id_usuario`),
  CONSTRAINT `fk_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

-- Dumping data for table tecnoshop.venta: ~0 rows (approximately)
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` (`id_venta`, `fecha`, `id_producto`, `valor`, `cantidad`, `id_usuario`) VALUES
	(1, '2022-10-04', 32, 3465430, 1, 17),
	(2, '2022-10-04', 32, 3465430, 1, 17),
	(3, '2022-10-04', 32, 3465430, 1, 17),
	(4, '2022-10-04', 32, 3465430, 1, 17),
	(5, '2022-10-04', 32, 3465430, 1, 17),
	(6, '2022-10-04', 32, 3465430, 1, 17),
	(7, '2022-10-04', 34, 3999000, 1, 17),
	(8, '2022-10-04', 23, 925900, 1, 17),
	(9, '2022-10-04', 23, 925900, 1, 17),
	(10, '2022-10-04', 23, 925900, 1, 17),
	(11, '2022-10-04', 23, 925900, 1, 17),
	(12, '2022-10-04', 23, 925900, 1, 17),
	(13, '2022-10-04', 23, 925900, 1, 17),
	(14, '2022-10-04', 23, 925900, 1, 17),
	(15, '2022-10-04', 24, 199999, 1, 17),
	(16, '2022-10-04', 24, 199999, 1, 17),
	(17, '2022-10-04', 24, 199999, 1, 17),
	(18, '2022-10-04', 23, 925900, 1, 17),
	(19, '2022-10-04', 23, 925900, 1, 17),
	(20, '2022-10-04', 23, 925900, 1, 17),
	(21, '2022-10-04', 23, 925900, 1, 17),
	(22, '2022-10-04', 23, 925900, 1, 17),
	(23, '2022-10-04', 23, 925900, 1, 17),
	(24, '2022-10-04', 23, 925900, 1, 17),
	(25, '2022-10-04', 26, 3179900, 1, 17),
	(26, '2022-10-04', 23, 925900, 1, 17),
	(27, '2022-10-04', 28, 299000, 1, 17);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
