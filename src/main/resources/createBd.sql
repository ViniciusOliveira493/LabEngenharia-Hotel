use master
DROP DATABASE bdHotel
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
INSERT INTO tbPessoa(documento,email,nome,senha,telefone,funcao,tipoDocumento)
    VALUES
        ('11111111111','adminmaster@gmail.com','admin','e10adc3949ba59abbe56e057f20f883e','0000000000',0,1)

SELECT  
    pessoa0_.documento 
    ,pessoa0_.tipoDocumento 
    ,pessoa0_.email 
    ,pessoa0_.funcao 
    ,pessoa0_.nome 
    ,pessoa0_.senha 
    ,pessoa0_.telefone
from 
    tbPessoa pessoa0_
WHERE
    funcao != 3