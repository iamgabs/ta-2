package br.edu.ifpe.topicosavancados2.services;

import br.edu.ifpe.topicosavancados2.entities.Usuario;
import br.edu.ifpe.topicosavancados2.interfaces.PermissaoServiceI;

public class PermissaoTokenServiceImpl implements PermissaoServiceI {
    @Override
    public boolean hasHole(Usuario usuario, String cargo) {
        return usuario != null && cargo.equalsIgnoreCase("manager");
    }
}
