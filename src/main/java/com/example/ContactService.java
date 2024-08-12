package com.example;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ContactService {

    List<ContactDetails> details;

    public ContactService() {

        details = new ArrayList<ContactDetails>();
        details.add(new ContactDetails("500", "Alexis Rose", "30010"));
        details.add(new ContactDetails("501", "David Rose", "30056"));
        details.add(new ContactDetails("502", "Ted Mullens", "31055"));

    }
    @Observed(name="get.contact", contextualName = "getting contact details")
    public ContactDetails getDetails(String cid) throws InterruptedException {
        Random r = new Random();
        int multiplier = r.nextInt(5) * 1000;
        System.out.println("multiplier: " + multiplier);
        Thread.sleep(multiplier);

        return details.stream().filter(detail -> cid.equals(detail.getContactId())).findAny().orElse(null);
    }

}
