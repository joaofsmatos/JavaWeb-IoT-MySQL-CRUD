create database esp8266;
use esp8266;

CREATE TABLE registro (
    id_impacto int AUTO_INCREMENT PRIMARY KEY,
    FK_id_dispositivo VARCHAR(8),
    Foreign Key (FK_id_dispositivo) REFERENCES dispositivo(id_dispositivo),
    msg_impacto varchar(30),
    hora_impacto TIME,
    data_impacto DATE
);

CREATE Table dispositivo (
    id_dispositivo VARCHAR(8) PRIMARY KEY,
    nome_dispositivo varchar(50) not null
);

select * from registro;

select * from dispositivo;

INSERT INTO dispositivo (id_dispositivo, nome_dispositivo)
VALUES ('1', 'ABC-1234');