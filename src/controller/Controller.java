package controller;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import model.Client;

public class Controller {

    private final Client cliente;
    private String login;
    private String arquivo;
    private int carret;

    public int getCarret() {
        return carret;
    }

    public void setCarret(int carret) {
        this.carret = carret;
    }
    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public Controller(String ip) throws NotBoundException, MalformedURLException, RemoteException {
        this.cliente = new Client(ip);
    }

    public int logar(String nome, String senha) throws RemoteException {
        return cliente.logar(nome, senha);
    }

    public boolean deslogar() throws RemoteException {
        return cliente.deslogar(login);
    }

    public String buscaArquivos() throws RemoteException {
        return cliente.listarDocumentos();
    }

    public boolean criarArquivos(String nome) throws RemoteException {
        return cliente.criarDocumento(nome);
    }
    
    public String abrirArquivo(String nome) throws RemoteException{
        return cliente.abrirArquivo(nome);
    }
    
    public String escreverArquivo(String arquivo, String texto) throws RemoteException{
        return cliente.escreverArquivo(arquivo, texto);
    }
}
