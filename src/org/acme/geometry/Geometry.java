package org.acme.geometry;

public interface Geometry {
	/**
	 * Indique si la géométrie est vide
	 * @return
	 */
	public boolean isEmpty() ;
	
	/**
	 * Renvoie la boite englobante de la géométrie
	 * @return
	 */
	public Envelope getEnvelope() ;
	
	/**
	 * Conversion au format WKT
	 * @return
	 */
	public String asText() ;
	
	/**
	 * Dispatching sur les méthodes du visitor
	 * @param visitor
	 */
	public <ReturnType> ReturnType accept(
		GeometryVisitor<ReturnType> visitor
	) ;
}
