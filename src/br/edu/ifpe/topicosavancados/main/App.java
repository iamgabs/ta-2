package br.edu.ifpe.topicosavancados.main;

import br.edu.ifpe.topicosavancados.autenticador.Autenticador;
import br.edu.ifpe.topicosavancados.dao.UsuarioDAO;
import br.edu.ifpe.topicosavancados.db.Database;
import br.edu.ifpe.topicosavancados.repositories.UsuarioRepositoryImpl;
import br.edu.ifpe.topicosavancados.service.SenhaServiceImpl;

public class App {
    public static void main(String[] args) {
        SenhaServiceImpl senhaService = new SenhaServiceImpl();
        Database database = Database.getInstance();
        UsuarioRepositoryImpl usuarioRepository = new UsuarioRepositoryImpl(database);
        Autenticador autenticador = new Autenticador(usuarioRepository, senhaService);

        // criando usuários
        UsuarioDAO user1 = new UsuarioDAO("user1@email.com", "senha1", senhaService, usuarioRepository);
        UsuarioDAO user2 = new UsuarioDAO("user2@email.com", "senha2", senhaService, usuarioRepository);
        usuarioRepository.persiste(user1);
        usuarioRepository.persiste(user2);
        autenticador.autenticarUsuario(user1.getEmail(), user1.getSenha());
        autenticador.autenticarUsuario(user2.getEmail(), user2.getSenha());
        usuarioRepository.registraLogin(user1);
        usuarioRepository.registraLogin(user2);
    }
}
