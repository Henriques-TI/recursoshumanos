 package dao;

import bdutil.Conexao;
import static bdutil.Conexao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Funcionario;

public class FuncionarioDAO {

    private static final String INSERT_SQL = "INSERT INTO funcionarios (nome, email, cargo, endereco) VALUES (?, ?, ?, ?)";
    private static final String SELECT_BY_ID = "SELECT id_funcionario, nome, email, cargo,  endereco FROM funcionarios WHERE id_funcionario = ?";
    private static final String SELECT_ALL = "SELECT * FROM funcionarios";
    private static final String DELETE_SQL = "DELETE FROM funcionarios WHERE id_funcionario = ?";
    private static final String UPDATE_SQL = "UPDATE funcionarios SET nome = ?, email = ?, cargo = ?,  endereco = ? WHERE id_funcionario = ?";

    public void insertFuncionario(Funcionario funcionario) {
        try (Connection connection = Conexao.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getEmail());
            preparedStatement.setString(3, funcionario.getCargo());
            preparedStatement.setString(4, funcionario.getEndereco());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("erro ao inserir dados" + e.getMessage());
            e.printStackTrace();

        }
    }
        
         

    public Funcionario selectFuncionario(int id){
        Funcionario funcionario = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("nome");
                String email = rs.getString("email");
                String cargo = rs.getString("cargo");
                String endereco = rs.getString("endereco");
                int id_funcionario = 0;
                funcionario = new Funcionario(id_funcionario, name, email, cargo, endereco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    public List<Funcionario> selectAllFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_funcionario");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cargo = rs.getString("cargo");
                String endereco = rs.getString("endereco");
                funcionarios.add(new Funcionario(id, nome, email, cargo, endereco));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

 public boolean deleteFuncionario(int id) {
        boolean rowDeleted = false;

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {

            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }   
    
 public boolean updateFuncionario(Funcionario funcionario) {
        boolean rowUpdated = false;

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {

            statement.setString(1, funcionario.getNome());
            statement.setString(2, funcionario.getEmail());
            statement.setString(3, funcionario.getCargo());
            statement.setString(4, funcionario.getEndereco());
            statement.setInt(5, funcionario.getId());

            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }
  public void dados(Funcionario funcionario){
    System.out.println("Nome: "+ funcionario.getNome());
    System.out.println("Email: "+ funcionario.getEmail());
    System.out.println("Cargo: "+ funcionario.getCargo());
    System.out.println("endereco: "+ funcionario.getEndereco());
  }
    
}
