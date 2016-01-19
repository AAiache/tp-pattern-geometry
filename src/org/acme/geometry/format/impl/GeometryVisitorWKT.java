package org.acme.geometry.format.impl;

import org.acme.geometry.GeometryVisitor;
import org.acme.geometry.LineString;
import org.acme.geometry.Point;
import org.acme.geometry.Polygon;

/**
 * 
 * @author MBorne
 *
 */
public class GeometryVisitorWKT implements GeometryVisitor {

	/** 
	 * Le WKT produit par la visite 
	 * 
	 * Remarque : Mis en place ainsi pour 
	 * illustré la gestion d'une variable de retour.
	 * En pratique, on utiliserait plutôt un "java.io.PrintWriter"
	 */
	private String result ;
	
	public String getResult(){
		return result ;
	}
	
	@Override
	public void visit(Point point) {
		if ( point.isEmpty() ){
			result = "POINT EMPTY";
			return ;
		}
		result = "POINT"+writeInnerPoint(point);
	}

	@Override
	public void visit(LineString lineString) {
		if ( lineString.isEmpty() ){
			result = "LINESTRING EMPTY";
			return ;
		}
		result = "LINESTRING"+writeInnerLineString(lineString);
	}
	

	@Override
	public void visit(Polygon polygon) {
		if ( polygon.isEmpty() ){
			result = "POLYGON EMPTY";
			return ;
		}
		result = "POLYGON"+writeInnerPolygon(polygon) ;
	}

	
	private String writeInnerPoint(Point point){
		return "("+point.getCoordinate()+")";
	}
	
	private String writeInnerPolygon(Polygon polygon){
		String result = "(";
		result += writeInnerLineString(polygon.getExteriorRing());
		result += ")";
		return result ;
	}

	private String writeInnerLineString(LineString lineString) {
		String result = "(";
		for ( int i = 0; i < lineString.getNumPoints(); i++ ) {
			if ( i != 0 ){
				result += ",";
			}
			result += lineString.getPointN(i).getCoordinate() ;
		}
		result += ")";
		return result ;
	}
	
}

