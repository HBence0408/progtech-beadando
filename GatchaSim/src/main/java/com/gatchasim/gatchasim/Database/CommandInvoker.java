package com.gatchasim.gatchasim.Database;

public class CommandInvoker {
    public void run(ICommand command) throws Exception {
        command.execute();
    }

    // ide kerülhet később hogy külön szálon indítsa a commandot, naplózza, vagy undozza
}
