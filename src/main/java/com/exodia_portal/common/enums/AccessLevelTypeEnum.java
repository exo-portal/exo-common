package com.exodia_portal.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccessLevelTypeEnum {
    // Admin Roles
    ROLE_SUPER_ADMIN("Super Admin"),
    ROLE_ADMIN("Admin"),
    //    HR Roles
    ROLE_FINANCE("Finance"),
    ROLE_HR("HR"),
    // Client Roles
    ROLE_CLIENT("Client"),
    //    Employee Roles
    ROLE_MANAGER("Manager"),
    ROLE_PROJECT_LEAD("Project Lead"),
    ROLE_TEAM_LEAD("Team Lead"),
    ROLE_TECH_LEAD("Tech Lead"),
    ROLE_SENIOR_EMPLOYEE("Senior Employee"),
    ROLE_MID_LEVEL_EMPLOYEE("Mid Level Employee"),
    ROLE_JUNIOR_EMPLOYEE("Junior Employee"),
    ROLE_ENTRY_LEVEL_EMPLOYEE("Entry Level Employee"),
    ROLE_INTERN("Intern"),
    //    external roles
    ROLE_APPLICANT("Applicant");

    private final String displayName;
}
