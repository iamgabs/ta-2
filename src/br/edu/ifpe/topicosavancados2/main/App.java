package br.edu.ifpe.topicosavancados2.main;

import br.edu.ifpe.topicosavancados2.controller.ControleAcesso;
import br.edu.ifpe.topicosavancados2.entities.Usuario;
import br.edu.ifpe.topicosavancados2.exceptions.AcessoProibidoException;
import br.edu.ifpe.topicosavancados2.services.*;

public class App {
    public static void main(String[] args) {

        ControleAcesso controleAcessoNormal;
        ControleAcesso controleAcessoToken;

        controleAcessoNormal = new ControleAcesso(new IdentificaServiceImpl(),
                                                new IdentificaERPServiceImpl(),
                                                new PermissaoServiceImpl(),
                                                new IdentificaExternoService());

        controleAcessoToken = new ControleAcesso(new IdentificaServiceImpl(),
                                                new IdentificaERPServiceImpl(),
                                                new PermissaoTokenServiceImpl(),
                                                new IdentificaExternoService());


        Usuario user1 = new Usuario("email@ifpe.com", "1234");
        Usuario user2 = new Usuario("email2@ifpe.com", "1234");

        try{
            controleAcessoNormal.login(user1, "employee");
            System.out.println("Acesso concedido ao usuario" + user1.getEmail());
        } catch (AcessoProibidoException acessoProibidoException) {
            System.out.println(acessoProibidoException.getMessage());
        }

        try{
            controleAcessoToken.login(user2, "manager");
            System.out.println("Acesso concedido ao usuario" + user2.getEmail());
        } catch (AcessoProibidoException acessoProibidoException) {
            System.out.println(acessoProibidoException.getMessage());
        }


        // É esperado uma exception, pois o usuário não tem a permissão necessária
        // (managers devem entrar com o token, na lógica)
        try{
            controleAcessoNormal.login(user2, "manager");
        } catch (AcessoProibidoException acessoProibidoException) {
            System.out.println(acessoProibidoException.getMessage());
        }

        // É esperado uma exception, pois o usuário não tem a permissão necessária
        // (employees devem entrar com sem token, na lógica)
        try{
            controleAcessoToken.login(user1, "employee");
        } catch (AcessoProibidoException acessoProibidoException) {
            System.out.println(acessoProibidoException.getMessage());
        }

        }
}
