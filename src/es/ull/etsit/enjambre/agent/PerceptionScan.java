package es.ull.etsit.enjambre.agent;

import java.util.ArrayList;
import java.util.HashMap;

import es.ull.etsii.ia.interface_.geometry.Point2D;
import es.ull.utils.Distance;

/**
 * clase encargada de representar el resultado del scaneo de una percepcion.
 * @author Javier Martin Hernandez y Tomas Rodriguez.
 *
 */
public class PerceptionScan<Key_Type, Value_Type> {
	private HashMap<Key_Type,ArrayList<Value_Type>> scan = new HashMap<Key_Type, ArrayList<Value_Type>>();
	
	public void add(Key_Type key, Value_Type value){
		getScan().get(key).add(value);
	}
	public  ArrayList<Value_Type> get(Key_Type key){
		return getScan().get(key);
	}
	protected HashMap<Key_Type, ArrayList<Value_Type>> getScan() {
		return scan;
	}

	protected void setScan(HashMap<Key_Type, ArrayList<Value_Type>> scan) {
		this.scan = scan;
	}
	
	
}
