package factory;

import java.net.MalformedURLException;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import gui.MainGUI;

public class LocalData implements DataMode{

	@Override
	public BLFacade dataMode() throws MalformedURLException{
		ConfigXML c=ConfigXML.getInstance();
		DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
		return new BLFacadeImplementation(da);
	}
	
}
