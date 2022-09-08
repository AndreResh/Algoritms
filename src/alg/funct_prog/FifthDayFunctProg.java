package alg.funct_prog;

import java.util.*;

public class FifthDayFunctProg {
}

class PhoneBook {
    private final Map<String, Collection<PhoneNumber>> nameToPhoneNumbersMap = new HashMap<>();

    public void addNewPhoneNumbers(String name, Collection<PhoneNumber> numbers) {
        nameToPhoneNumbersMap.compute(name, ((namen, phoneNumbers) -> {
            Collection<PhoneNumber> collection = nameToPhoneNumbersMap.getOrDefault(namen, new ArrayList<>());
            collection.addAll(numbers);
            return collection;

//            nameToPhoneNumbersMap.merge(name, numbers, (a, b) -> {
//                a.addAll(b);
//                return a;
//            });

//            nameToPhoneNumbersMap.computeIfAbsent(name, k -> new ArrayList<>()).addAll(numbers);
        }));
    }

    public void printPhoneBook() {

        nameToPhoneNumbersMap.forEach((name, phoneNumbers) -> {
            System.out.println(name);
            phoneNumbers.forEach(phoneNumber -> System.out.printf("%s: %s\n", phoneNumber.getType(), phoneNumber.getNumber()));
        });
    }
}

enum PhoneNumberType {
    MOBILE, HOME, WORK,
}

class PhoneNumber {

    private PhoneNumberType type;
    private String number;

    public PhoneNumber(PhoneNumberType type, String number) {
        this.type = type;
        this.number = number;
    }

    public PhoneNumberType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }
}