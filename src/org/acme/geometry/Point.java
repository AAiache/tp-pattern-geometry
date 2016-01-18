package org.acme.geometry;

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
		if ( isEmpty() ){
			return "POINT EMPTY";
		}else{
			return "POINT("+coordinate+")";
		}
	}
}
