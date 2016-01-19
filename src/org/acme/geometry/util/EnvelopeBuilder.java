package org.acme.geometry.util;

import org.acme.geometry.AbstractPointVisitor;
import org.acme.geometry.Coordinate;
import org.acme.geometry.Envelope;
import org.acme.geometry.Point;
import org.acme.math.Interval;

/**
 * Construction des enveloppes à partir des coordonnées
 * @author MBorne
 *
 */
public class EnvelopeBuilder extends AbstractPointVisitor {
	
	/**
	 * Interval sur les X
	 */
	private Interval xInterval ;
	
	/**
	 * Interval sur les Y
	 */
	private Interval yInterval ;
	
	
	public EnvelopeBuilder(){
		this.xInterval = new Interval();
		this.yInterval = new Interval();
	}
	
	/**
	 * Prise en compte d'une nouvelle coordonnées
	 * @param coordinate
	 */
	public void insert(Coordinate coordinate){
		xInterval.expandToInclude(coordinate.getX());
		yInterval.expandToInclude(coordinate.getY());		
	}
	
	/**
	 * Récupération de l'enveloppe pour l'ensemble des coordonnées
	 * @return
	 */
	public Envelope getEnvelope(){
		Coordinate bottomLeft = new Coordinate(
			xInterval.getMinValue(),
			yInterval.getMinValue()
		);
		Coordinate topRight = new Coordinate(
			xInterval.getMaxValue(),
			yInterval.getMaxValue()
		);
		return new Envelope(
			bottomLeft,
			topRight
		);
	}

	@Override
	public Void visit(Point point) {
		insert(point.getCoordinate());
		return null;
	}
	
}
