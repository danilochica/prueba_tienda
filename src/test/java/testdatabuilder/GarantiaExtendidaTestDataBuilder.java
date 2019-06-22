package testdatabuilder;

import java.util.Date;

import dominio.GarantiaExtendida;
import dominio.Producto;

public class GarantiaExtendidaTestDataBuilder {
	private static final Producto PRODUCTO = new Producto("F01TSA0150", "Computador Lenovo", 450000);
	private static final Date FECHA_SOLICITUD_GARANTIA = new Date();
	private static final Date FECHA_FIN_GARANTIA_EXTENDIDA = new Date();
	private static final double PRECIO_GARANTIA = 450000;
	private static final String NOMBRE_CLIENTE = "";

	public Producto producto;
	public Date fechaSolicitudGarantia;
	public Date fechaFinGarantiaExtendida;
	public double precioGarantia;
	public String nombreCliente;

	public GarantiaExtendidaTestDataBuilder() {
		this.producto = PRODUCTO;
		this.fechaSolicitudGarantia = FECHA_SOLICITUD_GARANTIA;
		this.fechaFinGarantiaExtendida = FECHA_FIN_GARANTIA_EXTENDIDA;
		this.precioGarantia = PRECIO_GARANTIA;
		this.nombreCliente = NOMBRE_CLIENTE;
	}

	public GarantiaExtendidaTestDataBuilder conProducto(Producto producto) {
		this.producto = producto;
		return this;
	}

	public GarantiaExtendidaTestDataBuilder conFechaSolicitudGarantia(Date fechaSolicitudGarantia) {
		this.fechaSolicitudGarantia = fechaSolicitudGarantia;
		return this;
	}

	public GarantiaExtendidaTestDataBuilder conFechaFinGarantiaExtendida(Date fechaFinGarantiaExtendida) {
		this.fechaFinGarantiaExtendida = fechaFinGarantiaExtendida;
		return this;
	}

	public GarantiaExtendidaTestDataBuilder conPrecioGarantia(double precioGarantia) {
		this.precioGarantia = precioGarantia;
		return this;
	}

	public GarantiaExtendidaTestDataBuilder conNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
		return this;
	}

	public GarantiaExtendida build() {
		return new GarantiaExtendida(this.producto, this.fechaSolicitudGarantia, this.fechaFinGarantiaExtendida,
				this.precioGarantia, this.nombreCliente);
	}
}
