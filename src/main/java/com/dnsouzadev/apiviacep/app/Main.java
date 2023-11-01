package com.dnsouzadev.apiviacep.app;

import com.dnsouzadev.apiviacep.model.Address;
import com.dnsouzadev.apiviacep.service.ViaCepService;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ViaCepService vcs = new ViaCepService();

        System.out.println("Put the CEP: ");
        String cep = sc.next();

        Address renderer = vcs.getAddress(cep);
        System.out.println(renderer.toString());


    }

}
