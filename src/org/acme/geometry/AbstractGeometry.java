package org.acme.geometry;

import org.acme.geometry.format.Format;
import org.acme.geometry.format.WKT;

/**
 * 
 * Une géométrie abstraite (Point, LineString, Polygon, etc.)
 * 
 * @author MBorne
 *
 */
public abstract class AbstractGeometry implements Geometry {
	
	@Override
	public String asText() {
		Format format = new WKT();
		return format.write(this);
	}
	
}
