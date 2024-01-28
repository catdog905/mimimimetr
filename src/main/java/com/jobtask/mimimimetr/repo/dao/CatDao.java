package com.jobtask.mimimimetr.repo.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.service.annotation.GetExchange;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cat", schema = "mimimimetr")
public class CatDao {
    @Id
    @SequenceGenerator(name="mimimimetr.cat_id_seq",
            sequenceName="mimimimetr.cat_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="mimimimetr.cat_id_seq")
    private Long id;
    private String name;
    private byte[] image;

    @Column(name="grade", insertable = false)
    private Double grade;
}
