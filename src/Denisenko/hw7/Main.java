package denisenko.hw7;


import denisenko.hw7.di.Injector;
import denisenko.hw7.handler.ConsoleHandler;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {
        Injector.injectDependency();
        ConsoleHandler.handle();
    }


}
