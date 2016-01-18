package org.acme.geometry;

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
		if ( isEmpty() ){
			return "POLYGON EMPTY";
		}
		String result = "POLYGON((";
		for ( int i = 0; i < getExteriorRing().getNumPoints(); i++ ) {
			if ( i != 0 ){
				result += ",";
			}
			result += getExteriorRing().getPointN(i).getCoordinate() ;
		}
		result += "))";
		return result ;
	}
	
	
	
}
