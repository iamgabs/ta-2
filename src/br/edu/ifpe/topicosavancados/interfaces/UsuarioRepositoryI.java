package br.edu.ifpe.topicosavancados.interfaces;

import br.edu.ifpe.topicosavancados.dao.UsuarioDAO;

public interface UsuarioRepositoryI {
    UsuarioDAO getUsuarioPorEmail(String email);
    void registraLogin(UsuarioDAO usuarioDAO);
    void persiste(UsuarioDAO usuarioDAO);
}
