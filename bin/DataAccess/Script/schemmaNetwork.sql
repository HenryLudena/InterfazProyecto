-- Creación de tablas con claves primarias autoincrementadas
CREATE TABLE IF NOT EXISTS MASCOTA (
   MASID                         INTEGER     PRIMARY KEY AUTOINCREMENT,
   PERFIL_ID                     INTEGER     NOT NULL,
   PROID                         INTEGER     NOT NULL,
   TIPID                         INTEGER     NOT NULL,
   MAS_NOMBRE                    TEXT        NOT NULL,
   MAS_OBSERVACION               TEXT        NOT NULL,
   MAS_SINTOMA_ALERGIAS          TEXT        NOT NULL,
   MAS_ESTADO                    VARCHAR(1)  DEFAULT ('A'),
   MAS_FECHAINGRESO              VARCHAR(20) DEFAULT(datetime('now')),

   FOREIGN KEY (PROID) REFERENCES PROPIETARIO(PROID),
   FOREIGN KEY (TIPID) REFERENCES TIPO(TIPID),
   FOREIGN KEY (PERFIL_ID) REFERENCES PERFIL(PERFIL_ID)
);

CREATE TABLE IF NOT EXISTS PROPIETARIO (
   PROID          INTEGER       PRIMARY KEY AUTOINCREMENT,
   PRONOMBRES     TEXT          NOT NULL,
   PROAPELLIDOS   TEXT          NOT NULL,
   PRODIRECCION   TEXT          NOT NULL,
   PROCORREO      TEXT          NOT NULL,
   PROTELEFONO    TEXT          NOT NULL,
   PROESTADO      VARCHAR(1)    DEFAULT ('A')
);

CREATE TABLE IF NOT EXISTS TIPO (
   TIPID          INTEGER       PRIMARY KEY AUTOINCREMENT,
   TIPNOMBRE      TEXT          NOT NULL,
   TIPESTADO      VARCHAR(1)    DEFAULT('A')
);
-- Insertar datos en la tabla TIPO
INSERT INTO TIPO (TIPNOMBRE) VALUES
    ('Gato'),
    ('Perro'),
    ('Conejo'),
    ('Pájaro'),
    ('Reptil');

-- Insertar datos en la tabla PROPIETARIO
INSERT INTO PROPIETARIO (PRONOMBRES, PROAPELLIDOS, PRODIRECCION, PROCORREO, PROTELEFONO) VALUES
    ('Ana',         'García',       'Calle 234',    'ana@example.com',          '1111111111'),
    ('Luis',        'Martínez',     'Avenida 567',  'luis@example.com',         '2222222222'),
    ('Elena',       'Rodríguez',    'Plaza 890',    'elena@example.com',        '3333333333'),
    ('Alejandro',   'Fernández',    'Callejón 12',  'alejandro@example.com',    '4444444444'),
    ('Sofía',       'Hernández',    'Calle 567',    'sofia@example.com',        '5555555555'),
    ('Javier',      'Díaz',         'Avenida 890',  'javier@example.com',       '6666666666'),
    ('Laura',       'López',        'Plaza 123',    'laura@example.com',        '7777777777'),
    ('Diego',       'Pérez',        'Calle 456',    'diego@example.com',        '8888888888'),
    ('Isabel',      'Gómez',        'Avenida 123',  'isabel@example.com',       '9999999999'),
    ('Manuel',      'Torres',       'Plaza 456',    'manuel@example.com',       '0000000000');


-- Insertar datos en la tabla MASCOTA
INSERT INTO MASCOTA (PROID, TIPID, MAS_NOMBRE, MAS_OBSERVACION, MAS_SINTOMA_ALERGIAS, PERFIL_ID) VALUES
    (1, 1, 'Mimi', 'Gata atigrada', "Estornudos", 1),
    (2, 2, 'Bella', 'Perra cariñosa', "Letargo", 2),
    (3, 1, 'Lucky', 'Gato suertudo', "Enrojecimiento", 3),
    (4, 2, 'Max', 'Perro enérgico', "Inflamación hocico", 4),
    (5, 3, 'Cotton', 'Conejo blanco', "Rascado Frecuente", 5),
    (6, 1, 'Lola', 'Gata tranquila', "Estornudos", 6),
    (7, 2, 'Lucy', 'Perra amigable', "Pérdida pelo", 7),
    (8, 1, 'Simba', 'Gato majestuoso', "Acumulación cera oído", 8),
    (9, 3, 'Coco', 'Conejo travieso', "Naúseas", 9),
    (10, 2, 'Boby', 'Perro juguetón', "Diarrea", 10);

SELECT M.MAS_NOMBRE "NombreMascota", T.TIPNOMBRE "TipoMascota", P.PRONOMBRES "Pronombre", 
P.PROAPELLIDOS "NombrePropietario", P.PROTELEFONO "TelefonoPropietario", M.MAS_OBSERVACION "Observacion", M.MAS_SINTOMA_ALERGIAS 
FROM MASCOTA M
JOIN TIPO T ON M.TIPID = T.TIPID
JOIN PROPIETARIO P ON M.PROID = P.PROID
JOIN PERFIL PE ON M.PERFIL_ID = PE.PERFIL_ID
WHERE PE.PERFIL_ID = '3'; -- Aquí va el ID de la mascota

--Tabla PERFIL(usuario) (INSERT, CREATE y SELECT)
CREATE TABLE IF NOT EXISTS PERFIL (
   PERFIL_ID                        INTEGER     PRIMARY KEY AUTOINCREMENT,
   MASID                            INTEGER     NOT NULL,
   CONTRASENA_PERFIL_NOMBRE         TEXT        NOT NULL,
   CEDULA_PERFIL_NOMBRE             TEXT        UNIQUE NOT NULL,
   USUARIO_PERFIL_NOMBRE            TEXT        UNIQUE NOT NULL,
   PERFIL_ESTADO                    VARCHAR(1)  DEFAULT('A'),
   PERFIL_FECHA_INGRESO             VARCHAR(20) DEFAULT(datetime('now')),
   PERFIL_FECHA_MODIFICACION        VARCHAR(20) DEFAULT(datetime('now')),
   FOREIGN KEY (MASID) REFERENCES   MASCOTA(MASID)
);       

INSERT INTO PERFIL (CEDULA_PERFIL_NOMBRE, CONTRASENA_PERFIL_NOMBRE, USUARIO_PERFIL_NOMBRE, MASID) VALUES
("1139392023", "profesor1234", "AnaCh1245", 1),
("1139452023", "contrasena", "Luishhs232", 2),
("1139492023", "388eej829", "Elenakdksk", 3),
("1124492023", "0300302rye", "AlejandroLud29", 4),
("1132492023", "dhdjs929", "Sofiadhdj", 5),
("1139552023", "383jejcs", "Javierkdd9", 6),
("1132442023", "eondn282ns", "LaurahdhSj", 7),
("1133432023", "ri483je", "Diego3jdkw",8),
("1139233223", "ruen38endn", "Isabel2dkdj", 9),
("1139332323", "684jdj", "Manueldsisj", 10);

SELECT p.CEDULA_PERFIL_NOMBRE, p.CONTRASENA_PERFIL_NOMBRE, p.USUARIO_PERFIL_NOMBRE 
FROM PERFIL p
WHERE PERFIL_ESTADO = 'A';

--Tabla Administrador (INSERT, CREATE y SELECT)
CREATE TABLE IF NOT EXISTS PERFIL_ADMINISTRADOR (
PERFIL_ADMINISTRADOR_ID                   INTEGER           PRIMARY KEY AUTOINCREMENT,
CONTRASENA_ADMINISTRADOR_NOMBRE           TEXT              NOT NULL,
CEDULA_ADMINISTRADOR_NOMBRE               TEXT              UNIQUE NOT NULL,
USUARIO_ADMINISTRADOR_NOMBRE              TEXT              UNIQUE NOT NULL,
PERFIL_ADMINISTRADOR_ESTADO               VARCHAR(1)        DEFAULT('A') ,
PERFIL_ADMINISTRADOR_FECHA_INGRESO        VARCHAR(20)       DEFAULT(datetime('now')),
PERFIL_ADMINISTRADOR_FECHA_MODIFICACION   VARCHAR(20)       DEFAULT(datetime('now'))
);

INSERT INTO PERFIL_ADMINISTRADOR (CEDULA_ADMINISTRADOR_NOMBRE, CONTRASENA_ADMINISTRADOR_NOMBRE, USUARIO_ADMINISTRADOR_NOMBRE) VALUES
("1148493929", "eyr828du8", "Juan092"),
("1248929848", "jdudiwwmu", "MarxTucxj"),
("1234567890","qwertyuiop", "JuanLucas"),
("1234567891","asdfghjkl", "Mateo29sk"),
("1234567892","zxcvbnm", "LucasGamer202"),
("1234567893","1qazxsw2", "Oscux29e"),
("1234567894","1qazwsxedc", "Veto2isk2"),
("1234567895","1qazws2d2vb", "BernardoLuis"),
("1234457896","1qa34sedcvb", "MacasMiCasa"),
("1233467897","1qaz342edcvb", "IuoGamer");

SELECT pa.CEDULA_ADMINISTRADOR_NOMBRE, pa.CONTRASENA_ADMINISTRADOR_NOMBRE, pa.USUARIO_ADMINISTRADOR_NOMBRE 
FROM PERFIL_ADMINISTRADOR pa
WHERE PERFIL_ADMINISTRADOR_ESTADO = 'A';







