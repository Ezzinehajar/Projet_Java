package entite;

import java.util.*;


public class ClassementParCircuit {
	private Map<Circuit, List<Equipe>> equipeParCircuit;
	

	public ClassementParCircuit(Map<Circuit, List<Equipe>> equipeParCircuit) {
		super();
		this.equipeParCircuit = equipeParCircuit;
	}

	public Map<Circuit, List<Equipe>> getEquipeParCircuit() {
		return equipeParCircuit;
	}

	public void setEquipeParCircuit(Map<Circuit, List<Equipe>> equipeParCircuit) {
		this.equipeParCircuit = equipeParCircuit;
	}



}
