package com.greatLearning.studentManagement.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatLearning.studentManagement.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public StudentServiceImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
		this.session = this.sessionFactory.openSession();
	}

	@Transactional
	public List<Student> findAll() {

		Transaction transaction = session.beginTransaction();

		List<Student> Students = session.createQuery("from Student", Student.class).list();

		transaction.commit();

		return Students;
	}
/*	public List<Student> searchBy(String name, String author) {
		// TODO Auto-generated method stub
		Transaction transaction = session.beginTransaction();
		
//		String query;
		
		List<Student> Students=null;
		
		if(name!=null && !name.isEmpty() && author!=null && !author.isEmpty()) {
			Students = session.createQuery("from Student where name like '%"+name+"%' or author like '%"+author+"%'",Student.class).list();
		}
		else if(name!=null && !name.isEmpty()) {
			Students = session.createQuery("from Student where name like '%"+name+"'",Student.class).list();
			
		}
		else if(author!=null &&  !author.isEmpty()) {
			Students = session.createQuery("from Student where author like '%"+author+"'",Student.class).list();
			
		}
		else {
			System.out.println("Invalid search data");
		}
		transaction.commit();
		
		return Students;
	} */
	public Student findById(int id) {
		Transaction transaction = session.beginTransaction();

		Student Student = session.get(Student.class, id);

		transaction.commit();
		return Student;
	}
	public void save(Student Student) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(Student);
		transaction.commit();
	}
	public void deleteById(int id) {
		
		Transaction transaction = session.beginTransaction();
		Student Student = session.get(Student.class, id);
		session.delete(Student);
		transaction.commit();
		// TODO Auto-generated method stub
		
	}

	

	

}