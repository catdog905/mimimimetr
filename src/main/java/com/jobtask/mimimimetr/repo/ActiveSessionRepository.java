package com.jobtask.mimimimetr.repo;

import com.jobtask.mimimimetr.repo.dao.ActiveSessionDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ActiveSessionRepository extends CrudRepository<ActiveSessionDao, UUID> {

}
