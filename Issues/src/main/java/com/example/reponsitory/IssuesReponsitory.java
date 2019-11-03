package com.example.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Issues;
@Repository
public interface IssuesReponsitory extends JpaRepository<Issues, Long> {

}
