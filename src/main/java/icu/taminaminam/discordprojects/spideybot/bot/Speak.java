package icu.taminaminam.discordprojects.spideybot.bot;

import com.github.matty.discord4j.spring.annotations.DiscordEventListener;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class Speak {
    String command = "echo";

    @DiscordEventListener
    public Mono<Message> echoCommand(MessageCreateEvent messageCreateEvent) {
        Message msg = messageCreateEvent.getMessage();

        String commandtext = msg.getContent();

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append(commandtext.substring(BotCaller.prefix.length() + 1 + command.length()));

        return BotCaller.call(msg, command, false, responseBuilder.toString());
    }
}
