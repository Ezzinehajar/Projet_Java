package entite;

import java.util.List;

public class Bolair extends Circuit {
	int TempsBolDAir;

	public Bolair(List<Epreuve> epreuves, String nom) {
		super(epreuves, nom);
		// TODO Auto-generated constructor stub
	}

	public int getTempsBolDAir() {
		return TempsBolDAir;
	}

	public void setTempsBolDAir(int tempsBolDAir) {
		TempsBolDAir = tempsBolDAir;
	}

}
