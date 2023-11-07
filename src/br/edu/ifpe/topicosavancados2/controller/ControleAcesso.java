package br.edu.ifpe.topicosavancados2.controller;

import br.edu.ifpe.topicosavancados2.entities.Usuario;
import br.edu.ifpe.topicosavancados2.exceptions.AcessoProibidoException;
import br.edu.ifpe.topicosavancados2.interfaces.IdentificaERPServiceI;
import br.edu.ifpe.topicosavancados2.interfaces.IdentificaExternoServiceI;
import br.edu.ifpe.topicosavancados2.interfaces.IdentificaServiceI;
import br.edu.ifpe.topicosavancados2.interfaces.PermissaoServiceI;

public class ControleAcesso {
    private IdentificaServiceI identificaService;
    private IdentificaERPServiceI identificaERPService;
    private PermissaoServiceI permissao;
    private IdentificaExternoServiceI identifica;

    public ControleAcesso() {}
    public ControleAcesso( IdentificaServiceI identificaService,
                            IdentificaERPServiceI identificaERPService,

                            PermissaoServiceI permissao,
                            IdentificaExternoServiceI identifica) {
        this.identificaService = identificaService;
        this.identificaERPService = identificaERPService;
        this.permissao = permissao;
        this.identifica = identifica;
    }
    public Usuario login(Usuario usuario, String cargo) {
        if(identificaService.isValid(usuario) && identificaERPService.isValid(usuario)){
            if (identifica.isValid(usuario) && permissao.hasHole(usuario, cargo)) {
                return usuario;
            }
        }
        throw new AcessoProibidoException("Acesso Negado");
    }
}