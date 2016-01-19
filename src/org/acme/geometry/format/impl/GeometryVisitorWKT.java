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
public class GeometryVisitorWKT implements GeometryVisitor<String> {

	@Override
	public String visit(Point point) {
		if ( point.isEmpty() ){
			return "POINT EMPTY";
		}
		return "POINT"+writeInnerPoint(point);
	}

	@Override
	public String visit(LineString lineString) {
		if ( lineString.isEmpty() ){
			return "LINESTRING EMPTY";
		}
		return "LINESTRING"+writeInnerLineString(lineString);
	}
	

	@Override
	public String visit(Polygon polygon) {
		if ( polygon.isEmpty() ){
			return "POLYGON EMPTY";
		}
		return "POLYGON"+writeInnerPolygon(polygon) ;
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

