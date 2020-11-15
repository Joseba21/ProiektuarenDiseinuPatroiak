package test.businessLogic;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.User;
import domain.Admins;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FacadeMockTest {
	DataAccess dataAccess=Mockito.mock(DataAccess.class);
	User mockedUser=Mockito.mock(User.class);
	Admins mockedAdmin=Mockito.mock(Admins.class);


	@InjectMocks
	BLFacade sut=new BLFacadeImplementation(dataAccess);

	@Test
	//sut.login:  Sartutako korreoa ez da erabiltzailea eta ez da admina 
	public void test1() {
		try {
			//define paramaters
			String korreoa="aitor@gmail.com";
			String pasahitza="aitor";

			//configure Mock
			Mockito.doReturn(false).when(dataAccess).adminetandago(Mockito.anyString());

			//invoke System Under Test (sut) 
			sut.login(korreoa,pasahitza);

			//if the program continues fail
			fail();
		}catch (Exception e) {
			// if the program goes to this point OK (Exception)
			assertTrue(true);
		}
	}

	@Test
	//sut.login:  Sartutako korreoa erabiltzailea da baina pasahitza okerra da
	public void test2() {
		try {
			//define paramaters
			String korreoa="joseba@gmail.com";
			String pasahitza="patata";

			//configure Mock
			Mockito.doReturn(false).when(dataAccess).adminetandago(Mockito.anyString());
			Mockito.doReturn(mockedUser).when(dataAccess).getUser(Mockito.anyString());
			Mockito.when(mockedUser.getPasahitza()).thenReturn("joseba");

			//invoke System Under Test (sut) 
			sut.login(korreoa,pasahitza);

			//if the program continues OK (Syso printed)
			assertTrue(true);
		}catch (Exception e) {
			// if the program goes to this point fail
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	//sut.login:  Sartutako korreoa erabiltzailea da eta pasahitza zuzena da
	public void test3() {
		try {
			//define paramaters
			String korreoa="joseba@gmail.com";
			String pasahitza="joseba";

			//configure Mock
			Mockito.doReturn(false).when(dataAccess).adminetandago(Mockito.anyString());
			Mockito.doReturn(mockedUser).when(dataAccess).getUser(Mockito.anyString());
			Mockito.when(mockedUser.getPasahitza()).thenReturn("joseba");

			//invoke System Under Test (sut) 
			sut.login(korreoa,pasahitza);

			//if the program continues OK
			assertTrue(true);
		}catch (Exception e) {
			// if the program goes to this point fail
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	//sut.login:  Sartutako korreoa admina da baina pasahitza okerra da
	public void test4() {
		try {
			//define paramaters
			String korreoa="admin05@gmail.com";
			String pasahitza="patata";

			//configure Mock
			Mockito.doReturn(true).when(dataAccess).adminetandago(Mockito.anyString());
			Mockito.doReturn(mockedAdmin).when(dataAccess).getadmin(Mockito.anyString());
			Mockito.when(mockedAdmin.getPasahitza()).thenReturn("admin05");

			//invoke System Under Test (sut) 
			sut.login(korreoa,pasahitza);

			//if the program continues OK (Syso printed)
			assertTrue(true);
		}catch (Exception e) {
			// if the program goes to this point fail
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	//sut.login:  Sartutako korreoa admina da eta pasahitza zuzena da
	public void test5() {
		try {
			//define paramaters
			String korreoa="admin05@gmail.com";
			String pasahitza="admin05";

			//configure Mock
			Mockito.doReturn(true).when(dataAccess).adminetandago(Mockito.anyString());
			Mockito.doReturn(mockedAdmin).when(dataAccess).getadmin(Mockito.anyString());
			Mockito.when(mockedAdmin.getPasahitza()).thenReturn("admin05");

			//invoke System Under Test (sut) 
			sut.login(korreoa,pasahitza);

			//if the program continues OK
			assertTrue(true);
		}catch (Exception e) {
			// if the program goes to this point fail
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	//sut.login:  Sartutako korreoa eta pasahitza null dira
	public void test6() {
		try {
			//define paramaters
			String korreoa=null;
			String pasahitza=null;

			//configure Mock
			Mockito.doReturn(false).when(dataAccess).adminetandago(Mockito.anyString());
			Mockito.doReturn(null).when(dataAccess).getUser(Mockito.anyString());

			//invoke System Under Test (sut) 
			sut.login(korreoa,pasahitza);

			//if the program continues fail
			fail();
		}catch (Exception e) {
			// if the program goes to this point OK
			assertTrue(true);
		}
	}
	
	@Test
	//sut.login:  Sartutako korreoa ez du korreo formaturik
	public void test7() {
		try {
			//define paramaters
			String korreoa="joseba";
			String pasahitza="joseba";

			//configure Mock
			Mockito.doReturn(false).when(dataAccess).adminetandago(Mockito.anyString());
			Mockito.doReturn(null).when(dataAccess).getUser(Mockito.anyString());

			//invoke System Under Test (sut) 
			sut.login(korreoa,pasahitza);

			//if the program continues fail
			fail();
		}catch (Exception e) {
			// if the program goes to this point OK
			assertTrue(true);
		}
	}

}
