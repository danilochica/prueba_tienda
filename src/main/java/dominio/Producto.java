package dominio;

public class Producto {

	private static final int NUMERO_VOCALES_PARA_NO_APLICAR_GARANTIA_EXTENDIDA = 3;
	private String codigo;
	private String nombre;
	private double precio;

	public Producto(String codigo, String nombre, double precio) {

		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int contarVocales() {
		int cantidadVocales = 0;
		for (int i = 0; i < codigo.length(); i++) {
			char letra = Character.toUpperCase(codigo.charAt(i));

			if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') {
				cantidadVocales++;
			}
		}
		return cantidadVocales;
	}

	public boolean aplicaGarantiaExtendida() {
		int vocales = contarVocales();
		if (vocales != NUMERO_VOCALES_PARA_NO_APLICAR_GARANTIA_EXTENDIDA) {
			return true;
		} else {
			return false;
		}
		
	}

}
