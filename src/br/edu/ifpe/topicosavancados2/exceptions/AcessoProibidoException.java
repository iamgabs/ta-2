package br.edu.ifpe.topicosavancados2.exceptions;

public class AcessoProibidoException extends RuntimeException{
    public AcessoProibidoException(String message) {
        super(message);
    }
}
