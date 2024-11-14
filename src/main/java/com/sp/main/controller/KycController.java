package com.sp.main.controller;

import com.sp.main.payload.KycDto;
import com.sp.main.service.UserKycService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kyc")
public class KycController {

    private UserKycService userKycService;

    public KycController(UserKycService userKycService) {
        this.userKycService = userKycService;
    }

    @PostMapping
    public ResponseEntity<KycDto> kycHere(@RequestBody  KycDto kycDto , @RequestParam long userId) {
        KycDto kycDto1 = userKycService.kycHere(kycDto, userId);
        return new ResponseEntity<>(kycDto1 , HttpStatus.OK);

    }
}
