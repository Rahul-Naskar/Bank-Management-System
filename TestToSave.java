package bank.crud;

import java.util.Scanner;

import com.rahul.AccountHolder;
import com.rahul.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestToSave 
{
	static Scanner sc = new Scanner(System.in);
	
	public static void save()
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("rahul");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
			
		
		//------------------------------------------------------------------------------
		System.out.println("Enter Account No. :");
		int ann = sc.nextInt();
		
		AccountHolder ah1 = em.find(AccountHolder.class, ann);
		if(ah1 == null)
		{
			sc.nextLine();
			System.out.println("Enter Account Holder Name :");
			String nn = sc.nextLine().toUpperCase();
			System.out.println("Enter Address :");
			String ad = sc.nextLine().toUpperCase();
			System.out.println("Enter Aadhar No. :");
			long ada = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter Pan No :");
			String p = sc.nextLine().toUpperCase();
			System.out.println("Enter Mobile No :");
			long ph = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter Email :");
			String e = sc.nextLine().toLowerCase();
			
			
			AccountHolder ah = new AccountHolder(ann, nn, ad, ada, p, ph, e);
			
			//-----------------------------------------------------------------------------
			System.out.println("Wait for a While !!!!");
			try 
			{
				Thread.sleep(5000);
				//-----------------------------------------------------------------------------
				System.out.println("Great ! please enter Account No. and Name again and add Initial Balance (* minimum 2000 *) ");
				//-----------------------------------------------------------------------------
				
				
				System.out.println("Enter Account No. :");
				int an = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter Account Holder Name :");
				String n = sc.nextLine().toUpperCase();
				System.out.println("Enter Balance :");
				double b = sc.nextDouble();
				
				
				if(ann==an)
				{
					if(nn.equals(n))
					{
						if(b>=2000)
						{
							Customer c = new Customer(an, n, b);
							System.out.println("Congrats ! Your Account has been created");
							
							c.setAh(ah);
							et.begin();
							em.persist(c);
							em.persist(ah);
							et.commit();
						}
						else
						{
							System.out.println("Oops !!!! I can't add you");
							Thread.sleep(3000);
							System.out.println("Sorry! minimum balance requirement not met");
						}
						
					}
					else
					{
						System.out.println("Oops !!!! I can't add you");
						Thread.sleep(3000);
						System.out.println("Your Names are not matching ! ");
					}
					
				}
				else
				{
					System.out.println("Oops !!!! I can't add you");
					Thread.sleep(3000);
					System.out.println("Your Account No. are not matching ! ");
				}
				
			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("This Account No. Is Already Exsist !!!");
		}
		
	}

}
