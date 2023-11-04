package br.edu.ifpe.topicosavancados.repositories;

import br.edu.ifpe.topicosavancados.dao.UsuarioDAO;
import br.edu.ifpe.topicosavancados.interfaces.DatabaseI;
import br.edu.ifpe.topicosavancados.interfaces.UsuarioRepositoryI;

public class UsuarioRepositoryImpl implements UsuarioRepositoryI {
    private DatabaseI databaseI;

    public UsuarioRepositoryImpl() {}

    public UsuarioRepositoryImpl(DatabaseI databaseI) {
        this.databaseI = databaseI;
    }

    @Override
    public UsuarioDAO getUsuarioPorEmail(String email) {
        return databaseI.getUserByEmail(email);
    }

    @Override
    public void registraLogin(UsuarioDAO usuarioDAO) {
        String msg =  usuarioDAO.isAutenticado() ? "Login Registrado": "Precisa estar autenticado";
        System.out.println(msg);
    }

    @Override
    public void persiste(UsuarioDAO usuarioDAO) {
        databaseI.addUser(usuarioDAO);
    }
}
