package com.example.notificacao.controller;

import com.example.notificacao.business.EmailService;
import com.example.notificacao.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<Void> enviaEmail(@RequestBody TarefasDTO dto){
        emailService.envioEmail(dto);
        return ResponseEntity.ok().build();
    }
}
