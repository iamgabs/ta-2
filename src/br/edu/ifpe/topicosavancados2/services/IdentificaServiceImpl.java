package br.edu.ifpe.topicosavancados2.services;

import br.edu.ifpe.topicosavancados2.entities.Usuario;
import br.edu.ifpe.topicosavancados2.interfaces.IdentificaServiceI;

public class IdentificaServiceImpl implements IdentificaServiceI {

    @Override
    public boolean isValid(Usuario usuario) {
        return true;
    }
}