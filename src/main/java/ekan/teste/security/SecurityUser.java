package ekan.teste.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.stream.Collectors;

public class SecurityUser extends User {

	
	public SecurityUser(ekan.teste.entity.User u) {
        super(u.getUsername(),
              u.getPassword(),
              u.getRoles().stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList()));
    }

}
