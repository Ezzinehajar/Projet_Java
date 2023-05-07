package entite;

import java.util.List;

public class MiniBolDAir extends Circuit {
	int TempsMiniBolDAir;
	public MiniBolDAir(List<Epreuve> epreuves, String nom) {
		super(epreuves, nom);
		// TODO Auto-generated constructor stub
	}
	public int getTempsMiniBolDAir() {
		return TempsMiniBolDAir;
	}
	public void setTempsMiniBolDAir(int tempsMiniBolDAir) {
		TempsMiniBolDAir = tempsMiniBolDAir;
	}

	

}
