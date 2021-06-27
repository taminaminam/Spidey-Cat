package icu.taminaminam.discordprojects.spideybot.bot;

import com.github.matty.discord4j.spring.annotations.DiscordEventListener;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public class BotCaller {

    private static String prefix = "spidey ";

    @DiscordEventListener
    public static Mono<Message> call(Message msg, String command, String response){

        String text = prefix + command;

        if (text.equals(msg.getContent())) {
            return msg.getChannel()
                    .flatMap(ch -> ch.createMessage(response));
        }

        return Mono.empty();
    }
}
