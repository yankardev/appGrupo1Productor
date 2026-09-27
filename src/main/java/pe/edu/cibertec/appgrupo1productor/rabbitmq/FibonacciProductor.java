package pe.edu.cibertec.appgrupo1productor.rabbitmq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.appgrupo1productor.config.RabbitMqConfig;

@RequiredArgsConstructor
@Slf4j
@Service
public class FibonacciProductor {
    private final RabbitTemplate rabbitTemplate;

    public void enviarNumeros(String numbers) {

        log.info("Enviando números a RabbitMQ: {}", numbers);

        rabbitTemplate.convertAndSend(
                RabbitMqConfig.EXCHANGE,
                RabbitMqConfig.ROUTING_KEY,
                numbers
        );
    }
}
