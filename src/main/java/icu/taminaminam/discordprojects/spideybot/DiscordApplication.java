package icu.taminaminam.discordprojects.spideybot;

import com.github.matty.discord4j.spring.annotations.EnableDiscord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDiscord
public class DiscordApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscordApplication.class);
    }
}
