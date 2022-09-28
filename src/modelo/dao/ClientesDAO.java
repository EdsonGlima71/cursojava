/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;

import connection.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import modelo.bean.Clientes;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edson
 */
public class ClientesDAO {
    
    public void create(Clientes c){
       
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Clientes(nome,endereco,bairro,cidade,estado,cep,cpf,celular,tipo)values(?,?,?,?,?,?,?,?,?)");
            
            stmt.setString(1,c.getNome());
            stmt.setString(2,c.getEndereco());
            stmt.setString(3,c.getBairro());
            stmt.setString(4,c.getCidade());
            stmt.setString(5,c.getEstado());
            stmt.setString(6,c.getCep());
            stmt.setString(7,c.getCpf());
            stmt.setString(8,c.getCelular());
            stmt.setString(9,c.getTipo());
            
            stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
             
         }
   public List<Clientes>read(){
       
       Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Clientes> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Clientes");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Clientes c = new Clientes();

                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setBairro(rs.getString("bairro"));
                c.setCidade(rs.getString("cidade"));
                c.setEstado(rs.getString("estado"));
                c.setCep(rs.getString("cep"));
                c.setCpf(rs.getString("cpf"));
                c.setCelular(rs.getString("celular"));
                c.setTipo(rs.getString("tipo"));
                               
                clientes.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return clientes;
       
   }

    public void update(Clientes p) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    }
