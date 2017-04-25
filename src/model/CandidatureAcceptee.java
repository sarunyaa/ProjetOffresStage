package model;
/*
import javafx.beans.property.SimpleIntegerProperty;

public class CandidatureAcceptee {
	private SimpleIntegerProperty idEtudiant;
	private SimpleIntegerProperty idCandidature;
	
	public CandidatureAcceptee(int idEtudiant, int idCandidature) {
	
		this.idEtudiant = new SimpleIntegerProperty(idEtudiant);
		this.idCandidature = new SimpleIntegerProperty(idCandidature) ;
	}

	public int getIdEtudiant() {
		return idEtudiant.get();
	}

	public void setIdEtudiant(int idE) {
		idEtudiant.set(idE);;
	}

	public int getIdCandidature() {
		return idCandidature.get();
	}

	public void setIdCandidature(int idC) {
		idCandidature.set(idC);
	}
	
	//candidatureAccepteTab

*/
public class CandidatureAcceptee {
	private int idetud;
	private int idcandidat;
	public CandidatureAcceptee(int idetud, int idcandidat) {
		super();
		this.idetud = idetud;
		this.idcandidat = idcandidat;
	}
	public int getIdetud() {
		return idetud;
	}
	public void setIdetud(int idetud) {
		this.idetud = idetud;
	}
	public int getIdcandidat() {
		return idcandidat;
	}
	public void setIdcandidat(int idcandidat) {
		this.idcandidat = idcandidat;
	}
	@Override
	public String toString() {
		return "CandidatureAcceptee [idetud=" + idetud + ", idcandidat=" + idcandidat + "]";
	}
	
	
}
