package entite;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
	private List<Participant> participants = new ArrayList<>();
	private Circuit circuit;

	public Equipe(List<Participant> participants, Circuit circuit) {
		super();
		this.participants = participants;
		this.circuit = circuit;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public Circuit getCircuit() {
		return circuit;
	}

	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}

}
