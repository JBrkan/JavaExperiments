import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {

    public static void main(String[] args){

        // Comparator sort
        List<Human> humans = new ArrayList<Human> ();

        humans.add(new Human("Darko", 24));
        humans.add(new Human("Danko", 13));
        humans.add(new Human("Damir", 24));
        humans.add(new Human("Ana",12));
        humans.add(new Human("Anastazija",90));
        humans.add(new Human("A", 12));

        humans.sort(Comparator.comparing(Human::getThirdLetterOfName).thenComparing(Human::getAge));


        // Lambda sort
        List<Human> humansLambda = new ArrayList<Human> ();

        humansLambda.add(new Human("Darko", 24));
        humansLambda.add(new Human("Danko", 13));
        humansLambda.add(new Human("Damir", 24));
        humansLambda.add(new Human("Ana",12));
        humansLambda.add(new Human("Anastazija",90));
        humansLambda.add(new Human("A", 12));

        humansLambda.sort((human1, human2) -> {
            if(human1.getThirdLetterOfName().equals(human2.getThirdLetterOfName())){
                return Integer.compare(human1.getAge(), human2.getAge());
            }else{
                return human1.getThirdLetterOfName().compareTo(human2.getThirdLetterOfName());
            }
        });
        System.out.println("humansLambda");
        humansLambda.forEach(human -> System.out.println(human.getName()+ " " + human.getAge()+ " " + human.getThirdLetterOfName()));
        System.out.println("humans");
        humans.forEach((human -> System.out.println(human.getName()+ " "+human.getAge()+" "+human.getThirdLetterOfName())));


        // File Creation
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("Created");
            } else {
                System.out.println("Already exists");
            }
            System.out.println(myObj.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // FileWriter
        try{
            FileWriter fileWriter = new FileWriter("filename.txt");
            humans.forEach(human -> {
                try {
                    fileWriter.write(human.getThirdLetterOfName()+" "+human.getName()+" "+human.getAge());
                    fileWriter.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // File Reader
        try{
            FileReader fileReader = new FileReader("filename.txt");
            int i;
            while((i=fileReader.read())!=-1){
                System.out.print((char)i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    }


