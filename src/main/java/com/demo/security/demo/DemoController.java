package com.demo.security.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/demo-controller")
public class DemoController {

  @GetMapping("/user")
  @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
  public ResponseEntity<String> sayHelloUser() {
    return ResponseEntity.ok("Ola seja bem vindo ao meu endpoint USER");
  }

  @GetMapping("/admin")
  @PreAuthorize("hasAuthority('ADMIN')")
  public ResponseEntity<String> sayHelloAdmin() {
    return ResponseEntity.ok("Ola seja bem vindo ao meu endpoint ADMIN");
  }

}
