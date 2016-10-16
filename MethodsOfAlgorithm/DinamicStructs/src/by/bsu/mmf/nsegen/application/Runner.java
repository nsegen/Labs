package by.bsu.mmf.nsegen.application;

import by.bsu.mmf.nsegen.collections.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by root on 18.9.16.
 */
public class Runner {

    public static void main(String[] args){

        IList<Integer> list = new MyLinkedList<>();

        Scanner sc = new Scanner(System.in);

        boolean isTrue = true;
        while(isTrue){
            System.out.println("Выберите действие со списком: ");
            System.out.println("0 -> exit()");
            System.out.println("1 -> add(data, index)");
            System.out.println("2 -> addToEnd(data)");
            System.out.println("3 -> addToStart(data)");
            System.out.println("4 -> remove(index)");
            System.out.println("5 -> get(index)");
            System.out.println("6 -> isEmpty()");
            System.out.println("7 -> showAll()");

            int index;
            Integer data;

            int action = sc.nextInt();
            switch (action){
                case 0:
                    isTrue = false;
                    break;
                case 1:
                    System.out.println("Enter index: ");
                    index = sc.nextInt();
                    System.out.println("Enter data: ");
                    data = sc.nextInt();
                    list.add(data, index);
                    break;
                case 2:
                    System.out.println("Enter data: ");
                    data = sc.nextInt();
                    list.addToEnd(data);
                    break;
                case 3:
                    System.out.println("Enter data: ");
                    data = sc.nextInt();
                    list.addToStart(data);
                    break;
                case 4:
                    System.out.println("Enter index: ");
                    index = sc.nextInt();
                    list.remove(index);
                    break;
                case 5:
                    System.out.println("Enter index: ");
                    index = sc.nextInt();
                    System.out.println(list.get(index));
                    break;
                case 6:
                    System.out.println(list.isEmpty());
                    break;
                case 7:
                    for(int i=0; i<list.getLength(); i++){
                        System.out.print(list.get(i) + " ");
                    }
                    System.out.println();
                    break;
            }
        }

        IStack<Integer> stack = new MyStack<>();

        isTrue = true;
        while(isTrue) {
            System.out.println("Выберите действие со стеком: ");
            System.out.println("0 -> exit()");
            System.out.println("1 -> push(data)");
            System.out.println("2 -> pop()");
            System.out.println("3 -> peek()");
            System.out.println("4 -> isEmpty()");
            System.out.println("5 -> showAll()");

            Integer data;

            int action = sc.nextInt();
            switch (action) {
                case 0:
                    isTrue = false;
                    break;
                case 1:
                    System.out.println("Enter data: ");
                    data = sc.nextInt();
                    stack.push(data);
                    break;
                case 2:
                    System.out.println(stack.pop());
                    break;
                case 3:
                    System.out.println(stack.peek());
                    break;
                case 4:
                    System.out.println(list.isEmpty());
                    break;
                case 5:
                    while (!stack.isEmpty()) {
                        System.out.print(stack.pop() + " ");
                    }
                    System.out.println();
                    break;
            }
        }

        List<Integer> listTree = new LinkedList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            listTree.add(sc.nextInt());
        }

        ITree<Integer> tree = new Tree<>(listTree);
        tree.printTree();

        int ch=1;
        String[] a = sc.nextLine().split(" ");
        while (ch != 0) {
            System.out.println("1 - print tree\n 2 - pre Order Traversal\n 3 - in Order Traversal\n 4 - post Order Traversal\n 0 -exit  ");
            ch =sc.nextInt();
            switch (ch) {
                case 1:
                    tree.printTree();
                    break;
                case 2:
                    tree.directBypass();
                    break;
                case 3:
                    tree.balancedBypass();
                    break;
                case 4:
                    tree.reverseBypass();
                    break;
                case 0:
                    return;

            }
        }

    }

}
