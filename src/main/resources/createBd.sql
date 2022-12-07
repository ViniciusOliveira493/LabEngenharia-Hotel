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
      
insert into tbTipoQuarto(tipo,valorDiaria)
    VALUES
        ('Comum',60)
        ,('Suite',80)
       
insert into tbQuarto(andar,numero,predio,tipo)
    VALUES
        (0,1,1,1)
        , (0,2,1,1)
        , (0,3,1,2)
  		, (0,4,1,1)
        , (0,5,1,2)
 
INSERT INTO tbUnidadeDeMedida(nome)
    VALUES
        ('Grama')
        ,('Litro')
--=================== FUNCTIONS PARA BUSCAR QUARTOS E VAGAS DISPONÍVEIS ====
GO
--===================FN Quartos
CREATE FUNCTION fn_buscarQuartosDisponiveis(@data DATETIME, @tipo INT)
RETURNS @tab TABLE(id BIGINT,andar int,numero int,predio varchar(255),tipo int)
AS
BEGIN
    INSERT into @tab
    SELECT TOP(20)
        q.id
        ,q.andar
        ,q.numero
        ,q.predio
        ,q.tipo
    FROM tbQuarto AS q, tbReserva AS r
    WHERE 
        q.id = r.quartoId AND q.tipo = @tipo
        AND
        @data NOT BETWEEN r.datainicio and r.datafim
        AND 
        @data != r.datainicio
    UNION
    SELECT TOP(20)
        q.id
        ,q.andar
        ,q.numero
        ,q.predio
        ,q.tipo
    FROM tbQuarto AS q
    WHERE 
        q.tipo = @tipo
        AND
        q.id NOT IN
        (SELECT DISTINCT quartoId from tbReserva)
    RETURN
END
Go
--=================== FN Vagas ==--
CREATE FUNCTION fn_buscarVagasDisponiveis(@data DATETIME,@tipo INT)
RETURNS @tab Table(estacionamento VARCHAR(15),numVaga INT,descricao VARCHAR(255),valorDiaria FLOAT,tipo INT)
AS 
BEGIN
    INSERT INTO @tab
    SELECT TOP(20)
        v.estacionamento
        ,v.numVaga
        ,v.descricao
        ,v.valorDiaria
        ,v.tipo
    FROM tbVaga AS v,tbReserva as r 
    WHERE 
        v.estacionamento = r.estacionamento AND v.numVaga = r.numVaga
        AND 
        @data != r.datainicio
        AND
        @data NOT BETWEEN r.datainicio and r.datafim
        AND v.tipo = @tipo
    UNION
   SELECT TOP(20)
        v.estacionamento
        ,v.numVaga
        ,v.descricao
        ,v.valorDiaria
        ,v.tipo
    FROM tbVaga AS v
        INNER JOIN tbReserva AS r
        ON 
            (v.numVaga != r.numVaga)
            OR
            (v.estacionamento != r.estacionamento)
    WHERE v.tipo = @tipo
    RETURN
END
