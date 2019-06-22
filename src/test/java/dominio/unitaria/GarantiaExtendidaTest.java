package dominio.unitaria;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import dominio.GarantiaExtendida;
import dominio.Producto;
import testdatabuilder.ProductoTestDataBuilder;

public class GarantiaExtendidaTest {
	
	public static final int VALOR_TEST_1= 550000;
	public static final int VALOR_TEST_2= 400000;
	
	public static final Double PORCENTAJE_VALOR_GARANTIA_EXTENDIDA_MAYOR_A_VALOR_MAXIMO = 0.2;
	public static final Double PORCENTAJE_VALOR_GARANTIA_EXTENDIDA_MENOR_O_IGUAL_AL_VALOR_MAXIMO = 0.1;
	
	public static final Integer DIAS_GARANTIA_EXTENDIDA_VALOR_MAYOR_AL_MAXIMO = 200;
	public static final Integer DIAS_GARANTIA_EXTENDIDA_MENOR_O_IGUAL_AL_VALOR_MAXIMO= 100;
	
	
	@Test
	public void testUnoMayorAlValorMaximo(){
		
		//Arrange
		Producto producto;
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		producto = productoTestDataBuilder.conPrecio(VALOR_TEST_1).build();
		GarantiaExtendida garantiaExtendida = new GarantiaExtendida(producto);
		
		//Act
		boolean result = garantiaExtendida.esMayorAlValorMaximo();
		
		//Assert
		assertTrue(result);
	}
	
	@Test
	public void testDosMenorAlValorMaximo(){
		
		//Arrange
		Producto producto;
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		producto = productoTestDataBuilder.conPrecio(VALOR_TEST_2).build();
		GarantiaExtendida garantiaExtendida = new GarantiaExtendida(producto);
		
		//Act
		boolean result = garantiaExtendida.esMayorAlValorMaximo();
		
		//Assert
		assertFalse(result);
	}
	
	@Test
	public void testUnoCalcularPrecioGarantiaMayor(){
		
		//Arrange
		double valorEsperado = VALOR_TEST_1 * PORCENTAJE_VALOR_GARANTIA_EXTENDIDA_MAYOR_A_VALOR_MAXIMO;
		Producto producto;
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		producto = productoTestDataBuilder.conPrecio(VALOR_TEST_1).build();
		GarantiaExtendida garantiaExtendida = new GarantiaExtendida(producto);
		garantiaExtendida = Mockito.spy(garantiaExtendida);
		Mockito.doReturn(true).when(garantiaExtendida).esMayorAlValorMaximo();
		
		//Act
		garantiaExtendida.calcularPrecioGarantia();
		
		//Assert
		boolean resultado =  garantiaExtendida.getPrecioGarantia()==valorEsperado;
		assertTrue(resultado);
		
	}
	
	@Test
	public void testDosCalcularPrecioGarantiaMayor(){
		
		//Arrange
		double valorEsperado = VALOR_TEST_2 * PORCENTAJE_VALOR_GARANTIA_EXTENDIDA_MENOR_O_IGUAL_AL_VALOR_MAXIMO;
		Producto producto;
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		producto = productoTestDataBuilder.conPrecio(VALOR_TEST_2).build();
		GarantiaExtendida garantiaExtendida = new GarantiaExtendida(producto);
		garantiaExtendida = Mockito.spy(garantiaExtendida);
		Mockito.doReturn(false).when(garantiaExtendida).esMayorAlValorMaximo();
		
		//Act
		garantiaExtendida.calcularPrecioGarantia();
		
		//Assert
		boolean resultado =  garantiaExtendida.getPrecioGarantia()==valorEsperado;
		assertTrue(resultado);
		
	}
	
	
	@Test
	public void testUnoDiasGarantiaParaValorMayor(){
		
		//Arrange
		Producto producto;
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		producto = productoTestDataBuilder.conPrecio(VALOR_TEST_1).build();
		GarantiaExtendida garantiaExtendida = new GarantiaExtendida(producto);
		
		//Act
		int resultadoDias =  garantiaExtendida.diasGarantia();
		boolean result = resultadoDias == DIAS_GARANTIA_EXTENDIDA_VALOR_MAYOR_AL_MAXIMO;
		
		//Assert
		assertTrue(result);

	}
	
	@Test
	public void testDosDiasGarantiaParaValorMenorIgual(){
		
		//Arrange
		Producto producto;
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder();
		producto = productoTestDataBuilder.conPrecio(VALOR_TEST_2).build();
		GarantiaExtendida garantiaExtendida = new GarantiaExtendida(producto);
		
		//Act
		int resultadoDias =  garantiaExtendida.diasGarantia();
		boolean result = resultadoDias == DIAS_GARANTIA_EXTENDIDA_MENOR_O_IGUAL_AL_VALOR_MAXIMO;
		
		//Assert
		assertTrue(result);

	}
	


}
