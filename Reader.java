/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcurrentServer;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

class Reader extends Thread {

    Socket soc;
    JFrame f1;
    JTextArea ta;
    JTextField tf2;

    Reader(Socket soc,JFrame f1,JTextArea ta,JTextField tf2) {
        this.soc = soc;
        this.f1=f1;
        this.ta=ta;
        this.tf2=tf2;
    }

    public void run() {
        try {
            BufferedReader nis = new BufferedReader(
                            new InputStreamReader(
                            soc.getInputStream()
                            )
             );
            String str = nis.readLine();
            String str2=nis.readLine();
            while( !str.equals("End") )
            {
             ta.append(str+"\n");
             if(!str2.equals("X"))
                 tf2.setText(str2);
             else
                 tf2.setText("");
             System.out.println("Message from Server >> " +str );
             str = nis.readLine();
             str2=nis.readLine();
            }
            Thread.sleep(2000);
            f1.dispose();
        } catch (Exception e) {
        }
    }
}

