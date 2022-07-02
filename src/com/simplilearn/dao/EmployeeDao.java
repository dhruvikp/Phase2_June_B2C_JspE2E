package com.simplilearn.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Employee;
import com.simplilearn.util.HibernateUtil;

// Spring Data JPA HQL with one JOIN query
public class EmployeeDao {

	public static void addEmployee(Employee e) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		session.close();
	}

	public static List<Employee> listEmployees() {
		List<Employee> employees = null;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		employees = session.createQuery("from Employee").list();

		session.close();
		return employees;
	}

	public static List<Employee> listEmployeesUsingCriteria() {
		List<Employee> employees = null;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		// 1. CriteriaBuilder
		CriteriaBuilder cb = session.getCriteriaBuilder();

		// 2. build criteriaQuery using criteriaBuilder
		CriteriaQuery<Employee> cr = cb.createQuery(Employee.class);
		Root<Employee> root =cr.from(Employee.class);
		cr.select(root).where(cb.gt(root.get("salary"), 10));
		
		// 3. session to create query
		employees = session.createQuery(cr).list();

		session.close();
		return employees;
	}
}
