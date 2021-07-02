package com.korea.dbapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Data를 가져와서 자바 오브젝트로 만드는 것!!
// JpaRepository 공통적인걸 다 준다 즉 DAO가 만들어져 있다
// JpaRepository 는 어노테이션이 없어도 뜬다 (얘만 해상함)

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "SELECT * FROM user WHERE username = :username", nativeQuery = true)
	User mFindByUsername(String username);
	
	@Query(value = "SELECT * FROM user WHERE username = :username AND password = :password", nativeQuery = true)
	User mLogin(String username, String password);
}
