package bank.crud;

import java.util.Scanner;

import org.hibernate.internal.build.AllowPrintStacktrace;

import com.rahul.AccountHolder;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class TestToUpdateDetails 
{
	static Scanner sc = new Scanner(System.in);
	
	public static void updateDetails()
	{
		
		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("rahul");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			
			System.out.println("1) Update Name");
			System.out.println("2) Update Address");
			System.out.println("3) Update Mobile No.");
			System.out.println("4) Update Aadhar No.");
			System.out.println("5) Update Pan No.");
			System.out.println("6) Update Email");
			
			int a = sc.nextInt();
			if(a==1)
			{
				//--------------------------UPDATE NAME-------------------------------
				
				String jpql1 = "update AccountHolder set name = :newName where accountNo = :accountno";
				String jpql2 = "update Customer set name = :newName where accountNo = :accountno";
				Query q1 = em.createQuery(jpql1);
				Query q2 = em.createQuery(jpql2);
				
				System.out.println("Enter Account No. :");
				int x = sc.nextInt();
				 
				AccountHolder ah = em.find(AccountHolder.class, x);
				
				System.out.println("Enter Account No. again :");
				int y = sc.nextInt();
				
				if(ah!=null)
				{
					
					if(x==y)
					{
						q1.setParameter("accountno", x);
						q2.setParameter("accountno", y);
						
						sc.nextLine();
						System.out.println("Enter New Name :");
						String n1 = sc.nextLine();
						q1.setParameter("newName", n1.toUpperCase());
						System.out.println("Enter New Name again :");
						String n2 = sc.nextLine();
						q2.setParameter("newName", n2.toUpperCase());
						Thread.sleep(3000);
						
						if(n1.equals(n2))
						{
							et.begin();
							q1.executeUpdate();
							q2.executeUpdate();
							et.commit();
							System.out.println("Congrats ! Your Name Successfully Updated");
						}
						else
						{
							System.out.println("Name does not match");
						}
						
					}
					else
					{
						System.out.println("Account No. not matched");
					}
				}
				else
				{
					System.out.println("Account No. not found ");
				}
			}
			else if(a==2)
			{
				//--------------------------UPDATE ADDRESS-------------------------------
				
				String jpql3 = "update AccountHolder set address = :newAddress where accountNo = :accountno";
				Query q3 = em.createQuery(jpql3);
				
				System.out.println("Enter Account No. :");
				int x = sc.nextInt();
				
				AccountHolder ah = em.find(AccountHolder.class, x);
				if(ah!=null)
				{
					q3.setParameter("accountno", x);
					sc.nextLine();
					System.out.println("Enter new Address :");
					String s = sc.nextLine();
					q3.setParameter("newAddress", s.toUpperCase());
					Thread.sleep(3000);
					
					
					et.begin();
					q3.executeUpdate();
					et.commit();
					System.out.println("Your Address Successfully Updated");
				}
				else
				{
					System.out.println("Account No. not found");
				}
				
			}
			else if(a==3)
			{
				//--------------------------UPDATE MOBILE NO.-------------------------------
				
				String jpql4 = "update AccountHolder set mobileNo = :newMobile where accountNo = :accountno";
				Query q4 = em.createQuery(jpql4);
				
				System.out.println("Enter Account No. :");
				int x = sc.nextInt();
				
				AccountHolder ah = em.find(AccountHolder.class, x);
				if(ah!=null)
				{
					q4.setParameter("accountno", x);
					System.out.println("Enter new Mobile No. :");
					long l = sc.nextLong();
					if(l>0)
					{
						q4.setParameter("newMobile", l);
						Thread.sleep(3000);
						
						et.begin();
						q4.executeUpdate();
						et.commit();
						System.out.println("Your Mobile No. Successfully Updated");
					}
					else
					{
						System.out.println("This Format is NOT ALLOWED");
					}
					
				}
				else
				{
					System.out.println("Account No. not found");
				}
			}
			else if(a==4)
			{
				//--------------------------UPDATE AADHAR NO.-------------------------------
				
				String jpql5 = "update AccountHolder set aadharNo = :newAadhar where accountNo = :accountno";
				Query q5 = em.createQuery(jpql5);
				
				System.out.println("Enter Account No. :");
				int x = sc.nextInt();
				
				AccountHolder ah = em.find(AccountHolder.class, x);
				if(ah!=null)
				{
					q5.setParameter("accountno", x);
					System.out.println("Enter new Aadhar No. :");
					long l = sc.nextLong();
					if(l>0)
					{
						q5.setParameter("newAadhar", l);
						Thread.sleep(3000);
						
						et.begin();
						q5.executeUpdate();
						et.commit();
						System.out.println("Your Aadhar No. Successfully Updated");
					}
					else
					{
						System.out.println("This Format is NOT ALLOWED");
					}
				}
				else
				{
					System.out.println("Account No. not found");
				}
			}
			else if(a==5)
			{
				//--------------------------UPDATE PAN NO.-------------------------------
				
				String jpql6 = "update AccountHolder set panNo = :newPan where accountNo = :accountno";
				Query q6 = em.createQuery(jpql6);
				
				System.out.println("Enter Account No. :");
				int x = sc.nextInt();
				
				AccountHolder ah = em.find(AccountHolder.class, x);
				if(ah!=null)
				{
					q6.setParameter("accountno", x);
					sc.nextLine();
					System.out.println("Enter new Pan No. :");
					String s = sc.nextLine().toUpperCase();
					q6.setParameter("newPan", s);
					Thread.sleep(3000);
					
					et.begin();
					q6.executeUpdate();
					et.commit();
					System.out.println("Your Pan No. Successfully Updated");	
				}
				else
				{
					System.out.println("Account No. not found");
				}
			}
			else if(a==6)
			{
				//--------------------------UPDATE EMAIL-------------------------------
				
				String jpql7 = "update AccountHolder set email = :newEmail where accountNo = :accountno";
				Query q7 = em.createQuery(jpql7);
				
				System.out.println("Enter Account No. :");
				int x = sc.nextInt();
				
				AccountHolder ah = em.find(AccountHolder.class, x);
				if(ah!=null)
				{
					q7.setParameter("accountno", x);
					sc.nextLine();
					System.out.println("Enter new Email :");
					String s = sc.nextLine().toLowerCase();
					q7.setParameter("newEmail", s);
					Thread.sleep(3000);
					
					et.begin();
					q7.executeUpdate();
					et.commit();
					System.out.println("Your Email Successfully Updated");
				}
				else
				{
					System.out.println("Account No. not found");
				}
			}
			else
			{
				System.out.println("Invalid Input");
			}
			
		}
		catch (Exception e) 
		{
			
		}
	}
}
