package gui;

import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import javax.swing.UIManager;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import factory.DataMode;
import factory.LocalData;
import factory.RemoteData;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;

public class ApplicationLauncher {


	public static void main(String[] args) {

		ConfigXML c=ConfigXML.getInstance();

		System.out.println(c.getLocale());

		Locale.setDefault(new Locale(c.getLocale()));

		System.out.println("Locale: "+Locale.getDefault());

		DataMode datamode;


		try {

			BLFacade appFacadeInterface;
			//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			if (c.isBusinessLogicLocal()) {
				datamode = new LocalData();
				System.out.println("hau da bfcade" + datamode.toString());
				appFacadeInterface=datamode.dataMode();
			} 

			else { //If remote

				datamode= new RemoteData();
				appFacadeInterface=datamode.dataMode();
			}
				MainGUI.setBussinessLogic(appFacadeInterface);
				System.out.println(MainGUI.getBusinessLogic());
				

			LoginGUI a=new LoginGUI();
			a.setVisible(true);

		}catch (Exception e) {
			//			a.jLabelSelectOption.setText("Error: "+e.toString());
			//			a.jLabelSelectOption.setForeground(Color.RED);		
			System.out.println("Error in ApplicationLauncher: "+e.toString());
		}
		//a.pack();


	}

}
