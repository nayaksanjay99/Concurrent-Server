/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcurrentServer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Client Signing on");
        
        
            Socket soc = new Socket("127.0.0.1", 8096);
            
            OutputStream out = soc.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out);
            BufferedWriter br = new BufferedWriter(osw);
            PrintWriter nos = new PrintWriter(br, true);
            BufferedReader kin = new BufferedReader(
                    new InputStreamReader(
                            System.in
                    )
            );
            JFrame f1 = new JFrame("GUI Client");
            JButton b1 = new JButton("Ok");
            JTextArea ta = new JTextArea(10,10);
            ta.setEditable(false);
            JTextField tf = new JTextField(20);
            JTextField tf2 = new JTextField(20);
            tf2.setEditable(false);
            JPanel p1 = new JPanel();
            p1.add(tf);
            p1.add(b1);
            f1.add(tf2,BorderLayout.NORTH);
            f1.add(p1,BorderLayout.SOUTH);
            f1.add(ta);
            f1.setSize(400,400);
            f1.setVisible(true);
            f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            L1 l1 = new L1(tf,ta,nos);
            b1.addActionListener(l1);
            tf.addActionListener(l1);
            
      
            Reader r = new Reader(soc,f1,ta,tf2);
            r.start();
            System.out.println("Client says connection established");
    }
}
class L1 implements ActionListener{
    
    JTextField tf;
    JTextArea ta;
    PrintWriter nos;
    L1(JTextField tf, JTextArea ta,PrintWriter nos){
        this.tf = tf;
        this.ta = ta;
        this.nos = nos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str =  tf.getText();
        tf.setText("");
        nos.println(str);
        if( str.equals("End")){
            System.exit(1);
        }
    }
}
//window listener


