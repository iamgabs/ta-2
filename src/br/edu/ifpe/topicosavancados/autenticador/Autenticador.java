package br.edu.ifpe.topicosavancados.autenticador;

import br.edu.ifpe.topicosavancados.dao.UsuarioDAO;
import br.edu.ifpe.topicosavancados.interfaces.HashI;
import br.edu.ifpe.topicosavancados.interfaces.UsuarioRepositoryI;

public class Autenticador {
    // Princípio de inversão de dependência aplicado
    private UsuarioRepositoryI repositorioUsuarios;
    private HashI hashI;

    public Autenticador(UsuarioRepositoryI usuarioRepositoryI, HashI hashI) {
        this.repositorioUsuarios = usuarioRepositoryI;
        this.hashI = hashI;
    }

    /**
     * Resposnsabilidade separada para o método autenticarUsuário
     * que agora só verifica se a hash da senha é igual a hash da senha
     * armazenanda para efetuar a autenticação
     * @param email
     * @param senha
     * @return
     */
    public boolean autenticarUsuario(String email, String senha) {
        UsuarioDAO usuario = repositorioUsuarios.getUsuarioPorEmail(email);
        StringBuilder senhaHasheada = hashI.getHash(senha);
        System.out.println("hash: "+senhaHasheada+" para a senha: "+ senha + ", do usuario de email: " + email);

        boolean state = false;
        if (usuario.getHashSenha().toString().equals(senhaHasheada.toString())) {
            // atualiza usuário para autenticado
            usuario.setAuth();
        }
        if (usuario != null) state = usuario.isAutenticado();
        return state;
    }

}
