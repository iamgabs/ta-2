package br.edu.ifpe.topicosavancados.db;

import br.edu.ifpe.topicosavancados.dao.UsuarioDAO;
import br.edu.ifpe.topicosavancados.interfaces.DatabaseI;

import java.util.ArrayList;

public class Database implements DatabaseI {
    private ArrayList<UsuarioDAO> usersDB = new ArrayList<>();

    private static Database instance;

    private Database() {}

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    @Override
    public UsuarioDAO getUserByEmail(String email) {
        UsuarioDAO usuarioDAO = null;
        for (int i = 0; i < usersDB.size(); i++) {
            if (usersDB.get(i).getEmail().equalsIgnoreCase(email)) {
                usuarioDAO = usersDB.get(i);
                break;
            }
        }
        return usuarioDAO;
    }


    @Override
    public void addUser(UsuarioDAO usuarioDAO) {
        usersDB.add(usuarioDAO);
    }
}
