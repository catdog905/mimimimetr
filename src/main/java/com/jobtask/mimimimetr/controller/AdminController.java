package com.jobtask.mimimimetr.controller;

import com.jobtask.mimimimetr.domain.Cat;
import com.jobtask.mimimimetr.repo.CatRepository;
import com.jobtask.mimimimetr.repo.dao.CatDao;
import com.jobtask.mimimimetr.service.CatManager;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private final CatManager catManager;

    @Data
    public static class InsertBody {
        private final String name;
        private final String image;
    }

    @PostMapping("/cat")
    public ResponseEntity<Long> insertNewCat(
            @RequestBody InsertBody body
    ) {
        Cat.CatId catId = catManager.createNewCat(body.name, Base64.getDecoder().decode(body.image));
        return ResponseEntity.ok(catId.value());
    }
}
