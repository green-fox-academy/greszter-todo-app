public class TODOApp {

    public static void main(String[] args) {


        if (args.length < 1) {
            FileHandling.printLines("print_usage.txt");
        } else if (args[0].equals("-l")) {
            ListBuilder.printItems();
        } else if (args[0].equals("-a")) {
            if (args.length == 1) {
                System.out.println("Unable to add: no task provided");
                System.exit(1);
            } else {
                ListBuilder.addItem(args[1]);
            }
        } else if (args[0].equals("-r")) {
            try {
                if (args.length == 1) {
                    System.out.println("Unable to remove: no index provided");
                    System.exit(1);
                } else {
                    try {
                        ListBuilder.removeFromList(Integer.parseInt(args[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("Unable to remove: index is not a number");
                        System.exit(1);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Unable to remove: index is out of bound");
                System.exit(1);
            }
        } else if (args[0].equals("-c")) {
            try {
                if (args.length == 1) {
                    System.out.println("Unable to remove: no index provided");
                    System.exit(1);
                } else {
                    try {
                        ListBuilder.checkItem(Integer.parseInt(args[1]));
                    } catch (NumberFormatException e) {
                        System.out.println("Unable to remove: index is not a number");
                        System.exit(1);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Unable to remove: index is out of bound");
                System.exit(1);
            }
        } else {
            System.out.println("Unsupported argument");
            FileHandling.printLines("print_usage.txt");
            System.exit(1);
        }
    }
}