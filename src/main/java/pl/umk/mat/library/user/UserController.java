package pl.umk.mat.library.user;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping()
    public List<User> getUserByName(String email){
        return userRepository.getUsersByEmailLike("%" + email + "%");
    }

    @Transactional
    @PutMapping()
    public User changeUserSettings(Long id, Boolean isAdmin){
       User user  =  userRepository.getUsersById( id);
       user.setAdmin(isAdmin);
       return user;
    }

    @PostMapping("/login")
    public User login(@RequestBody UserLoginRequest userLoginRequest) {
        if (userRepository.existsByEmail(userLoginRequest.getEmail())) {
            return userRepository.findByEmailAndPassword(userLoginRequest.getEmail(),userLoginRequest.getPassword());
        } else {
            throw new RuntimeException("cos sie olabejz");
        }
    }

    @PostMapping("/register")
    public User register(@RequestBody UserRegisterRequest userRegisterRequest) {
        if (!userRepository.existsByEmail(userRegisterRequest.getEmail())) {
            User user = new User(
                    userRegisterRequest.getEmail(),
                    userRegisterRequest.getFirstName(),
                    userRegisterRequest.getLastName(),
                    userRegisterRequest.getPhoneNumber(),
                    userRegisterRequest.getPassword()
            );
            return userRepository.save(user);
        } else {
            throw new RuntimeException("cos sie olabejz");
        }
    }
}
