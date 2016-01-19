package org.acme.geometry.demo;

import java.util.ArrayList;
import java.util.List;

import org.acme.geometry.Coordinate;
import org.acme.geometry.Geometry;
import org.acme.geometry.LineString;
import org.acme.geometry.Point;
import org.acme.geometry.decorator.GeometryWithCachedEnvelope;

public class DemoCachedEnvelope {

	public static Geometry createGeometry(){
		List<Point> points = new ArrayList<Point>();
		for ( int i = 0; i < 1000000; i++ ){
			points.add(new Point(new Coordinate(i,i)));
		}
		return new LineString(points);
	}
	
	public static void main(String[] args) {
		System.out.println("Création de la géométrie...");
		Geometry geometry = createGeometry();
		geometry = new GeometryWithCachedEnvelope(geometry);
		System.out.println("Calcul BoundingBox 1...");
		System.out.println(geometry.getEnvelope());
		
		System.out.println("Calcul BoundingBox 2...");
		System.out.println(geometry.getEnvelope());
	}
	
}
