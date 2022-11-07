package br.com.fiap.baze.to;

public class EnderecoUsuarioTO {

	//Variaveis
		private int id;
		private String rua;
		private int numero;
		private String bairro;
		private int cep;
		private String cidade;
		private String estado;
		private String pais;
		private String complemento;
		private UsuarioTO usuarioTo;
		
		
		
		//Construtor vazio
		public EnderecoUsuarioTO() {}

		//Construtor com parametros e argumentos
		public EnderecoUsuarioTO(int id, String rua, int numero, String bairro, int cep, String cidade, String estado, String pais,
				String complemento) {
			this.id = id;
			this.rua = rua;
			this.numero = numero;
			this.bairro = bairro;
			this.cep = cep;
			this.cidade = cidade;
			this.estado = estado;
			this.pais = pais;
			this.complemento = complemento;
		}

		//Getters and Setters
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
		public String getRua() {
			return rua;
		}

		public void setRua(String rua) {
			this.rua = rua;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public String getBairro() {
			return bairro;
		}

		public void setBairro(String bairro) {
			this.bairro = bairro;
		}

		public int getCep() {
			return cep;
		}

		public void setCep(int cep) {
			this.cep = cep;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getPais() {
			return pais;
		}

		public void setPais(String pais) {
			this.pais = pais;
		}

		public String getComplemento() {
			return complemento;
		}

		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}

		public UsuarioTO getUsuarioTo() {
			return usuarioTo;
		}

		public void setUsuarioTo(UsuarioTO usuarioTo) {
			this.usuarioTo = usuarioTo;
		}
}
