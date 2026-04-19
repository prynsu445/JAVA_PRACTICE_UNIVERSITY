class VowelException extends Exception {
    VowelException(String msg) {
        super(msg);
    }
}

class BlankException extends Exception {
    BlankException(String msg) {
        super(msg);
    }
}

class ExitException extends Exception {
    ExitException(String msg) {
        super(msg);
    }
}

class TestException {
    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Provide character");
            return;
        }

        char ch = args[0].charAt(0);

        try {

            if("aeiouAEIOU".indexOf(ch) != -1) {
                throw new VowelException("Vowel not allowed");
            }

            else if(ch == ' ') {
                throw new BlankException("Blank space not allowed");
            }

            else if(ch == 'X' || ch == 'x') {
                throw new ExitException("Program terminated");
            }

            else {
                System.out.println("Valid character");
            }

        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}