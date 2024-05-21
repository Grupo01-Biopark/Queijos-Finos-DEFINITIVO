INSERT INTO TB_PRODUCER (TIPO_STATUS_PRODUCTION, ID, CNPJ, COMMENTS, CPF_PRODUCER, EMAIL, NAME_PRODUCER, SOCIAL_REASON)
VALUES (1, 1, '12345678000100', 'Comentário 1', '12345678900', 'email1@example.com', 'Produtor 1', 1);

INSERT INTO TB_PRODUCER (TIPO_STATUS_PRODUCTION, ID, CNPJ, COMMENTS, CPF_PRODUCER, EMAIL, NAME_PRODUCER, SOCIAL_REASON)
VALUES (1, 2, '12345678000101', 'Comentário 2', '12345678901', 'email2@example.com', 'Produtor 2', 1);

INSERT INTO TB_PRODUCER (TIPO_STATUS_PRODUCTION, ID, CNPJ, COMMENTS, CPF_PRODUCER, EMAIL, NAME_PRODUCER, SOCIAL_REASON)
VALUES (2, 3, '12345678000102', 'Comentário 3', '12345678902', 'email3@example.com', 'Produtor 3', 1);


-- Tecnologia A está ativa
INSERT INTO TB_TECHNOLOGY (ID, NAME, OBSERVATION, ACTIVE_ITEM)
VALUES (1, 'Tecnologia A', 'Observação A', true);

-- Tecnologia B está ativa
INSERT INTO TB_TECHNOLOGY (ID, NAME, OBSERVATION, ACTIVE_ITEM)
VALUES (2, 'Tecnologia B', 'Observação B', true);

-- Tecnologia C está ativa
INSERT INTO TB_TECHNOLOGY (ID, NAME, OBSERVATION, ACTIVE_ITEM)
VALUES (3, 'Tecnologia C', 'Observação C', true);

-- Tecnologia D está ativa
INSERT INTO TB_TECHNOLOGY (ID, NAME, OBSERVATION, ACTIVE_ITEM)
VALUES (4, 'Tecnologia D', NULL, true);

-- Tecnologia E está ativa
INSERT INTO TB_TECHNOLOGY (ID, NAME, OBSERVATION, ACTIVE_ITEM)
VALUES (5, 'Tecnologia E', 'Observação E', true);

-- Tecnologia F está ativa
INSERT INTO TB_TECHNOLOGY (ID, NAME, OBSERVATION, ACTIVE_ITEM)
VALUES (6, 'Tecnologia F', NULL, true);

-- Tecnologia G está ativa
INSERT INTO TB_TECHNOLOGY (ID, NAME, OBSERVATION, ACTIVE_ITEM)
VALUES (7, 'Tecnologia G', 'Observação G', true);

-- Tecnologia H está ativa
INSERT INTO TB_TECHNOLOGY (ID, NAME, OBSERVATION, ACTIVE_ITEM)
VALUES (8, 'Tecnologia H', NULL, true);

-- Tecnologia I está ativa
INSERT INTO TB_TECHNOLOGY (ID, NAME, OBSERVATION, ACTIVE_ITEM)
VALUES (9, 'Tecnologia I', 'Observação I', true);

-- Tecnologia J está ativa
INSERT INTO TB_TECHNOLOGY (ID, NAME, OBSERVATION, ACTIVE_ITEM)
VALUES (10, 'Tecnologia J', NULL, true);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-01', '2023-01-01', 0, 1, 1, 1);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-02', '2023-01-02', 1, 2, 1, 2);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-03', '2023-01-03', 2, 3, 1, 3);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-04', '2023-01-04', 3, 4, 1, 4);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-05', '2023-01-05', 0, 5, 1, 5);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-06', '2023-01-06', 1, 6, 1, 6);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-07', '2023-01-07', 2, 7, 1, 7);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-08', '2023-01-08', 3, 8, 1, 8);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-09', '2023-01-09', 0, 9, 1, 9);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-10', '2023-01-10', 1, 10, 1, 10);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-11', '2023-01-11', 2, 11, 2, 1);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-12', '2023-01-12', 3, 12, 2, 2);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-13', '2023-01-13', 0, 13, 2, 3);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-14', '2023-01-14', 1, 14, 2, 4);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-15', '2023-01-15', 2, 15, 2, 5);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-16', '2023-01-16', 3, 16, 2, 6);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-17', '2023-01-17', 0, 17, 2, 7);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-18', '2023-01-18', 1, 18, 2, 8);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-19', '2023-01-19', 2, 19, 2, 9);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-20', '2023-01-20', 3, 20, 2, 10);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-21', '2023-01-21', 0, 21, 3, 1);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-22', '2023-01-22', 1, 22, 3, 2);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-23', '2023-01-23', 2, 23, 3, 3);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-24', '2023-01-24', 3, 24, 3, 4);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-25', '2023-01-25', 0, 25, 3, 5);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-26', '2023-01-26', 1, 26, 3, 6);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-27', '2023-01-27', 2, 27, 3, 7);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-28', '2023-01-28', 3, 28, 3, 8);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-29', '2023-01-29', 0, 29, 3, 9);

INSERT INTO TB_TRANSFER (COMPLETION_DATE, START_DATE, TIPO_STATUS_PRODUCTION, ID, PRODUCER_ID, TECHNOLOGY_ID)
VALUES ('2023-01-30', '2023-01-30', 1, 30, 3, 10);


