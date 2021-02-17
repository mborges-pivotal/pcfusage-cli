package com.borgescloud.pcfusage.command;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "org", description = "provide organization information")
public class OrganizationCommand implements Runnable {

    private int foundationId;

    @Option(names = {"-f", "--foundation"},
            description = "foundation id")
    public void setFoundationId(int foundationId) {
        this.foundationId = foundationId;
    }

    @Override
    public void run() {
       System.out.printf("Organization command called for foundation id %d", foundationId);
    }
    
}
