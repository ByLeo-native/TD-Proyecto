package launcher;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student alumno = new Student( 125970, "Paillamilla", "Leonardo", "leonardopaillamilla@yahoo.com.ar", "https://github.com/ByLeo-native/TD-Proyecto1", "");
            	SimplePresentationScreen presentacion = new SimplePresentationScreen(alumno);
            	presentacion.setVisible(true);
            }
        });
    }
}