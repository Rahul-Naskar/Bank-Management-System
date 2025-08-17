package bank.crud;

import java.util.Scanner;

import com.rahul.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class TestToUpdateBalance 
{
	static Scanner sc = new Scanner(System.in);
	
	public static void update()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("rahul");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		//---------------------------------UPDATE BALANCE------------------------------------
		String jpql = "update Customer set balance = :newBalance where accountNo = :accountno";
		Query q= em.createQuery(jpql);
		
		System.out.println("Please enter AccountNo to check Balance :");
		int x = sc.nextInt();
		Customer c = em.find(Customer.class, x);
		
		if(c!=null)
		{
			System.out.println("Your current Balance is :" + c.getBalance());
			
			System.out.println("1) Deposit Amount");
			System.out.println("2) Withdraw Amount");
			
			int a = sc.nextInt();
			if(a==1)
			{
				System.out.println("Enter Account No :");
				int y = sc.nextInt();
				if(x==y)
				{
					q.setParameter("accountno", y);
					double newBalance = c.getBalance();
					System.out.println("Enter Deposit Amount :");
					double b1 = sc.nextDouble();
					if(b1>=1)
					{
						newBalance = newBalance + b1;
						q.setParameter("newBalance", newBalance);
						
						System.out.println("Congrats ! your Balance has been Updated");
						et.begin();
						q.executeUpdate();
						et.commit();
					}
					else
					{
						System.out.println("Insufficient Balance");
					}
				}
				else
				{
					System.out.println("Oops !!! Mismatch Account No. ");
				}
			}
			else if(a==2)
			{
				System.out.println("Enter Account No :");
				int y = sc.nextInt();
				if(x==y)
				{
					q.setParameter("accountno", y);
					double newBalance = c.getBalance();
					System.out.println("Enter Withdraw Amount :");
					double b2 = sc.nextDouble();
					if(b2>=1 && b2<newBalance)
					{
						newBalance = newBalance - b2;
						q.setParameter("newBalance", newBalance);
						
						System.out.println("Congrats ! your Balance has been Updated");
						et.begin();
						q.executeUpdate();
						et.commit();
					}
					else
					{
						System.out.println("Insufficient Balance");
					}
				}
				else
				{
					System.out.println("Oops !!! Mismatch Account No. ");
				}	
			}
			else
			{
				System.out.println("Invalid Input");
			}
		}
		else
		{
			System.out.println("Account doesn't exist");
		}
	}
}
