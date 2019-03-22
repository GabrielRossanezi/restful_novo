package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="T_AULA")
@SequenceGenerator(name="AULA", sequenceName="SQ_T_AULA", allocationSize=1)
public class AulaTO implements Serializable {

	private static final long serialVersionUID = 7033047452141448675L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="AULA")
	@Column(name="CD_AULA")
	private int id;
	
	@Column(name="NM_MATERIA", nullable=false, length=50)
	private String materia;
	
	@Column(name="NM_PROFESSOR", nullable=false, length=60)
	private String professor;

	@Column(name="NR_SALA", nullable=false)
	private int sala;

	public int getId() {
		return id;
	}
	

	public AulaTO() {
		super();
	}
	
	public AulaTO(int id, String materia, String professor, int sala) {
		super();
		this.id = id;
		this.materia = materia;
		this.professor = professor;
		this.sala = sala;
	}

	public AulaTO(String materia, String professor, int sala) {
		super();
		this.materia = materia;
		this.professor = professor;
		this.sala = sala;
	}



	public void setId(int id) {
		this.id = id;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public int getSala() {
		return sala;
	}
	public void setSala(int sala) {
		this.sala = sala;
	}
	
	
}
