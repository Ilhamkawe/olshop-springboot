package com.olshop.olshop.repository;

import com.olshop.olshop.entity.CategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository {

    @Query(value = "SELECT c FROM CategoryEntity c")
    List<CategoryEntity> getAllCategory();

    @Query(value = "SELECT c FROM CategoryEntity c WHERE c.name = :name")
    Object getCategoryByName(@Param("name") String name);

    @Query(value = "SELECT c FROM CategoryEntity c INNER JOIN ProductEntity p ON p.categoryId = c.id WHERE c.name = :name")
    Object getCategoryByNameWithProduk(@Param("name") String name);

    @Query(value = "SELECT c FROM CategoryEntity c INNER JOIN ProductEntity p ON p.categoryId = c.id")
    List<CategoryEntity> getAllCategoryWithProduk();


}
