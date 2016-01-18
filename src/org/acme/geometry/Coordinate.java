package org.acme.geometry;

/**
 * 
 * Représente des coordonnées spatiales
 * 
 * @author MBorne
 *
 */
public class Coordinate {
	
	private double x ;

	private double y ;
	
	public Coordinate(){
		this.x = Double.NaN ;
		this.y = Double.NaN ;
	}
	
	/**
	 * Construction d'une coordonnées 2D
	 * @param x
	 * @param y
	 */
	public Coordinate(double x, double y){
		this.x = x ;
		this.y = y ;
	}

	/**
	 * @return the x
	 */
	public double getX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public double getY() {
		return y;
	}

	/**
	 * 
	 * @return true is empty
	 */
	public boolean isEmpty(){
		return Double.isNaN(x) || Double.isNaN(y) ;
	}
	
	@Override
	public String toString() {
		return this.x+" "+this.y ;
	}
	
}
