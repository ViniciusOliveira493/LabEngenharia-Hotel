CREATE DATABASE bdHotel
GO
use bdHotel
GO

INSERT INTO tbTipoDocumento(nomeTipo)
    VALUES
        ('RG')
        ,('CPF')
        , ('ITIN number')

Insert into tbVaga(estacionamento,numVaga,descricao,valorDiaria,tipo)
    VALUES
        ('E01',01,'vaga para carro',15,1)

select * from tbPessoa
INSERT INTO tbPessoa(DTYPE,documento,email,nome,senha,telefone,funcao,tipoDocumento)
    VALUES
        ('CPF','11111111111','adminmaster@gmail.com','admin','e10adc3949ba59abbe56e057f20f883e','0000000000',0,1)