package br.usjt.arqdesis.sispred.model;

public class Usuario {
	private String nome, sobrenome, cpf;
	private int id;

	public Usuario() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome
				+ ", cpf=" + cpf + "]";
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if(nome == null){
			if(other.nome != null)
				return false;
		} else if(!nome.equals(other.nome))
			return false;
		if(sobrenome == null){
			if(other.sobrenome != null)
				return false;
		} else if(!sobrenome.equals(other.sobrenome))
			return false;
		if(cpf == null){
			if(other.cpf != null)
				return false;
		} else if(!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
