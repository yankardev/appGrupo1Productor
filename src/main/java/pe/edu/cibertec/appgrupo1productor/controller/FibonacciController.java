package pe.edu.cibertec.appgrupo1productor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.appgrupo1productor.rabbitmq.FibonacciProductor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    private final FibonacciProductor fibonacciProductor;

    @GetMapping("/send")
    public ResponseEntity<String> enviarNumeros(@RequestParam String numbers) {

        fibonacciProductor.enviarNumeros(numbers);

        return ResponseEntity.ok("Lista enviada a RabbitMQ correctamente");
    }
}