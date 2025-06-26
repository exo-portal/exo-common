package com.exodia_portal.common.model;

import com.exodia_portal.common.enums.AccessLevelTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
@FilterDef(name = "isDeletedFilter", parameters = @ParamDef(name = "isDeleted", type = Boolean.class))
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    private String login;

    @JsonIgnore
    private String password;

    private boolean isAccountLock;

    @JsonIgnore
    private boolean isEmailLoginEnabled;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @Filter(name = "isDeletedFilter", condition = "isDeleted = :isDeleted")
    private List<LoginMethod> loginMethods;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @Filter(name = "isDeletedFilter", condition = "isDeleted = :isDeleted")
    private List<UserRole> userRoles;

    @JsonManagedReference
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private UserInfo userInfo;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PasswordHistory> passwordHistories;

    // Constants for field names
    public static final String USER_EMAIL_FIELD = "email";

    public static final String USER_PASSWORD_FIELD = "password";

    /**
     * Retrieves the access level role of the default `UserRole`.
     *
     * @return the `AccessLevelTypeEnum` of the default role, or null if no default role exists.
     */
    public Optional<AccessLevelTypeEnum> getDefaultAccessLevelRole() {
        return this.getUserRoles().stream()
                .filter(UserRole::isDefaultRole)
                .map(userRole -> userRole.getRole().getAccessLevelRole())
                .findFirst();
    }

    /**
     * Retrieves the feature keys associated with the default `UserRole`.
     *
     * @return a list of feature keys for the default role.
     */
    public List<String> getDefaultRoleFeatureKeys() {
        return this.getUserRoles().stream()
                .filter(UserRole::isDefaultRole)
                .flatMap(userRole -> userRole.getRole().getRoleFeatureAccesses().stream())
                .map(roleFeatureAccess -> roleFeatureAccess.getFeatureAccess().getFeatureKey())
                .toList();
    }

    /**
     * Retrieves the feature keys associated with the specified `UserRole`.
     *
     * @param userRole the `UserRole` for which to retrieve feature keys.
     * @return a list of feature keys for the specified role, or an empty list if the role is null or has no features.
     */
    public List<String> getRoleFeatureKeysByUserRole(UserRole userRole) {
        if (userRole == null || userRole.getRole() == null) {
            return List.of();
        }
        return userRole.getRole().getRoleFeatureAccesses().stream()
                .map(roleFeatureAccess -> roleFeatureAccess.getFeatureAccess().getFeatureKey())
                .toList();
    }

    /**
     * Retrieves the names of all roles assigned to the user.
     *
     * @return a list of role names.
     */
    public List<AccessLevelTypeEnum> getAccessLevelRoles() {
        return this.getUserRoles().stream()
                .sorted(Comparator.comparingLong(ur -> ur.getRole().getId()))
                .map(userRole -> userRole.getRole().getAccessLevelRole())
                .toList();
    }

}
