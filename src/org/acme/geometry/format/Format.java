package org.acme.geometry.format;

import org.acme.geometry.Geometry;

/**
 * Format de sérialisation d'une géométrie
 * @author MBorne
 */
public interface Format {
	
	/**
	 * Ecriture d'une géométrie
	 * @param geometry
	 * @return
	 */
	public String write(Geometry geometry);
	
}
