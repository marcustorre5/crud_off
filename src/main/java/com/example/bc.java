package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;

public class bc {

    //conexao com banco de dados postgres
    public static void conexao(){
    

        try{
            Connection conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "250250");
            if (conectar != null){
                System.out.println("Bando de dados conectato comm sucesso:");
                Statement st = conectar.createStatement();
                ler(st);
                criar(st);
                update(st);
                delete(st);
            }else{
                System.out.println("Não foi possível conectar ao banco de dados");
            }
    
        }
    
        catch(SQLException e){
            e.printStackTrace();
        }    
    
    }

    //criar 
    public static void criar(Statement st ){

        //movies filme = new movies();
        //filme.filmes();
        //String sql = "INSERT INTO filmes (nome_do_filme, ano) values ('"+filme.nome+"',"+filme.ano+");";

        String sql = "INSERT INTO filmes (nome_do_filme, ano) values ('homem formiga',"+2017+");";

        try{
            st.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    
    }

    //lendo tabela filmes do banco de dados postgres
    public static void ler(Statement st){

        String sql = "select * from filmes;";
        try{
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                //System.out.println("id: "+result.getString("id") + ", Nome: "+result.getString("nome"));
                System.out.println("filme: "+result.getString("nome_do_filme"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    //atualizando uma coluna da tabela filmes no banco de dados postgres
    public static void update(Statement st){

        String sql = "update filmes set nome_do_filme = 'vingadores endgame' where id = 9;";

        try{
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                //System.out.println("id: "+result.getString("id") + ", Nome: "+result.getString("nome"));
                System.out.println("filme: "+result.getString("nome_do_filme"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    //deletando uma linha da coluna id da tabela filmes do bancos de dados postgres
    public static void delete(Statement st){

        String sql = "delete from filmes where id = 17;";

        try{
            ResultSet result = st.executeQuery(sql);
            while (result.next()) {
                //System.out.println("id: "+result.getString("id") + ", Nome: "+result.getString("nome"));
                System.out.println("filme: "+result.getString("nome_do_filme"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
