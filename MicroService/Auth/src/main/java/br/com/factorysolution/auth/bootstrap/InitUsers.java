package br.com.factorysolution.auth.bootstrap;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import br.com.factorysolution.auth.entity.Permission;
import br.com.factorysolution.auth.entity.User;
import br.com.factorysolution.auth.repository.PermissionRepository;
import br.com.factorysolution.auth.repository.UserRepository;

@Component
public class InitUsers implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		initUsers();		
	}

	private void initUsers() {
		Permission permission = null;
		Permission findPermission = permissionRepository.findByDescription("Admin");
		if (findPermission == null) {
			permission = new Permission();
			permission.setDescription("Admin");
			permission = permissionRepository.save(permission);
		} else {
			permission = findPermission;
		}
		
		User admin = new User();
		admin.setUserName("Andre");
		admin.setAccountNonExpired(true);
		admin.setAccountNonLocked(true);
		admin.setCredentialsNonExpired(true);
		admin.setEnabled(true);
		admin.setPassword(passwordEncoder.encode("123456"));
		admin.setPermissions(Arrays.asList(permission));

		Optional<User> find = userRepository.findByUserName("Andre");
		if (!find.isPresent()) {
			userRepository.save(admin);
		}
		
	}

}
