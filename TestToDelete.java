package bank.crud;

import java.util.Scanner;

import com.rahul.AccountHolder;
import com.rahul.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestToDelete 
{
	static Scanner sc = new Scanner(System.in);
	
	public static void delete()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("rahul");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		System.out.println("Please Enter Account No To Delete :");
		int a = sc.nextInt();
		AccountHolder ah = em.find(AccountHolder.class, a);
		Customer c = em.find(Customer.class, a);
		
		
		if(ah!=null && c!=null)
		{
			try 
			{
				System.out.println("Are you sure to Delete the record permanently ?");
				System.out.println("1) Yes");
				System.out.println("2) No");
				int x = sc.nextInt();
				if(x==1)
				{
					System.out.println("Wait for a While !!!");
					Thread.sleep(3000);
					et.begin();
					em.remove(c);
					em.remove(ah);
					et.commit();
					System.out.println("Successfully Deleted Your Account");
				}
				else if(x==2)
				{
					System.out.println("Your Account has not Deleted");
				}
				else
				{
					System.out.println("Invalid Input");
				}
				
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Sorry! No Record Is There");
		}
	}
}
