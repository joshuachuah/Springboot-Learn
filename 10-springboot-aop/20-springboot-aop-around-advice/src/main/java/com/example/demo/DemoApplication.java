package com.example.demo;

import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;
import com.example.demo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
											   MembershipDAO theMembershipDAO,
											   TrafficFortuneService theTrafficFortuneService) {

		return runner -> {
			// demoBeforeAdvice(theAccountDAO, theMembershipDAO);
			// demoAfterReturningAdvice(theAccountDAO);
			// demoAfterThrowingAdvice(theAccountDAO);
			// demoAfterAdvice(theAccountDAO);

			demoAroundAdvice(theTrafficFortuneService);
		};
	}

	private void demoAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

		System.out.println("\nMain Program: demoAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = theTrafficFortuneService.getFortune();

		System.out.println("\nMy fortune is: " + data);

		System.out.println("Finished.");
	}

	private void demoAfterAdvice(AccountDAO theAccountDAO) {

		// call method to find the accounts
		List<Account> theAccounts = null;

		try{

			// boolean flag to simulate exception
			boolean tripWire = false;

			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("\n\nMain Program: ... catch exception: " + e);
		}


		// display the accounts
		System.out.println("\n\nMain Program: demoAfterThrowingAdvice");
		System.out.println("---------------------");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoAfterThrowingAdvice(AccountDAO theAccountDAO) {

		// call method to find the accounts
		List<Account> theAccounts = null;

		try{

			// boolean flag to simulate exception
			boolean tripWire = true;

			theAccounts = theAccountDAO.findAccounts(tripWire);
		}
		catch (Exception e){
			System.out.println("\n\nMain Program: ... catch exception: " + e);
		}


		// display the accounts
		System.out.println("\n\nMain Program: demoAfterThrowingAdvice");
		System.out.println("---------------------");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoAfterReturningAdvice(AccountDAO theAccountDAO) {

		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();

		// display the accounts
		System.out.println("\n\nMain Program: demoAfterReturningAdvice");
		System.out.println("---------------------");

		System.out.println(theAccounts);

		System.out.println("\n");
	}

	private void demoBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		myAccount.setName("John Doe");
		myAccount.setLevel("Business");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();


		// call accountdao getter/setter methods
		theAccountDAO.setName("Kazuha");
		theAccountDAO.setServiceCode("LE SSERAFIM");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();

	}
}
