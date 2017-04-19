package br.usjt.arqdesis.sispred.model;

public class Empresa {

	private int id;
	private String razaoSocial;
	private String cnpj;
	private String conjunto;

	// CONSTRUTORES
	public Empresa() {}

	public Empresa(int id, String razaoSocial, String cnpj, String conjunto) {
		this.id = id;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.conjunto = conjunto;
	}

	// METODOS GETs e SETs
	// get ID
	public int getId() {
		return id;
	}

	// set ID
	public void setId(int id) {
		this.id = id;
	}

	// get Razao Social
	public String getRazaoSocial() {
		return razaoSocial;
	}

	// set Razao Social
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	// get CNPJ
	public String getCnpj() {
		return cnpj;
	}

	// set CNPJ
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	// get Numero de conjuntos
	public String getConjunto() {
		return conjunto;
	}

	// set numero de conjuntos
	public void setConjunto(String conjunto) {
		this.conjunto = conjunto;
	}

	// metodo que retorna uma string
	@Override
	public String toString() {
		return "Razao Social [" + razaoSocial + "] CNPJ ["+cnpj+"] N de Conjutos"+conjunto+"]";
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if(razaoSocial == null){
			if(other.razaoSocial != null)
				return false;
		} else if(!razaoSocial.equals(other.razaoSocial))
			return false;
		if(cnpj == null){
			if(other.cnpj != null)
				return false;
		} else if(!cnpj.equals(other.cnpj))
			return false;
		if(conjunto == null){
			if(other.conjunto != null)
				return false;
		} else if(!conjunto.equals(other.conjunto))
			return false;
		return true;
	}
}
