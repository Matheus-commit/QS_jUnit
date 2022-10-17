package PraticaJUnit.QS.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramaFidelidadeTeste {

    ProgramaFidelidade programa = new ProgramaFidelidade("Carlos", "123345223");

    @Test
    public void testeInserirCredito(){
        boolean result = programa.inserirCredito(100.00);

        assertTrue(result);
    }

    @Test
    public void testeInserirCreditoNegativo(){
        boolean result = programa.inserirCredito(-100.00);

        assertFalse(result);
    }

    @Test
    public void testeInserirPontos(){
        boolean result = programa.inserirPontos(12);

        assertTrue(result);
    }

    @Test
    public void testeInserirPontosNegativo(){
        boolean result = programa.inserirPontos(-1);

        assertFalse(result);
    }

    @Test
    public void testeRealizarCompraComCredito(){
        programa.inserirCredito(12);
        boolean result = programa.realizarCompraComCredito(11);

        assertTrue(result);
    }

    @Test
    public void testeRealizarCompraComCreditoNegativo(){
        boolean result = programa.realizarCompraComCredito(-11);

        assertFalse(result);
    }

    @Test
    public void TesteRealizarCompraComPontos(){
        programa.inserirPontos(12);
        boolean result = programa.realizarCompraComPontos(12);

        assertTrue(result);
    }

    @Test
    public void TesteRealizarCompraComPontosNegativos(){
        boolean result = programa.realizarCompraComPontos(-12);

        assertFalse(result);
    }

    @Test
    public void TesteVenderPontos(){

        programa.inserirPontos(12);
        boolean result = programa.venderPontos(12);

        assertTrue(result);
    }

    @Test
    public void TesteVenderPontosNegativos(){

        boolean result = programa.venderPontos(-12);

        assertFalse(result);
    }

    @Test
    public void TesteTransferirPontos(){

        ProgramaFidelidade contaTest = new ProgramaFidelidade("Joao", "123");

        programa.inserirPontos(10);
        boolean result = programa.transferirPontos(10, contaTest);

        assertTrue(result);
    }

    @Test
    public void TesteTransferirPontosNegativo(){

        ProgramaFidelidade contaTest = new ProgramaFidelidade("Joao", "123");

        programa.inserirPontos(10);
        boolean result = programa.transferirPontos(-10, contaTest);

        assertFalse(result);
    }
}
