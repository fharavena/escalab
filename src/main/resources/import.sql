INSERT INTO producto (nombre, precio, cantidad) VALUES ('producto1',101.0,5.5)
INSERT INTO producto (nombre, precio, cantidad) VALUES ('producto2',101.0,15.5)
INSERT INTO producto (nombre, precio, cantidad) VALUES ('producto3',103.0,25.5)
INSERT INTO producto (nombre, precio, cantidad) VALUES ('producto4',104.0,25.5)
INSERT INTO producto (nombre, precio, cantidad) VALUES ('producto5',105.0,35.5)
INSERT INTO producto (nombre, precio, cantidad) VALUES ('producto6',105.0,35.5)
INSERT INTO producto (nombre, precio, cantidad) VALUES ('producto7',105.0,5.5)
INSERT INTO producto (nombre, precio, cantidad) VALUES ('producto8',105.0,0.0)

INSERT INTO comonosconoce (shortdescription) VALUES ('twitter')
INSERT INTO comonosconoce (shortdescription) VALUES ('tv')
INSERT INTO comonosconoce (shortdescription) VALUES ('instagram')
INSERT INTO comonosconoce (shortdescription) VALUES ('radio')
INSERT INTO comonosconoce (shortdescription) VALUES ('facebook')
INSERT INTO comonosconoce (shortdescription) VALUES ('another client')

INSERT INTO cliente (nombre, estado,comonosconoce_id) VALUES ('nombre1',1,1)
INSERT INTO cliente (nombre, estado,comonosconoce_id) VALUES ('nombre2',1,2)
INSERT INTO cliente (nombre, estado,comonosconoce_id) VALUES ('nombre3',0,3)
INSERT INTO cliente (nombre, estado,comonosconoce_id) VALUES ('nombre4',0,4)
INSERT INTO cliente (nombre, estado,comonosconoce_id) VALUES ('nombre5',1,1)
INSERT INTO cliente (nombre, estado,comonosconoce_id) VALUES ('nombre6',1,2)
INSERT INTO cliente (nombre, estado,comonosconoce_id) VALUES ('nombre7',1,3)

INSERT INTO venta (descuento, fecha,iva,total,cliente_id) VALUES (5,NOW(),20.0,200.0,2)
INSERT INTO venta (descuento, fecha,iva,total,cliente_id) VALUES (10,NOW(),60.0,300.0,5)

INSERT INTO detalle (cantidad, subtotal,producto_id,venta_id) VALUES (10.0,20.0,1,1)
INSERT INTO detalle (cantidad, subtotal,producto_id,venta_id) VALUES (10.0,30.0,2,1)
INSERT INTO detalle (cantidad, subtotal,producto_id,venta_id) VALUES (10.0,20.0,1,2)
INSERT INTO detalle (cantidad, subtotal,producto_id,venta_id) VALUES (10.0,50.0,3,2)
INSERT INTO detalle (cantidad, subtotal,producto_id,venta_id) VALUES (10.0,50.0,4,2)

INSERT INTO usuario(id_usuario, nombre, clave, estado) values (1, 'prueba@gmail.com', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', '1');
INSERT INTO rol(id_rol, nombre) values (1, 'USER');
INSERT INTO rol(id_rol, nombre) values (1, 'ADMIN');
INSERT INTO usuario_rol(id_usuario,id_rol) values (1,1);