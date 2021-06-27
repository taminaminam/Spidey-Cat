package icu.taminaminam.discordprojects.spideybot.bot;

import com.github.matty.discord4j.spring.annotations.DiscordEventListener;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;

@Component
public class PingMessageEvent {
    @DiscordEventListener
    public Mono<Message> pingCommand(MessageCreateEvent messageCreateEvent) {
        Message msg = messageCreateEvent.getMessage();

        return BotCaller.call(msg, "ping", false, "Pang!");
    }

    @DiscordEventListener
    public Mono<Message> pongCommand(MessageCreateEvent messageCreateEvent) {
        Message msg = messageCreateEvent.getMessage();

        return BotCaller.call(msg, "pong", false, "Ping!");
    }

    @DiscordEventListener
    public Mono<Message> pingTimeCommand(MessageCreateEvent messageCreateEvent) {
        Message msg = messageCreateEvent.getMessage();

        Instant msgTime = msg.getTimestamp();

        Instant now = Instant.now();

        long timeElapsed = Duration.between(msgTime, now).toMillis();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("Pong! ");
        responseBuilder.append(timeElapsed);
        responseBuilder.append("ms");

        return BotCaller.call(msg, "ping time", false, responseBuilder.toString());
    }
}
