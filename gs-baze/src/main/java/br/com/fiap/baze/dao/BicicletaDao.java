package br.com.fiap.baze.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fiap.baze.exception.IdNotFoundException;
import br.com.fiap.baze.to.BicicletaTO;

public class BicicletaDao {
	
	private Connection conexao;
	
	public BicicletaDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	/**
	 * Usando o result set para retornar a bicicleta do usuario
	 * @param result
	 * @throws SQLException
	 */
	private BicicletaTO parse(ResultSet result) throws SQLException {
		int id = result.getInt("id_bike");
		int aro = result.getInt("nr_aro");
		double quadro = result.getDouble("nr_quadro");
		double peso = result.getInt("nr_peso");
		double altura = result.getDouble("nr_altura");
		String cor = result.getString("nm_cor");
		String tipo = result.getString("nm_tipo");
		int marcha = result.getInt("nr_marcha");
		
		return new BicicletaTO(id , aro, quadro, peso, altura, cor, tipo, marcha);
		
	}
	
	/**
	 * Metodo que vai buscar o bicicleta pelo id
	 * @throws SQLException 
	 */
	
	public BicicletaTO buscarBicicletaPorId(int id) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("select * from t_baze_bike where id_bike = ?");
		
		ps.setInt(1, id);
		
		ResultSet result = ps.executeQuery();
		
		return parse(result);
	}
	
	/**
	 * Cadastrar o bicicleta do usuario no banco
	 * @throws SQLException 
	 */
	
	public void cadastrarBicicleta(BicicletaTO bicicleta) throws SQLException {
		PreparedStatement ps = conexao.prepareStatement("insert into t_baze_bike (id_bike, "
				+ " nr_aro, nr_quadro, nr_peso, nr_altura, nm_cor, nm_tipo, nr_marcha) " + " values (sq_t_baze_bike.nextval,?,?,?,?,?,?,?,?)");
		
		ps.setInt(1, bicicleta.getId());
		ps.setInt(2, bicicleta.getAro());
		ps.setDouble(3, bicicleta.getQuadro());
		ps.setDouble(4, bicicleta.getPeso());
		ps.setDouble(5, bicicleta.getAltura());
		ps.setString(6, bicicleta.getCor());
		ps.setString(7, bicicleta.getTipo());
		ps.setInt(8, bicicleta.getMarcha());
		
		ps.executeUpdate();
	}
	
	/**
	 * Deletar um bicicleta do banco pelo seu id
	 * @throws SQLException 
	 * @throws IdNotFoundException 
	 */
	
	public void deletarBicicleta(int id) throws SQLException, IdNotFoundException {
		PreparedStatement ps = conexao.prepareStatement("delete from t_baze_bike where id_bike = ?");
		
		ps.setInt(1, id);
		
		int quantidade  = ps.executeUpdate();
		
		if(quantidade == 0) {
			throw new IdNotFoundException("bicicleta nao teve seu id encontrado, e nao podera ser removido ");
		}
	}
}