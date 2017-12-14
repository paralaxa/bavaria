package sk.bavaria.bavaria.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by martin.cuchran on 12/14/2017.
 */
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;
    private String authority;

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Long getId() {
        return id;
    }
}
