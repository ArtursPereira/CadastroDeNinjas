--v2: Migrations para adicionar a coluna ranking na tabela de cadastro

ALTER TABLE tb_cadastro_de_ninjas
ADD COLUMN rank VARCHAR(255);