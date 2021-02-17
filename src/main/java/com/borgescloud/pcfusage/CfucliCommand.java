package com.borgescloud.pcfusage;

import java.util.*;
import javax.inject.Inject;

import com.borgescloud.pcfusage.command.ApplicationCommand;
import com.borgescloud.pcfusage.command.OrganizationCommand;
import com.borgescloud.pcfusage.model.Foundation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;
import io.micronaut.http.client.annotation.*;
import io.micronaut.http.client.*;
import io.reactivex.*;

import static io.micronaut.http.HttpRequest.*;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "cfucli", header = {
    "@|green        __                                     _ _ |@",
    "@|green       / _|                                   | (_)|@",
    "@|green   ___| |_   _   _ ___  __ _  __ _  ___    ___| |_ |@",
    "@|green  / __|  _| | | | / __|/ _` |/ _` |/ _ \\  / __| | ||@",
    "@|green | (__| |   | |_| \\__ \\ (_| | (_| |  __/ | (__| | ||@",
    "@|green  \\___|_|    \\__,_|___/\\__,_|\\__, |\\___|  \\___|_|_||@",
    "@|green                            __/ |                |@",
    "@|green                           |___/                  |@"},
    description = "Interacts wiht PCF Usage Dashboard APIs",
    mixinStandardHelpOptions = true, version = "cfucli 0.1",
    subcommands = {OrganizationCommand.class, ApplicationCommand.class}) 

public class CfucliCommand implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(CfucliCommand.class);

    @Inject CfucliConfiguration configuration;

    @Client("${cfucli.endpoint}")
    @Inject RxHttpClient client;     

    @Option(names = {"-v", "--verbose"}, description = "Shows the response body")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(CfucliCommand.class, args);
    }

    public void run() {

       Foundation[] foundations = client.retrieve(GET("/api/foundation/list"),Foundation[].class).blockingFirst();

       System.out.printf("Returned %d foundations\n", foundations.length);
       
        // business logic here
        if (verbose) {
            for (Foundation f: foundations) {
                System.out.printf("Workspace (%d - %s) has foundation %d -> %s\n", f.getWorkspaceId(), f.getWorkspaceName(), f.getId(), f.getName());
            }
        }
    }
}
