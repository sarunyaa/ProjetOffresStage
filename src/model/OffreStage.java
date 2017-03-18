package model;
import java.util.Date;
import java.sql.*;

public class OffreStage {
	
	private int idOffre;
	public String libelleOffre;
	public Long descriptionOffre ;
	public String domaineOffre;
	public Date dateDebutOffre;
	public String dureeOffre;
	private String cheminOffre;
	private boolean valide;
	
	/* Constructeur */
	public OffreStage(int idOffre, String libelleOffre, Long descriptionOffre, String domaineOffre, Date dateDebutOffre,
			String dureeOffre, String cheminOffre, boolean valide) 
	{
		this.idOffre = idOffre;
		this.libelleOffre = libelleOffre;
		this.descriptionOffre = descriptionOffre;
		this.domaineOffre = domaineOffre;
		this.dateDebutOffre = dateDebutOffre;
		this.dureeOffre = dureeOffre;
		this.cheminOffre = cheminOffre;
		this.valide = valide;
	} 
	
	

}
