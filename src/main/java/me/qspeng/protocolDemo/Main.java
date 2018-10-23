package me.qspeng.protocolDemo;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import me.qspeng.protocolDemo.AddressBookProtos.Person.PhoneNumber;

import static me.qspeng.protocolDemo.AddressBookProtos.*;

public class Main {
    public static void main(String[] args) {
        testGenerateClass();
    }

    private static void testGenerateClass() {
        Person person = Person.newBuilder()
                .setId(1)
                .setEmail("qspeng@thoughtworks.com")
                .setName("qspeng")
                .addPhones(0, PhoneNumber.newBuilder().setNumber("xxxxxx").setType(Person.PhoneType.MOBILE).build())
                .build();
        AddressBook addressBook = AddressBook.newBuilder().addPeople(person).build();
        System.out.println("size: " + addressBook.getSerializedSize());
        System.out.println("isInit: " + addressBook.isInitialized());
        System.out.println("bytes: " + addressBook.toByteString());
        System.out.println("enum test: " + addressBook.getPeople(0).getPhones(0).getType());

        try {
            System.out.println("decode: " + AddressBook.parseFrom(addressBook.toByteString()).getPeopleCount());
            System.out.println("decode test enum: " + AddressBook.parseFrom(addressBook.toByteString()).getPeople(0).getPhones(0).getType());
            //转成JSON 发现枚举值丢失
            System.out.println("To Json: " + JsonFormat.printer().print(addressBook));
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
