package com.exodia_portal.common.repository;

import com.exodia_portal.common.enums.AccessLevelTypeEnum;
import com.exodia_portal.common.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByAccessLevelRole(AccessLevelTypeEnum roleName);
}
