package com.exodia_portal.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccessLevelTypeEnum {
    // Admin Roles
    ROLE_SUPER_ADMIN("Super Admin", "ROLE_SUPER_ADMIN"),
    ROLE_ADMIN("Admin", "ROLE_ADMIN"),
    //    HR Roles
    ROLE_FINANCE("Finance", "ROLE_FINANCE"),
    ROLE_HR("HR", "ROLE_HR"),
    // Client Roles
    ROLE_CLIENT("Client", "ROLE_CLIENT"),
    //    Employee Roles
    ROLE_MANAGER("Manager", "ROLE_MANAGER"),
    ROLE_PROJECT_LEAD("Project Lead", "ROLE_PROJECT_LEAD"),
    ROLE_TEAM_LEAD("Team Lead", "ROLE_TEAM_LEAD"),
    ROLE_TECH_LEAD("Tech Lead", "ROLE_TECH_LEAD"),
    ROLE_SENIOR_EMPLOYEE("Senior Employee", "ROLE_SENIOR_EMPLOYEE"),
    ROLE_MID_LEVEL_EMPLOYEE("Mid Level Employee", "ROLE_MID_LEVEL_EMPLOYEE"),
    ROLE_JUNIOR_EMPLOYEE("Junior Employee", "ROLE_JUNIOR_EMPLOYEE"),
    ROLE_ENTRY_LEVEL_EMPLOYEE("Entry Level Employee", "ROLE_ENTRY_LEVEL_EMPLOYEE"),
    ROLE_INTERN("Intern", "ROLE_INTERN"),
    //    external roles
    ROLE_APPLICANT("Applicant", "ROLE_APPLICANT");

    private final String accessLevel;

    private final String displayName;
}
