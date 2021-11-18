package demo.canary.release;

import java.util.Optional;


public class Main {

    public static void main(String[] args) {
        String GREETING = Optional.ofNullable(System.getenv("GREETING")).orElse("Hello World!").trim();
        String MAX_REQUESTS_PER_SECOND = Optional.ofNullable(System.getenv("MAX_REQUESTS_PER_SECOND")).orElse("0").trim();

        if (!MAX_REQUESTS_PER_SECOND.equals("0")) {
            System.out.println("Service will limit requests to " + MAX_REQUESTS_PER_SECOND + " req/second");
        }

        Server server = new Server(
            GREETING,
            Float.parseFloat(MAX_REQUESTS_PER_SECOND)
        );

        server.start();
    }

}
