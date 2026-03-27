package dao;

import bdutil.Conexao;
import static bdutil.Conexao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Departamento;

public class DepartamentoDAO {

    private static final String INSERT_SQL = "INSERT INTO departamentos (nome, descricao)VALUES (?, ?)";
    private static final String SELECT_BY_ID = "SELECT id_departamento, nome, descricao FROM departamentos WHERE id_departamento = ?";
    private static final String SELECT_ALL = "SELECT * FROM departamentos";
    private static final String DELETE_SQL = "DELETE FROM departamentos WHERE id_departamento = ?";
    private static final String UPDATE_SQL = "UPDATE departamentos SET nome = ?, descricao = ? WHERE id_departamento = ?";

    public void insertDepartamento(Departamento departamento) {
        try (Connection connection = Conexao.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
            preparedStatement.setString(1, departamento.getNome());
            preparedStatement.setString(2, departamento.getDescricao());
            int valor=preparedStatement.executeUpdate();
            System.out.println("dados guardados com sucesso"+valor);
        } catch (SQLException e) {
            System.out.println("erro ao inserir dados" + e.getMessage());
            e.printStackTrace();
        }

    }

    public Departamento selectDepartamento(int id) {
        Departamento departamento = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id_departamento = rs.getInt("id_departamento");
                String name = rs.getString("nome");
                String descricao = rs.getString("descricao");
                departamento = new Departamento(id_departamento, name, descricao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamento;
    }

    public List<Departamento> selectAllDepartamentos() {
        List<Departamento> departamentos = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_departamento");
                String name = rs.getString("nome");
                String descricao = rs.getString("descricao");
                departamentos.add(new Departamento(id, name, descricao));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamentos;

    }

    public boolean deleteDepartamento(int id) {
        boolean rowDeleted = false;

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_SQL)) {

            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowDeleted;
    }

    public boolean updateDepartamento(Departamento departamento) {
        boolean rowUpdated = false;

        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_SQL)) {

            statement.setString(1, departamento.getNome());
            statement.setString(2, departamento.getDescricao());
            statement.setInt(3, departamento.getId());

            rowUpdated = statement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowUpdated;
    }

    public void dados(Departamento departamento) {
        System.out.println("Nome: " + departamento.getNome());
        System.out.println("Descricao: " + departamento.getDescricao());
    }

}
