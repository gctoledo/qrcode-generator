package com.gctoledo.qrcode.generator.service;

import com.gctoledo.qrcode.generator.controller.dto.qrcode.QrCodeGenerateResponse;
import com.gctoledo.qrcode.generator.ports.StoragePort;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class QrCodeService {
    private final StoragePort storage;

    public QrCodeService(StoragePort storage) {
        this.storage = storage;
    }

    public QrCodeGenerateResponse generateQrCode(String text) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 200, 200);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);

        byte[] pngQrCodeData = pngOutputStream.toByteArray();

        String url = storage.uploadFile(pngQrCodeData, UUID.randomUUID() + ".png", "image/png");

        return new QrCodeGenerateResponse(url);
    }
}
