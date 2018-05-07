package de.alexzimmer.hrw.ndi.webclient;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SimpleWebclient {

    private String host;
    private int port;
    private String file;

    public SimpleWebclient(String host, String port, String file) {
        this.host = host;
        this.port = Integer.parseInt(port);
        this.file = file;
    }

    public void performRequest() {
        try {
            InetAddress address = InetAddress.getByName(host);
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(address, port), 2000);
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            output.println("GET "+file+" HTTP/1.1");
            output.println("Host: "+host+":"+port);
            output.println("Connection: Close");
            output.println();

            boolean loop = true;
            while (loop) {
                if (input.ready()) {
                    int i = 0;
                    while (i != -1) {
                        i = input.read();
                        System.out.print((char) i);
                    }
                    loop = false;
                }
            }
            socket.close();

        } catch(Exception e) { }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

}
