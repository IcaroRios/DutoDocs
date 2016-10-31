/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Controller;
import static java.lang.Thread.sleep;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Neida
 */
public class AtualizarAntiga implements Runnable {

    private Controller controller;
    private JTextArea textArea;

    public AtualizarAntiga(Controller controller, JTextArea textArea) {
        this.controller = controller;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String texto = controller.abrirArquivo(controller.getArquivo());
                if (!textArea.getText().equals(texto)) {
                    //controller.setCarret(textArea.getCaretPosition());
                    textArea.setText(texto);
                    System.out.println("texto diferente, modificando");
                    //textArea.setCaretPosition(controller.getCarret());
                }else
                    System.out.println("texto é igual");
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(AtualizarAntiga.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(AtualizarAntiga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
