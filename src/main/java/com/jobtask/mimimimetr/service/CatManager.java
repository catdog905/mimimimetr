package com.jobtask.mimimimetr.service;

import com.jobtask.mimimimetr.domain.Cat;
import com.jobtask.mimimimetr.repo.CatRepository;
import com.jobtask.mimimimetr.repo.dao.CatDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
@AllArgsConstructor
public class CatManager {

    private final CatRepository catRepository;

    public Cat.CatId createNewCat(String name, byte[] image) {
        CatDao savedCat = catRepository.save(
                CatDao.builder()
                        .name(name)
                        .image(image)
                        .build()
        );
        return new Cat.CatId(savedCat.getId());
    }
}
