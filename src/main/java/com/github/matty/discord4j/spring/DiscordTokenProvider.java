package com.github.matty.discord4j.spring;

/**
 * Provider for Discord token when creating the client.
 *
 * @author Matty Southall
 * @since 1.0
 */
@FunctionalInterface
public interface DiscordTokenProvider {

    String getToken();
}
