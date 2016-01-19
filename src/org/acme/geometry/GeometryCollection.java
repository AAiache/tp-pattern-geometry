package org.acme.geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.acme.geometry.format.Format;
import org.acme.geometry.format.WKT;

/**
 * 
 * Collection de géométries
 * 
 * @author MBorne
 *
 */
public class GeometryCollection implements Geometry {
	
	private List<Geometry> geometries ;
	
	/**
	 * Constructeur de collection vide
	 */
	public GeometryCollection(){
		this.geometries = new ArrayList<Geometry>();
	}
	
	/**
	 * Construction
	 * @param geometries
	 */
	public GeometryCollection(List<Geometry> geometries){
		this.geometries = new ArrayList<Geometry>(geometries);
	}
	

	@Override
	public boolean isEmpty() {
		return geometries.isEmpty() ;
	}

	/**
	 * Récupération du nombre de géométrie
	 * @return
	 */
	public int getNumGeometries(){
		return geometries.size() ;
	}
	
	/**
	 * Récupération de la n-ième géométrie
	 * @param n
	 * @return
	 */
	public Geometry getGeometryN(int n){
		return geometries.get(n);
	}

	
	@Override
	public String asText() {
		Format format = new WKT();
		return format.write(this);
	}

	@Override
	public <ReturnType> ReturnType accept(GeometryVisitor<ReturnType> visitor) {
		return visitor.visit(this);
	}

	
}
