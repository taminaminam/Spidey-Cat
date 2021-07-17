package icu.taminaminam.discordprojects.spideybot.bot;

import com.github.matty.discord4j.spring.annotations.DiscordEventListener;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public class BotCaller {

    public static String prefix = "spidey ";


    public static Mono<Message> call(Message msg, String command, boolean equals_check, String response){

        String text = prefix + command;

        if (equals_check) {
            if (msg.getContent().equals(text)) {
                return msg.getChannel()
                        .flatMap(ch -> ch.createMessage(response));
            }
        } else{
            if (msg.getContent().startsWith(text)) {
                return msg.getChannel()
                        .flatMap(ch -> ch.createMessage(response));
            }
        }

        return Mono.empty();
    }
}
