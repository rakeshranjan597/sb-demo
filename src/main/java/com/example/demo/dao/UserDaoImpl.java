package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDaoImpl implements UserDao {
	
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	
	@Override
	public UserEntity getUser(int uid) {
		String sql = "from UserEntity where uid=:uid";
		EntityManager manager = factory.createEntityManager();
		try {
			TypedQuery<UserEntity> query = manager.createQuery(sql, UserEntity.class);
			query.setParameter("uid", uid);
			List<UserEntity> result = query.getResultList();
			if (!result.isEmpty()) {
				return result.get(0);
			}
		} catch (Exception e) {
			log.error("Error while getting user:{} -- reason {}", uid, e.getMessage());
		}
		return new UserEntity();
	}

	@Override
	public List<UserEntity> getAllUser() {
		String sql = "from UserEntity";
		EntityManager manager = factory.createEntityManager();
		try {
			TypedQuery<UserEntity> query = manager.createQuery(sql, UserEntity.class);
			List<UserEntity> result = query.getResultList();
			return result;
		} catch (Exception e) {
			log.error("Error while getting all user reason {}", e.getMessage());
		}
		return null;
	}

	@Override
	public String setUser() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		try {
			UserEntity entity = new UserEntity();
			entity.setCountry("INDIA");
			entity.setName("ABC");
			manager.persist(entity);
			tran.commit();
			return "new record added";
		} catch (Exception e) {
			tran.rollback();
			log.error("Something wrong: {}", e.getMessage());
			return "Something wrong";
		}
	}

}
