package iterator;

import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Event;
import factory.DataMode;
import factory.LocalData;

public class Main {
	public static void main(String[] args) throws ParseException, MalformedURLException {
		//Facade objektua lortu lehendabiziko ariketa erabiliz
		DataMode datamode = new LocalData();
		BLFacade appFacadeInterface=datamode.dataMode();
		
		String eguna = "17/03/2020";
		String pattern = "dd/MM/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		Date data = simpleDateFormat.parse(eguna);
		
		ExtendedIterator<Event> i=appFacadeInterface.getEvents(data);
		Event ev;
		i.goLast();
		while (i.hasPrevious()){
			ev=i.previous();
			System.out.println(ev.toString());
		}
		//Nahiz eta suposatu hasierara ailegatu garela, eragiketa egiten dugu.
		System.out.println();
		i.goFirst();
		while (i.hasNext()){
			ev=i.next();
			System.out.println(ev.toString());
		}
	}
}