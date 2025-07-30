CREATE TABLE topicos (
    id bigint NOT NULL auto_increment,
    titulo VARCHAR(100) NOT NULL,
    mensaje VARCHAR(255) NOT NULL,
    fecha_creacion DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor VARCHAR(50) NOT NULL,
    curso VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
)