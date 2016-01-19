package org.acme.geometry.demo;

import org.acme.geometry.GeometryCollection;
import org.acme.geometry.GeometryVisitor;
import org.acme.geometry.LineString;
import org.acme.geometry.Point;
import org.acme.geometry.Polygon;

public class DemoGeometryVisitor implements GeometryVisitor<Void> {

	@Override
	public Void visit(Point point) {
		System.out.println("Traitement d'un point");
		return null;
	}

	@Override
	public Void visit(LineString lineString) {
		System.out.println("Traitement d'une polyligne");
		return null;
	}

	@Override
	public Void visit(Polygon polygon) {
		System.out.println("Traitement d'un polygone");
		return null;
	}
	
	@Override
	public Void visit(GeometryCollection collection) {
		System.out.println("Traitement d'une collection");
		return null;
	}
	
	/*
	 * Traitement d'un point
     * Traitement d'une polyligne
     * Traitement d'un polygone
	 */
	public static void main(String[] args) {
		DemoGeometryVisitor visitor = new DemoGeometryVisitor();
		{
			Point point = new Point();
			point.accept(visitor);
		}
		{
			LineString lineString = new LineString();
			lineString.accept(visitor);
		}
		{
			Polygon polygon = new Polygon();
			polygon.accept(visitor);
		}
		{
			GeometryCollection collection = new GeometryCollection();
			collection.accept(visitor);
		}
	}

}
