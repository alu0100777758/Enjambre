package es.ull.etsit.enjambre.agent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase encargada de representar la tabla en base a la cual se evaluarán los estados.
 * @author Javier Martin Hernandez
 *
 * @param <Key_Type>
 * @param <Value_Type>
 */
public class Evaluation_table<Key_Type, Value_Type> implements Serializable{
	private static final long serialVersionUID = 3984679199938523544L;
	private ArrayList<HashMap<Key_Type, Evaluation_Value<Value_Type>>> table = new ArrayList();
	public Evaluation_table() {
		// TODO Auto-generated constructor stub
	}
	public void addStateEvaluation(HashMap<Key_Type, Evaluation_Value<Value_Type>> state){
		getTable().add(state);
	}
	public double evaluate(int state, PerceptionScan<Key_Type, Value_Type> scan){
		double value = 0;
		Evaluation_Value<Value_Type> increment = null;
		for(Key_Type key : getTable().get(state).keySet()){
			increment = getTable().get(state).get(key);
			for(Value_Type element : scan.get(key)){
				value += increment.value(element);
			}
		}
		return value;
	}
	protected ArrayList<HashMap<Key_Type, Evaluation_Value<Value_Type>>> getTable() {
		return table;
	}
	protected void setTable(ArrayList<HashMap<Key_Type, Evaluation_Value<Value_Type>>> table) {
		this.table = table;
	}
	
	
	
}
