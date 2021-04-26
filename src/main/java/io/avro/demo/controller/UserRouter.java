package io.avro.demo.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import io.avro.demo.Producer;
import io.avro.demo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRouter {

  @Bean
  RouterFunction router(Producer producer) {
    return route(POST("/publish").and(accept(
        APPLICATION_JSON)), request -> request.bodyToMono(User.class)
        .doOnNext(user -> producer.sendMessage(user))
        .then(ServerResponse.ok().build()));
  }
}
