package it.contrader.model;

	public class Environment {
		
		private int id;
		
		private String nome;



		public Environment() {
		}	

		public Environment(String nome) {
			this.nome=nome;
		}
		public Environment(int id,String nome) {
			this.id=id;
			this.nome=nome;
		}
		
		public int getId() {
			return this.id;
		}
		public void setId(int id) {
			this.id=id;
		}
		public void setNome(String nome) {
			this.nome=nome;
		}
		public String getNome() {
			return nome;
		}
		public String toString() {
			return id + "\t" + nome + "\t\t";
		}
		public boolean equals(Object obj) {
			if(this ==obj)
				return true;
			if(obj ==null)
				return false;
			if(getClass() !=obj.getClass() )
				return false;
			Environment other = (Environment) obj;
			if(id != other.id)
				return false;
			if(nome==null) {
				if(other.nome !=null)
					return false;
			}else if(!nome.contentEquals(other.nome))
				return false;
			return true;
		}
		
	}
