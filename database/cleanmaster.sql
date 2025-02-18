Drop database cleanmaster;
create database CleanMaster;
use cleanMaster;

create table tb_cliente
(
cod_cli int primary key auto_increment,
dni_cli int,
nom_cli varchar(35),
correo_cli varchar(30),
tele_cli varchar(9),
fecha_cli date,
cod_tipo int
);
insert into tb_cliente values (null,993845742,"Jerson","jersonvidal2@gmail.com","923929893",null,2);




select * from tb_cliente;
DROP TABLE IF EXISTS tb_tipoServicio;
create table tb_tipoServicio
(
cod_tipo int primary key auto_increment,
nom_tipo varchar(35)
);

insert into tb_tipoServicio values(null,'Servicio 1');
insert into tb_tipoServicio values(null,'Servicio 2');
insert into tb_tipoServicio values(null,'Servicio 3');
insert into tb_tipoServicio values(null,'Servicio 4');
alter table tb_cliente add constraint FK_01 foreign key(cod_tipo) references tb_tipoServicio(cod_tipo);

select * from tb_tipoServicio;


create table tb_tipoempleado(
cod_tipoemp int primary key auto_increment,
tipo_emp varchar(30)
);

insert into tb_tipoempleado values(null, "Gerente");
insert into tb_tipoempleado values(null, "Limpiador");
insert into tb_tipoempleado values(null, "Recepcionista");


create table tb_empleado
(
cod_emp int primary key auto_increment,
nom_emp varchar(35),
cod_tipoemp int 

);
insert into tb_empleado values(null,"Jersonn",1);
insert into tb_empleado values(null,"Jose",2);
insert into tb_empleado values(null,"Juan",3);

alter table tb_empleado add FOREIGN KEY (cod_tipoemp) REFERENCES tb_tipoempleado(cod_tipoemp);

select * from tb_empleado;







CREATE TABLE `tb_enlace` (
  `idenlace` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  `ruta` varchar(45) DEFAULT NULL,
  `tipo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`idenlace`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

insert into tb_enlace values(null,"Clientes","listadoClientes.jsp","A");
insert into tb_enlace values(null,"Limpieza","limpieza.jsp","B");


DROP TABLE IF EXISTS `tb_rol`;
CREATE TABLE `tb_rol` (
  `idrol` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

insert into tb_rol values(null,"Administrador");
insert into tb_rol values(null,"Limpiador");
insert into tb_rol values(null,"Recepcionista");
select * from tb_rol;

DROP TABLE IF EXISTS `tb_rol_enlace`;
CREATE TABLE `tb_rol_enlace` (
  `idrol` int NOT NULL,
  `idenlace` int NOT NULL,
  PRIMARY KEY (`idrol`,`idenlace`),
  KEY `fk25` (`idenlace`),
  CONSTRAINT `fk24` FOREIGN KEY (`idrol`) REFERENCES `tb_rol` (`idrol`),
  CONSTRAINT `fk25` FOREIGN KEY (`idenlace`) REFERENCES `tb_enlace` (`idenlace`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into tb_rol_enlace values(8,9);
insert into tb_rol_enlace values(8,10);
insert into tb_rol_enlace values(9,10);
insert into tb_rol_enlace values(10,9);


select * from tb_rol_enlace;
select * from tb_rol;
select * from tb_enlace;

CREATE TABLE `tb_usuario` (
  `cod_usu` int NOT NULL auto_increment,
  `login` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `idrol` int DEFAULT NULL,
  `cod_emp` int DEFAULT NULL,
  PRIMARY KEY (`cod_usu`),
  KEY `fk23` (`idrol`),
  KEY `FK02` (`cod_emp`),
  CONSTRAINT `FK02` FOREIGN KEY (`cod_emp`) REFERENCES `tb_empleado` (`cod_emp`),
  CONSTRAINT `fk23` FOREIGN KEY (`idrol`) REFERENCES `tb_rol` (`idrol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into tb_usuario values(null, "jerson123","jerson222",8,1);
insert into tb_usuario values(null, "jose123","jose222",9,2);
insert into tb_usuario values(null, "juan123","juan222",10,3);

select * from tb_empleado;
select*from tb_usuario;


ALTER TABLE tb_cliente
ADD COLUMN cod_emp INT,
ADD FOREIGN KEY (cod_emp) REFERENCES tb_empleado(cod_emp);


SELECT c.*, e.nom_emp  
                         FROM tb_cliente c  
                         LEFT JOIN tb_empleado e ON c.cod_emp = e.cod_emp;
