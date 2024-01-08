create database IoTImpactos;
use IoTImpactos;

CREATE TABLE registros (
    id_impacto int AUTO_INCREMENT PRIMARY KEY,
    msg_impacto varchar(10),
    hora_impacto TIME,
    data_impacto DATE,
    id_dispositivo VARCHAR(8),
    FOREIGN KEY (fk_id_dispositivo) REFERENCES dispositivos(id_dispositivo)
);

CREATE TABLE dispositivos (
    id_dispositivo VARCHAR(8) PRIMARY KEY,
    nome_dispositivo varchar(50) not null
);
