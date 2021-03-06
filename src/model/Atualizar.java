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
public class Atualizar implements Runnable {

    private Controller controller;
    private JTextArea textArea;

    public Atualizar(Controller controller, JTextArea textArea) {
        this.controller = controller;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String texto = controller.abrirArquivo(controller.getArquivo());
                if (!textArea.getText().equals(texto)) {
                    int carret = textArea.getCaretPosition();
                    texto = removerUltimoEnter(texto);
                    textArea.setText(texto);
                    System.out.println("texto diferente, modificando");
                    if (carret <= texto.length()) {
                        textArea.setCaretPosition(carret);
                    } else {
                        textArea.setCaretPosition(texto.length());
                    }
                } else {
                    System.out.println("texto é igual");
                }
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Atualizar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex) {
                Logger.getLogger(Atualizar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String removerUltimoEnter(String str) {
        if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == '\n') {
            str = str.substring(0, str.length() - 1);
        }
        return str;
    }
}
