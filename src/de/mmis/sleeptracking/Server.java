package de.mmis.sleeptracking;

import java.io.*;
import java.net.*; 
import java.util.*;
import javax.microedition.io.*;
import javax.bluetooth.*;
import javax.bluetooth.UUID;

public class Server {
	
	UUID uuid = new UUID("8848",true);
	
    public void startserver() {
        try {
     String url = "btspp://localhost:" + uuid +
         ";name=File Server";
     StreamConnectionNotifier service = (StreamConnectionNotifier) Connector.open( url );

     StreamConnection connection = (StreamConnection) service.acceptAndOpen();
     InputStream inStream=connection.openInputStream();
     BufferedReader bReader=new BufferedReader(new InputStreamReader(inStream));
     String lineRead=bReader.readLine();
     System.out.println(lineRead);
     
     service.close();

        }catch ( IOException e ) {
        	System.err.print(e.toString());
        }
    }
    
    
    
    public static void main( String args[] ) {
    	try {
    		LocalDevice local = LocalDevice.getLocalDevice();
    		System.out.println("Serverted:\n"
    				+local.getBluetoothAddress()
    				+"\n"+local.getFriendlyName()); 

    		Server ff = new Server(); 
    		while (true) {
    			ff.startserver(); 
    		} //while 
    	}  //try 
    	catch (Exception e) {System.err.print(e.toString());
    	}
    }
}
	
	


