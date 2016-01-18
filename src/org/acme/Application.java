package org.acme;

import java.util.ArrayList;
import java.util.List;

import org.acme.geometry.Coordinate;
import org.acme.geometry.LineString;
import org.acme.geometry.Point;
import org.acme.geometry.Polygon;

public class Application {
	/*
		POINT EMPTY
		POINT(3.0 4.0)
		LINESTRING EMPTY
		LINESTRING(0.0 0.0,3.0 4.0)
		POLYGON EMPTY
		POLYGON((0.0 0.0,3.0 4.0))
	 */
	public static void main(String[] args) {
		// Note : Ressemble beaucoup à des tests.
		
		// Point
		{
			Point point = new Point();
			assert( point.isEmpty() );
			assert( point.asText().equals("POINT EMPTY") ) ;
			System.out.println(point.asText());
		}
		
		// Point 3.0 4.0
		{
			Point point = new Point(new Coordinate(3.0,4.0));
			assert( ! point.isEmpty() );
			assert( point.asText().equals("POINT(3.0 4.0)") ) ;
			System.out.println(point.asText());
		}
		
		// LineString vide
		{
			LineString lineString = new LineString();
			assert( lineString.isEmpty() );
			assert( lineString.asText().equals("LINESTRING EMPTY") ) ;
			System.out.println(lineString.asText());
		}
		
		// LineString avec deux points
		{
			List<Point> points = new ArrayList<Point>();
			points.add(new Point(new Coordinate(0.0,0.0)));
			points.add(new Point(new Coordinate(3.0,4.0)));
			
			LineString lineString = new LineString(points);
			assert( ! lineString.isEmpty() );
			assert( lineString.getNumPoints() == 2 );
			assert( lineString.asText().equals("LINESTRING(0.0 0.0,3.0 4.0)") );
			System.out.println(lineString.asText());
		}
		
		// Polygon vide
		{
			Polygon polygon = new Polygon();
			assert(polygon.isEmpty());
			assert(polygon.asText().equals("POLYGON EMPTY"));
			System.out.println(polygon.asText());
		}
		
		{
			List<Point> points = new ArrayList<Point>();
			points.add(new Point(new Coordinate(0.0,0.0)));
			points.add(new Point(new Coordinate(3.0,4.0)));
			
			LineString exteriorRing = new LineString(points);
			Polygon polygon = new Polygon(exteriorRing);
			
			assert( ! polygon.isEmpty() );
			assert( polygon.asText().equals("LINESTRING(0.0 0.0,3.0 4.0)") );
			System.out.println(polygon.asText());
		}

	}
}
