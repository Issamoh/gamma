package com.issambenmessaoud.gamma.resources;

import com.issambenmessaoud.gamma.models.*;
import com.issambenmessaoud.gamma.models.payloads.*;
import com.issambenmessaoud.gamma.repositories.RoleRepository;
import com.issambenmessaoud.gamma.repositories.TacheRepository;
import com.issambenmessaoud.gamma.repositories.UserRepository;
import com.issambenmessaoud.gamma.services.MyUserDetails;
import com.issambenmessaoud.gamma.services.MyUserDetailsService;
import com.issambenmessaoud.gamma.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin
public class HomeResource {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    TacheRepository TacheRepository;

    @GetMapping({"/home"})
    public String home() {
        return "Page d'accueil";
    }

    @GetMapping({"/about"})
    public String help() {
        return "About us";
    }

    @GetMapping({"/admin"})
    public String admin() {
        return "Admin dashboard";
    }

    @GetMapping({"/user"})
    public String user() {
        return "welcome user";
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> creatAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.badRequest().body(new MessageResponse("Mot de passe ou nom d'utilisateur incorrectes"));
            // throw new Exception("Mot de passe ou nom d'utilisateur incorrectes", e);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        // return ResponseEntity.ok(new LoginResponse(jwt,userDetails.getAuthorities()));
        return ResponseEntity.ok(new LoginResponse(jwt, ((MyUserDetails) userDetails).getId(), userDetails.getUsername(), ((MyUserDetails) userDetails).getEmail(), ((MyUserDetails) userDetails).getNom(), userDetails.getAuthorities(), ((MyUserDetails) userDetails).getEtat()));
    }

    @PostMapping(value = "/admin/adduser")
    public ResponseEntity<?> addUser(@RequestBody SignupRequest signupRequest) {
        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Nom d'utilisateur " + signupRequest.getUsername() + " existe déja"));
        }
        User user = new User(signupRequest.getUsername(), signupRequest.getPassword(), signupRequest.getEmail(), signupRequest.getNom(), signupRequest.getPoste(), signupRequest.getTel());
        String strRole = signupRequest.getRole();
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow();
        Role AdminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow();
        if (strRole != null) {
            switch (strRole) {
                case "admin":
                    roles.add(userRole);
                    roles.add(AdminRole);
                    break;
                default:
                    roles.add(userRole);
                    break;

            }
        } else {
            roles.add(userRole);
        }
        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("Utilisateur ajouté avec succes"));

    }

    @PostMapping(value = "/addtache")
    public ResponseEntity<?> addTache(@RequestBody TacheAdd tacheAdd) {
      //  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY HH:mm:ss");
        LocalDateTime dateCreation = LocalDateTime.now();
        Tache tache = new Tache(tacheAdd.getTitle(), tacheAdd.getDescription(), tacheAdd.getDureeSuffisante(), dateCreation, ETacheEtat.NEW);
        TacheRepository.save(tache);
        return ResponseEntity.ok(new MessageResponse("Tache ajoutée avec succés"));
    }





}
