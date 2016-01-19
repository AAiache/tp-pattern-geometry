package org.acme.geometry.format;

import org.acme.geometry.Geometry;
import org.acme.geometry.LineString;
import org.acme.geometry.Point;
import org.acme.geometry.Polygon;
import org.acme.geometry.format.impl.GeometryVisitorWKT;

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
		GeometryVisitorWKT visitor = new GeometryVisitorWKT();
		return geometry.accept(visitor);
	}

}
