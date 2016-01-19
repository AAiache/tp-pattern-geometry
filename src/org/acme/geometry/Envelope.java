package org.acme.geometry;

/**
 * 
 * Bounding box
 * 
 * @author MBorne
 *
 */
public class Envelope {
	
	/**
	 * bottom left corner
	 */
	private Coordinate bottomLeft ;
	
	/**
	 * top right corner
	 */
	private Coordinate topRight ;

	public Envelope(){
		this.bottomLeft = new Coordinate() ;
		this.topRight   = new Coordinate() ;
	}
	
	public Envelope(Coordinate bottomLeft, Coordinate topRight ){
		this.bottomLeft = bottomLeft ;
		this.topRight = topRight ;
	}
	
	
	public Coordinate getBottomLeft() {
		return bottomLeft;
	}
	
	public double getMinX(){
		return getBottomLeft().getX() ;
	}
	
	public double getMinY(){
		return getBottomLeft().getY() ;
	}
	
	
	
	public Coordinate getTopRight() {
		return topRight;
	}
	
	public double getMaxX(){
		return getTopRight().getX() ;
	}
	
	public double getMaxY(){
		return getTopRight().getY() ;
	}
	
	@Override
	public String toString() {
		return getMinX()+","+getMinY()+","+getMaxX()+","+getMaxY();
	}
	
}
