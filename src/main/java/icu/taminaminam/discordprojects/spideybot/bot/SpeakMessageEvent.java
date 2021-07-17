package icu.taminaminam.discordprojects.spideybot.bot;

import com.github.matty.discord4j.spring.annotations.DiscordEventListener;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
public class SpeakMessageEvent{

    public String command = "echo ";

    @DiscordEventListener
    public Mono<Message> echoCommand(MessageCreateEvent messageCreateEvent) {
        Message msg = messageCreateEvent.getMessage();

        String commandtext = msg.getContent();

        StringBuilder responseBuilder = new StringBuilder();

        responseBuilder.append(commandtext);

        responseBuilder.delete(0, BotCaller.prefix.length());
        responseBuilder.delete(0, this.command.length());

        return BotCaller.callStartsWithCommand(msg, command, responseBuilder.toString(), false);
        //return BotCaller.call(msg, command, false, commandtext);

    }
}
