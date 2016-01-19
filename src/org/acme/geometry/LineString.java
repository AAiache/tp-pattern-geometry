package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

import org.acme.geometry.format.Format;
import org.acme.geometry.format.WKT;

/**
 * 
 * Une polyligne vide ou décrite par au moins deux points
 * 
 * @author MBorne
 *
 */
public class LineString implements Geometry {
	/**
	 * Les points définissant la LineString
	 */
	private List<Point> points ;
	
	/**
	 * Construction d'une polyligne vide
	 */
	public LineString(){
		points = new ArrayList<Point>();
	}
	
	/**
	 * Construction à partir d'une liste de point
	 * @param points
	 */
	public LineString(List<Point> points){
		this.points = points ;
	}
	
	
	@Override
	public boolean isEmpty() {
		return points.isEmpty() ;
	}

	/**
	 * Renvoie le nombre de points
	 * @return
	 */
	public int getNumPoints(){
		return points.size() ;
	}
	
	/**
	 * Renvoie le n-ième point
	 * @param n
	 * @return
	 */
	public Point getPointN(int n){
		return points.get(n);
	}
	
	
	@Override
	public String asText() {
		Format format = new WKT();
		return format.write(this);
	}
	
	@Override
	public void accept(GeometryVisitor visitor) {
		visitor.visit(this);
	}
	
}
