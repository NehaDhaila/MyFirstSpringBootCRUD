package com.neha.MyProject.repository;

import com.neha.MyProject.modal.User;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

