package com.borgescloud.pcfusage.command;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "app", description = "provide application information")
public class ApplicationCommand implements Runnable {

    private int foundationId;

    @Option(names = {"-f", "--foundation"},
            description = "foundation id")
    public void setFoundationId(int foundationId) {
        this.foundationId = foundationId;
    }

    @Override
    public void run() {
       System.out.printf("Application command called for foundation id %d", foundationId);
    }
    
}
