package dominio;

import java.util.Calendar;
import java.util.Date;

public class GarantiaExtendida {
	
	public static final Integer VALOR_MAXIMO_PARA_CALCULAR_LA_GARANTIA= 500000;
	public static final Double PORCENTAJE_VALOR_GARANTIA_EXTENDIDA_MAYOR_A_VALOR_MAXIMO = 0.2;
	public static final Double PORCENTAJE_VALOR_GARANTIA_EXTENDIDA_MENOR_O_IGUAL_AL_VALOR_MAXIMO = 0.1;
	public static final Integer DIAS_GARANTIA_EXTENDIDA_VALOR_MAYOR_AL_MAXIMO = 200;
	public static final Integer DIAS_GARANTIA_EXTENDIDA_MENOR_O_IGUAL_AL_VALOR_MAXIMO= 100;
	public static final Integer NRO_DE_DIA_PARA_DOMINGO = 2;
	public static final Integer NRO_DE_DIA_PARA_LUNES = 1;
	
    private Producto producto;
    private Date fechaSolicitudGarantia;
    private Date fechaFinGarantia;
    private double precioGarantia;
    private String nombreCliente;

    public GarantiaExtendida(Producto producto) {
        this.fechaSolicitudGarantia = new Date();
        this.producto = producto;
    }

    public GarantiaExtendida(Producto producto, Date fechaSolicitudGarantia, Date fechaFinGarantia,
            double precioGarantia, String nombreCliente) {

        this.producto = producto;
        this.fechaSolicitudGarantia = fechaSolicitudGarantia;
        this.fechaFinGarantia = fechaFinGarantia;
        this.precioGarantia = precioGarantia;
        this.nombreCliente = nombreCliente;
    }
    
    public GarantiaExtendida(Producto producto, String nombreCliente) {
    	
    	this.fechaSolicitudGarantia = new Date();
        this.producto = producto;
        this.nombreCliente = nombreCliente;
    }
    
    
    public Producto getProducto() {
        return producto;
    }

    public Date getFechaSolicitudGarantia() {
        return fechaSolicitudGarantia;
    }

    public Date getFechaFinGarantia() {
        return fechaFinGarantia;
    }

    public double getPrecioGarantia() {
        return precioGarantia;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public boolean esMayorAlValorMaximo() {
    	return producto.getPrecio() > VALOR_MAXIMO_PARA_CALCULAR_LA_GARANTIA ;
    }
    
    public void calcularPrecioGarantia() {
    	if(esMayorAlValorMaximo()) {
    		this.precioGarantia = producto.getPrecio() * PORCENTAJE_VALOR_GARANTIA_EXTENDIDA_MAYOR_A_VALOR_MAXIMO;
    	}else {
    		this.precioGarantia = producto.getPrecio() * PORCENTAJE_VALOR_GARANTIA_EXTENDIDA_MENOR_O_IGUAL_AL_VALOR_MAXIMO;
    	}
    }
    
	public Integer diasGarantia() {
		int diasGarantia = 0;
		if (esMayorAlValorMaximo()) {
			diasGarantia = DIAS_GARANTIA_EXTENDIDA_VALOR_MAYOR_AL_MAXIMO;
		} else {
			diasGarantia = DIAS_GARANTIA_EXTENDIDA_MENOR_O_IGUAL_AL_VALOR_MAXIMO ;
		}
		return diasGarantia;
	}


	public void calcularFechaFinGarantia() {
		int diasGarantia = diasGarantia();
		int dia = 0;
		int diaDeLaSemana = 0;
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fechaSolicitudGarantia);
		
		while (dia < diasGarantia) {
			diaDeLaSemana = calendar.get(Calendar.DAY_OF_WEEK);
			if (NRO_DE_DIA_PARA_LUNES != diaDeLaSemana) {
				dia++;
			}
			calendar.add(Calendar.DATE, 1);
		}
		diaDeLaSemana = calendar.get(Calendar.DAY_OF_WEEK);
		if (NRO_DE_DIA_PARA_DOMINGO == diaDeLaSemana) {
			calendar.add(Calendar.DATE, 1);
		}
		
		this.fechaFinGarantia = calendar.getTime();
    }
    	
    
    
}
