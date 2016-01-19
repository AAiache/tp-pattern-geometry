package org.acme.geometry;

import org.acme.geometry.format.Format;
import org.acme.geometry.format.WKT;

/**
 * 
 * @author MBorne
 *
 */
public class Point implements Geometry {
	
	/**
	 * Point coordinate
	 */
	private Coordinate coordinate ;
	
	/**
	 * Empty point constructor
	 */
	public Point(){
		this.coordinate = new Coordinate() ; 
	}

	/**
	 * Constructor with coordinate
	 * @param coordinate
	 */
	public Point(Coordinate coordinate){
		this.coordinate = coordinate ;
	}

	/**
	 * @return
	 */
	public double getX(){
		return getCoordinate().getX() ;
	}
	
	/**
	 * @return
	 */
	public double getY(){
		return getCoordinate().getY() ;
	}
	
	/**
	 * @return the coordinate
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}

	@Override
	public boolean isEmpty() {
		return coordinate.isEmpty();
	}

	@Override
	public String asText() {
		Format format = new WKT();
		return format.write(this);
	}
}
