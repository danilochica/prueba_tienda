package dominio;

import dominio.repositorio.RepositorioProducto;
import dominio.excepcion.GarantiaExtendidaException;
import dominio.repositorio.RepositorioGarantiaExtendida;

public class Vendedor {

    public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garantia extendida";
    public static final String EL_PRODUCTO_NO_TIENE_GARANTIA = "El producto no cuenta con garantia extendida";

    private RepositorioProducto repositorioProducto;
    private RepositorioGarantiaExtendida repositorioGarantia;

    public Vendedor(RepositorioProducto repositorioProducto, RepositorioGarantiaExtendida repositorioGarantia) {
        this.repositorioProducto = repositorioProducto;
        this.repositorioGarantia = repositorioGarantia;

    }

    public void generarGarantia(String codigo, String nombreCliente) {
    	if(tieneGarantia(codigo)) {
    		throw new GarantiaExtendidaException(EL_PRODUCTO_TIENE_GARANTIA);
    	}else {
    		Producto producto = repositorioProducto.obtenerPorCodigo(codigo);
    		if(!producto.aplicaGarantiaExtendida()) {
    			throw new GarantiaExtendidaException(EL_PRODUCTO_NO_TIENE_GARANTIA);
    		}else {
    			GarantiaExtendida garantia = new GarantiaExtendida(producto, nombreCliente);
    			garantia.calcularFechaFinGarantia();
    			garantia.calcularPrecioGarantia();
    			repositorioGarantia.agregar(garantia);
    		}
    	}

    }

    public boolean tieneGarantia(String codigo) {
        return repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigo) != null;
    }

}
