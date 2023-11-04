package br.edu.ifpe.topicosavancados.interfaces;

import br.edu.ifpe.topicosavancados.dao.UsuarioDAO;

import java.util.ArrayList;

public interface DatabaseI {
    UsuarioDAO getUserByEmail(String email);

    public void addUser(UsuarioDAO usuarioDAO);

}
