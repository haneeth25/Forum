package com.stackoverflow.backend.Users;

import com.stackoverflow.backend.Answers.AnswerRepository;
import com.stackoverflow.backend.Questions.QuestionsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private AnswerRepository answerRepository;
    private QuestionsRepository questionsRepository;
    private UserRepository userRepository;
    private ProfileService profileService;
    public UserController(UserRepository userRepository , QuestionsRepository questionsRepository, AnswerRepository answerRepository , ProfileService profileService){
        this.userRepository = userRepository;
        this.questionsRepository = questionsRepository;
        this.answerRepository = answerRepository;
        this.profileService = profileService;
    }

//    @PostMapping("/create-user")
//    public ResponseEntity<?> createUser(
//            @RequestBody UserEntity userEntity
//    ){
//        Integer count = userRepository.countByUserName(userEntity.getUserName());
//        System.out.println(count);
//        if (count < 0 && userEntity.getPassword() != null && userEntity.getUserEmail() != null){
//            return ResponseEntity.ok("{\"message\":\"User Created\"}");
//        }
//        else{
//            return ResponseEntity.badRequest().body("{\"message\":\"Invalid user data\"}");
//        }
//    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity) {
        Integer count = userRepository.countByUserName(userEntity.getUserName());
        System.out.println(count);

        // Check if username already exists
        if (count > 0) {
            return ResponseEntity.badRequest().body("{\"message\":\"Username already exists\"}");
        }

        // Check for valid password and email
        if (userEntity.getPassword() != null && userEntity.getUserEmail() != null) {
            userRepository.save(userEntity); // Save the user entity to the database
            return ResponseEntity.ok("{\"message\":\"User Created\"}");
        } else {
            return ResponseEntity.badRequest().body("{\"message\":\"Invalid user data\"}");
        }
    }


    @GetMapping("/user/check")
    public UserEntity checkUser(
            @RequestParam("userName") String userName,
            @RequestParam("password") String password
    ){
        return userRepository.findByUserNameAndPassword(userName,password);
    }
    @GetMapping("/profile/{userName}")
    public ProfileResponse UserDetails(
            @PathVariable("userName") String userName
    ){
        return profileService.toProfileResponse(userRepository.findByUserName(userName),questionsRepository.findAllByUserNameOrderByTimestampDesc(userName),answerRepository.findAllByUserNameOrderByTimestampDesc(userName));
        //return userName;
    }


}
