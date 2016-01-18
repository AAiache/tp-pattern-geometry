package org.acme.geometry;

/**
 * 
 * Une géométrie abstraite (Point, LineString, Polygon, etc.)
 * 
 * @author MBorne
 *
 */
public interface Geometry {
	
	/**
	 * Indique si la géométrie est vide
	 * @return
	 */
	public boolean isEmpty() ;
	
	/**
	 * Conversion au format WKT
	 * @return
	 */
	public String asText() ;
	
}
