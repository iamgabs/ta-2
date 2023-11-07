package br.edu.ifpe.topicosavancados2.services;

import br.edu.ifpe.topicosavancados2.entities.Usuario;
import br.edu.ifpe.topicosavancados2.interfaces.IdentificaExternoServiceI;

public class IdentificaExternoService implements IdentificaExternoServiceI {
    @Override
    public boolean isValid(Usuario usuario) {
        return usuario.getEmail().contains("@") && usuario.getSenha().length() > 3;
    }
}
