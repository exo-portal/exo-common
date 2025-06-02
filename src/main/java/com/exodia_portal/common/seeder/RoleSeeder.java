package com.exodia_portal.common.seeder;

import com.exodia_portal.common.enums.AccessLevelTypeEnum;
import com.exodia_portal.common.model.Role;
import com.exodia_portal.common.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleSeeder implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        seedRoles();
    }

    /**
     * Seeds the database with predefined roles if they do not already exist.
     * This method is called during application startup to ensure that essential roles are available.
     */
    private void seedRoles() {
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_SUPER_ADMIN.getDisplayName(), AccessLevelTypeEnum.ROLE_SUPER_ADMIN);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_ADMIN.getDisplayName(), AccessLevelTypeEnum.ROLE_ADMIN);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_FINANCE.getDisplayName(), AccessLevelTypeEnum.ROLE_FINANCE);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_HR.getDisplayName(), AccessLevelTypeEnum.ROLE_HR);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_CLIENT.getDisplayName(), AccessLevelTypeEnum.ROLE_CLIENT);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_MANAGER.getDisplayName(), AccessLevelTypeEnum.ROLE_MANAGER);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_TEAM_LEAD.getDisplayName(), AccessLevelTypeEnum.ROLE_TEAM_LEAD);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_TEAM_LEAD.getDisplayName(), AccessLevelTypeEnum.ROLE_TEAM_LEAD);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_PROJECT_LEAD.getDisplayName(), AccessLevelTypeEnum.ROLE_PROJECT_LEAD);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_SENIOR_EMPLOYEE.getDisplayName(), AccessLevelTypeEnum.ROLE_SENIOR_EMPLOYEE);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_MID_LEVEL_EMPLOYEE.getDisplayName(), AccessLevelTypeEnum.ROLE_MID_LEVEL_EMPLOYEE);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_JUNIOR_EMPLOYEE.getDisplayName(), AccessLevelTypeEnum.ROLE_JUNIOR_EMPLOYEE);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_ENTRY_LEVEL_EMPLOYEE.getDisplayName(), AccessLevelTypeEnum.ROLE_ENTRY_LEVEL_EMPLOYEE);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_INTERN.getDisplayName(), AccessLevelTypeEnum.ROLE_INTERN);
        createRoleIfNotExists(AccessLevelTypeEnum.ROLE_APPLICANT.getDisplayName(), AccessLevelTypeEnum.ROLE_APPLICANT);
    }

    /**
     * Creates a role if it does not already exist in the database.
     *
     * @param roleName    The name of the role to create.
     * @param accessLevel The access level associated with the role.
     */
    private void createRoleIfNotExists(String roleName, AccessLevelTypeEnum accessLevel) {
        Optional<Role> existingRole = roleRepository.findByRoleName(roleName);
        if (existingRole.isEmpty()) {
            Role role = Role.builder()
                    .roleName(roleName)
                    .accessLevelRole(accessLevel)
                    .build();
            roleRepository.save(role);
        }
    }

}
