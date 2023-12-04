-- Criação da tabela frutas
CREATE TABLE frut(
                     id_frut SERIAL PRIMARY KEY UNIQUE NOT NULL,
                     name_frut TEXT NOT NULL,
                     family_frut TEXT NOT NULL,
                     order_frut TEXT NOT NULL,
                     genus_frut TEXT NOT NULL,
                     calories_frut INTEGER NOT NULL,
                     fat_frut DOUBLE PRECISION NOT NULL,
                     sugar_frut DOUBLE PRECISION NOT NULL,
                     carbohydrates_frut DOUBLE PRECISION NOT NULL,
                     protein_frut DOUBLE PRECISION NOT NULL
);