INSERT INTO tb_user (name_user, email, password, tipo_user_permission, cpf, cnpj, razao_social, obs, status)
VALUES ('João Silva', 'joao.silva@example.com', 'senha123', 'ADMIN', '123.456.789-00', NULL, NULL, 'Usuário administrativo', 'ATIVO');

INSERT INTO tb_user (name_user, email, password, tipo_user_permission, cpf, cnpj, razao_social, obs, status)
VALUES ('Maria Oliveira', 'maria.oliveira@example.com', 'senha456', 'CLIENTE', NULL, '12.345.678/0001-90', 'Empresa Exemplo', 'Cliente comum', 'INATIVO');
