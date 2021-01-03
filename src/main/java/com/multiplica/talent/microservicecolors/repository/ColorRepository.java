package com.multiplica.talent.microservicecolors.repository;

import com.multiplica.talent.microservicecolors.repository.model.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
 import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ColorRepository  extends PagingAndSortingRepository<Color,Integer> {

    @Query(value="select id,name,color from Color")
    Page<Color> getAllColor(Pageable pageable);

}
