package Eunseo.day1211.Practice.Printer;

public class ConsolePrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Printer printer = new ConsolePrinter();
        printer.print("Hello World");
    }
}
