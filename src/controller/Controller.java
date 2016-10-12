package controller;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import model.Client;

public class Controller {

    private final Client cliente;

    public Controller(String ip) throws NotBoundException, MalformedURLException, RemoteException {
        this.cliente = new Client(ip);
    }

    public int logar(String nome, String senha) throws RemoteException {
        return cliente.logar(nome, senha);
    }

    public boolean deslogar(String nome, String senha) throws RemoteException {
        return cliente.deslogar(nome, senha);
    }


}
