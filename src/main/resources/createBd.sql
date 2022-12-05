use master
DROP DATABASE bdHotel
CREATE DATABASE bdHotel
GO
use bdHotel
GO

INSERT INTO tbTipoDocumento(nomeTipo)
    VALUES
        ('CPF')
        , ('ITIN number')
        
INSERT INTO tbTipoVaga(tipo)
    VALUES
        ('Carro')
        ,('Moto') 
        ,('Ônibus')