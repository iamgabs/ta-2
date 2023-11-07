package br.edu.ifpe.topicosavancados2.services;

import br.edu.ifpe.topicosavancados2.entities.Usuario;
import br.edu.ifpe.topicosavancados2.interfaces.IdentificaERPServiceI;

public class IdentificaERPServiceImpl implements IdentificaERPServiceI {

    @Override
    public boolean isValid(Usuario usuario) {
        return usuario != null && (usuario.getEmail().contains("@ifpe"));
    }
}
