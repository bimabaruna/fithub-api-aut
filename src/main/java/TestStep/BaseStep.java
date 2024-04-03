package TestStep;

import com.github.javafaker.Faker;



public class BaseStep {

    public Faker faker = new Faker();

    public void implicitWait(Integer time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {

        }
    }
    public String randEmail() {

        String email = faker.name().firstName();
        String emailFormat = "@mailinator.com";
        return email + emailFormat;
    }
}
