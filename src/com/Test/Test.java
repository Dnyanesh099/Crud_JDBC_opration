package com.Test;

import java.util.Scanner;

import com.Service.service;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
        	System.out.println();
            System.out.println("***** Enter Your Choice *****");
            System.out.println("------------------------------");
            System.out.println("1. Insert Data  ");
            System.out.println("2. Update Data ");
            System.out.println("3. Delete Data   ");
            System.out.println("4. Get Your Details by Name ");
            System.out.println("5. Get All Data of Employee ");
            System.out.println("6. Exit ");
            System.out.println("------------------------------");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    service.InsertDta();
                    break;
                case 2:
                    service.UpdateData();
                    break;
                case 3:
                    service.DeleteData();
                    break;
                case 4:
                    service.FetchData_Byname();
                    break;
                case 5:
                    service.GetData();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Wrong Choice...");
            }

        } while (choice != 6);
        
        sc.close();
    }
}
