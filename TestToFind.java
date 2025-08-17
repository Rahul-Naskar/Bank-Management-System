package bank.crud;


import java.util.Scanner;

import com.rahul.AccountHolder;
import com.rahul.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestToFind 
{
	static Scanner sc = new Scanner(System.in);

	public static void find()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("rahul");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		System.out.println("1)  Check Account Holder Details");
		System.out.println("2)  Check Customer Account Details");
		int a = sc.nextInt();
		
		if(a==1)
		{
			System.out.println("Please Enter Account Number To Find The Account Holder Details :");
			sc.nextLine();
			AccountHolder ah = em.find(AccountHolder.class, sc.nextLine());
			if(ah!=null)
			{
				System.out.println(ah);
			}
			else
			{
				System.out.println("Sorry ! Account No doesn't exsist");
			}
			
		}
		else if (a == 2)
		{
			System.out.println("Please Enter Account Number To Find The Customer Account Details :");
			sc.nextLine();
			Customer c = em.find(Customer.class, sc.nextLine());
			if(c!=null)
			{
				System.out.println(c);
			}
			else
			{
				System.out.println("Sorry ! Account No doesn't exsist");
			}
		}
		else
		{
			System.out.println("Invalid Input");
		}
	}

}
