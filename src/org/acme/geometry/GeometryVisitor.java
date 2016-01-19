package org.acme.geometry;

/**
 * 
 * Visiteur pour les classes géométriques
 * 
 * @author MBorne
 *
 */
public interface GeometryVisitor {
	
	/**
	 * 
	 * Traitement spécifique à un Point
	 * 
	 * @param point
	 */
	public void visit(Point point) ;
	
	/**
	 * 
	 * Traitement spécifique à une LineString
	 * 
	 * @param lineString
	 */
	public void visit(LineString lineString) ;
	
	/**
	 * 
	 * Traitement spécifique à un Polygon
	 * 
	 * @param polygon
	 */
	public void visit(Polygon polygon) ;
	
}
