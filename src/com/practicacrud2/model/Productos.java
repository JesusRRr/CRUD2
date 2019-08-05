package com.practicacrud2.model;


public class Productos {
	private int idProducto;
	private String nombreProducto;
	private double precioProducto;
	private int existenciaProducto;
	
	public Productos(int idProducto, String nombreProducto, double precioProducto, int existenciaProducto) {
		this.idProducto=idProducto;
		this.nombreProducto=nombreProducto;
		this.precioProducto=precioProducto;
		this.existenciaProducto=existenciaProducto;
		
	}
	
	public Productos() {
		
	}
	public void setIdProducto(int idProducto) {
		this.idProducto=idProducto;
	}
	
	public int getIdProducto() {
		
		return idProducto;
	}
	
	public void setNombreProduct(String nombreProducto) {
		this.nombreProducto=nombreProducto;
	}
	
	public String getNombreProducto() {
		
		return nombreProducto;
	}
	
	public void setExistencias(int existenciaProducto) {
		this.existenciaProducto=existenciaProducto;
	}
	
	public int getExistenciasProducto() {
		
		return existenciaProducto;
	}
	
	public void setPrecioProducto(double precioProducto) {
		this.precioProducto=precioProducto;
	}
	
	public double getPrecioProducto() {
		
		return precioProducto;
	}
}
