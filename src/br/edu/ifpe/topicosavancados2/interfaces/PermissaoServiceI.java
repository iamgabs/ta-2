package br.edu.ifpe.topicosavancados2.interfaces;

import br.edu.ifpe.topicosavancados2.entities.Usuario;

public interface PermissaoServiceI {
    public boolean hasHole(Usuario usuario, String cargo);
}
