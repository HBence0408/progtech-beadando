package com.gatchasim.gatchasim.Database;

public class CommandInvoker {
    public void run(ICommand command) throws Exception {
        command.execute();
    }

    public <T> T run(IReturningCommand<T> command) throws Exception {
        return command.execute();
    } // Ez azért kell hogy olyan commandokat is futtassunk amelyek valamit visszaadnak értékként, a Loginhoz csináltam,
    // hogy az új LoggedInUser singletonba tárolni tudjam azt hogy ki is van bejelentkezve
    // ide kerülhet később hogy külön szálon indítsa a commandot, naplózza, vagy undozza
}
