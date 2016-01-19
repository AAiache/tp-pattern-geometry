package org.acme.geometry;

/**
 * 
 * Traverse les géométries pour visiter les points
 * 
 * @author saisd
 *
 */
public abstract class AbstractPointVisitor implements GeometryVisitor<Void> {

	/*
	 * (non-Javadoc)
	 * @see org.acme.geometry.GeometryVisitor#visit(org.acme.geometry.LineString)
	 */
	public Void visit(LineString lineString) {
		for ( int i = 0; i < lineString.getNumPoints(); i++ ){
			visit(lineString.getPointN(i));
		}
		return null ;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.acme.geometry.GeometryVisitor#visit(org.acme.geometry.Polygon)
	 */
	public Void visit(Polygon polygon) {
		visit(polygon.getExteriorRing());
		return null ;
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.acme.geometry.GeometryVisitor#visit(org.acme.geometry.GeometryCollection)
	 */
	public Void visit(GeometryCollection collection){
		for ( int i = 0; i < collection.getNumGeometries(); i++ ){
			collection.getGeometryN(i).accept(this);
		}
		return null;
	}
	
}
