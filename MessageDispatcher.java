/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConcurrentServer;

import java.io.*;

public class MessageDispatcher extends Thread {
    
    @Override
    public void run() {
        while (true) {
            try {
                String str = Server.q.dequeue();
                String str2;
                if(str.toLowerCase().contains("coke"))
                    str2="All New Coke now for rupees ten only";
                else
                    str2="X";
                for (PrintWriter o : Server.noslist) {
                    o.println(str);
                    o.println(str2);
                }
            } catch (Exception e) {
            }
        }
    }
}

