package com.email.Gemmail.Controller;

import com.email.Gemmail.Entity.EmailRequest;
import com.email.Gemmail.Service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("api/email")
public class EmailController {

    private  final EmailService emailService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest){

        String response  = emailService.generateEmailReply(emailRequest);
        return  ResponseEntity.ok(response);
    }
}
