package de.alexzimmer.hrw.ndi.webclient;

public class Entrypoint {

    public static void main(String[] args) {
        String host = "localhost";
        String port = "8080";
        String file = "/";
        if(args.length >= 1) {
            host = args[0];
            if(args.length >= 2) {
                port = args[1];
                if(args.length >= 3) {
                    file = args[2];
                }
            }
        }
        new SimpleWebclient(host, port, file).performRequest();
    }

}
