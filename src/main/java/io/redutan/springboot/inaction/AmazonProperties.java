package io.redutan.springboot.inaction;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("amazon")  // amazon 접두어가 붙은 프로퍼티 주입
public class AmazonProperties {
    @Getter
    @Setter
    private String associateId;
}
