package com.exodia_portal.common.seeder;

import com.exodia_portal.common.enums.AccessLevelTypeEnum;
import com.exodia_portal.common.model.Role;
import com.exodia_portal.common.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    /**
     * Constructor for RoleSeeder that initializes the role repository.
     *
     * @param roleRepository The repository used to interact with the Role entity in the database.
     */
    public RoleSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedRoles();
    }

    /**
     * Seeds the database with predefined roles if they do not already exist.
     * This method is called during application startup to ensure that essential roles are available.
     */
    private void seedRoles() {
        for (AccessLevelTypeEnum accessLevel : AccessLevelTypeEnum.values()) {
            createRoleIfNotExists(accessLevel.getAccessLevel(), accessLevel);
        }
    }

    /**
     * Creates a role if it does not already exist in the database.
     *
     * @param roleName    The name of the role to create.
     * @param accessLevel The access level associated with the role.
     */
    private void createRoleIfNotExists(String roleName, AccessLevelTypeEnum accessLevel) {
        Optional<Role> existingRole = roleRepository.findByAccessLevelRole(accessLevel);
        if (existingRole.isEmpty()) {
            Role role = Role.builder()
                    .roleName(roleName)
                    .accessLevelRole(accessLevel)
                    .build();
            roleRepository.save(role);
        }
    }

}
