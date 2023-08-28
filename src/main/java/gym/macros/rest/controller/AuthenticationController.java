package gym.macros.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gym.macros.entity.user.AuthenticationDTO;
import gym.macros.entity.user.LoginResponseDTO;
import gym.macros.entity.user.RegisterDTO;
import gym.macros.entity.user.User;
import gym.macros.rest.repository.UserRepository;
import gym.macros.security.TokenService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepo;	
	
	@Autowired 
	private TokenService tokenService;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
		
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = authenticationManager.authenticate(usernamePassword);
		
		var token = tokenService.generateToken((User) auth.getPrincipal());
		
		String tokenWithBearer = "Bearer " + token;
		
		return ResponseEntity.ok(new LoginResponseDTO(tokenWithBearer));
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
		
		if (userRepo.findByLogin(data.login()) != null) {
			return ResponseEntity.badRequest().build();
		}
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User newUser = new User(data.login(), encryptedPassword, data.role());
		
		userRepo.save(newUser);
		return ResponseEntity.ok().build();
	}
}
