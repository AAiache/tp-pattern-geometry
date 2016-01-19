package org.acme.geometry;

import org.acme.geometry.format.Format;
import org.acme.geometry.format.WKT;
import org.acme.geometry.util.EnvelopeBuilder;

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
	
	@Override
	public Envelope getEnvelope() {
		EnvelopeBuilder builder = new EnvelopeBuilder();
		accept(builder);
		return builder.getEnvelope();
	}
	
}
