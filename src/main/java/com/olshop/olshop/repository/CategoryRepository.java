package com.olshop.olshop.repository;

import com.olshop.olshop.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

    Optional<CategoryEntity> findByNameContaining(String name);
    Optional<CategoryEntity> findByName(String name);

    @Query(value = "SELECT c FROM CategoryEntity c WHERE LOWER(c.name) = LOWER(:name) ")
    CategoryEntity findByNameIgnoreCase(String name);
    @Query(value = "SELECT c FROM CategoryEntity c WHERE c.id = :id ")
    CategoryEntity findById(@Param("id") int id);
    @Query(value = "SELECT c FROM CategoryEntity c")
    List<CategoryEntity> getAllCategory();

    @Query(value = "SELECT c FROM CategoryEntity c WHERE c.name = :name")
    Object getCategoryByName(@Param("name") String name);

    @Query(value = "SELECT c FROM CategoryEntity c WHERE c.id = :id")
    Object getCategoryById(@Param("id") int id);

    @Query(value = "SELECT c FROM CategoryEntity c JOIN ProductEntity p ON p.category.id = c.id WHERE LOWER(c.name) = LOWER(:name) ")
    CategoryEntity findByNameWithProduct(@Param("name") String name);

    @Query(value = "SELECT c FROM CategoryEntity c INNER JOIN ProductEntity p ON p.category.id = c.id WHERE c.id = :id")
    CategoryEntity findByIdWithProduct(@Param("id") int id);

    @Query(value = "SELECT c FROM CategoryEntity c INNER JOIN ProductEntity p ON p.category.id = c.id")
    List<CategoryEntity> getAllCategoryWithProduk();
//

}
