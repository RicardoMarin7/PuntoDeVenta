-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 17-05-2019 a las 18:34:00
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `basepuntodeventa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `filas_orden`
--

CREATE TABLE `filas_orden` (
  `ID_FILA` int(11) NOT NULL,
  `ID_orden` int(11) NOT NULL,
  `ID_Producto` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `filas_orden`
--

INSERT INTO `filas_orden` (`ID_FILA`, `ID_orden`, `ID_Producto`, `Cantidad`) VALUES
(1, 1, 1, 2),
(2, 1, 2, 2),
(3, 1, 4, 13),
(4, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ordenes`
--

CREATE TABLE `ordenes` (
  `ID_orden` int(11) NOT NULL,
  `Nombre_cliente` varchar(30) NOT NULL,
  `Fecha_orden` date DEFAULT NULL,
  `Pagado` tinyint(1) NOT NULL DEFAULT '0',
  `Total` int(10) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ordenes`
--

INSERT INTO `ordenes` (`ID_orden`, `Nombre_cliente`, `Fecha_orden`, `Pagado`, `Total`) VALUES
(1, 'Ricardo', '2019-05-17', 1, 562);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `ID_Producto` int(10) NOT NULL,
  `Nombre_Producto` varchar(40) NOT NULL,
  `Precio_producto` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`ID_Producto`, `Nombre_Producto`, `Precio_producto`) VALUES
(1, 'Malteada de Chocolate', 21),
(2, 'Crepa', 22),
(3, 'Helado de Fresa', 34),
(4, 'Helado de Vainilla', 35);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `ID_Role` int(11) NOT NULL,
  `role_name` varchar(30) NOT NULL,
  `role_display` varchar(30) NOT NULL,
  `descripcion` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`ID_Role`, `role_name`, `role_display`, `descripcion`) VALUES
(1, 'admin', 'Administrador', 'Puede editar productos, crearlos y borrarlos.'),
(2, 'user', 'Usuario', 'Puede crear ordenes y cancelarlas, no tiene acceso a crear los productos, modificarlos ni eliminarlos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID_Usuario` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `ID_Rol` int(11) NOT NULL,
  `Contraseña` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID_Usuario`, `Nombre`, `ID_Rol`, `Contraseña`) VALUES
(1, 'admin', 1, 'admin'),
(2, 'user', 2, '123456789');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `filas_orden`
--
ALTER TABLE `filas_orden`
  ADD PRIMARY KEY (`ID_FILA`),
  ADD KEY `ID_orden` (`ID_orden`),
  ADD KEY `ID_Producto` (`ID_Producto`);

--
-- Indices de la tabla `ordenes`
--
ALTER TABLE `ordenes`
  ADD PRIMARY KEY (`ID_orden`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`ID_Producto`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`ID_Role`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID_Usuario`),
  ADD KEY `id_rol` (`ID_Rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `filas_orden`
--
ALTER TABLE `filas_orden`
  MODIFY `ID_FILA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `ordenes`
--
ALTER TABLE `ordenes`
  MODIFY `ID_orden` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `ID_Producto` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `ID_Role` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `filas_orden`
--
ALTER TABLE `filas_orden`
  ADD CONSTRAINT `filas_orden_ibfk_1` FOREIGN KEY (`ID_orden`) REFERENCES `ordenes` (`ID_orden`),
  ADD CONSTRAINT `filas_orden_ibfk_2` FOREIGN KEY (`ID_Producto`) REFERENCES `productos` (`ID_Producto`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`ID_Rol`) REFERENCES `roles` (`ID_Role`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
