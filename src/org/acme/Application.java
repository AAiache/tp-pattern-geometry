package org.acme;

import java.util.ArrayList;
import java.util.List;

import org.acme.geometry.Coordinate;
import org.acme.geometry.Envelope;
import org.acme.geometry.Geometry;
import org.acme.geometry.GeometryCollection;
import org.acme.geometry.LineString;
import org.acme.geometry.Point;
import org.acme.geometry.Polygon;
import org.acme.geometry.util.EnvelopeBuilder;

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
		
		List<Geometry> geometries = new ArrayList<Geometry>();
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
			geometries.add(point);
			System.out.println(point.getEnvelope());
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
			System.out.println(lineString.getEnvelope());
			
			geometries.add(lineString);
		}
		
		// Polygon vide
		{
			Polygon polygon = new Polygon();
			assert(polygon.isEmpty());
			assert(polygon.asText().equals("POLYGON EMPTY"));
			System.out.println(polygon.asText());
			System.out.println(polygon.getEnvelope());
		}
		
		{
			List<Point> points = new ArrayList<Point>();
			points.add(new Point(new Coordinate(0.0,0.0)));
			points.add(new Point(new Coordinate(1.0,0.0)));
			points.add(new Point(new Coordinate(1.0,1.0)));
			points.add(new Point(new Coordinate(0.0,1.0)));
			points.add(new Point(new Coordinate(0.0,0.0)));

			LineString exteriorRing = new LineString(points);
			Polygon polygon = new Polygon(exteriorRing);
			
			assert( ! polygon.isEmpty() );
			assert( polygon.asText().equals("LINESTRING(0.0 0.0,3.0 4.0)") );
			System.out.println(polygon.asText());
			System.out.println(polygon.getEnvelope());
			
			geometries.add(polygon);
		}

		// GeometryCollection non vide
		{
			GeometryCollection collection = new GeometryCollection(geometries);
			System.out.println(collection.asText());			
		}
		
		
		// EnvelopeBuilder empty
		{
			EnvelopeBuilder builder = new EnvelopeBuilder();
			Envelope bbox = builder.getEnvelope();
			System.out.println(bbox);
		}
		
		// EnvelopeBuilder 
		{
			EnvelopeBuilder builder = new EnvelopeBuilder();
			builder.insert(new Coordinate(2.0,2.0));
			builder.insert(new Coordinate(3.0,4.0));
			builder.insert(new Coordinate(1.0,3.0));
			Envelope bbox = builder.getEnvelope();
			System.out.println(bbox);
		}
	}
}
