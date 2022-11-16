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