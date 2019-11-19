/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            
            while(true){
                Scanner ler = new Scanner(System.in);
            
                InputStream is = sock.getInputStream(); // Canal de entrada de dados
                OutputStream os = sock.getOutputStream(); // Canal de saída de dados
                String msg = "Olá, DCOMP!!!";
                msg = ler.nextLine();
                byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem
                
                System.out.print("[ Enviando mensagem    ..............................  ");
                os.write(buf);
                System.out.println("[OK] ]");
                
                buf = new byte[20]; // buffer de recepção
    
                System.out.print("[ Aguardando recebimento de mensagem   ..............  ");
                is.read(buf); // Operação bloqueante (aguardando chegada de dados)
                System.out.println("[OK] ]");
                
                msg = new String(buf); // Mapeando vetor de bytes recebido para String
                
                System.out.println("  Mensagem recebida: "+ msg);
            }
            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}