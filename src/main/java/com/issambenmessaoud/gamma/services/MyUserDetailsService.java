package com.issambenmessaoud.gamma.services;

import com.issambenmessaoud.gamma.models.ERole;
import com.issambenmessaoud.gamma.models.Role;
import com.issambenmessaoud.gamma.models.User;
import com.issambenmessaoud.gamma.repositories.RoleRepository;
import com.issambenmessaoud.gamma.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;


    @Override
    public MyUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));
      /*      //TODO delete this hardcoded roles while adding signup feature
        HashSet<Role> roles = new HashSet<>();
        Role role = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() ->new UsernameNotFoundException("role not found"));
        roles.add(role);
        user.setRoles(roles);*/
            return  MyUserDetails.build(user);
        }

}

