package com.gctoledo.qrcode.generator.controller;

import com.gctoledo.qrcode.generator.controller.dto.qrcode.QrCodeGenerateRequest;
import com.gctoledo.qrcode.generator.controller.dto.qrcode.QrCodeGenerateResponse;
import com.gctoledo.qrcode.generator.service.QrCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qrcode")
public class QrCodeController {

    private final QrCodeService qrCodeService;

    public QrCodeController(QrCodeService qrCodeService) {
        this.qrCodeService = qrCodeService;
    }

    @PostMapping
    public ResponseEntity<QrCodeGenerateResponse> generateQrCode(@RequestBody QrCodeGenerateRequest request) {
        try {
            QrCodeGenerateResponse response = this.qrCodeService.generateQrCode(request.text());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
