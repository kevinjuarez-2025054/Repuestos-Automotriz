Drop database if exists DBRepuestosAutomotriz_in5cm;
create database DBRepuestosAutomotriz_in5cm;
use DBRepuestosAutomotriz_in5cm;

create table Proveedores(
id_proveedor int auto_increment not null,
nombre_proveedor varchar(60) not null,
telefono_proveedor int not null,
direccion varchar(100) not null,
email_proveedor varchar(100) not null,
primary key PK_id_proveedor(id_proveedor)
);
create table Empleados(
id_empleado int auto_increment not null,
nombre_empleado varchar(60) not null,
apellido_empleado varchar(60) not null,
puesto_empleado varchar(20) null,
email_empleado varchar(100) not null,
primary key PK_id_empleado(id_empleado)
);
create table Repuestos(
id_repuesto int auto_increment not null,
nombre_repuesto varchar(60) not null,
categoria_repuesto varchar(60) not null,
precio_compra double not null,
precio_venta double not null,
id_proveedor int not null,
primary key PK_id_repuesto(id_repuesto),
constraint FK_repuesto_proveedor foreign key (id_proveedor)
references proveedores(id_proveedor) on delete cascade
);
create table Ventas(
id_venta int auto_increment not null,
fecha_venta date not null,
cantidad int not null,
total double not null,
id_empleado int not null,
id_repuesto int not null,
primary key PK_id_venta(id_venta),
constraint FK_ventas_empleado foreign key (id_empleado)
references Empleados(id_empleado) on delete cascade,
constraint FK_ventas_repuestos foreign key (id_repuesto)
references Repuestos(id_repuesto) on delete cascade
);
--  Proveedores  --
delimiter $$
create procedure sp_createProveedores(in pnombre_proveedor varchar (60),in ptelefono_proveedor int,
	in pdireccion varchar(100),in pemail_proveedor varchar(100))
begin
	insert into Proveedores (nombre_proveedor,telefono_proveedor,direccion,email_proveedor)
    values (pnombre_proveedor,ptelefono_proveedor,pdireccion,pemail_proveedor);
end $$
delimiter ;

delimiter $$
create procedure sp_read_all_Proveedores()
begin
	select *from Proveedores;
end $$
delimiter ;

delimiter $$
create procedure sp_read_all_Proveedores_id(in id int)
begin
	select *from Proveedores  where id_proveedor = id;
end $$
delimiter ;

delimiter $$
create procedure sp_updateProveedores(in id int,in pnombre_proveedor varchar (60),in ptelefono_proveedor int,
	in pdireccion varchar(100),in pemail_proveedor varchar(100))
begin
	update Proveedores
    set nombre_proveedor = pnombre_proveedor,
		telefono_proveedor = ptelefono_proveedor,
        direccion = pdireccion,
        email_proveedor = pemail_proveedor
		where id_proveedor = id ;
end $$
delimiter ;

delimiter $$
create procedure sp_deleteProveedores(in id int)
begin
	delete from Proveedores where id_proveedor = id ;
end $$
delimiter ;

-- Empleados --
delimiter $$
create procedure sp_createEmpleados(in pnombre_empleado varchar(60),in papellido_empleado varchar(60),
	in ppuesto_empleado varchar(20),in pemail_empleado varchar(100))
begin
	insert into Empleados (nombre_empleado,apellido_empleado,puesto_empleado,email_empleado)
    values (pnombre_empleado,papellido_empleado,ppuesto_empleado,pemail_empleado);
end $$
delimiter ;

delimiter $$
create procedure sp_read_all_Empleados()
begin
	select *from Empleados;
end $$
delimiter ;

delimiter $$
create procedure sp_read_all_Empleados_id(in id int)
begin
	select *from Empleados where id_empleado = id;
end $$
delimiter ;

delimiter $$
create procedure sp_updateEmpleados(in id int,in pnombre_empleado varchar(60),in papellido_empleado varchar(60),
	in ppuesto_empleado varchar(20),in pemail_empleado varchar(100))
begin
	update Empleados 
    set nombre_empleado = pnombre_empleado,
    apellido_empleado = papellido_empleado,
    puesto_empleado = ppuesto_empleado,
    email_empleado = pemail_empleado
    where id_empleado = id;
end $$
delimiter ;

delimiter $$
create procedure sp_deleteEmpleados(in id int)
begin
	delete from Empleados where id_empleado = id;
end $$
delimiter ;

-- Repuestos --
delimiter $$
create procedure sp_createRepuestos(in pnombre_repuesto varchar(60),in pcategoria_repuesto varchar(60),
	in pprecio_compra double,in pprecio_venta double,in pid_proveedor int)
begin
	insert into Repuestos (nombre_repuesto,categoria_repuesto,precio_compra,precio_venta,id_proveedor)
    values (pnombre_repuesto,pcategoria_repuesto,pprecio_compra,pprecio_venta,pid_proveedor);
end $$
delimiter ;

delimiter $$
create procedure sp_read_all_Repuestos()
begin
	select *from Repuestos;
end $$
delimiter ;

delimiter $$
create procedure sp_read_all_Repuestos_id(in id int)
begin
	select *from Repuestos where id_repuesto = id;
end $$
delimiter ;

delimiter $$
create procedure sp_updateRepuestos(in id int,in pnombre_repuesto varchar(60),in pcategoria_repuesto varchar(60),
	in pprecio_compra double,in pprecio_venta double,in pid_proveedor int)
begin
	update Repuestos
    set nombre_repuesto = pnombre_repuesto,
		categoria_repuesto = pcategoria_repuesto,
        precio_compra = pprecio_compra,
        precio_venta = pprecio_venta,
        id_proveedor = pid_proveedor
        where id_repuesto = id;
end $$ 
delimiter ;

delimiter $$
create procedure sp_deleteRepuestos(in id int)
begin
	delete from Repuestos where id_repuesto = id;
end$$
delimiter ;

--  Ventas  --
delimiter $$
create procedure sp_createVentas(in pfecha_venta date,in pcantidad int,
    in ptotal double,in pid_empleado int,in pid_repuesto int)
begin
	insert into Ventas (fecha_venta,cantidad,total,id_empleado,id_repuesto)
    values (pfecha_venta,pcantidad,ptotal,pid_empleado,pid_repuesto);
end $$
delimiter ;

delimiter $$
create procedure sp_read_all_Ventas()
begin
	select *from Ventas;
end $$
delimiter ;

delimiter $$
create procedure sp_read_all_Ventas_id(in id int)
begin
	select *from Ventas where id_venta = id;
end $$
delimiter ;

delimiter $$
create procedure sp_updateVentas(in id int,in pfecha_venta date,in pcantidad int,
    in ptotal double,in pid_empleado int,in pid_repuesto int)
begin
	update Ventas
    set fecha_venta = pfecha_venta,
		cantidad = pcantidad,
        total = ptotal,
        id_empleado = pid_empleado,
        id_repuesto = pid_repuesto
	where id_venta = id;
end $$
delimiter ;

delimiter $$
create procedure sp_deleteVentas(in id int)
begin
	delete from Ventas where id_venta = id;
end $$
delimiter ;

-- Proveedores --
CALL sp_createProveedores('AutoPartes Centro',50123456,'Zona 1, Ciudad de Guatemala','auto.partes@gmail.com');
CALL sp_createProveedores('Repuestos El Volante',50234567,'Zona 7, Ciudad de Guatemala','rpvolantes@yahoo.com');
CALL sp_createProveedores('Motores GT',50345678,'Zona 11, Ciudad de Guatemala','motores.gt@outlook.com');
CALL sp_createProveedores('Frenos Nacionales',50456789,'Mixco, Guatemala','frenos@hotmail.com');
CALL sp_createProveedores('Repuestos La Terminal',50567890,'Zona 4, Guatemala','rpterminal@gmail.com');
CALL sp_createProveedores('Lubricantes Total GT',50678901,'Villa Nueva','lubricantes.gt@yahoo.com');
CALL sp_createProveedores('Autopartes El Águila',50789012,'Zona 12, Guatemala','autopartes.aguila@outlook.com');
CALL sp_createProveedores('Distribuidora MotorMax',50890123,'Amatitlán','dis.motormax@hotmail.com');
CALL sp_createProveedores('Repuestos San Juan',50901234,'San Juan Sacatepéquez','rpsanjuan@gmail.com');
CALL sp_createProveedores('Importadora AutoPlus',50012345,'Zona 9, Guatemala','imp.autoplus@yahoo.com');

-- Empleados --
CALL sp_createEmpleados('Juan','Pérez','Vendedor','juan.perez@gmail.com');
CALL sp_createEmpleados('María','López','Vendedor','maria.lopez@hotmail.com');
CALL sp_createEmpleados('Carlos','Gómez','Cajero','carlos.gomez@outlook.com');
CALL sp_createEmpleados('Ana','Martínez','Administrador','ana.martinez@yahoo.com');
CALL sp_createEmpleados('Luis','Ramírez','Vendedor','luis.ramirez@gmail.com');
CALL sp_createEmpleados('Sofía','Hernández','Cajero','sofia.hernandez@hotmail.com');
CALL sp_createEmpleados('José','Castillo','Bodega','jose.castillo@outlook.com');
CALL sp_createEmpleados('Paola','Morales','Vendedor','paola.morales@yahoo.com');
CALL sp_createEmpleados('Miguel','Rojas','Supervisor','miguel.rojas@gmail.com');
CALL sp_createEmpleados('Diana','Flores','Cajero','diana.flores@hotmail.com');

-- Repuestos --
CALL sp_createRepuestos('Filtro de aceite','Motor',50.00,75.00,1);
CALL sp_createRepuestos('Pastillas de freno','Frenos',120.00,180.00,2);
CALL sp_createRepuestos('Bujías','Encendido',30.00,50.00,3);
CALL sp_createRepuestos('Aceite 10W40','Lubricantes',90.00,130.00,6);
CALL sp_createRepuestos('Disco de freno','Frenos',200.00,280.00,4);
CALL sp_createRepuestos('Amortiguador','Suspensión',350.00,480.00,8);
CALL sp_createRepuestos('Correa de tiempo','Motor',150.00,220.00,9);
CALL sp_createRepuestos('Radiador','Enfriamiento',600.00,850.00,10);
CALL sp_createRepuestos('Filtro de aire','Motor',45.00,70.00,1);
CALL sp_createRepuestos('Batería 12V','Eléctrico',700.00,950.00,7);

-- Ventas --
CALL sp_createVentas('2026-01-05',2,150.00,1,1);
CALL sp_createVentas('2026-01-06',1,180.00,2,2);
CALL sp_createVentas('2026-01-07',4,200.00,3,3);
CALL sp_createVentas('2026-01-08',3,390.00,4,4);
CALL sp_createVentas('2026-01-09',1,280.00,5,5);
CALL sp_createVentas('2026-01-10',2,960.00,6,6);
CALL sp_createVentas('2026-01-11',1,220.00,7,7);
CALL sp_createVentas('2026-01-12',1,850.00,8,8);
CALL sp_createVentas('2026-01-13',5,350.00,9,9);
CALL sp_createVentas('2026-01-14',1,950.00,10,10);