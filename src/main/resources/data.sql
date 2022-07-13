INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Pedro', 'Almeida', 'pedro@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, password) VALUES ('Silvia', 'Camilla', 'silvia@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);


INSERT INTO tb_hospital (nome_do_hospital, telefone_do_hospital, bairro_do_hospital, cep_do_hospital, endereco_do_hospital, moment) VALUES ('Hospital Santa Joana', '(81) 3216-6666', 'Graças', '52011-906', 'R. Joaquim Nabuco, 200, Recife - PE', TIMESTAMP WITH TIME ZONE '2021-01-01T15:00:00Z');
INSERT INTO tb_hospital (nome_do_hospital, telefone_do_hospital, bairro_do_hospital, cep_do_hospital, endereco_do_hospital, moment) VALUES ('Hospital Nossa Senhora das Graças', '(81) 3216-2221', 'Boa Viagem', '51030-020', 'Av. Visc. de Jequitinhonha, 1144, Recife - PE', TIMESTAMP WITH TIME ZONE '2021-01-16T10:00:00Z');
INSERT INTO tb_hospital (nome_do_hospital, telefone_do_hospital, bairro_do_hospital, cep_do_hospital, endereco_do_hospital, moment) VALUES ('Hospital de Boa Viagem', '(81) 3325-9999', 'Boa Viagem', '51111-040', 'R. Ana Camelo da Silva, 315, Recife - PE', TIMESTAMP WITH TIME ZONE '2021-01-23T17:00:00Z');
INSERT INTO tb_hospital (nome_do_hospital, telefone_do_hospital, bairro_do_hospital, cep_do_hospital, endereco_do_hospital, moment) VALUES ('Hospital Ilha do Leite', '(81) 4002-3633', 'Ilha do Leite', '50070-430', 'R. Dr. João Asfora, 35, Recife - PE', TIMESTAMP WITH TIME ZONE '2021-02-07T13:00:00Z');
INSERT INTO tb_hospital (nome_do_hospital, telefone_do_hospital, bairro_do_hospital, cep_do_hospital, endereco_do_hospital, moment) VALUES ('Hospital Agamenon Magalhães', '(81) 3184-1600', 'Casa Amarela', '52070-230', 'Estr. do Arraial, 2723, Recife - PE', TIMESTAMP WITH TIME ZONE '2021-02-10T16:00:00Z');
INSERT INTO tb_hospital (nome_do_hospital, telefone_do_hospital, bairro_do_hospital, cep_do_hospital, endereco_do_hospital, moment) VALUES ('Hospital Espinheiro', '(81) 4002-3633', 'Espinheiro', '52020-020', 'R. do Espinheiro, 222, Recife - PE', TIMESTAMP WITH TIME ZONE '2021-03-13T11:00:00Z');
INSERT INTO tb_hospital (nome_do_hospital, telefone_do_hospital, bairro_do_hospital, cep_do_hospital, endereco_do_hospital, moment) VALUES ('Hospital e Maternidade Nossa Senhora do Ó', '(81) 3228-5143', 'Prado', '50751-130', 'R. Carlos Gomes, 1050, Recife - PE', TIMESTAMP WITH TIME ZONE '2021-03-27T08:00:00Z');


INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Linha do Tiro', '52131-600', 'Apt 02', 'Recife', 'Rua Santa Agripina', 470, 'PE', '451.527.234-92', 's__daianeanabernardes@autbook.com', 'Daiane Ana Bernardes', TIMESTAMP WITH TIME ZONE '2006-10-04 05:00:00Z', 'enfermaria', TIMESTAMP WITH TIME ZONE '2021-12-06 06:00:00Z', 'diabetes', 'LEVE', 16, 'AB');

INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Dois Unidos', '52160-425', 'casa 25', 'Recife', 'Rua do Amor', 312, 'PE', '566.588.004-30', 'larissaantonellanogueira@etec.sp.gov.br', 'Larissa Antonella Emanuelly Nogueira', TIMESTAMP WITH TIME ZONE '1981-01-03 05:00:00Z', 'enfermaria', TIMESTAMP WITH TIME ZONE '2021-12-09 23:00:00Z', 'bronquite', 'LEVE', 41, 'O+');


INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Casa Amarela', '52070-488', 'Bl-A, Apt 301', 'Recife', '1ª Travessa Bonito de Santa Fé', 1227, 'PE', '032.544.534-68', 'isaacemanuelanthonyfreitas-88@publicar.com.br', 'Isaac Emanuel Anthony Freitas', TIMESTAMP WITH TIME ZONE '1963-01-07 05:00:00Z', 'UTI', TIMESTAMP WITH TIME ZONE '2021-12-13 15:00:00Z', 'Insuficiência cardíaca', 'GRAVE', 59, 'B-');


INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Iputinga', '50670-480', 'casa 74', 'Recife', 'Rua Mauricéia', 577, 'PE', '965.787.194-82', 'flavializemilydias_@spamgourmet.com', 'Flávia Liz Emily Dias', TIMESTAMP WITH TIME ZONE '1972-04-30 10:00:00Z', 'UTI', TIMESTAMP WITH TIME ZONE '2021-07-25 04:00:00Z', 'Miocardiopatias', 'MODERADA', 49, 'A+');

INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Morro da Conceição', '52280-680', 'Lt-12, casa II', 'Recife', 'Avenida Norte Miguel Arraes de Alencar', 888, 'PE', '582.583.394-35', 'yurigeraldoramos-74@apso.org.br', 'Yuri Geraldo Freitas Ramos', TIMESTAMP WITH TIME ZONE '1971-07-19 03:00:00Z', 'enfermaria', TIMESTAMP WITH TIME ZONE '2021-10-04 15:00:00Z', 'Insuficiência renal', 'LEVE', 50, 'A+');

INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Torre', '50710-215', 'Apt 602', 'Recife', 'Rua Diogo Álvares', 131, 'PE', '983.285.704-08', 'liviaprisciladamata-73@band.com.br', 'Lívia Priscila da Mata', TIMESTAMP WITH TIME ZONE '1975-11-09 07:00:00Z', 'enfermaria', TIMESTAMP WITH TIME ZONE '2021-10-27 09:00:00Z', 'Câncer de cólon', 'LEVE', 47, 'O-');
         
INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Boa Viagem', '51020-020', 'Apt 2101', 'Recife', 'Avenida Conselheiro Aguiar', 2314, 'PE', '809.132.304-21', 'isaacmarcioferreira@rizan.com.br', 'Assis Márcio Ferreira', TIMESTAMP WITH TIME ZONE '1944-10-13 11:00:00Z', 'UTI', TIMESTAMP WITH TIME ZONE '2021-11-09 10:00:00Z', 'Câncer de pâncreas', 'GRAVE', 78, 'AB-');         

INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Tamarineira', '52110-005', 'Apt 1203', 'Recife', 'Avenida Norte Miguel Arraes de Alencar', 1055, 'PE', '247.964.144-95', 'nnathanluandaluz@torrez.com.br', 'Nathan Luan da Luz', TIMESTAMP WITH TIME ZONE '1963-05-22 14:00:00Z', 'enfermaria', TIMESTAMP WITH TIME ZONE '2021-11-11 19:00:00Z', 'Pneumonia', 'LEVE', 59, 'A+');     


INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Imbiribeira', '51150-020', 'Bl-b, Apt 003', 'Recife', 'Rua Professora Rosilda Costa', 602, 'PE', '198.068.154-67', 'caioluizmatheusdamota_@alcastro.com.br', 'Caio Luiz Matheus da Mota', TIMESTAMP WITH TIME ZONE '1992-08-02 19:00:00Z', 'UTI', TIMESTAMP WITH TIME ZONE '2021-11-19 23:00:00Z', 'Miocardiopatias', 'LEVE', 30, 'B-');    

INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Água Fria', '52121-130', 'casa 76', 'Recife', 'Rua Cratem', 896, 'PE', '663.939.784-65', 'sophiaelzaheloisaduarte-94@prokopetz.com.br', 'Sophia Elza Heloisa Duarte', TIMESTAMP WITH TIME ZONE '1957-02-25 22:00:00Z', 'UTI', TIMESTAMP WITH TIME ZONE '2021-12-23 04:00:00Z', 'diabetes', 'GRAVE', 65, 'AB+');    

INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Santo Amaro', '50110-667', 'Apt 302', 'Recife', 'Rua Dois', 34, 'PE', '677.143.244-06', 'laralizcaldeira-73@vianetfone.com.br', 'Lara Liz Caldeira', TIMESTAMP WITH TIME ZONE '1992-07-11 07:00:00Z', 'UTI', TIMESTAMP WITH TIME ZONE '2021-12-27 11:00:00Z', 'Pneumonia', 'MODERADA', 30, 'A-'); 

INSERT INTO tb_paciente (bairro, cep, complemento, localidade, logradouro, numero, uf, cpf, email, nome, data_de_nascimento, ala_hospitalar, data_de_internamento, enfermidade, gravidade_da_enfermidade, idade, tipo_sanguineo) VALUES 
         ('Tejipió', '50930-380', 'Bl-F, Apt 004', 'Recife', 'Rua Itanhenga', 171, 'PE', '812.337.164-09', 'anthonygaelpires_@acaoi.com.br', 'Anthony Gael Pires', TIMESTAMP WITH TIME ZONE '2002-01-05 20:00:00Z', 'enfermaria', TIMESTAMP WITH TIME ZONE '2021-12-03 11:00:00Z', 'Insuficiência renal', 'LEVE', 20, 'AB+'); 
