package br.edu.ifpe.topicosavancados.dao;

import br.edu.ifpe.topicosavancados.interfaces.DatabaseI;
import br.edu.ifpe.topicosavancados.interfaces.HashI;
import br.edu.ifpe.topicosavancados.interfaces.UsuarioRepositoryI;

import java.util.ArrayList;

public class UsuarioDAO {
    private String email, senha;
    private boolean autenticado = false;
    private HashI senhaService;
    private UsuarioRepositoryI usuarioRepositoryI;


    public UsuarioDAO() {}

    public UsuarioDAO(String email, String senha) {}

    public UsuarioDAO(String email, String senha, HashI senhaService, UsuarioRepositoryI usuarioRepositoryI) {
        this.email = email;
        this.senha = senha;
        this.senhaService = senhaService;
        this.usuarioRepositoryI = usuarioRepositoryI;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setAuth() {
        this.autenticado = true;
    }
    public boolean isAutenticado() {
        return this.autenticado;
    }
    public StringBuilder getHashSenha() {
        return senhaService.getHash(this.senha);
    }
}
