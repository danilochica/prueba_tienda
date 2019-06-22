package dominio.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.mockito.Mockito;

import dominio.Producto;
import testdatabuilder.ProductoTestDataBuilder;

public class ProductoTest {

	private static final String CODIGO = "S01H1AT51";
	private static final String NOMBRE_PRODUCTO = "Impresora";
	private static final int PRECIO = 550000;

	@Test
	public void crearProductoTest() {
		
		// arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().
				conNombre(NOMBRE_PRODUCTO).
				conCodigo(CODIGO).
				conPrecio(PRECIO);

		// act
		Producto producto = productoTestDataBuilder.build();

		// assert
		assertEquals(NOMBRE_PRODUCTO, producto.getNombre());
		assertEquals(CODIGO, producto.getCodigo());
		assertEquals(PRECIO, producto.getPrecio(),0);
	}
	
	@Test
	public void testContarVocalesCuandoElCodigoDelProductoTieneCincoVocales() {
		//Arrange
		String codigoProducto = "ADDI3254EIO";
		ProductoTestDataBuilder productoBuilder = new ProductoTestDataBuilder().conCodigo(codigoProducto);
		Producto producto = productoBuilder.build();
		//Act
		int result = producto.contarVocales();
		
		//Assert
		assertEquals(5, result);
	}
	
	@Test
	public void testContarVocalesCuandoElCodigoDelProductoTieneNueveVocales() {
		//Arrange
		String codigoProducto = "AAAAADDI3254EIO";
		ProductoTestDataBuilder productoBuilder = new ProductoTestDataBuilder().conCodigo(codigoProducto);
		Producto producto = productoBuilder.build();
	
		//Act
		int result = producto.contarVocales();
		
		//Assert
		assertEquals(9, result);
	}
	
	@Test
	public void testContarVocalesCuandoElCodigoDelProductoTieneTresVocales() {
		//Arrange
		String codigoProducto = "DDi3254eo";
		ProductoTestDataBuilder productoBuilder = new ProductoTestDataBuilder().conCodigo(codigoProducto);
		Producto producto = productoBuilder.build();
	
		//Act
		int result = producto.contarVocales();
		
		//Assert
		assertEquals(3, result);
	}
	
	@Test
	public void testContarVocalesCuandoElCodigoDelProductoTieneDosVocales() {
		//Arrange
		String codigoProducto = "DDI3254e";
		ProductoTestDataBuilder productoBuilder = new ProductoTestDataBuilder().conCodigo(codigoProducto);
		Producto producto = productoBuilder.build();
	
		//Act
		int result = producto.contarVocales();
		
		//Assert
		assertEquals(2, result);
	}
	
	@Test
	public void testCuandoNumeroDeVocalesEsTres() {
		//Arrange
		Producto producto = Mockito.mock(Producto.class);
		Mockito.when(producto.contarVocales()).thenReturn(3);
		
		//Act
		boolean result = producto.aplicaGarantiaExtendida();
		
		//Assert
		assertFalse(result);
	}


}
