package de.alexzimmer.hrw.ndi.webclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Worker extends Thread {

    private InputStream input;

    public Worker(InputStream input) {
        this.input = input;
    }

    @Override
    public void run() {
        try {
            StringBuilder sb = new StringBuilder();
            int c;
            while ( (( c = input.read() ) >= 0) && (c != 0x0a /* <LF> */) ) {
                if ( c != 0x0d /* <CR> */ ) {
                    sb.append( (char)c );
                } else {
                    // Ignore <CR>.
                }
            }
            System.out.print(sb.toString());
        } catch (Exception e) {

        }
    }
}
