package com.one.Shout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.Shout.domain.Users;

@Repository
public interface Userrepo extends JpaRepository<Users, Long> {
//	Users  findByEmailAndPassword(String email,String password);
//	boolean existByEmail(String email);
}
