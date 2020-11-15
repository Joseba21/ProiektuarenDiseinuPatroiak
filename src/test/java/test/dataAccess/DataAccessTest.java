package test.dataAccess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import businessLogic.*;


public class DataAccessTest {

	static DataAccess sut=new DataAccess(ConfigXML.getInstance().getDataBaseOpenMode().equals("initialize"));;
	static BLFacadeImplementation testBL=new BLFacadeImplementation();

	private boolean b;

	@Test
	//sut.adminetandago:  Erabiltzailea ez da admina 
	public void test1() {
		try {

			//define paramaters	
			String korreoa = "joseba@gmail.com";

			//configure the state of the system (create object in the dabatase)
			//Kasu honetan ez da beharrezkoa errorea eman behar du eta.		

			//invoke System Under Test (sut)  
			b = sut.adminetandago(korreoa);

			//verify the results
			assertEquals(b,false);
			assertTrue(true);

		} catch (Exception e) {
			// if the program goes to this point fail
			fail();
		} finally {
			//Remove the created objects in the database (cascade removing)   
			//Kasu honetan ez dut objekturik sortu datu basean         
		}
	}
	@Test
	//sut.adminetandago:  Erabiltzailea admina da
	public void test2() {
		try {

			//define paramaters
			String iz = "joseba";
			String ab = "jimenez";
			String korreoa = "joseba@gmail.com";
			String phitz1 = "joseba";
			String phitz2 = "joseba";
			Integer tfnoa = 946598745;
			Integer adina = 21;			

			//configure the state of the system (create object in the dabatase)
			sut.createAdmin(iz,ab,korreoa,phitz1,phitz2,tfnoa,adina);				

			//invoke System Under Test (sut)  
			b = sut.adminetandago(korreoa);

			//verify the results
			assertEquals(b,true);

		} catch (Exception e) {
			e.printStackTrace();
			fail();
		} finally {
			//Remove the created objects in the database (cascade removing)   
			sut.deleteAdmin("joseba@gmail.com");
			System.out.println("Proba erabiltzailea ezabatu da");           
		}
	}

	@Test
	//sut.adminetandago:  null balioa sartuz
	public void test3() {
		try {

			//define paramaters	

			//configure the state of the system (create object in the dabatase)

			//invoke System Under Test (sut)  
			b = sut.adminetandago(null);

			//verify the results
			fail();

		} catch (Exception e) {
			assertTrue(true);
		} finally {
			//Remove the created objects in the database (cascade removing)
			//Kasu honetan ez dut objekturik sortu datu basean
		}
	}

	@Test
	//sut.adminetandago:  korreoa ez den balio bat sartuz
	public void test4() {
		try {

			//define paramaters	

			//configure the state of the system (create object in the dabatase)

			//invoke System Under Test (sut)  
			b = sut.adminetandago("patata");


			//verify the results
			fail();


		} catch (Exception e) {
			assertTrue(true);
		} finally {
			//Remove the created objects in the database (cascade removing)   
			//Kasu honetan ez dut objekturik sortu datu basean
		}
	}
}
