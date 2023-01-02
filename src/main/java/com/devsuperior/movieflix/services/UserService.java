package com.devsuperior.movieflix.services;

import com.devsuperior.movieflix.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements UserDetailsService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private UserRepository repository;

  @Transactional(readOnly = true)
  public UserDTO getProfile() {

    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    User userLogged = repository.findByEmail(username);

    Optional<User> obj = repository.findById(userLogged.getId());
    User entity = obj.orElseThrow(() -> new ResourceNotFoundException("User not found."));
    return new UserDTO(entity);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = repository.findByEmail(username);

    if (user == null) {
      logger.error("User not found: {}", username);
      throw new UsernameNotFoundException("Email not found.");
    }
    logger.info("User found: {}", username);
    return user;
  }
}
