package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.sound.midi.Soundbank;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.models.User;


@Repository
public class userDao {
	@Autowired
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
   @Transactional
    public List<User> getAllUser() {
        Session session = this.sessionFactory.getCurrentSession();
		List<User>  userList = session.createQuery("from USER").list();
        return userList;
    }
    
    @Transactional
	public User saveUser(User user) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);

        return user;
	}


	@Transactional
	public String Validate(String userName){
	 String password=(String) sessionFactory.getCurrentSession().createQuery("SELECT password FROM USER WHERE username = :username")
				.setParameter("username", userName)
				.uniqueResult();
		if (password == null) {
			return "WrongPass";
		}

		return password;
	}
    

    @Transactional
    public User getUser(String username,String password) {
    	Query query = sessionFactory.getCurrentSession().createQuery("from USER where username = :username");


    	query.setParameter("username",username);

    	
    	try {
			User user = (User) query.getSingleResult();

			if(password.equals(user.getPassword())) {

				return user;
			}
			else {
				return new User();
			}
		}catch(Exception e){
			System.out.println("Inside Exception"+e.getMessage());
			User user = new User();
			return user;
		}
    	
    }


	}

