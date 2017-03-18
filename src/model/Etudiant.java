package model;
import java.util.Date;

public class Etudiant extends Utilisateur{
	
	private int idEtudiant;
	public String nom;
	public String prenom;
	private Date dateDeNaissance; 
	private String niveauEtude;
	private String adresseMail;
	
	/* Constructeur */
	public Etudiant(int idUtilisateur, String login, String motdepasse, String adresseRue, String adresseVille,
			int adresseCodePostal) 
	{
		super(idUtilisateur, login, motdepasse, adresseRue, adresseVille, adresseCodePostal);
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.niveauEtude = niveauEtude;
		this.adresseMail = adresseMail;
	}

}
