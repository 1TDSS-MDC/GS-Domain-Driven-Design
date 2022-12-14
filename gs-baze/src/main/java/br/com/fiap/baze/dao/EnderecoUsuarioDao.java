package br.com.fiap.baze.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.baze.exception.IdNotFoundException;
import br.com.fiap.baze.to.EnderecoUsuarioTO;

public class EnderecoUsuarioDao {

	private Connection conexao;

	public EnderecoUsuarioDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	/**
	 * Usando o result set para retornar o endereco do usuario
	 * @param result
	 * @throws SQLException
	 */
	private EnderecoUsuarioTO parse(ResultSet result) throws SQLException {
		int id = result.getInt("id_endereco");
		String rua = result.getString("nm_logradouro");
		int numero = result.getInt("nr_logradouro");
		String bairro = result.getString("nm_bairro");
		int cep = result.getInt("nr_cep");
		String cidade = result.getString("nm_cidade");
		String estado = result.getString("nm_estado");
		String pais = result.getString("nm_pais");
		String complemento = result.getString("ds_complemento");
		
		return new EnderecoUsuarioTO(id, rua, numero, bairro, cep, cidade, estado, pais, complemento);
		
	}
	
	/**
	 * Cadastrar o endereco do usuario no banco
	 * @throws SQLException 
	 */
	
	public void cadastrarEndereco(EnderecoUsuarioTO endereco) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("insert into t_baze_ender_usuario (id_ender_usuario"
				+ "nm_logradouro, nr_logradouro, nm_bairro, nm_cidade, nm_estado, nm_pais, nr_cep, ds_complemento) " + " values (sq_t_baze_ender_usuario.nextval,?,?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, endereco.getId());
		ps.setString(2, endereco.getRua());
		ps.setInt(3, endereco.getNumero());
		ps.setString(4, endereco.getBairro());
		ps.setInt(5, endereco.getCep());
		ps.setString(6, endereco.getCidade());
		ps.setString(7, endereco.getEstado());
		ps.setString(8, endereco.getPais());
		ps.setString(9, endereco.getComplemento());
		
		ps.executeUpdate();
		
	}
	
	/**
	 * Atualizar Usuario no banco de dados
	 * @throws SQLException 
	 */
	public void atualizarEndereco(EnderecoUsuarioTO endereco) throws SQLException, IdNotFoundException {
		PreparedStatement ps = conexao.prepareStatement("update t_baze_ender_usuario set id_ender_usuario = ?, nm_logradouro = ?, nr_logradouro = ?,"
				+ "nm_bairro = ?, nm_cidade = ?, nm_estado = ?, nm_pais = ?, nr_peso = ?, nr_cep = ?, ds_complemento = ?");
		
		//Setando os valores na query, usando a ordem do banco de dados 
		ps.setInt(1, endereco.getId());
		ps.setString(2, endereco.getRua());
		ps.setInt(3, endereco.getNumero());
		ps.setString(4, endereco.getBairro());
		ps.setInt(5, endereco.getCep());
		ps.setString(6, endereco.getCidade());
		ps.setString(7, endereco.getEstado());
		ps.setString(8, endereco.getPais());
		ps.setString(9, endereco.getComplemento());
		
		int quantidade  = ps.executeUpdate();
		
		if(quantidade == 0) {
			throw new IdNotFoundException("endereco nao pode ser encontrado para efetivar a atualizacao ");
		}
	}
	
	/**
	 * Metodo que vai buscar o endere?o pelo id
	 * @throws SQLException 
	 */
	
	public EnderecoUsuarioTO buscarEnderecoPorId(int id) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("select * from t_baze_ender_usuario where id_ender_usuario = ?");
		
		ps.setInt(1, id);
		
		ResultSet result = ps.executeQuery();
		
		return parse(result);
	}
	
	
}
