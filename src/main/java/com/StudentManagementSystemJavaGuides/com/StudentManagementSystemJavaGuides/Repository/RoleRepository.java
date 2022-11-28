package com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Repository;

import com.StudentManagementSystemJavaGuides.com.StudentManagementSystemJavaGuides.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query("select r from Role r where r.name=?1")
    public Role findByName(String name);
}
