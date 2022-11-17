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
