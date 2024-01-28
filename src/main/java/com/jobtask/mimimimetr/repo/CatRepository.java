package com.jobtask.mimimimetr.repo;

import com.jobtask.mimimimetr.repo.dao.CatDao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends CrudRepository<CatDao, Long> {

    @Query("SELECT COALESCE(avg(c.grade), 0) FROM CatDao c")
    Double averageGrade();
}

