package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import rmi.Gerenciador;

public class Client {

    private final Gerenciador gerenciador;

    public Client(String ip) throws NotBoundException, MalformedURLException, RemoteException {
        gerenciador = (Gerenciador) Naming.lookup("//" + ip + ":3322/gerenciador");

    }

    public int logar(String nome, String senha) throws RemoteException {
        return gerenciador.logar(nome, senha);
    }

    public boolean deslogar(String nome) throws RemoteException {
        return gerenciador.deslogar(nome);
    }

    public String listarDocumentos() throws RemoteException {
        return gerenciador.listarDocumentos();
    }

    public boolean criarDocumento(String nome) throws RemoteException {
        return gerenciador.criarDocumento(nome);
    }
    
    public String abrirArquivo(String nome) throws RemoteException{
        return gerenciador.abrirArquivo(nome);
    }
    public String escreverArquivo(String arquivo, String texto) throws RemoteException{
        return gerenciador.escreverArquivo( arquivo,texto);
    }
}
