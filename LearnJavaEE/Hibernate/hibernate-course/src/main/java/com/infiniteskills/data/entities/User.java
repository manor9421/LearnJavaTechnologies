package com.infiniteskills.data.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="finances_user")
//@Access(value=AccessType.PROPERTY)
public class User {
	
	@Id//Primary key в таблице!!
	@GeneratedValue(strategy=GenerationType.IDENTITY)// определяем стратегию генерации уникального идентификатора
	//@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_seq")//для ORACLE DB. Генерируем primary key
	//@SequenceGenerator(name="user_seq",sequenceName="USER_ID_SEQ")
	//аннотациями @GeneratedValue и @SequenceGenerator мы определяем стратегию генерации уникального идентификатора, в данном случае мы говорим, что при сохранении информации в базу данных, мы берем число из sequence с названием «user_seq»
	//@GeneratedValue(strategy=GenerationType.TABLE,generator="user_table_generator")
	//@TableGenerator(name="user_table_generator",table="ifinances_keys",
	//	pkColumnName="PK_NAME",valueColumnName="PK_VALUE")
	//GenerationType.TABLE работает в любой бд
	@Column(name="USER_ID")// лучше ставить это на геттеры, чтобы не портить инкапсуляцию
	private Long userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	//@Basic// простейший тип маппинга на колонку
	@Column(name="BIRTH_DATE", nullable=false)// не может быть null. При попытке вставить null вылетит ошибка
	private Date birthDate;

	@Column(name="EMAIL_ADDRESS")
	private String emailAddress;

	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	@Column(name="LAST_UPDATED_BY")
	private String lastUpdatedBy;

	@Column(name="CREATED_DATE", updatable=false)//не будет меняться это поле после создания коммита. Все последующие апдейты этой колонки не произойдут
	private Date createdDate;

	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Transient// обозначить, что это не колонка таблицы. По дефолту именно так ее воспримет Хибернейт
	private boolean valid;
	
	@Formula("lower(datediff(curdate(), birth_date)/365")//при селекте значение этой переменной само посчитается. При том, что такого поля нет в бд
	private int age;

	@OneToOne(mappedBy = "user")
	private Credential credential;
	
	@ElementCollection// #list
	//@Embedded
	@CollectionTable(name="USER_ADDRESS",joinColumns=@JoinColumn(name="USER_ID"))//#list
	@AttributeOverrides({@AttributeOverride(name="addressLine1", column=@Column(name="USER_ADDRESS_LINE_1")),// пишем, что персонально для этой таблицы значения переменной Address будут связаны не с теми полями, что указаны в ее классе, а с указанными здесь(они такие же, просто имеют другие имена)
	@AttributeOverride(name="addressLine2", column=@Column(name="USER_ADDRESS_LINE_2"))})
	//private Address address;
	private List<Address> address = new ArrayList<>();
	
	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
