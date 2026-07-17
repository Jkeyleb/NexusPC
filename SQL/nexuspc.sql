-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-07-2026 a las 22:28:15
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

--SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
--START TRANSACTION;
--SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nexuspc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

--CREATE TABLE `clientes` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(120) DEFAULT NULL,
  `tipo` enum('PERSONA','EMPRESA') DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT 1
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

--INSERT INTO `clientes` (`id_cliente`, `nombre`, `tipo`, `telefono`, `email`, `activo`) VALUES
--(1, 'Juan Caleb', 'PERSONA', '931392763', 'juuakaslka@gmial.com', 1),
--(2, 'emilio', 'PERSONA', '931931931', 'emilio@gmail.com', 1),
--(3, 'Pablo', 'PERSONA', '123123123', 'opablo@gmail.com', 1),
--(4, 'Autoparts SAC', 'EMPRESA', '999888777', 'autoparts@gmail.com', 1),
--(5, 'CMPeru', 'EMPRESA', '988000909', 'Cmperutech@gmail.com', 1),
--(6, 'Susan', 'PERSONA', '908778908', 'suanibae@gmail.com', 1),
--(7, 'JORGE', 'PERSONA', '988776554', 'jaen123@gmail.com', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_venta`
--

--CREATE TABLE `detalle_venta` (
  --`id_detalle` int(11) NOT NULL,
  --`id_venta` int(11) DEFAULT NULL,
  --`id_producto` int(11) DEFAULT NULL,
  --`cantidad` int(11) DEFAULT NULL,
  --`precio_unitario` decimal(10,2) DEFAULT NULL,
  --`subtotal` decimal(10,2) NOT NULL
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalle_venta`
--

--INSERT INTO `detalle_venta` (`id_detalle`, `id_venta`, `id_producto`, `cantidad`, `precio_unitario`, `subtotal`) VALUES
--(1, 1, 1, 1, 1500.00, 1500.00),
--(2, 2, 2, 1, 400.00, 400.00),
--(3, 2, 3, 1, 500.00, 500.00),
--(4, 3, 1, 1, 1500.00, 1500.00),
--(5, 4, 1, 1, 1500.00, 1500.00),
--(6, 5, 1, 1, 1500.00, 1500.00),
--(7, 6, 1, 1, 1500.00, 1500.00),
--(8, 7, 4, 1, 380.00, 380.00),
--(9, 7, 7, 1, 1200.00, 1200.00),
--(1OTHING ELSE
--(12, 9, 7, 1０, 12００.００, １２０００.００),
--(１３,９,１１,１６,７５００.００,１２００００.００),
--(１４,１０,１,１,１５００.００,１５００.００),
--(１５,１１,１,２９,１５００.₀₀,

--(16, 12, 1, 11, 1500.00, 16500.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `garantias`
--

--CREATE TABLE `garantias` (
 -- `id_garantia` int(11) NOT NULL,
 -- `id_cliente` int(11) DEFAULT NULL,
  --`id_producto` int(11) DEFAULT NULL,
  --`fecha_inicio` date DEFAULT NULL,
  --`fecha_fin` date DEFAULT NULL,
  --`descripcion` text DEFAULT NULL,
  --`estado` varchar(50) DEFAULT NULL
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

--CREATE TABLE `productos` (
  --`id_producto` int(11) NOT NULL,
  --`nombre` varchar(120) DEFAULT NULL,
  --`descripcion` text DEFAULT NULL,
  --`precio` decimal(10,2) DEFAULT NULL,
  --`stock` int(11) DEFAULT NULL,
  --`stock_minimo` int(11) DEFAULT NULL,
  --`proveedor` varchar(100) DEFAULT NULL
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

--INSERT INTO `productos` (`id_producto`, `nombre`, `descripcion`, `precio`, `stock`, `stock_minimo`, `proveedor`) VALUES
--(1, 'Laptop Lenovo', 'Core i7 16GB RAM', 1500.00, 9, 10, 'Lenovo EE.UU'),
--(2, 'Tarjeta grafica', 'Tarjeta GeForce RTX 5070 12GB', 400.00, 89, 10, 'Grupo Computer Shop'),
--(3, 'RTX 5070', 'Tarjeta Grafica', 500.00, 249, 50, 'NVIDIA'),
--(4, 'RTX 5060', 'Tarjeta Grafica', 380.00, 318, 30, 'NVIDIA'),
--(5, 'SSD Kingston', 'Memoria', 200.00, 500, 100, 'Kingston'),
--(6, 'SSD Samsung', 'Memoria', 290.99, 299, 80, 'Samsung'),
--(7, 'Monitor LG', 'Pantalla de PC', 1200.00, 89, 20, 'LG'),
--(8, 'Mouse Logitech', 'Mouse de PC', 150.00, 90, 50, 'Logitech'),
--(10, 'Laptop ASUS', 'Laptop Asus gamer', 4500.00, 100, 10, 'ASUS'),
--(11, 'Macbook Pro', 'Laptop marca MAC', 7500.00, 34, 10, 'Apple'),
--(12, 'SSD ADATA', 'memoria de 250GB', 300.00, 10, 20, 'ADATA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

--CREATE TABLE `roles` (
  --`id_rol` int(11) NOT NULL,
  --`nombre` varchar(50) DEFAULT NULL
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

--INSERT INTO `roles` (`id_rol`, `nombre`) VALUES
--(1, 'ADMIN'),
--(2, 'VENDEDOR'),
--(3, 'ALMACEN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

--CREATE TABLE `usuarios` (
  --`id_usuario` int(11) NOT NULL,
  --`nombre` varchar(100) DEFAULT NULL,
  --`usuario` varchar(50) DEFAULT NULL,
  --`password` varchar(255) DEFAULT NULL,
  --`id_rol` int(11) DEFAULT NULL,
  --`estado` varchar(20) DEFAULT 'ACTIVO'
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

--INSERT INTO `usuarios` (`id_usuario`, `nombre`, `usuario`, `password`, `id_rol`, `estado`) VALUES
--(15, 'Juan Caleb', 'admin', '$2a$10$ujBKVQ7MJIugs5Iw3KpliOXmLKEobD6EOtvXg0/65/ktDZ33Nxuz6', 1, 'ACTIVO'),
--(17, 'Donal Trump', 'vendedor', '$2a$10$gioONJKSUgL62ROySSK6GOkg934pfygDoi4KvHNuoUrMpAIO5mxuy', 2, 'ACTIVO'),
--(18, 'Jaen', 'jaen123', '$2a$10$OcMK1u7A3XNWD5L5I2vxguAvkTXLSTowpAqo6iOZ5h03QvIx8t9Cm', 2, 'INACTIVO'),
--(19, 'Samuel', 'Samuel Almacen', '$2a$10$5P1NlcczL/VnFakcak15MeU8eZpIN.2CJEfHOv6WHBBtlW6BTom.O', 3, 'ACTIVO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

--CREATE TABLE `ventas` (
  --`id_venta` int(11) NOT NULL,
  --`fecha` datetime NOT NULL,
  --`id_cliente` int(11) DEFAULT NULL,
  --`id_usuario` int(11) DEFAULT NULL,
  --`total` decimal(10,2) DEFAULT NULL
--) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ventas`
--

--INSERT INTO `ventas` (`id_venta`, `fecha`, `id_cliente`, `id_usuario`, `total`) VALUES
--(1, '2026-07-15 17:21:13', 1, 15, 1500.00),
--(2, '2026-07-15 22:08:53', 1, 15, 900.00),
--(3, '2026-07-15 22:09:19', 1, 15, 1500.00),
--(4, '2026-07-15 22:10:06', 1, 15, 1500.00),
--(5, '2026-07-15 22:10:12', 1, 15, 1500.00),
--(6, '2026-07-15 22:48:54', 6, 15, 1500.00),
--(7, '2026-07-15 23:58:01', 5, 15, 1580.00),
--(8, '2026-07-15 23:58:27', 5, 15, 67₀.99),
--(9, '2₀₂₆-₀₇-₁₆ ₀₀:₀₅:₁₈', 4, ₁₅, ₁₃₂₀₀₀.₀₀),
--(₁₀, '₂₀₂₆-₀₇-₁₆ ₁₆:₁₁:₃₉', 6, ₁₅, ₁₅₀₀.₀₀),
--(11, '2026-07-16 20:10:31', 6, 15, 43500.00),
--(12, '2026-07-17 14:49:16', 6, 15, 16500.00);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
--ALTER TABLE `clientes`
  --ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `detalle_venta`
--
--ALTER TABLE `detalle_venta`
  --ADD PRIMARY KEY (`id_detalle`),
  --ADD KEY `id_venta` (`id_venta`),
  --ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `garantias`
--
--ALTER TABLE `garantias`
  --ADD PRIMARY KEY (`id_garantia`),
  --ADD KEY `id_cliente` (`id_cliente`),
  --ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `productos`
--
--ALTER TABLE `productos`
  --  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `roles`
--
--ALTER TABLE `roles`
  --ADD PRIMARY KEY (`id_rol`);

--
-- Indices de la tabla `usuarios`
--
--ALTER TABLE `usuarios`
 -- ADD PRIMARY KEY (`id_usuario`),
 -- ADD UNIQUE KEY `usuario` (`usuario`),
  --ADD KEY `id_rol` (`id_rol`);

--
-- Indices de la tabla `ventas`
--
--ALTER TABLE `ventas`
  --ADD PRIMARY KEY (`id_venta`),
  --ADD KEY `id_cliente` (`id_cliente`),
  --ADD KEY `id_usuario` (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
--ALTER TABLE `clientes`
  --MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `detalle_venta`
--
--ALTER TABLE `detalle_venta`
  --MODIFY `id_detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `garantias`
--
--ALTER TABLE `garantias`
  --MODIFY `id_garantia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `productos`
--
--ALTER TABLE `productos`
  --MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `roles`
--
--ALTER TABLE `roles`
  --MODIFY `id_rol` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
--ALTER TABLE `usuarios`
  --MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
--ALTER TABLE `ventas`
  --MODIFY `id_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_venta`
--
--ALTER TABLE `detalle_venta`
  --ADD CONSTRAINT `detalle_venta_ibfk_1` FOREIGN KEY (`id_venta`) REFERENCES `ventas` (`id_venta`),
  --ADD CONSTRAINT `detalle_venta_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);

--
-- Filtros para la tabla `garantias`
--
--ALTER TABLE `garantias`
  --ADD CONSTRAINT `garantias_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  --ADD CONSTRAINT `garantias_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);

--
-- Filtros para la tabla `usuarios`
--
--ALTER TABLE `usuarios`
  --ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`);

--
-- Filtros para la tabla `ventas`
--
--ALTER TABLE `ventas`
  --ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`),
  --ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);
--COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
