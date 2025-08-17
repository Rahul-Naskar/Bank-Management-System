package bank.crud;

import java.util.Scanner;

import com.rahul.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestToCheckBalance 
{
	static Scanner sc = new Scanner(System.in);
	public static void check()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("rahul");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Enter Account No. to Check Balance :");
		int x = sc.nextInt();
		Customer c = em.find(Customer.class, x);
		if(c!=null)
		{
			System.out.println("Your current Balance is: " + c.getBalance());
		}
		else
		{
			System.out.println("Account doesn't exist");
		}
	}
}
