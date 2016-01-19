package org.acme.math;

/**
 * 
 * Classe utilitaire pour la gestion des intervales de nombres
 * 
 * @author MBorne
 *
 */
public class Interval {
	
	private double minValue ;
	
	private double maxValue ;
	
	
	public Interval(){
		this.minValue = Double.NaN ;
		this.maxValue = Double.NaN ;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty(){
		return Double.isNaN(minValue) || Double.isNaN(maxValue) ;
	}
	
	public double getMinValue() {
		return minValue;
	}

	public double getMaxValue() {
		return maxValue;
	}

	/**
	 * Extension de l'interval pour inclure une valeur
	 * @param value
	 */
	public void expandToInclude(double value){
		if ( isEmpty() ){
			this.minValue = value ;
			this.maxValue = value ;
			return ;
		}
		if ( value < minValue ){
			minValue = value ;
		}
		if ( value > maxValue ){
			maxValue = value ;
		}
	}

}
