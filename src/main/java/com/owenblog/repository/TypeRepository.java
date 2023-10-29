package com.owenblog.repository;

import com.owenblog.entity.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by owen on 2017/10/16.
 */
@Repository
public interface TypeRepository extends JpaRepository<Type,Long> , JpaSpecificationExecutor<Type> {

    Type findByName(String name);


    @Query("select t from Type t")
    List<Type> findTop(Pageable pageable);
}
