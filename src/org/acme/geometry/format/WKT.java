package org.acme.geometry.format;

import org.acme.geometry.Geometry;
import org.acme.geometry.LineString;
import org.acme.geometry.Point;
import org.acme.geometry.Polygon;

/**
 * 
 * Ecriture d'une géométrie en WKT
 * 
 * @author MBorne
 *
 */
public class WKT implements Format {

	@Override
	public String write(Geometry geometry) {
		if ( geometry instanceof Point ){
			return writePoint((Point)geometry);
		}else if ( geometry instanceof LineString ){
			return writeLineString((LineString)geometry);
		}else if ( geometry instanceof Polygon ){
			return writePolygon((Polygon)geometry);
		}else{
			throw new IllegalArgumentException("Unsupported geometry type");
		}
	}
	
	private String writePoint(Point point){
		if ( point.isEmpty() ){
			return "POINT EMPTY";
		}
		return "POINT"+writeInnerPoint(point);
	}
	
	private String writeInnerPoint(Point point){
		return "("+point.getCoordinate()+")";
	}
	
	private String writeLineString(LineString lineString){
		if ( lineString.isEmpty() ){
			return "LINESTRING EMPTY";
		}
		
		return "LINESTRING"+writeInnerLineString(lineString);
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

	private String writePolygon(Polygon polygon){
		if ( polygon.isEmpty() ){
			return "POLYGON EMPTY";
		}
		return "POLYGON"+writeInnerPolygon(polygon) ;
	}

	private String writeInnerPolygon(Polygon polygon){
		String result = "(";
		result += writeInnerLineString(polygon.getExteriorRing());
		result += ")";
		return result ;
	}

}
