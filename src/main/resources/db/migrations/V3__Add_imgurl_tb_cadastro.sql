--v3: Migrations para adicionar a coluna img_url na tabela de cadastro

ALTER TABLE tb_cadastro_de_ninjas
    ADD COLUMN img_url VARCHAR(255);