package com.gctoledo.qrcode.generator.controller;

import com.gctoledo.qrcode.generator.controller.dto.qrcode.QrCodeGenerateRequest;
import com.gctoledo.qrcode.generator.controller.dto.qrcode.QrCodeGenerateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generateQrCode(@RequestBody QrCodeGenerateRequest request) {
        return null;
    }
}
