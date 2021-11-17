package se.iths.exceptions;

public class InvalidIdInputException extends Exception {
    public InvalidIdInputException(String errorMessage){
        super(errorMessage);
    }

    static void checkIfIdIsANumber(Long id) throws InvalidIdInputException{

        if(id == null){
            throw new InvalidIdInputException("id is not a valid number");
        }else {
            System.out.println("Test");
        }

    }
}
