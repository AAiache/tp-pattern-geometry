package org.acme.geometry.decorator;

import org.acme.geometry.Envelope;
import org.acme.geometry.Geometry;
import org.acme.geometry.GeometryVisitor;

/**
 * 
 * Dans la mesure où les Geometry sont immuables, on peut
 * facilement mettre en cache les Envelope par décoration/proxy
 * 
 * Remarque : l'absence fabrique rend délicat la construction
 *  transparente de Geometry de ce type.
 * 
 * @author MBorne
 *
 */
public class GeometryWithCachedEnvelope implements Geometry {
	
	/**
	 * La géométrie de travail
	 */
	private Geometry original ;
	
	/**
	 * Le cache
	 */
	private Envelope cachedEnvelope ;
	
	/**
	 * 
	 * @param original
	 */
	public GeometryWithCachedEnvelope(Geometry original){
		this.original = original ;
	}

	@Override
	public Envelope getEnvelope() {
		if ( cachedEnvelope == null ){
			cachedEnvelope = original.getEnvelope() ;
		}
		return cachedEnvelope ;
	}

	
	@Override
	public boolean isEmpty() {
		return original.isEmpty() ;
	}

	@Override
	public String asText() {
		return original.asText() ;
	}

	@Override
	public <ReturnType> ReturnType accept(GeometryVisitor<ReturnType> visitor) {
		return original.accept(visitor);
	}
	
	
	
}
