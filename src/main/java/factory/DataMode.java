package factory;

import java.net.MalformedURLException;

import businessLogic.BLFacade;

public interface DataMode {
	public BLFacade dataMode() throws MalformedURLException;
}
