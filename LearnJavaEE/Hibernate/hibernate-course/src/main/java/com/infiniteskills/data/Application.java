package com.infiniteskills.data;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.infiniteskills.data.entities.Account;
import com.infiniteskills.data.entities.AccountType;
import com.infiniteskills.data.entities.Address;
import com.infiniteskills.data.entities.Bank;
import com.infiniteskills.data.entities.Bond;
import com.infiniteskills.data.entities.Credential;
import com.infiniteskills.data.entities.Currency;
import com.infiniteskills.data.entities.Investment;
import com.infiniteskills.data.entities.Market;
import com.infiniteskills.data.entities.Portfolio;
import com.infiniteskills.data.entities.Stock;
import com.infiniteskills.data.entities.TimeTest;
import com.infiniteskills.data.entities.User;
import com.infiniteskills.data.entities.ids.CurrencyId;
import com.infiniteskills.data.entities.Transaction;

public class Application {
	
	public static void main(String[] args) {
		
//		Session session = HibernateUtil.getSessionFactory().openSession();
		/*
		session.beginTransaction();
		session.close();*/
		
		/*session.getTransaction().begin();
		
		User user = new User();
		user.setBirthDate(new Date());
		user.setCreatedDate(new Date());
		user.setCreatedBy("me");
		user.setEmailAddress("i@g.com");
		user.setFirstName("Roman");
		user.setLastName("Orel");
		user.setLastUpdatedDate(new Date());
		user.setLastUpdatedBy("roman");
		
		session.save(user);
		
		session.getTransaction().commit();// Commit
		session.close();*/
		
		/*try {
			session.getTransaction().begin();

			TimeTest test = new TimeTest(new Date());
			session.save(test);
			session.getTransaction().commit();
			
			session.refresh(test);
			
			System.out.println(test.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}*/
		
		/*try {
			Transaction transaction = session.beginTransaction();
			
			User user = new User();
			Address address = new Address();
			user.setAge(22);
			user.setBirthDate(new Date());
			user.setCreatedBy("Kevin");
			user.setCreatedDate(new Date());
			user.setEmailAddress("kmb3");
			user.setFirstName("kevin");
			user.setLastName("bowersox");
			user.setLastUpdatedBy("kmb");
			user.setLastUpdatedDate(new Date());
			
			address.setAddressLine1("line 1");
			address.setAddressLine2("line2");
			address.setCity("Philadelphia");
			address.setState("PA");
			address.setZipCode("12345");
			 
			user.setAddress(address);
			session.save(user);
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}*/
		
		/*try {
			Transaction transaction = session.beginTransaction();
			
			Bank bank = new Bank();
			bank.setName("Federal Trust");
			bank.setAddressLine1("33 Wall Street");
			bank.setAddressLine2("Suite 233");
			bank.setCity("New York");
			bank.setState("NY");
			bank.setZipCode("12345");
			bank.setInternational(false);
			bank.setCreatedBy("Kevin");
			bank.setCreatedDate(new Date());
			bank.setLastUpdatedBy("Kevin");
			bank.setLastUpdatedDate(new Date());
			//bank.getContacts().add("Joe");
			//bank.getContacts().add("Mary");
			bank.getContacts().put("MANAGER","Joe");
			bank.getContacts().put("TELLER","Mary");
			session.save(bank);
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}*/
		
		/*try {
			Transaction transaction = session.beginTransaction();
			
			User user = new User();
		
			Address address = new Address();
			Address address2 = new Address();
			setAddressFields(address);
			setAddressFields2(address2);
			user.getAddress().add(address);
			user.getAddress().add(address2);
			setUserFields(user);

			session.save(user);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}*/
		
		/*try {
			Transaction transaction = session.beginTransaction();
			
			User user = new User();
			user.setFirstName("Kevin");
			user.setLastName("Bowersox");
			user.setAge(20);
			user.setBirthDate(new Date());
			user.setCreatedBy("Kevin Bowersox");
			user.setCreatedDate(new Date());
			user.setEmailAddress("kevin.bowersox@navy.mil");
			user.setLastUpdatedDate(new Date());
			user.setLastUpdatedBy("Kevin Bowersox");

			Credential credential = new Credential();
			credential.setPassword("kevinspassword");
			credential.setUsername("kmb385");
			credential.setUser(user);
			
			session.save(credential);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}*/
		
		
		/*Account account = createNewAccount();
		Transaction trans1 = createNewBeltPurchase(account);
		Transaction trans2 = createShoePurchase(account);
		account.getTransactions().add(trans1);
		account.getTransactions().add(trans2);
		// если создать объект хибернейт, выполнить с ним 1 транзакцию, затем его изменить и выполнить вторую, то мы сделаем АПДЕЙТ первой записи, т.к. объект один и тот же
		
		System.out.println(session.contains(account));
		System.out.println(session.contains(trans1));
		System.out.println(session.contains(trans1));
		
		try {
			org.hibernate.Transaction transaction = session.beginTransaction();
			session.save(account);

			System.out.println(session.contains(account));
			System.out.println(session.contains(trans1));
			System.out.println(session.contains(trans1));

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}*/
		
		/*try {
			org.hibernate.Transaction transaction = session.beginTransaction();
			
			// make update
			Bank bank = (Bank) session.get(Bank.class, 1L);// get a row, 1 - id of row
			
			bank.setName("New Hope Bank");
			bank.setLastUpdatedBy("Roman");
			bank.setLastUpdatedDate(new Date());
			
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
		*/
		
		/*try {
			org.hibernate.Transaction transaction = session.beginTransaction();
			//get row with id 1
			Bank bank = (Bank) session.get(Bank.class, 1L);
			
			System.out.println(session.contains(bank));
			session.delete(bank);//delete
			System.out.println("Method Invoked");
			System.out.println(session.contains(bank));
			
			transaction.commit();//confirm
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
		*/
		
		/*try {
			// reattaching detached entity
			// можно получить переменную, закрыть сессию, сделать манипуляции и обновить в другой сессии
			org.hibernate.Transaction transaction = session.beginTransaction();			
			Bank bank = (Bank) session.get(Bank.class, 1L);// get
			transaction.commit();
			session.close();// close
			
			Session session2 = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction transaction2 = session2.beginTransaction();
			
			System.out.println(session2.contains(bank));// false, т.к. другая сессия
			session2.update(bank);
			bank.setName("Test Bank");// change
			System.out.println("Method Invoked");
			System.out.println(session2.contains(bank));
			
			transaction2.commit();// update
			session2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.getSessionFactory().close();
		}*/
		
		/*try {
			org.hibernate.Transaction transaction = session.beginTransaction();			
			Bank detachedBank = (Bank) session.get(Bank.class, 1L);
			transaction.commit();
			session.close();
			
			Bank transientBank = createBank();
			
			Session session2 = HibernateUtil.getSessionFactory().openSession();
			org.hibernate.Transaction transaction2 = session2.beginTransaction();
						
			session2.saveOrUpdate(transientBank);// save OR update
			session2.saveOrUpdate(detachedBank);
			detachedBank.setName("Test Bank 2");
			transaction2.commit();
			session2.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			HibernateUtil.getSessionFactory().close();
		}*/
		
		/*org.hibernate.Transaction transaction = session.beginTransaction();
		try {
			Bank bank = (Bank) session.get(Bank.class, 1L);
			bank.setName("Something Different");
			System.out.println("Calling Flush");
			session.flush(); // flush!!!
			
			bank.setAddressLine1("Another Address Line");
			System.out.println("Calling commit");
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();// откатить commit
			e.printStackTrace();
		}finally{
			session.close();
			HibernateUtil.getSessionFactory().close();
		}
		*/
		
		
		// JPA.
		/*
		//Before it - create META_INF/persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("infinite-finances");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx =  em.getTransaction();

		tx.begin();
		
		Bank bank = createBank();
		
		em.persist(bank);
		
		tx.commit();
		
		em.close();
		emf.close();
		*/
		
		/*
		EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try{
			
			factory = Persistence.createEntityManagerFactory("infinite-finances");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			//Bank bank = createBank();
			//em.persist(bank);// записать в бд
			
			
			Bank bank = em.find(Bank.class, 1L);// ищем в БД
			System.out.println(em.contains(bank));
			System.out.println(bank.getName());

			Bank bank2 = em.getReference(Bank.class, 12L);// ищем в БД. НО выбросит Exception, если не найдет
			System.out.println(em.contains(bank2));
			System.out.println(bank2.getName());
			
			bank.setName("Demo");// изменяем
			
			// em.remove(bank);// удалить запись из БД
			
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
			factory.close();
		}*/
	
		/*EntityManagerFactory factory = null;
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try{
			
			factory = Persistence.createEntityManagerFactory("infinite-finances");
			em = factory.createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Bank bank = em.find(Bank.class, 1L);
			//em.clear();// очищаем все, что есть
			em.detach(bank);// очищаем поштучно
			System.out.println(em.contains(bank));
			
			bank.setName("New name");// если не найдет(а мы очистили detach - сделает новую запись
			Bank bank2 = em.merge(bank);// пишем изменения в БД. Возвращает то, что записали - bank2
			
			bank.setName("New name 2");// здесь мы уже работаем с вернувшимся значением(bank2)
			// т.к. мы его не записываем в БД, а изменяем тут - второго апдейта не будет
			
			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
			factory.close();
		}*/
		
		/*
		SessionFactory sessionFactory = null;
		Session session = null;
		Session session2 = null;
		org.hibernate.Transaction tx = null;
		org.hibernate.Transaction tx2 = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Currency currency = new Currency();
			currency.setCountryName("United States");
			currency.setName("Dollar");
			currency.setSymbol("$");

			session.persist(currency);
			tx.commit();

			session2 = sessionFactory.openSession();
			tx2 = session2.beginTransaction();

			Currency dbCurrency = (Currency) session2.get(Currency.class,
					new CurrencyId("Dollar", "United States"));
			System.out.println(dbCurrency.getName());
			
			tx2.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			if (tx2 != null) {
				tx2.rollback();
			}
		} finally {
			session.close();
			sessionFactory.close();
		}*/
		
		/*SessionFactory sessionFactory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Currency currency = new Currency();
			currency.setCountryName("United Kingdom");
			currency.setName("Pound");
			currency.setSymbol("Pound Sign");

			Market market = new Market();
			market.setMarketName("London Stock Exchange");
			market.setCurrency(currency);
			
			session.persist(market);// persist
			tx.commit();
			
			Market dbMarket = (Market) session.get(Market.class, market.getMarketId());
			System.out.println(dbMarket.getCurrency().getName());
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
		*/
		
		// работа с Enum. Сохраняется в varchar
		/*SessionFactory sessionFactory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Account account = createNewAccount();
			account.setAccountType(AccountType.SAVINGS);
			
			session.save(account);
			tx.commit();
			
			Account dbAccount = (Account) session.get(Account.class, account.getAccountId());
			System.out.println(dbAccount.getName());
			System.out.println(dbAccount.getAccountType());
			
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}*/
		
		//
		/*SessionFactory sessionFactory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
		
			Stock stock = createStock();
			session.save(stock);
		
			Bond bond = createBond();
			session.save(bond);
			
			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
		*/
		
		SessionFactory sessionFactory = null;
		Session session = null;
		org.hibernate.Transaction tx = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
		
			Portfolio portfolio= new Portfolio();
			portfolio.setName("First Investments");
			
		    Stock stock = createStock();		
		    stock.setPortfolio(portfolio);
		    
		    Bond bond = createBond();
		    bond.setPortfolio(portfolio);
		
			portfolio.getInvestements().add(stock);
			portfolio.getInvestements().add(bond);
			
			// т.к. они оба связаны с Portfolio(их родитель содержит Portfolio), эта таблица заполнится сама(частный пример)
			// т.к. Portfolio сам заполнится в этом случае, у нас будет UNION - "дорогая операция"
			session.save(stock);
			session.save(bond);

			tx.commit();
			
			Portfolio dbPortfolio = (Portfolio) session.get(Portfolio.class, portfolio.getPortfolioId());
			session.refresh(dbPortfolio);
			
			for(Investment i:dbPortfolio.getInvestements()){
				System.out.println(i.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	private static Bond createBond() {
		Bond bond = new Bond();
		bond.setInterestRate(new BigDecimal("123.22"));
		bond.setIssuer("JP Morgan Chase");
		bond.setMaturityDate(new Date());
		bond.setPurchaseDate(new Date());
		bond.setName("Long Term Bond Purchases");
		bond.setValue(new BigDecimal("10.22"));
		return bond;
	}

	private static Stock createStock(){
		Stock stock = new Stock();
		stock.setIssuer("Allen Edmonds");
		stock.setName("Private American Stock Purchases");
		stock.setPurchaseDate(new Date());
		stock.setQuantity(new BigDecimal("1922"));
		stock.setSharePrice(new BigDecimal("100.00"));
		return stock;
	}
	
	private static Bank createBank() {
		Bank bank = new Bank();
		bank.setName("First United Federal");
		bank.setAddressLine1("103 Washington Plaza");
		bank.setAddressLine2("Suite 332");
		bank.setAddressType("PRIMARY");
		bank.setCity("New York");
		bank.setCreatedBy("Kevin Bowersox");
		bank.setCreatedDate(new Date());
		bank.setInternational(false);
		bank.setLastUpdatedBy("Kevin Bowersox");
		bank.setLastUpdatedDate(new Date());
		bank.setState("NY");
		bank.setZipCode("10000");
		return bank;
	}

	private static User createUser() {
		User user = new User();
		Address address = createAddress();
		user.setAddress(Arrays.asList(new Address[]{createAddress()}));
		user.setBirthDate(new Date());
		user.setCreatedBy("Kevin Bowersox");
		user.setCreatedDate(new Date());
		user.setCredential(createCredential(user));
		user.setEmailAddress("test@test.com");
		user.setFirstName("John");
		user.setLastName("Doe");
		user.setLastUpdatedBy("system");
		user.setLastUpdatedDate(new Date());
		return user;
	}

	private static Credential createCredential(User user) {
		Credential credential = new Credential();
		credential.setUser(user);
		credential.setUsername("test_username");
		credential.setPassword("test_password");
		return credential;
	}

	private static Address createAddress() {
		Address address = new Address();
		address.setAddressLine1("101 Address Line");
		address.setAddressLine2("102 Address Line");
		address.setCity("New York");
		address.setState("PA");
		address.setZipCode("10000");
		address.setAddressType("PRIMARY");
		return address;
	}

	private static Transaction createNewBeltPurchase(Account account) {
		Transaction beltPurchase = new Transaction();
		beltPurchase.setAccount(account);
		beltPurchase.setTitle("Dress Belt");
		beltPurchase.setAmount(new BigDecimal("50.00"));
		beltPurchase.setClosingBalance(new BigDecimal("0.00"));
		beltPurchase.setCreatedBy("Kevin Bowersox");
		beltPurchase.setCreatedDate(new Date());
		beltPurchase.setInitialBalance(new BigDecimal("0.00"));
		beltPurchase.setLastUpdatedBy("Kevin Bowersox");
		beltPurchase.setLastUpdatedDate(new Date());
		beltPurchase.setNotes("New Dress Belt");
		beltPurchase.setTransactionType("Debit");
		return beltPurchase;
	}

	private static Transaction createShoePurchase(Account account) {
		Transaction shoePurchase = new Transaction();
		shoePurchase.setAccount(account);
		shoePurchase.setTitle("Work Shoes");
		shoePurchase.setAmount(new BigDecimal("100.00"));
		shoePurchase.setClosingBalance(new BigDecimal("0.00"));
		shoePurchase.setCreatedBy("Kevin Bowersox");
		shoePurchase.setCreatedDate(new Date());
		shoePurchase.setInitialBalance(new BigDecimal("0.00"));
		shoePurchase.setLastUpdatedBy("Kevin Bowersox");
		shoePurchase.setLastUpdatedDate(new Date());
		shoePurchase.setNotes("Nice Pair of Shoes");
		shoePurchase.setTransactionType("Debit");
		return shoePurchase;
	}

	private static Account createNewAccount() {
		Account account = new Account();
		account.setCloseDate(new Date());
		account.setOpenDate(new Date());
		account.setCreatedBy("Kevin Bowersox");
		account.setInitialBalance(new BigDecimal("50.00"));
		account.setName("Savings Account");
		account.setCurrentBalance(new BigDecimal("100.00"));
		account.setLastUpdatedBy("Kevin Bowersox");
		account.setLastUpdatedDate(new Date());
		account.setCreatedDate(new Date());
		return account;
	}
	
	private static void setUserFields(User user) {
		user.setAge(22);
		user.setBirthDate(new Date());
		user.setCreatedBy("kmb");
		user.setCreatedDate(new Date());
		user.setEmailAddress("kmb385");
		user.setFirstName("Kevin");
		user.setLastName("bowersox");
		user.setLastUpdatedBy("kevin");
		user.setLastUpdatedDate(new Date());
	}

	private static void setAddressFields(Address address) {
		address.setAddressLine1("Line 1");
		address.setAddressLine2("Line 2");
		address.setCity("New York");
		address.setState("NY");
		address.setZipCode("12345");
	}

	private static void setAddressFields2(Address address) {
		address.setAddressLine1("Line 3");
		address.setAddressLine2("Line 4");
		address.setCity("Corning");
		address.setState("NY");
		address.setZipCode("12345");
	}

}
