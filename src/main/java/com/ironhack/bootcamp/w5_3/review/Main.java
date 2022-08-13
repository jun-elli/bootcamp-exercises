package com.ironhack.bootcamp.w5_3.review;

import java.util.*;

/**
 * forma de declarar métodos
 * modificador_accesso [static] tipo_retorno nombre_metodo(tipo arg1, tipo arg2...) {
 *     implementación método.
 * }
 */


public class Main {
    String texto;
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>();

        numList.add(1);
        numList.add(5);
        numList.add(15);
        int index = 0;

        incrementAtIndex(numList, index);



        Persona juan = new Persona("Juan", "Gomez", new ArrayList<>());
        Persona juanito = new Persona("Juan", "Gomez", new ArrayList<>());
        Persona pedro = new Persona("Pedro", "Hernandez", new ArrayList<>());
        Persona maria = new Persona("María", "Gimenez", new ArrayList<>());
        Persona ana = new Persona("Ana", "Lopez", new ArrayList<>());
        Persona jaime = new Persona("Jaime", "Gomez", new ArrayList<>());

        juan.addAmigo(pedro);
        juan.addAmigo(maria);
        juan.addAmigo(ana);
        juan.addAmigo(jaime);

        pedro.addAmigo(juan);
        pedro.addAmigo(maria);
        pedro.addAmigo(ana);
        pedro.addAmigo(jaime);

        maria.addAmigo(juan);
        maria.addAmigo(maria);
        maria.addAmigo(ana);
        maria.addAmigo(jaime);


//        PersonaDao.findByName("juan");




        if (juanito.equals(juan)) {
            System.out.println("Son el mismo");
        }




        maria.removeAmigo(jaime);

        Map<String, Persona>  map = new HashMap<>();
        map.put("username", juan);
        map.put("pedro", pedro);
        map.put("maria", maria);
        map.put("juandiego", juan);
        map.put("ana", ana);

        map.size();




        System.out.println("Amigos de María:");
        for (Persona amigo : maria.getAmigos()) {
            System.out.println("Amigo: " + amigo.getNombre() + " " + amigo.getApellidos());
        }

        Status status = Status.DISABLED;


        switch (status) {
            case ENABLED:
                System.out.println("System is enabled");
                break;
            case DISABLED:
                System.out.println("System is disabled");
                break;
            case UNKNOWN:
            default:
                System.out.println("System is unknown");

        }

        if (status.equals(Status.DISABLED)) {
            System.out.println("System is disabled");
        } else {
            System.out.println("System is enabled");
        }

        int review = 3;
        int number = 0;
        number += review * 2;
        number = number + review * 2;




    }

    public static List<Integer> incrementAtIndex (List<Integer> numList, int index) {
        Integer value = numList.get(index);
        numList.set(index, value +1);
        return  numList;
    }
}

