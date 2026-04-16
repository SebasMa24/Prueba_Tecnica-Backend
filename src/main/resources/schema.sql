-- =========================
-- TABLA: alumnos
-- =========================
CREATE TABLE alumnos (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    fecha_nacimiento DATE NOT NULL
);

-- =========================
-- TABLA: materias
-- =========================
CREATE TABLE materias (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    codigo INTEGER NOT NULL UNIQUE,
    creditos INTEGER NOT NULL
);

-- =========================
-- TABLA: notas
-- =========================
CREATE TABLE notas (
    id BIGSERIAL PRIMARY KEY,
    valor DOUBLE PRECISION NOT NULL,
    fecha_registro DATE NOT NULL,

    alumno_id BIGINT,
    materia_id BIGINT,

    -- Foreign Keys
    CONSTRAINT fk_notas_alumno
        FOREIGN KEY (alumno_id)
        REFERENCES alumnos (id)
        ON DELETE CASCADE,

    CONSTRAINT fk_notas_materia
        FOREIGN KEY (materia_id)
        REFERENCES materias (id)
        ON DELETE CASCADE
);

CREATE INDEX idx_notas_alumno ON notas(alumno_id);
CREATE INDEX idx_notas_materia ON notas(materia_id);