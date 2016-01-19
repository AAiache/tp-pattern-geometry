package org.acme.geometry;

/**
 * 
 * Visiteur pour les classes géométriques
 * 
 * @author MBorne
 *
 */
public interface GeometryVisitor<ReturnType> {
	
	/**
	 * 
	 * Traitement spécifique à un Point
	 * 
	 * @param point
	 */
	public ReturnType visit(Point point) ;
	
	/**
	 * 
	 * Traitement spécifique à une LineString
	 * 
	 * @param lineString
	 */
	public ReturnType visit(LineString lineString) ;
	
	/**
	 * 
	 * Traitement spécifique à un Polygon
	 * 
	 * @param polygon
	 */
	public ReturnType visit(Polygon polygon) ;
	
}
