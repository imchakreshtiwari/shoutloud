package com.one.Shout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.one.Shout.domain.Usercontact;

@Repository
public interface Usercontactrepo extends JpaRepository<Usercontact, Long>{

}
