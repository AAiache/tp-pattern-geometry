package org.acme.geometry;

import org.acme.geometry.format.Format;
import org.acme.geometry.format.WKT;

/**
 * 
 * Un polygone définit par son contour extérieur
 * 
 * @author MBorne
 *
 */
public class Polygon implements Geometry {
	/**
	 * Contour extérieur du polygone
	 */
	private LineString exteriorRing ;
	
	/**
	 * Constructeur de polygone vide
	 */
	public Polygon(){
		this.exteriorRing = new LineString();
	}

	/**
	 * Constructeur de polygone avec un contour
	 * @param exteriorRing
	 */
	public Polygon(LineString exteriorRing){
		this.exteriorRing = exteriorRing ;
	}
	
	
	/**
	 * @return the exteriorRing
	 */
	public LineString getExteriorRing() {
		return exteriorRing;
	}

	@Override
	public boolean isEmpty() {
		return exteriorRing.isEmpty();
	}

	@Override
	public String asText() {
		Format format = new WKT();
		return format.write(this);
	}
	
	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
}
