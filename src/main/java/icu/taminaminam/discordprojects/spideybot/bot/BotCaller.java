package icu.taminaminam.discordprojects.spideybot.bot;

import discord4j.core.object.entity.Message;
import reactor.core.publisher.Mono;

public class BotCaller {

    public static String prefix = "spidey ";
    public static String botID = "858742652849750066";

    public static Mono<Message> call(Message msg, String command, boolean equals_check, String response, boolean ignoreself){

        if (!(msg.getAuthor().map(user -> user.getId().asString().equals(botID)).orElse(false) && ignoreself)) {

            String text = prefix + command;

            if (equals_check) {
                if (msg.getContent().equals(text)) {
                    return msg.getChannel()
                            .flatMap(ch -> ch.createMessage(response));
                }
            } else {
                if (msg.getContent().startsWith(text)) {
                    return msg.getChannel()
                            .flatMap(ch -> ch.createMessage(response));
                }
            }

        }

        return Mono.empty();
    }

    public static Mono<Message> callStartsWithCommand(Message msg, String command, String response, boolean ignoreself){
        return call(msg, command, false, response, ignoreself);
    }
}
