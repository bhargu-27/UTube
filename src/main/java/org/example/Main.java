package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please select uTube side size:");
        int size = sc.nextInt();
        int length=size*2+1;
        UTube uTube= new UTube(length);
        System.out.println("UTube has been Created!");
        int choice=0;
        while (choice!=-1){
            System.out.println("Please select an Operation");
            System.out.println("1. Add Element from Left side");
            System.out.println("2. Add Element from Right side");
            System.out.println("3. Display Tube");
            System.out.println("0. Select option again");
            System.out.println("-1. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            if (choice == -1) {
                System.out.println("Exiting...");
                break;
            } else if (choice == 0) {
                continue;
            }
            String ele;
            switch (choice){
                case 1:
                    System.out.println("Please enter String to enter from left");
                    ele = sc.nextLine();
                    uTube.addElementosLeft(ele);
                    break;
                case 2:
                    System.out.println("Please enter String to enter from right");
                    ele = sc.nextLine();
                    uTube.addElementosRight(ele);
                    break;
                case 3:
                    uTube.printUTube();
                    break;
                default:
                    System.out.println("Invalid choice try again");
            }
        }
        sc.close();
    }
}